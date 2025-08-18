package cn.sixmm.sixsixsix.business.api.domain;

import java.util.Date;

import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
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

/**
 * 旅游日记对象 ta_note
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data
@TableName("ta_note")
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 目的地id
     */
    @Excel(name = "目的地id")
    private Long destId;

    /**
     * 目的地
     */
    @Excel(name = "目的地")
    private String destName;

    /**
     * 作者id
     */
    @Excel(name = "作者id")
    private Long authorId;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 概要
     */
    @Excel(name = "概要")
    private String summary;

    /**
     * 封面
     */
    @Excel(name = "封面")
    private String coverUrl;

    /**
     * 旅游时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "旅游时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date travelTime;

    /**
     * 人均消费
     */
    @Excel(name = "人均消费")
    private Long avgConsume;

    /**
     * 旅游天数
     */
    @Excel(name = "旅游天数")
    private Long days;

    /**
     * 和谁旅游
     */
    @Excel(name = "和谁旅游")
    private String person;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    /**
     * 是否公开 0:否 1:是
     */
    @Excel(name = "是否公开 0:否 1:是")
    private String isPublic;

    /**
     * 点击/阅读数
     */
    @Excel(name = "点击/阅读数")
    private Long viewnum;

    /**
     * 回复数
     */
    @Excel(name = "回复数")
    private Long replynum;

    /**
     * 收藏数
     */
    @Excel(name = "收藏数")
    private Long favornum;

    /**
     * 分享数
     */
    @Excel(name = "分享数")
    private Long sharenum;

    /**
     * 点赞数
     */
    @Excel(name = "点赞数")
    private Long thumbsupnum;

    /**
     * 游记状态 0:草稿 1:待发布(待审核) 2:审核通过 3:拒绝
     */
    @Excel(name = "游记状态 0:草稿 1:待发布(待审核) 2:审核通过 3:拒绝")
    private String status;

    private Date createTime;
    private Date updateTime;
    @TableField(exist = false)
    private UserInfo author;

    @TableField(exist = false)
    private NoteContent content;

    public String getPersonDisplay() {
        switch (this.person) {
            case "1":
                return "一个人";
            case "2":
                return "情侣/夫妻";
            case "3":
                return "带孩子";
            case "4":
                return "家庭出游";
            case "5":
                return "和朋友";
            case "6":
                return "和同学";
            default:
                return "其他";
        }
    }

}
