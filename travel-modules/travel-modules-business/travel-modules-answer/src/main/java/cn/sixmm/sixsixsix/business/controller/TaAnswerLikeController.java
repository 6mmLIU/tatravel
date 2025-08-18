package cn.sixmm.sixsixsix.business.controller;

import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.security.annotation.InnerAuth;
import cn.sixmm.sixsixsix.business.api.domain.TaAnswerLike;
import cn.sixmm.sixsixsix.business.query.TaAnswerLikeQuery;
import cn.sixmm.sixsixsix.business.service.ITaAnswerLikeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 问答-回答点赞 Controller
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("taAnswerLikes")
public class TaAnswerLikeController {
    @Autowired
    private ITaAnswerLikeService taAnswerLikeService;
    /**
     * 问答-回答点赞详情
     */
    @GetMapping("/detail/{id}")
    public R<TaAnswerLike> detail(@PathVariable Long id) {
        TaAnswerLike taAnswerLike = taAnswerLikeService.getById(id);
        return R.ok(taAnswerLike);
    }
    /**
     * 问答-回答点赞 列表
     */
    @GetMapping("/query")
    public R<IPage<TaAnswerLike>> query(TaAnswerLikeQuery qo) {
        IPage<TaAnswerLike> page = taAnswerLikeService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<TaAnswerLike>> feignList() {
        return R.ok(taAnswerLikeService.list());
    }
    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<TaAnswerLike> feignGet(@PathVariable Long id) {
        return R.ok(taAnswerLikeService.getById(id));
    }
}
