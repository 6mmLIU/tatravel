package cn.sixmm.sixsixsix.business.query;


import cn.sixmm.sixsixsix.common.core.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

/**
 * 游记状态 0:草稿 1:待发布(待审核) 2:审核通过 3:拒绝查询参数封装对象
 */
@Setter
@Getter
public class NoteQuery extends QueryObject {
    private String orderBy = "viewnum";
    private int travelTimeType;
    private int consumeType;
    private int dayType;
}
