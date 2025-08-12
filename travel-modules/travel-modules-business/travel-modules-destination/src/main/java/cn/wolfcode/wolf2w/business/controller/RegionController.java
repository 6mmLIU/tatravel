package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.business.api.domain.Region;
import cn.wolfcode.wolf2w.business.query.RegionQuery;
import cn.wolfcode.wolf2w.business.service.IRegionService;
import cn.wolfcode.wolf2w.common.security.annotation.RequiresLogin;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 区域 Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Api(value = "热门区域接口类", tags = "封装热门区域的对外接口和feign接口实现")
@RestController
@RequestMapping("/regions")
@ApiResponses(
        {
                @ApiResponse(code = 200, message = "成功"),
                @ApiResponse(code = 200, message = "参数异常"),
                @ApiResponse(code = 200, message = "未认证"),
                @ApiResponse(code = 200, message = "未授权"),
                @ApiResponse(code = 200, message = "无页面"),
                @ApiResponse(code = 200, message = "服务器内部错误")

        }
)
public class RegionController {
    @Autowired
    private IRegionService regionService;

    @GetMapping("/testauth")
    @RequiresLogin
    public R<?> testauth() {
        return R.ok("测试成功");
    }

    /**
     * 区域详情
     */
    @ApiOperation(value = "热门区域详情查询", notes = "根据区域id查询区域详情")
    @GetMapping("/detail/{id}")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "详情id", required = true, dataType = "Long", example = "5L")
    )
    public R<Region> detail(@PathVariable Long id) {
        Region region = regionService.getById(id);
        return R.ok(region);
    }

    /**
     * 区域 列表
     */
    @ApiOperation(value = "热门区域分页查询", notes = "热门区域分页查询参数为分页对象")
    @GetMapping("/query")
    public R<IPage<Region>> query(RegionQuery qo) {
        IPage<Region> page = regionService.queryPage(qo);
        return R.ok(page);
    }


    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @ApiIgnore
    @GetMapping("/feign/list")
    public R<List<Region>> feignList() {
        return R.ok(regionService.list());
    }
    @ApiIgnore
    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<Region> feignGet(@PathVariable Long id) {
        return R.ok(regionService.getById(id));
    }
}
