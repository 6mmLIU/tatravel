package cn.sixmm.sixsixsix.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.sixmm.sixsixsix.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.sixmm.sixsixsix.business.query.TaAnswerLikeQuery;
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
import cn.sixmm.sixsixsix.business.api.domain.TaAnswerLike;
import cn.sixmm.sixsixsix.business.service.ITaAnswerLikeService;
import cn.sixmm.sixsixsix.common.core.web.controller.BaseController;
import cn.sixmm.sixsixsix.common.core.utils.poi.ExcelUtil;


/**
 * 问答-回答点赞Controller
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("/admin/answerLikes")
public class TaAnswerLikeAdminController extends BaseController
{
    @Autowired
    private ITaAnswerLikeService taAnswerLikeService;

    /**
     * 查询问答-回答点赞列表
     */
    @RequiresPermissions("business:answerLike:list")
    @GetMapping("/list")
    public R<IPage<TaAnswerLike>> list(TaAnswerLikeQuery qo) {
        return R.ok(taAnswerLikeService.queryPage(qo));
    }


    /**
     * 导出问答-回答点赞列表
     */
    @RequiresPermissions("business:answerLike:export")
    @Log(title = "问答-回答点赞", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaAnswerLike taAnswerLike)
    {
        List<TaAnswerLike> list = taAnswerLikeService.list();
        ExcelUtil<TaAnswerLike> util = new ExcelUtil<TaAnswerLike>(TaAnswerLike.class);
        util.exportExcel(response, list, "问答-回答点赞数据");
    }

    /**
     * 获取问答-回答点赞详细信息
     */
    @RequiresPermissions("business:answerLike:query")
    @GetMapping(value = "/{answerId}")
    public R<TaAnswerLike> getInfo(@PathVariable("answerId") Long answerId)
    {
        return R.ok(taAnswerLikeService.getById(answerId));
    }

    /**
     * 新增问答-回答点赞
     */
    @RequiresPermissions("business:answerLike:add")
    @Log(title = "问答-回答点赞", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody TaAnswerLike taAnswerLike)
    {
        return toAjax(taAnswerLikeService.save(taAnswerLike));
    }

    /**
     * 修改问答-回答点赞
     */
    @RequiresPermissions("business:answerLike:edit")
    @Log(title = "问答-回答点赞", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody TaAnswerLike taAnswerLike)
    {
        return toAjax(taAnswerLikeService.updateById(taAnswerLike));
    }

    /**
     * 删除问答-回答点赞
     */
    @RequiresPermissions("business:answerLike:remove")
    @Log(title = "问答-回答点赞", businessType = BusinessType.DELETE)
	@DeleteMapping("/{answerIds}")
    public R<?> remove(@PathVariable Long[] answerIds)
    {
        return toAjax(taAnswerLikeService.removeByIds(Arrays.stream(answerIds).collect(Collectors.toList())));
    }
}
