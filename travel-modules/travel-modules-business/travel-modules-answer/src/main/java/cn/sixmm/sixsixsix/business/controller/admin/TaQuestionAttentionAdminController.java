package cn.sixmm.sixsixsix.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.sixmm.sixsixsix.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.sixmm.sixsixsix.business.query.TaQuestionAttentionQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.sixmm.sixsixsix.common.log.annotation.Log;
import cn.sixmm.sixsixsix.common.log.enums.BusinessType;
import cn.sixmm.sixsixsix.common.security.annotation.RequiresPermissions;
import cn.sixmm.sixsixsix.business.api.domain.TaQuestionAttention;
import cn.sixmm.sixsixsix.business.service.ITaQuestionAttentionService;
import cn.sixmm.sixsixsix.common.core.web.controller.BaseController;
import cn.sixmm.sixsixsix.common.core.utils.poi.ExcelUtil;


/**
 * 问答-问题关注关系Controller
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("/admin/answerAttentions")
public class TaQuestionAttentionAdminController extends BaseController
{
    @Autowired
    private ITaQuestionAttentionService taQuestionAttentionService;

    /**
     * 查询问答-问题关注关系列表
     */
    @RequiresPermissions("business:answerAttention:list")
    @GetMapping("/list")
    public R<IPage<TaQuestionAttention>> list(TaQuestionAttentionQuery qo) {
        return R.ok(taQuestionAttentionService.queryPage(qo));
    }


    /**
     * 导出问答-问题关注关系列表
     */
    @RequiresPermissions("business:answerAttention:export")
    @Log(title = "问答-问题关注关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaQuestionAttention taQuestionAttention)
    {
        List<TaQuestionAttention> list = taQuestionAttentionService.list();
        ExcelUtil<TaQuestionAttention> util = new ExcelUtil<TaQuestionAttention>(TaQuestionAttention.class);
        util.exportExcel(response, list, "问答-问题关注关系数据");
    }

    /**
     * 获取问答-问题关注关系详细信息
     */
    @RequiresPermissions("business:answerAttention:query")
    @GetMapping(value = "/{questionId}")
    public R<TaQuestionAttention> getInfo(@PathVariable("questionId") Long questionId)
    {
        return R.ok(taQuestionAttentionService.getById(questionId));
    }

    /**
     * 新增问答-问题关注关系
     */
    @RequiresPermissions("business:answerAttention:add")
    @Log(title = "问答-问题关注关系", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody TaQuestionAttention taQuestionAttention)
    {
        return toAjax(taQuestionAttentionService.save(taQuestionAttention));
    }

    /**
     * 修改问答-问题关注关系
     */
    @RequiresPermissions("business:answerAttention:edit")
    @Log(title = "问答-问题关注关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody TaQuestionAttention taQuestionAttention)
    {
        return toAjax(taQuestionAttentionService.updateById(taQuestionAttention));
    }

    /**
     * 删除问答-问题关注关系
     */
    @RequiresPermissions("business:answerAttention:remove")
    @Log(title = "问答-问题关注关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{questionIds}")
    public R<?> remove(@PathVariable Long[] questionIds)
    {
        return toAjax(taQuestionAttentionService.removeByIds(Arrays.stream(questionIds).collect(Collectors.toList())));
    }
}
