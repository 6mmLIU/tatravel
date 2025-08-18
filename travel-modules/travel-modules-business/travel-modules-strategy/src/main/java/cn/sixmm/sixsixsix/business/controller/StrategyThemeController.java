package cn.sixmm.sixsixsix.business.controller;

import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.security.annotation.InnerAuth;
import cn.sixmm.sixsixsix.business.api.domain.StrategyTheme;
import cn.sixmm.sixsixsix.business.query.StrategyThemeQuery;
import cn.sixmm.sixsixsix.business.service.IStrategyThemeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 攻略主题 Controller
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("strategyThemes")
public class StrategyThemeController {
    @Autowired
    private IStrategyThemeService strategyThemeService;
    /**
     * 攻略主题详情
     */
    @GetMapping("/detail/{id}")
    public R<StrategyTheme> detail(@PathVariable Long id) {
        StrategyTheme strategyTheme = strategyThemeService.getById(id);
        return R.ok(strategyTheme);
    }
    /**
     * 攻略主题 列表
     */
    @GetMapping("/query")
    public R<IPage<StrategyTheme>> query(StrategyThemeQuery qo) {
        IPage<StrategyTheme> page = strategyThemeService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<StrategyTheme>> feignList() {
        return R.ok(strategyThemeService.list());
    }
    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<StrategyTheme> feignGet(@PathVariable Long id) {
        return R.ok(strategyThemeService.getById(id));
    }
}
