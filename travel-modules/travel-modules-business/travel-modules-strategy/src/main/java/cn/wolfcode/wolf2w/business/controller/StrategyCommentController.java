package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.business.api.domain.StrategyComment;
import cn.wolfcode.wolf2w.business.query.StrategyCommentQuery;
import cn.wolfcode.wolf2w.business.service.IStrategyCommentService;
import cn.wolfcode.wolf2w.common.security.annotation.RequiresLogin;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 攻略评论 Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("strategyComments")
public class StrategyCommentController {
    @Autowired
    private IStrategyCommentService strategyCommentService;

    @RequiresLogin
    @PostMapping("/add")
    public R<?> add(StrategyComment comment) {
        strategyCommentService.add(comment);
        return R.ok();
    }

    /**
     * 攻略评论详情
     */
    @GetMapping("/detail/{id}")
    public R<StrategyComment> detail(@PathVariable Long id) {
        StrategyComment strategyComment = strategyCommentService.getById(id);
        return R.ok(strategyComment);
    }

    /**
     * 攻略评论 列表
     */
    @GetMapping("/query")
    public R<IPage<StrategyComment>> query(StrategyCommentQuery qo) {
        IPage<StrategyComment> page = strategyCommentService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<StrategyComment>> feignList() {
        return R.ok(strategyCommentService.list());
    }

    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<StrategyComment> feignGet(@PathVariable Long id) {
        return R.ok(strategyCommentService.getById(id));
    }
}
