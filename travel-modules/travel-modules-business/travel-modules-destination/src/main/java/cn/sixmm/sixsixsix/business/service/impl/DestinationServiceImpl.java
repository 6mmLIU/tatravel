package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.domain.DTO.DestinationDTO;
import cn.sixmm.sixsixsix.business.api.domain.Destination;
import cn.sixmm.sixsixsix.business.api.domain.Region;
import cn.sixmm.sixsixsix.business.api.domain.StrategyRank;
import cn.sixmm.sixsixsix.business.api.domain.vo.DestinationOptionVO;
import cn.sixmm.sixsixsix.business.mapper.DestinationMapper;
import cn.sixmm.sixsixsix.business.mapper.RegionMapper;
import cn.sixmm.sixsixsix.business.mapper.StrategyRankMapper;
import cn.sixmm.sixsixsix.business.query.DestinationQuery;
import cn.sixmm.sixsixsix.business.service.IDestinationService;
import cn.sixmm.sixsixsix.common.core.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 目的地Service业务层处理
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
@Transactional
@RequiredArgsConstructor
public class DestinationServiceImpl extends ServiceImpl<DestinationMapper, Destination> implements IDestinationService {

    private final RegionMapper regionMapper;

    private final DestinationMapper destinationMapper;
    private final StrategyRankMapper rankMapper;
    @Override
    public IPage<Destination> queryPage(DestinationQuery qo) {
        IPage<Destination> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }

    @Override
    public List<Destination> queryByRegionId(Long regionId) {
        List<Destination> list = null;
        if (regionId == -1) {
            //国内
            list = lambdaQuery().eq(Destination::getParentId, 1).list();
        } else {
            Region region = regionMapper.selectById(regionId);
            String refIds = region.getRefIds();
            String[] split = refIds.split(",");//"86" "87" 88 89
            List<Long> ids = new ArrayList<>();//"86","87" 88 89
            for (String s : split) {
                Long id = Long.valueOf(s);
                ids.add(id);
            }
            list = baseMapper.selectBatchIds(ids);
        }
        for (Destination destination : list) {
            Long id = destination.getId();
            List<Destination> children = lambdaQuery().eq(Destination::getParentId, id).last("limit 10").list();
            destination.setChildren(children);

        }
        return list;
    }

    @Override
    public List<Destination> queryToasts(Long destId) {
        List<Destination> list = new ArrayList<>();
        creatToasts(destId, list);
        return list;
    }

    @Override
    public List<DestinationOptionVO> listForSelector(Integer type, String name, Integer size) {
        size = (size == null || size <= 0) ? 30 : size;

        // 2 = 热门：来自排行表，按热度聚合排序
        if (Integer.valueOf(2).equals(type)) {
            return hotByWrapper(size);
        }

        // 其它：直接查目的地
        LambdaQueryWrapper<Destination> qw = new LambdaQueryWrapper<Destination>()
                .select(Destination::getId, Destination::getName);

        if (StringUtils.hasText(name)) {
            qw.like(Destination::getName, name);
        }

        if (Integer.valueOf(-1).equals(type)) {
            // 国内：所有“中国”的下一级（你的库里“中国”通常是 id=1）
            qw.eq(Destination::getParentId, 1L);
        } else if (Integer.valueOf(1).equals(type)) {
            // 国际：顶级国家（parent_id 为空，且排除“中国”自身）
            qw.isNull(Destination::getParentId).ne(Destination::getId, 1L);
        } else {
            // 兜底：一些顶级目的地
            qw.isNull(Destination::getParentId);
        }

        qw.last("LIMIT " + size);

        return this.list(qw).stream()
                .map(d -> new DestinationOptionVO(d.getId(), d.getName()))
                .collect(Collectors.toList());
    }

    /** 热门目的地（不写 XML/注解），用 MP Wrapper 做聚合 */
    private List<DestinationOptionVO> hotByWrapper(int size) {
        QueryWrapper<StrategyRank> qw = new QueryWrapper<>();
        qw.select(
                        "dest_id AS id",
                        "MAX(dest_name) AS name",
                        "SUM(statisnum) AS hot"
                )
                .eq("type", 3)               // 3：目的地热度（按你库定义）
                .groupBy("dest_id")
                .orderByDesc("hot")
                .last("LIMIT " + size);

        List<Map<String, Object>> rows = rankMapper.selectMaps(qw);
        return rows.stream()
                .map(m -> new DestinationOptionVO(
                        ((Number) m.get("id")).longValue(),
                        (String) m.get("name")))
                .collect(Collectors.toList());
    }


    private void creatToasts(Long destId, List<Destination> list) {
        if (destId == null) {
            return;
        }
        Destination destination = baseMapper.selectById(destId);
        Long parentId = destination.getParentId();

        creatToasts(parentId, list);
        list.add(destination);
    }
}
