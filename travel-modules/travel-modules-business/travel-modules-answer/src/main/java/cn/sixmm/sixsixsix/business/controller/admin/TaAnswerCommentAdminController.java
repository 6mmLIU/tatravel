package cn.sixmm.sixsixsix.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.sixmm.sixsixsix.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.sixmm.sixsixsix.business.query.TaAnswerCommentQuery;
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
import cn.sixmm.sixsixsix.business.api.domain.TaAnswerComment;
import cn.sixmm.sixsixsix.business.service.ITaAnswerCommentService;
import cn.sixmm.sixsixsix.common.core.web.controller.BaseController;
import cn.sixmm.sixsixsix.common.core.utils.poi.ExcelUtil;


/**
 * 问答-回答评论Controller
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("/admin/answerComments")
public class TaAnswerCommentAdminController extends BaseController
{
    @Autowired
    private ITaAnswerCommentService taAnswerCommentService;

    /**
     * 查询问答-回答评论列表
     */
    @RequiresPermissions("business:answerComment:list")
    @GetMapping("/list")
    public R<IPage<TaAnswerComment>> list(TaAnswerCommentQuery qo) {
        return R.ok(taAnswerCommentService.queryPage(qo));
    }


    /**
     * 导出问答-回答评论列表
     */
    @RequiresPermissions("business:answerComment:export")
    @Log(title = "问答-回答评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaAnswerComment taAnswerComment)
    {
        List<TaAnswerComment> list = taAnswerCommentService.list();
        ExcelUtil<TaAnswerComment> util = new ExcelUtil<TaAnswerComment>(TaAnswerComment.class);
        util.exportExcel(response, list, "问答-回答评论数据");
    }

    /**
     * 获取问答-回答评论详细信息
     */
    @RequiresPermissions("business:answerComment:query")
    @GetMapping(value = "/{id}")
    public R<TaAnswerComment> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(taAnswerCommentService.getById(id));
    }

    /**
     * 新增问答-回答评论
     */
    @RequiresPermissions("business:answerComment:add")
    @Log(title = "问答-回答评论", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody TaAnswerComment taAnswerComment)
    {
        return toAjax(taAnswerCommentService.save(taAnswerComment));
    }

    /**
     * 修改问答-回答评论
     */
    @RequiresPermissions("business:answerComment:edit")
    @Log(title = "问答-回答评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody TaAnswerComment taAnswerComment)
    {
        return toAjax(taAnswerCommentService.updateById(taAnswerComment));
    }

    /**
     * 删除问答-回答评论
     */
    @RequiresPermissions("business:answerComment:remove")
    @Log(title = "问答-回答评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(taAnswerCommentService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
