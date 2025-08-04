package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.business.api.domain.StrategyContent;
import cn.wolfcode.wolf2w.business.service.IStrategyContentService;
import cn.wolfcode.wolf2w.business.vo.CatalogVO;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.context.SecurityContextHolder;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.business.api.domain.Strategy;
import cn.wolfcode.wolf2w.business.query.StrategyQuery;
import cn.wolfcode.wolf2w.business.service.IStrategyService;
import cn.wolfcode.wolf2w.common.security.annotation.RequiresLogin;
import cn.wolfcode.wolf2w.common.security.annotation.RequiresPermissions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 攻略 Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Slf4j
@RestController
@RequestMapping("strategies")
public class StrategyController {
    @Autowired
    private IStrategyService strategyService;
    @Autowired
    private IStrategyContentService strategyContentService;

    @GetMapping("/isUserFavor")
    public R<?> isUserFavor(Long uid, Long sid) {
        boolean ret = strategyService.isUserFavor(uid, sid);
        return R.ok(ret);
    }

    @PostMapping("/replynumIncr")
    public R<?> replynumIncr(Long sid) {
        Map map = strategyService.replynumIncr(sid);
        return R.ok(map);
    }

    @RequiresLogin
    @PostMapping("/thumbsup")
    public R<?> thumbsup(Long sid) {
        Long userId = SecurityContextHolder.getUserId();
        Map map = strategyService.thumbsup(sid, userId);
        return R.ok(map);
    }

    @RequiresLogin //要求登录才能访问这个资源,如果没登录,抛异常
    @PostMapping("/favor")
    public R<?> favor(Long sid) {
        Long userId = SecurityContextHolder.getUserId();
        Map map = strategyService.favor(sid, userId);
        return R.ok(map);
    }

    /**
     * 返回值为整体的统计数字对象(hash结构)
     *
     * @param sid
     * @return
     */
    @PostMapping("/viewnumIncr")
    public R<?> viewnumIncr(Long sid) {
        Map map = strategyService.viewnumIncrease(sid);
        return R.ok(map);

    }

    @GetMapping("/viewnnumTop3")
    public R<List<Strategy>> viewnnumTop3(Long destId) {
        List<Strategy> list = strategyService.queryViewnumTop3(destId);
        return R.ok(list);
    }

    @GetMapping("/catalogList")
    public R<List<CatalogVO>> catalogList(Long destId) {
        List<CatalogVO> list = strategyService.queryCatalogVO(destId);
        return R.ok(list);
    }

    /**
     * 攻略详情
     */
    @GetMapping("/detail/{id}")
    public R<Strategy> detail(@PathVariable Long id) {
        Strategy strategy = strategyService.getById(id);
        StrategyContent content = strategyContentService.getById(id);
        strategy.setContent(content);
        return R.ok(strategy);
    }

    /**
     * 攻略 列表
     */
    @GetMapping("/query")
    public R<IPage<Strategy>> query(StrategyQuery qo) {
        IPage<Strategy> page = strategyService.queryPage(qo);
        return R.ok(page);
    }

    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<Strategy>> feignList() {
        return R.ok(strategyService.list());
    }

    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<Strategy> feignGet(@PathVariable Long id) {
        return R.ok(strategyService.getById(id));
    }

    @InnerAuth
    @PostMapping("/feign/statisRank")
    public R<?> statisRank(HttpServletRequest request) {
        log.info("FROM_SOURCE={}", request.getHeader(SecurityConstants.FROM_SOURCE));
        strategyService.statisRank();
        return R.ok();
    }

    @InnerAuth
    @PostMapping("/feign/statisCondition")
    public R<?> statisCondition() {
        System.out.println("攻略服务=====statisCondition===方法被调用");
        strategyService.statisCondition();
        return R.ok();
    }

    @InnerAuth
    @PostMapping("/feign/statisHashPersistence")
    public R<?> statisHashPersistence() {
        strategyService.statisHashPersistence();
//        System.out.println("攻略持久化");
        return R.ok();
    }

}
