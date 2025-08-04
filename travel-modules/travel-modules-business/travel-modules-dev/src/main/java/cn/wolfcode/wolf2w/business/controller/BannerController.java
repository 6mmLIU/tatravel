package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.business.api.domain.Banner;
import cn.wolfcode.wolf2w.business.query.BannerQuery;
import cn.wolfcode.wolf2w.business.service.IBannerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章推荐 Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("banners")
public class BannerController {
    @Autowired
    private IBannerService bannerService;
    @GetMapping("/strategy")
    public R strategy(){
        List<Banner> list=bannerService.queryByType(1);
        return R.ok(list);
    }
    @GetMapping("/travel")
    public R travel(){
        List<Banner> list=bannerService.queryByType(2);
        return R.ok(list);

    }
    /**
     * 文章推荐详情
     */
    @GetMapping("/detail/{id}")
    public R<Banner> detail(@PathVariable Long id) {
        Banner banner = bannerService.getById(id);
        return R.ok(banner);
    }
    /**
     * 文章推荐 列表
     */
    @GetMapping("/query")
    public R<IPage<Banner>> query(BannerQuery qo) {
        IPage<Banner> page = bannerService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<Banner>> feignList() {
        return R.ok(bannerService.list());
    }
    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<Banner> feignGet(@PathVariable Long id) {
        return R.ok(bannerService.getById(id));
    }
}
