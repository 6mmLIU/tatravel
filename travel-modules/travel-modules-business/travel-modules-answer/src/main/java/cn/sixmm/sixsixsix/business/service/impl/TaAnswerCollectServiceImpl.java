package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.domain.TaAnswerCollect;
import cn.sixmm.sixsixsix.business.mapper.TaAnswerCollectMapper;
import cn.sixmm.sixsixsix.business.query.TaAnswerCollectQuery;
import cn.sixmm.sixsixsix.business.service.ITaAnswerCollectService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 问答-回答收藏关系Service业务层处理
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@Service
@Transactional
public class TaAnswerCollectServiceImpl extends ServiceImpl<TaAnswerCollectMapper,TaAnswerCollect> implements ITaAnswerCollectService {

    @Override
    public IPage<TaAnswerCollect> queryPage(TaAnswerCollectQuery qo) {
        IPage<TaAnswerCollect> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }
}
