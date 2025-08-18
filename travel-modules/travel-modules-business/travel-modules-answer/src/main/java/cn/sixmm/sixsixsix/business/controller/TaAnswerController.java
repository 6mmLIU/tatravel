package cn.sixmm.sixsixsix.business.controller;

import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.security.annotation.InnerAuth;
import cn.sixmm.sixsixsix.business.api.domain.TaAnswer;
import cn.sixmm.sixsixsix.business.query.TaAnswerQuery;
import cn.sixmm.sixsixsix.business.service.ITaAnswerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 问答-回答 Controller
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("taAnswers")
public class TaAnswerController {
    @Autowired
    private ITaAnswerService taAnswerService;
    /**
     * 问答-回答详情
     */
    @GetMapping("/detail/{id}")
    public R<TaAnswer> detail(@PathVariable Long id) {
        TaAnswer taAnswer = taAnswerService.getById(id);
        return R.ok(taAnswer);
    }
    /**
     * 问答-回答 列表
     */
    @GetMapping("/query")
    public R<IPage<TaAnswer>> query(TaAnswerQuery qo) {
        IPage<TaAnswer> page = taAnswerService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<TaAnswer>> feignList() {
        return R.ok(taAnswerService.list());
    }
    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<TaAnswer> feignGet(@PathVariable Long id) {
        return R.ok(taAnswerService.getById(id));
    }
}
