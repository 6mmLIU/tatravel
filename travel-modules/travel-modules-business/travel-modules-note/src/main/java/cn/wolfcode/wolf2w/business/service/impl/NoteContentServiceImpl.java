package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.NoteContent;
import cn.wolfcode.wolf2w.business.mapper.NoteContentMapper;
import cn.wolfcode.wolf2w.business.query.NoteContentQuery;
import cn.wolfcode.wolf2w.business.service.INoteContentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 游记内容Service业务层处理
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
@Transactional
public class NoteContentServiceImpl extends ServiceImpl<NoteContentMapper,NoteContent> implements INoteContentService {

    @Override
    public IPage<NoteContent> queryPage(NoteContentQuery qo) {
        IPage<NoteContent> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        return lambdaQuery()
                .page(page);
    }
}
