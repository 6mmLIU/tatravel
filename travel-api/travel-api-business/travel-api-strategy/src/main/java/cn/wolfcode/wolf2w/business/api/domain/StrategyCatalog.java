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

/**
 * 攻略分类对象 ta_strategy_catalog
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data
@TableName("ta_strategy_catalog")
public class StrategyCatalog implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String name;

    /** 目的id */
    @Excel(name = "目的id")
    private Long destId;

    /** 状态 0:显示 1:禁用 */
    @Excel(name = "状态 0:显示 1:禁用")
    private Long state;

    /** 排序 */
    @Excel(name = "排序")
    private Long seq;

    /** 目的名称 */
    @Excel(name = "目的名称")
    private String destName;

}
