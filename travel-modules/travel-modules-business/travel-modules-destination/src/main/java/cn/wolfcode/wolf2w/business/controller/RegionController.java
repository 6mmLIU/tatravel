package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.business.api.domain.Region;
import cn.wolfcode.wolf2w.business.query.RegionQuery;
import cn.wolfcode.wolf2w.business.service.IRegionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 区域 Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/regions")
public class RegionController {
    @Autowired
    private IRegionService regionService;
    /**
     * 区域详情
     */
    @GetMapping("/detail/{id}")
    public R<Region> detail(@PathVariable Long id) {
        Region region = regionService.getById(id);
        return R.ok(region);
    }
    /**
     * 区域 列表
     */
    @GetMapping("/query")
    public R<IPage<Region>> query(RegionQuery qo) {
        IPage<Region> page = regionService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<Region>> feignList() {
        return R.ok(regionService.list());
    }
    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<Region> feignGet(@PathVariable Long id) {
        return R.ok(regionService.getById(id));
    }
}
