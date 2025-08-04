package cn.wolfcode.wolf2w.business.api.domain;

import cn.wolfcode.wolf2w.common.core.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 目的地对象 ta_destination
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data

@TableName("ta_destination")
public class Destination implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 中文名称
     */
    @Excel(name = "中文名称")
    private String name;

    /**
     * 英文名称
     */
    @Excel(name = "英文名称")
    private String english;

    /**
     * 封面图片
     */
    @Excel(name = "封面图片")
    private String coverUrl;

    /**
     * 介绍
     */
    @Excel(name = "介绍")
    private String info;

    /**
     * 上级名称
     */
    @Excel(name = "上级名称")
    private String parentName;

    /**
     * 上级ID
     */
    @Excel(name = "上级ID")
    private Long parentId;

    /**
     * 地区(板块)归属
     */
    @Excel(name = "地区(板块)归属")
    private Long regionId;

    /**
     * 0正常 1审核中
     */
    @Excel(name = "0正常 1审核中")
    private Long status;
    @TableField(exist = false)
    private List<Destination> children = new ArrayList<>();

}
