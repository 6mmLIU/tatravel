package cn.sixmm.sixsixsix.business.controller;

import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.security.annotation.InnerAuth;
import cn.sixmm.sixsixsix.business.api.domain.TaQuestionAttention;
import cn.sixmm.sixsixsix.business.query.TaQuestionAttentionQuery;
import cn.sixmm.sixsixsix.business.service.ITaQuestionAttentionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 问答-问题关注关系 Controller
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("taQuestionAttentions")
public class TaQuestionAttentionController {
    @Autowired
    private ITaQuestionAttentionService taQuestionAttentionService;
    /**
     * 问答-问题关注关系详情
     */
    @GetMapping("/detail/{id}")
    public R<TaQuestionAttention> detail(@PathVariable Long id) {
        TaQuestionAttention taQuestionAttention = taQuestionAttentionService.getById(id);
        return R.ok(taQuestionAttention);
    }
    /**
     * 问答-问题关注关系 列表
     */
    @GetMapping("/query")
    public R<IPage<TaQuestionAttention>> query(TaQuestionAttentionQuery qo) {
        IPage<TaQuestionAttention> page = taQuestionAttentionService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<TaQuestionAttention>> feignList() {
        return R.ok(taQuestionAttentionService.list());
    }
    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<TaQuestionAttention> feignGet(@PathVariable Long id) {
        return R.ok(taQuestionAttentionService.getById(id));
    }
}
