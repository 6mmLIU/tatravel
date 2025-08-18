package cn.sixmm.sixsixsix.member.api.factory;

import cn.sixmm.sixsixsix.member.api.RemoteUserInfoService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 前台用户 远程服务降级回调
 *
 * @author dafei
 * @date 2023-06-18
 */
@Component
public class RemoteUserInfoFallbackFactory implements FallbackFactory<RemoteUserInfoService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteUserInfoFallbackFactory.class);

    @Override
    public RemoteUserInfoService create(Throwable throwable) {
        log.error("前台用户服务调用失败:{}", throwable.getMessage());

        return new RemoteUserInfoService() {
            @Override
            public R<List<UserInfo>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询前台用户列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<UserInfo> getOne(Long id, String source) {
                return R.fail("查询前台用户信息失败:" + throwable.getMessage());
            }

            @Override
            public R<UserInfo> queryByUsername(String username, String source) {
                return R.fail("查询前台用户信息失败:" + throwable.getMessage());
            }

            @Override
            public R<Boolean> registerUserInfo(UserInfo userinfo, String source) {
                return R.fail("注册前台用户信息失败:" + throwable.getMessage());
            }
        };
    }
}
