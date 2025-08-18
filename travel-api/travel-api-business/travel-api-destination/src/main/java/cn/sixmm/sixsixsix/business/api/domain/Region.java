package cn.sixmm.sixsixsix.business.api.domain;

import cn.sixmm.sixsixsix.common.core.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 区域对象 ta_region
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data
@TableName("ta_region")
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 中文名称 */
    @Excel(name = "中文名称")
    private String name;

    /** 编码 */
    @Excel(name = "编码")
    private String sn;

    /** 是否热门，0非热门，1:热门 */
    @Excel(name = "是否热门，0非热门，1:热门")
    private Long ishot;

    /** 展示顺序 */
    @Excel(name = "展示顺序")
    private Long seq;

    /** 介绍 */
    @Excel(name = "介绍")
    private String info;

    /** 关联id集合 */
    @Excel(name = "关联id集合")
    private String refIds;

}
