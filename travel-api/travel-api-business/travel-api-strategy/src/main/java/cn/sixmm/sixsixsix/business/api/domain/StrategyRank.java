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
 * 攻略排行对象 ta_strategy_rank
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data
@TableName("ta_strategy_rank")
public class StrategyRank implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 目的地id */
    @Excel(name = "目的地id")
    private Long destId;

    /** 目的地名称 */
    @Excel(name = "目的地名称")
    private String destName;

    /** 攻略id */
    @Excel(name = "攻略id")
    private Long strategyId;

    /** 攻略标题 */
    @Excel(name = "攻略标题")
    private String strategyTitle;

    /** 排行类 1国外 2:国内 3热门 */
    @Excel(name = "排行类 1国外 2:国内 3热门")
    private Long type;

    /** 统计时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "统计时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statisTime;

    /** 统计数 */
    @Excel(name = "统计数")
    private Long statisnum;

}
