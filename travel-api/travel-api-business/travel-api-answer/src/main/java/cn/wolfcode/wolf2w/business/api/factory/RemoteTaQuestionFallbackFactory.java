package cn.wolfcode.wolf2w.business.api.factory;

import cn.wolfcode.wolf2w.business.api.RemoteTaQuestionService;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.TaQuestion;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 问答-问题 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@Component
public class RemoteTaQuestionFallbackFactory implements FallbackFactory<RemoteTaQuestionService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteTaQuestionFallbackFactory.class);

    @Override
    public RemoteTaQuestionService create(Throwable throwable) {
        log.error("问答-问题服务调用失败:{}", throwable.getMessage());

        return new RemoteTaQuestionService() {
            @Override
            public R<List<TaQuestion>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询问答-问题列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<TaQuestion> getOne(Long id, String source) {
                return R.fail("查询问答-问题信息失败:" + throwable.getMessage());
            }
        };
    }
}
