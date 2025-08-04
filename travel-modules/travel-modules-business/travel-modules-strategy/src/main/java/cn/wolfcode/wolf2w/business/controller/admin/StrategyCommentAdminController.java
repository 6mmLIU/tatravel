package cn.wolfcode.wolf2w.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.wolfcode.wolf2w.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wolfcode.wolf2w.business.query.StrategyCommentQuery;
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
import cn.wolfcode.wolf2w.business.api.domain.StrategyComment;
import cn.wolfcode.wolf2w.business.service.IStrategyCommentService;
import cn.wolfcode.wolf2w.common.core.web.controller.BaseController;
import cn.wolfcode.wolf2w.common.core.utils.poi.ExcelUtil;


/**
 * 攻略评论Controller
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/admin/comments")
public class StrategyCommentAdminController extends BaseController
{
    @Autowired
    private IStrategyCommentService strategyCommentService;

    /**
     * 查询攻略评论列表
     */
    @RequiresPermissions("business:comment:list")
    @GetMapping("/list")
    public R<IPage<StrategyComment>> list(StrategyCommentQuery qo) {
        return R.ok(strategyCommentService.queryPage(qo));
    }


    /**
     * 导出攻略评论列表
     */
    @RequiresPermissions("business:comment:export")
    @Log(title = "攻略评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StrategyComment strategyComment)
    {
        List<StrategyComment> list = strategyCommentService.list();
        ExcelUtil<StrategyComment> util = new ExcelUtil<StrategyComment>(StrategyComment.class);
        util.exportExcel(response, list, "攻略评论数据");
    }

    /**
     * 获取攻略评论详细信息
     */
    @RequiresPermissions("business:comment:query")
    @GetMapping(value = "/{id}")
    public R<StrategyComment> getInfo(@PathVariable("id") Long id)
    {
        return R.ok(strategyCommentService.getById(id));
    }

    /**
     * 新增攻略评论
     */
    @RequiresPermissions("business:comment:add")
    @Log(title = "攻略评论", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody StrategyComment strategyComment)
    {
        return toAjax(strategyCommentService.save(strategyComment));
    }

    /**
     * 修改攻略评论
     */
    @RequiresPermissions("business:comment:edit")
    @Log(title = "攻略评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody StrategyComment strategyComment)
    {
        return toAjax(strategyCommentService.updateById(strategyComment));
    }

    /**
     * 删除攻略评论
     */
    @RequiresPermissions("business:comment:remove")
    @Log(title = "攻略评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids)
    {
        return toAjax(strategyCommentService.removeByIds(Arrays.stream(ids).collect(Collectors.toList())));
    }
}
