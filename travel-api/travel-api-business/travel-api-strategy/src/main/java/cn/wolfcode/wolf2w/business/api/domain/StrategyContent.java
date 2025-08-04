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
 * 攻略内容对象 ta_strategy_content
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data
@TableName("ta_strategy_content")
public class StrategyContent implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键 */
    @TableId(type = IdType.INPUT)
    private Long id;

    /** 攻略内容 */
    @Excel(name = "攻略内容")
    private String content;

}
