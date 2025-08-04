package cn.wolfcode.wolf2w.business.api.factory;

import cn.wolfcode.wolf2w.business.api.RemoteTaAnswerCollectService;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.TaAnswerCollect;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 问答-回答收藏关系 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@Component
public class RemoteTaAnswerCollectFallbackFactory implements FallbackFactory<RemoteTaAnswerCollectService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteTaAnswerCollectFallbackFactory.class);

    @Override
    public RemoteTaAnswerCollectService create(Throwable throwable) {
        log.error("问答-回答收藏关系服务调用失败:{}", throwable.getMessage());

        return new RemoteTaAnswerCollectService() {
            @Override
            public R<List<TaAnswerCollect>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询问答-回答收藏关系列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<TaAnswerCollect> getOne(Long id, String source) {
                return R.fail("查询问答-回答收藏关系信息失败:" + throwable.getMessage());
            }
        };
    }
}
