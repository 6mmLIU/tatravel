package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.Note;
import cn.wolfcode.wolf2w.business.query.NoteQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 旅游日记Service接口
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface INoteService extends IService<Note>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<Note> queryPage(NoteQuery qo);

    Note queryById(Long id);

    List<Note> queryViewTop3(Long destId);

    void saveNote(Note note);
}
