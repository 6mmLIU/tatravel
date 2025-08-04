package cn.wolfcode.wolf2w.member.api;

import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.member.api.domain.UserInfo;
import cn.wolfcode.wolf2w.member.api.factory.RemoteUserInfoFallbackFactory;
import cn.wolfcode.wolf2w.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 前台用户 远程服务
 *
 * @author dafei
 * @date 2023-06-18
 */
@FeignClient(contextId = "RemoteUserInfoService", name = ServiceNameConstants.MEMBER_SERVICE, fallbackFactory = RemoteUserInfoFallbackFactory.class)
public interface RemoteUserInfoService {

    @GetMapping("/userInfos/feign/list")
    R<List<UserInfo>> list(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/userInfos/feign/{id}")
    R<UserInfo> getOne(@PathVariable("id") Long id, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/userInfos/feign/queryByUsername")
    R<UserInfo> queryByUsername(@RequestParam("username") String username, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PostMapping("/userInfos/feign/register")
    public R<Boolean> registerUserInfo(@RequestBody UserInfo userInfo, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
