package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.RemoteDestinationService;
import cn.sixmm.sixsixsix.business.api.domain.Destination;
import cn.sixmm.sixsixsix.business.api.domain.Note;
import cn.sixmm.sixsixsix.business.api.domain.NoteComment;
import cn.sixmm.sixsixsix.business.api.domain.NoteContent;
import cn.sixmm.sixsixsix.business.mapper.NoteContentMapper;
import cn.sixmm.sixsixsix.business.mapper.NoteMapper;
import cn.sixmm.sixsixsix.business.query.NoteCommentQuery;
import cn.sixmm.sixsixsix.business.query.NoteCondition;
import cn.sixmm.sixsixsix.business.query.NoteQuery;
import cn.sixmm.sixsixsix.business.service.INoteService;
import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.context.SecurityContextHolder;
import cn.sixmm.sixsixsix.member.api.RemoteUserInfoService;
import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 旅游日记Service业务层处理
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
@Transactional
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements INoteService {

    @Autowired
    private RemoteUserInfoService remoteUserInfoService;
    @Autowired
    private NoteContentMapper noteContentMapper;
    @Autowired
    private RemoteDestinationService remoteDestinationService;

    @Override
    public IPage<Note> queryPage(NoteQuery qo) {
        IPage<Note> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        QueryWrapper<Note> qw = new QueryWrapper<>();
        qw.orderByDesc(qo.getOrderBy());
        NoteCondition dayCondition = NoteCondition.DAY_MAP.get(qo.getDayType());
        if (dayCondition != null) {
            qw.between("days", dayCondition.getMin(), dayCondition.getMax());
        }
        NoteCondition consumeCondition = NoteCondition.CONSUME_MAP.get(qo.getConsumeType());
        if (consumeCondition != null) {
            qw.between("avg_consume", consumeCondition.getMin(), consumeCondition.getMax());

        }
        NoteCondition timeCondition = NoteCondition.TIME_MAP.get(qo.getTravelTimeType());
        if (timeCondition != null) {
            qw.between("MONTH(travel_time)", timeCondition.getMin(), timeCondition.getMax());
        }

        baseMapper.selectPage(page, qw);
        for (Note note : page.getRecords()) {
            Long authorId = note.getAuthorId();
            UserInfo author = remoteUserInfoService.getOne(authorId, SecurityConstants.INNER).getData();
            note.setAuthor(author);
        }
        return page;
    }

    @Override
    public Note queryById(Long id) {
        Note note = baseMapper.selectById(id);
        Long authorId = note.getAuthorId();
        UserInfo author = remoteUserInfoService.getOne(authorId, SecurityConstants.INNER).getData();
        note.setAuthor(author);
        NoteContent content = noteContentMapper.selectById(id);
        note.setContent(content);
        return note;
    }

    @Override
    public List<Note> queryViewTop3(Long destId) {
        return lambdaQuery().eq(Note::getDestId, destId)
                .orderByDesc(Note::getViewnum)
                .last("limit 3")
                .list();
    }

    @Override
    public void saveNote(Note note) {
        Destination destination = remoteDestinationService.getOne(note.getDestId(), SecurityConstants.INNER).getData();
        note.setDestName(destination.getName());
        Long userId = SecurityContextHolder.getUserId();
        note.setAuthorId(userId);
        Date now = new Date();
        note.setCreateTime(now);
        note.setUpdateTime(now);
        note.setStatus("0");
        note.setViewnum(0l);
        note.setReplynum(0l);
        note.setFavornum(0l);
        note.setSharenum(0l);
        note.setThumbsupnum(0l);
        baseMapper.insert(note);
        Long id = note.getId();
        String content = note.getContent().getContent();
        NoteContent noteContent = new NoteContent();
        noteContent.setId(id);
        noteContent.setContent(content);
        noteContentMapper.insert(noteContent);
    }
}
