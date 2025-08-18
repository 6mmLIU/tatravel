package cn.sixmm.sixsixsix.business.api.domain;

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
 * 攻略主题对象 ta_strategy_theme
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data
@TableName("ta_strategy_theme")
public class StrategyTheme implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 主题名称 */
    @Excel(name = "主题名称")
    private String name;

    /** 主题状态 */
    @Excel(name = "主题状态")
    private Long state;

    /** 序号 */
    @Excel(name = "序号")
    private Long seq;

}
