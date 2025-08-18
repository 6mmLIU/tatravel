package cn.sixmm.sixsixsix.common.core.web.controller;

import cn.sixmm.sixsixsix.common.core.constant.HttpStatus;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.core.utils.DateUtils;
import cn.sixmm.sixsixsix.common.core.utils.PageUtils;
import cn.sixmm.sixsixsix.common.core.web.page.TableDataInfo;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * web层通用数据处理
 * 
 * @author ruoyi
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageUtils.startPage();
    }

    /**
     * 清理分页的线程变量
     */
    protected void clearPage()
    {
        PageUtils.clearPage();
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setRows(list);
        rspData.setMsg("查询成功");
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected R<?> toAjax(int rows)
    {
        return rows > 0 ? R.ok() : R.fail();
    }

    /**
     * 响应返回结果
     * 
     * @param result 结果
     * @return 操作结果
     */
    protected R<?> toAjax(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * 返回成功
     */
    public R<?> success()
    {
        return R.ok();
    }

    /**
     * 返回失败消息
     */
    public R<?> error()
    {
        return R.fail();
    }

    /**
     * 返回成功消息
     */
    public R<?> success(String message)
    {
        return R.ok(null,message);
    }
    /**
     * 返回成功消息
     */
    public R<?> success(Object data)
    {
        return R.ok(data);
    }


    /**
     * 返回失败消息
     */
    public R<?> error(String message)
    {
        return R.fail(message);
    }
}
