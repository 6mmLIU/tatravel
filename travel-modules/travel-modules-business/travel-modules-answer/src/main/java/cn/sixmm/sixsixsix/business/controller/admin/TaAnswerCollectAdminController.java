package cn.sixmm.sixsixsix.business.controller.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import cn.sixmm.sixsixsix.common.core.domain.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.sixmm.sixsixsix.business.query.TaAnswerCollectQuery;
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
import cn.sixmm.sixsixsix.business.api.domain.TaAnswerCollect;
import cn.sixmm.sixsixsix.business.service.ITaAnswerCollectService;
import cn.sixmm.sixsixsix.common.core.web.controller.BaseController;
import cn.sixmm.sixsixsix.common.core.utils.poi.ExcelUtil;


/**
 * 问答-回答收藏关系Controller
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@RestController
@RequestMapping("/admin/answerCollects")
public class TaAnswerCollectAdminController extends BaseController
{
    @Autowired
    private ITaAnswerCollectService taAnswerCollectService;

    /**
     * 查询问答-回答收藏关系列表
     */
    @RequiresPermissions("business:answerCollect:list")
    @GetMapping("/list")
    public R<IPage<TaAnswerCollect>> list(TaAnswerCollectQuery qo) {
        return R.ok(taAnswerCollectService.queryPage(qo));
    }


    /**
     * 导出问答-回答收藏关系列表
     */
    @RequiresPermissions("business:answerCollect:export")
    @Log(title = "问答-回答收藏关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaAnswerCollect taAnswerCollect)
    {
        List<TaAnswerCollect> list = taAnswerCollectService.list();
        ExcelUtil<TaAnswerCollect> util = new ExcelUtil<TaAnswerCollect>(TaAnswerCollect.class);
        util.exportExcel(response, list, "问答-回答收藏关系数据");
    }

    /**
     * 获取问答-回答收藏关系详细信息
     */
    @RequiresPermissions("business:answerCollect:query")
    @GetMapping(value = "/{answerId}")
    public R<TaAnswerCollect> getInfo(@PathVariable("answerId") Long answerId)
    {
        return R.ok(taAnswerCollectService.getById(answerId));
    }

    /**
     * 新增问答-回答收藏关系
     */
    @RequiresPermissions("business:answerCollect:add")
    @Log(title = "问答-回答收藏关系", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody TaAnswerCollect taAnswerCollect)
    {
        return toAjax(taAnswerCollectService.save(taAnswerCollect));
    }

    /**
     * 修改问答-回答收藏关系
     */
    @RequiresPermissions("business:answerCollect:edit")
    @Log(title = "问答-回答收藏关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody TaAnswerCollect taAnswerCollect)
    {
        return toAjax(taAnswerCollectService.updateById(taAnswerCollect));
    }

    /**
     * 删除问答-回答收藏关系
     */
    @RequiresPermissions("business:answerCollect:remove")
    @Log(title = "问答-回答收藏关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{answerIds}")
    public R<?> remove(@PathVariable Long[] answerIds)
    {
        return toAjax(taAnswerCollectService.removeByIds(Arrays.stream(answerIds).collect(Collectors.toList())));
    }
}
