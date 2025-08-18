package cn.sixmm.sixsixsix.business.api.domain;

import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import cn.sixmm.sixsixsix.common.core.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 攻略评论对象 ta_strategy_comment
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data
@TableName("ta_strategy_comment")
public class StrategyComment implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 攻略(明细)id
     */
    @Excel(name = "攻略(明细)id")
    private Long strategyId;

    /**
     * 攻略标题
     */
    @Excel(name = "攻略标题")
    private String strategyTitle;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 评论内容
     */
    @Excel(name = "评论内容")
    private String content;

    /**
     * 状态 0正常 1禁用
     */
    @Excel(name = "状态 0正常 1禁用")
    private Long state;

    /**
     * 点赞数
     */
    @Excel(name = "点赞数")
    private Long thumbnum;

    /**
     * 点赞用户id
     */
    @Excel(name = "点赞用户id")
    private String thumbupids;

    private Date createTime;

    @TableField(exist = false)
    private UserInfo user;

}
