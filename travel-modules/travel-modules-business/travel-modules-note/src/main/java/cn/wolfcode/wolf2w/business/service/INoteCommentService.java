package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.NoteComment;
import cn.wolfcode.wolf2w.business.query.NoteCommentQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 游记评论Service接口
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface INoteCommentService extends IService<NoteComment>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<NoteComment> queryPage(NoteCommentQuery qo);

    void saveComment(NoteComment comment) throws Exception;
}
