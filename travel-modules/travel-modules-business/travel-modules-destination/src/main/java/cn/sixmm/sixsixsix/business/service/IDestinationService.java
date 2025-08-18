package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.DTO.DestinationDTO;
import cn.sixmm.sixsixsix.business.api.domain.Destination;
import cn.sixmm.sixsixsix.business.api.domain.vo.DestinationOptionVO;
import cn.sixmm.sixsixsix.business.query.DestinationQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 目的地Service接口
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface IDestinationService extends IService<Destination> {
    /**
     * 分页
     *
     * @param qo
     * @return
     */
    IPage<Destination> queryPage(DestinationQuery qo);

    List<Destination> queryByRegionId(Long regionId);

    List<Destination> queryToasts(Long destId);

    List<DestinationOptionVO> listForSelector(Integer type, String name, Integer size);
}
