package cn.wolfcode.wolf2w.business.service;

import cn.wolfcode.wolf2w.business.api.domain.NoteContent;
import cn.wolfcode.wolf2w.business.query.NoteContentQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 游记内容Service接口
 * 
 * @author liuhaoming
 * @date 2025-07-22
 */
public interface INoteContentService extends IService<NoteContent>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<NoteContent> queryPage(NoteContentQuery qo);
}
