package cn.wolfcode.wolf2w.business.query;


import cn.wolfcode.wolf2w.common.core.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

/**
 * 关联id查询参数封装对象
 */
@Setter
@Getter
public class NoteCommentQuery extends QueryObject {
    private Long noteId;
}
