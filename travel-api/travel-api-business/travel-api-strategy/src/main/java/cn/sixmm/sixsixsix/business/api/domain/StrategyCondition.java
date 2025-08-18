package cn.sixmm.sixsixsix.business.api.domain;

import java.util.Date;
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
 * 攻略条件对象 ta_strategy_condition
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data
@TableName("ta_strategy_condition")
public class StrategyCondition implements Serializable {
    private static final long serialVersionUID = 1L;
    /** $column.columnComment */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 统计数量
 */
    @Excel(name = "统计数量 ")
    private Long count;

    /** 引用攻略ID */
    @Excel(name = "引用攻略ID")
    private Long refid;

    /** 条件类型，1表示国外，2表示国内，3表示主题 */
    @Excel(name = "条件类型，1表示国外，2表示国内，3表示主题")
    private Long type;

    /** 归档统计时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "归档统计时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statisTime;


}
