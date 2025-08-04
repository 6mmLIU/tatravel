package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.TaAnswer;
import cn.wolfcode.wolf2w.business.api.domain.dto.AnswerDTO;
import cn.wolfcode.wolf2w.business.mapper.TaAnswerMapper;
import cn.wolfcode.wolf2w.business.query.TaAnswerQuery;
import cn.wolfcode.wolf2w.business.service.ITaAnswerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
 * 问答-回答Service业务层处理
 * 
 * @author liuhaoming
 * @date 2025-07-31
 */
@Service
@Transactional
public class TaAnswerServiceImpl extends ServiceImpl<TaAnswerMapper,TaAnswer> implements ITaAnswerService {

    @Override
    public IPage<TaAnswer> queryPage(TaAnswerQuery qo) {
        IPage<TaAnswer> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }

    @Override
    public Long create(AnswerDTO dto, Long userId) {
        TaAnswer a = new TaAnswer();
        a.setQuestionId(dto.getQuestionId());
        a.setAuthorId(userId);
        a.setContent(dto.getContent());
        a.setLikeNum(0L);
        a.setCollectNum(0L);
        a.setCommentNum(0L);
        a.setStatus(0L);
        Date now = new Date();
        a.setCreateTime(now);
        a.setUpdateTime(now);
        this.save(a);
        return a.getId();
    }
}
