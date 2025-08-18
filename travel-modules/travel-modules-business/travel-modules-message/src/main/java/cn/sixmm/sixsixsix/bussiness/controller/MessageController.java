package cn.sixmm.sixsixsix.bussiness.controller;

import cn.sixmm.sixsixsix.bussiness.service.IMessageService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class MessageController {
    @Autowired
    private IMessageService messageService;

    @PostMapping("/sendVerifyCode")
    public Object sendVerifyCode(String phone) {
        messageService.sendVerifyCode(phone);
        return R.ok();
    }
}
