package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.TaQuestionQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.wolfcode.wolf2w.common.log.annotation.Log;
import cn.wolfcode.wolf2w.common.log.enums.BusinessType;
import cn.wolfcode.wolf2w.common.security.annotation.RequiresPermissions;
import cn.wolfcode.wolf2w.business.api.domain.TaQuestion;
import cn.wolfcode.wolf2w.business.service.ITaQuestionService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;


/**
 * 问答-问题Controller
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("/admin/answerQuestions")
public class TaQuestionAdminController extends BaseController
{
    @Autowired
    private ITaQuestionService taQuestionService;

    /**
     * 查询问答-问题列表
     */
    @RequiresPermissions("business:answerQuestion:list")
    @GetMapping("/list")
    public R<IPage<TaQuestion>> list(TaQuestionQuery qo) {
        return R.ok(taQuestionService.queryPage(qo));
    }


    /**
     * 导出问答-问题列表
     */
    @RequiresPermissions("business:answerQuestion:export")
    @Log(title = "问答-问题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaQuestion taQuestion)
    {
        List<TaQuestion> list = taQuestionService.list();
        ExcelUtil<TaQuestion> util = new ExcelUtil<TaQuestion>(TaQuestion.class);
        util.exportExcel(response, list, "问答-问题数据");
    }

    /**
     * 获取问答-问题详细信息
     */
    @RequiresPermissions("business:answerQuestion:query")
    @GetMapping(value = "/{id}")
    public R<TaQuestion> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(taQuestionService.getById(id));
    }

    /**
     * 新增问答-问题
     */
    @RequiresPermissions("business:answerQuestion:add")
    @Log(title = "问答-问题", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody TaQuestion taQuestion)
    {
        return toAjax(taQuestionService.save(taQuestion));
    }

    /**
     * 修改问答-问题
     */
    @RequiresPermissions("business:answerQuestion:edit")
    @Log(title = "问答-问题", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody TaQuestion taQuestion)
    {
        return toAjax(taQuestionService.updateById(taQuestion));
    }

    /**
     * 删除问答-问题
     */
    @RequiresPermissions("business:answerQuestion:remove")
    @Log(title = "问答-问题", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(taQuestionService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
