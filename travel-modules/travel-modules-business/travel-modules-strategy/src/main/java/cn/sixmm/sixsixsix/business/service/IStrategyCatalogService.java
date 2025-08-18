package cn.sixmm.sixsixsix.business.service;

import cn.sixmm.sixsixsix.business.api.domain.StrategyCatalog;
import cn.sixmm.sixsixsix.business.query.StrategyCatalogQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 攻略分类Service接口
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface IStrategyCatalogService extends IService<StrategyCatalog>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<StrategyCatalog> queryPage(StrategyCatalogQuery qo);

    List<Map<String, Object>> queryGroupList();
}
