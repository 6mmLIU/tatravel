package cn.sixmm.sixsixsix.business.controller;

import cn.sixmm.sixsixsix.business.service.IStrategyService;
import cn.sixmm.sixsixsix.business.service.IStrategyThemeService;
import cn.sixmm.sixsixsix.business.vo.ThemeVO;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.security.annotation.InnerAuth;
import cn.sixmm.sixsixsix.business.api.domain.StrategyRank;
import cn.sixmm.sixsixsix.business.query.StrategyRankQuery;
import cn.sixmm.sixsixsix.business.service.IStrategyRankService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 攻略排行 Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("strategyRanks")
public class StrategyRankController {
    @Autowired
    private IStrategyRankService strategyRankService;
    @Autowired
    private IStrategyService strategyService;

    @GetMapping("/theme")
    public R<?> theme() {
        List<ThemeVO> list = strategyService.queryTheme();
        return R.ok(list);
    }

    @GetMapping("rank")
    public R<List<StrategyRank>> rank(long type) {
        List<StrategyRank> list = strategyRankService.queryRankByPage(type);
        return R.ok(list);
    }

    /**
     * 攻略排行详情
     */
    @GetMapping("/detail/{id}")
    public R<StrategyRank> detail(@PathVariable Long id) {
        StrategyRank strategyRank = strategyRankService.getById(id);
        return R.ok(strategyRank);
    }

    /**
     * 攻略排行 列表
     */
    @GetMapping("/query")
    public R<IPage<StrategyRank>> query(StrategyRankQuery qo) {
        IPage<StrategyRank> page = strategyRankService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<StrategyRank>> feignList() {
        return R.ok(strategyRankService.list());
    }

    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<StrategyRank> feignGet(@PathVariable Long id) {
        return R.ok(strategyRankService.getById(id));
    }

}
