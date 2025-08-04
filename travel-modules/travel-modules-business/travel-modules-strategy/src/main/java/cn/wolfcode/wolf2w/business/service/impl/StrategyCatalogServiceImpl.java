package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.StrategyCatalog;
import cn.wolfcode.wolf2w.business.mapper.StrategyCatalogMapper;
import cn.wolfcode.wolf2w.business.query.StrategyCatalogQuery;
import cn.wolfcode.wolf2w.business.service.IStrategyCatalogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 攻略分类Service业务层处理
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
@Transactional
public class StrategyCatalogServiceImpl extends ServiceImpl<StrategyCatalogMapper, StrategyCatalog> implements IStrategyCatalogService {

    @Override
    public IPage<StrategyCatalog> queryPage(StrategyCatalogQuery qo) {
        IPage<StrategyCatalog> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }

    @Override
    public List<Map<String, Object>> queryGroupList() {
        QueryWrapper<StrategyCatalog> qw = new QueryWrapper<>();
        qw.groupBy("dest_name");
        qw.select("dest_name destName, GROUP_CONCAT(id) ids, GROUP_CONCAT(name) names");
        List<Map<String, Object>> list = baseMapper.selectMaps(qw);
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> map : list) {
            String destName = (String) map.get("destName");
            String ids = (String) map.get("ids");
            String names = (String) map.get("names");
            String[] idarr = ids.split(",");
            String[] namesarr = names.split(",");
            List<StrategyCatalog> catalogList = new ArrayList<>();
            for (int i = 0; i < idarr.length; i++) {
                Long id = Long.valueOf(idarr[i]);
                String name = namesarr[i];
                StrategyCatalog catalog = new StrategyCatalog();
                catalog.setId(id);
                catalog.setName(name);
                catalogList.add(catalog);
            }
            Map<String, Object> m = new HashMap<>();
            m.put("destName", destName);
            m.put("catalogList", catalogList);
            result.add(m);
        }
        return result;
    }
}
