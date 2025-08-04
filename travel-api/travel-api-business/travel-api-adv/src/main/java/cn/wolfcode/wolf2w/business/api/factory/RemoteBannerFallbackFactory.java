package cn.wolfcode.wolf2w.business.api.factory;

import cn.wolfcode.wolf2w.business.api.RemoteBannerService;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.business.api.domain.Banner;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文章推荐 远程服务降级回调
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Component
public class RemoteBannerFallbackFactory implements FallbackFactory<RemoteBannerService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteBannerFallbackFactory.class);

    @Override
    public RemoteBannerService create(Throwable throwable) {
        log.error("文章推荐服务调用失败:{}", throwable.getMessage());

        return new RemoteBannerService() {
            @Override
            public R<List<Banner>> list(String source) {
                return R.fail(Lists.newArrayList(), "查询文章推荐列表信息失败:" + throwable.getMessage());
            }

            @Override
            public R<Banner> getOne(Long id, String source) {
                return R.fail("查询文章推荐信息失败:" + throwable.getMessage());
            }
        };
    }
}
