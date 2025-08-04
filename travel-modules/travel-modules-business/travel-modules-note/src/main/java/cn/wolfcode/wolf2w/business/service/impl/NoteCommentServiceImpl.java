package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.NoteComment;
import cn.wolfcode.wolf2w.business.mapper.NoteCommentMapper;
import cn.wolfcode.wolf2w.business.query.NoteCommentQuery;
import cn.wolfcode.wolf2w.business.service.INoteCommentService;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.context.SecurityContextHolder;
import cn.wolfcode.wolf2w.common.core.utils.StringUtils;
import cn.wolfcode.wolf2w.member.api.RemoteUserInfoService;
import cn.wolfcode.wolf2w.member.api.domain.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 游记评论Service业务层处理
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Service
@Transactional
public class NoteCommentServiceImpl extends ServiceImpl<NoteCommentMapper, NoteComment> implements INoteCommentService {
    @Autowired
    private RemoteUserInfoService remoteUserInfoService;

    @Override
    public void saveComment(NoteComment comment) throws Exception {
        String content = StringUtils.trimToNull(comment.getContent());
        if (content == null) {
            throw new Exception("评论内容不能为空");
        }
        comment.setContent(content);
        Long userId = SecurityContextHolder.getUserId();
        comment.setUserId(userId);
        comment.setCreateTime(new Date());
        comment.setStatus("0");
        baseMapper.insert(comment);
    }

    @Override
    public IPage<NoteComment> queryPage(NoteCommentQuery qo) {
        IPage<NoteComment> page = new Page<>(qo.getCurrentPage(), qo.getPageSize());
        LambdaQueryWrapper<NoteComment> qw = new LambdaQueryWrapper<>();
        qw.eq(NoteComment::getNoteId, qo.getNoteId());
        baseMapper.selectPage(page, qw);
        for (NoteComment comment : page.getRecords()) {
            UserInfo user = remoteUserInfoService.getOne(comment.getUserId(), SecurityConstants.INNER).getData();
            comment.setUser(user);
            Long refId = comment.getRefId();
            if (refId != null) {
                NoteComment refComment = baseMapper.selectById(refId);
                comment.setRefComment(refComment);
                UserInfo refUser = remoteUserInfoService.getOne(refComment.getUserId(), SecurityConstants.INNER).getData();
                refComment.setUser(refUser);
            }
        }
        return page;
    }
}
