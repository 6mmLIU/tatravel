package cn.wolfcode.wolf2w.business.api.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.wolfcode.wolf2w.common.core.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * 问答-回答对象 ta_answer
 *
 * @author liuhaoming
 * @date 2025-07-31
 */
@Data
@TableName("ta_answer")
public class TaAnswer implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 问题id(ta_question.id) */
    @Excel(name = "问题id(ta_question.id)")
    private Long questionId;

    /** 回答者(ta_user_info.id) */
    @Excel(name = "回答者(ta_user_info.id)")
    private Long authorId;

    /** 昵称快照 */
    @Excel(name = "昵称快照")
    private String authorName;

    /** 头像快照 */
    @Excel(name = "头像快照")
    private String headImgUrl;

    /** 用户等级快照(前端有展示) */
    @Excel(name = "用户等级快照(前端有展示)")
    private Long level;

    /** 回答内容(富文本) */
    @Excel(name = "回答内容(富文本)")
    private String content;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long likeNum;

    /** 被收藏数 */
    @Excel(name = "被收藏数")
    private Long collectNum;

    /** 评论数 */
    @Excel(name = "评论数")
    private Long commentNum;

    /** 状态: 0正常 1禁用 2删除 */
    @Excel(name = "状态: 0正常 1禁用 2删除")
    private Long status;
    private Date createTime;
    private Date updateTime;

}
