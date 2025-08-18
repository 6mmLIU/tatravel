package cn.sixmm.sixsixsix.business.controller;

import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.security.annotation.InnerAuth;
import cn.sixmm.sixsixsix.business.api.domain.StrategyCondition;
import cn.sixmm.sixsixsix.business.query.StrategyConditionQuery;
import cn.sixmm.sixsixsix.business.service.IStrategyConditionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 攻略条件 Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("strategyConditions")
public class StrategyConditionController {
    @Autowired
    private IStrategyConditionService strategyConditionService;
    @GetMapping("/condition")
    public R<List<StrategyCondition>> condition(long type){
        List<StrategyCondition> list=strategyConditionService.queryConditionByType(type);
        return R.ok(list);
    }
    /**
     * 攻略条件详情
     */
    @GetMapping("/detail/{id}")
    public R<StrategyCondition> detail(@PathVariable Long id) {
        StrategyCondition strategyCondition = strategyConditionService.getById(id);
        return R.ok(strategyCondition);
    }
    /**
     * 攻略条件 列表
     */
    @GetMapping("/query")
    public R<IPage<StrategyCondition>> query(StrategyConditionQuery qo) {
        IPage<StrategyCondition> page = strategyConditionService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<StrategyCondition>> feignList() {
        return R.ok(strategyConditionService.list());
    }
    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<StrategyCondition> feignGet(@PathVariable Long id) {
        return R.ok(strategyConditionService.getById(id));
    }
}
