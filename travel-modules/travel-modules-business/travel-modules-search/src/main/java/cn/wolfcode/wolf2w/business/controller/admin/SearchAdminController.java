package cn.wolfcode.wolf2w.business.controller.admin;

import cn.wolfcode.wolf2w.business.service.IDestinationEsService;
import cn.wolfcode.wolf2w.business.service.INoteEsService;
import cn.wolfcode.wolf2w.business.service.IStrategyEsService;
import cn.wolfcode.wolf2w.business.service.IUserInfoEsService;
import cn.wolfcode.wolf2w.common.core.domain.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SearchAdminController {
    //正常用post,.这里为了在浏览器测试方便,使用get方式
    private final IStrategyEsService strategyEsService;
    private final INoteEsService noteEsService;
    private final IDestinationEsService destinationEsService;
    private final IUserInfoEsService userInfoEsService;

    @GetMapping("/dataInit")
    public R<?> dataInit() {
        strategyEsService.initData();
        noteEsService.initData();
        destinationEsService.initData();
        userInfoEsService.initData();
        return R.ok("攻略ES数据初始化完成");
    }
}
