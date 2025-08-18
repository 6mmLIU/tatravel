package cn.sixmm.sixsixsix.business.api.factory;

import cn.sixmm.sixsixsix.business.api.RemoteTaAnswerService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.business.api.domain.TaAnswer;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 问答-回答 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@Component
public class RemoteTaAnswerFallbackFactory implements FallbackFactory<RemoteTaAnswerService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteTaAnswerFallbackFactory.class);

    @Override
    public RemoteTaAnswerService create(Throwable throwable) {
        log.error("问答-回答服务调用失败:{}", throwable.getMessage());

        return new RemoteTaAnswerService() {
            @Override
            public R<List<TaAnswer>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询问答-回答列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<TaAnswer> getOne(Long id, String source) {
                return R.fail("查询问答-回答信息失败:" + throwable.getMessage());
            }
        };
    }
}
