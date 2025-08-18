package cn.sixmm.sixsixsix.business.controller;

import cn.sixmm.sixsixsix.business.api.domain.dto.QuestionCreateDTO;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.security.annotation.InnerAuth;
import cn.sixmm.sixsixsix.business.api.domain.TaQuestion;
import cn.sixmm.sixsixsix.business.query.TaQuestionQuery;
import cn.sixmm.sixsixsix.business.service.ITaQuestionService;
import cn.sixmm.sixsixsix.common.security.utils.SecurityUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.jsonwebtoken.lang.Assert;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * 问答-问题 Controller
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("/destinationDoubt")
public class TaQuestionController {
    @Autowired
    private ITaQuestionService taQuestionService;

    /**
     * 问答-问题详情
     */
    @GetMapping("/detail/{id}")
    public R<TaQuestion> detail(@PathVariable Long id) {
        TaQuestion taQuestion = taQuestionService.getById(id);
        return R.ok(taQuestion);
    }

    /**
     * 问答-问题 列表
     */
    @GetMapping("/page")
    public R<IPage<TaQuestion>> query(TaQuestionQuery qo) {
        IPage<TaQuestion> page = taQuestionService.queryPage(qo);
        return R.ok(page);
    }

    @PostMapping("/save")
    public R<Long> save(@RequestBody @Valid QuestionCreateDTO dto, HttpServletRequest req) {
        Long userId = SecurityUtils.getUserId();
        if (userId == null) {
            userId = Optional.ofNullable(req.getHeader("user-id")).map(Long::valueOf).orElse(null);
        }
        Assert.notNull(userId, "未登录");
        Long id=taQuestionService.create(dto,userId);
        return R.ok(id);
    }

    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<TaQuestion>> feignList() {
        return R.ok(taQuestionService.list());
    }

    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<TaQuestion> feignGet(@PathVariable Long id) {
        return R.ok(taQuestionService.getById(id));
    }
}
