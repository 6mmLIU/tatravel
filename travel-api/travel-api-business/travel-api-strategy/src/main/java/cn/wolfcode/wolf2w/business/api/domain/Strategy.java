package cn.wolfcode.wolf2w.business.api.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * 攻略对象 ta_strategy
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data
@TableName("ta_strategy")
public class Strategy implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 引用目的地ID
     */
    @Excel(name = "引用目的地ID")
    private Long destId;

    /**
     * 引用目的地名称
     */
    @Excel(name = "引用目的地名称")
    private String destName;

    /**
     * 引用主题ID
     */
    @Excel(name = "引用主题ID")
    private Long themeId;

    /**
     * 引用主题名称
     */
    @Excel(name = "引用主题名称")
    private String themeName;

    /**
     * 引用分类ID
     */
    @Excel(name = "引用分类ID")
    private Long catalogId;

    /**
     * 引用分类名称
     */
    @Excel(name = "引用分类名称")
    private String catalogName;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 副标题
     */
    @Excel(name = "副标题")
    private String subTitle;

    /**
     * 内容概要
     */
    @Excel(name = "内容概要")
    private String summary;

    /**
     * 封面图片地址
     */
    @Excel(name = "封面图片地址")
    private String coverUrl;

    /**
     * 是否为国外，0表示国内，1表示国外
     */
    @Excel(name = "是否为国外，0表示国内，1表示国外")
    private Long isabroad;

    /**
     * 点击数
     */
    @Excel(name = "点击数")
    private Long viewnum;

    /**
     * 攻略评论数
     */
    @Excel(name = "攻略评论数")
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
     * 状态，0表示待发布，1表示发布
     */
    @Excel(name = "状态，0表示待发布，1表示发布")
    private Long state;
    private Date createTime;
    @TableField(exist = false)
    private StrategyContent content;
}
