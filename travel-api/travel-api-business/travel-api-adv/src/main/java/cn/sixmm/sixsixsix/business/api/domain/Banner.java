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
 * 文章推荐对象 ta_banner
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@Data
@TableName("ta_banner")
public class Banner implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 关联id */
    @Excel(name = "关联id")
    private Long refid;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 副标题 */
    @Excel(name = "副标题")
    private String subtitle;

    /** 封面 */
    @Excel(name = "封面")
    private String coverUrl;

    /** 状态： 0正常 1禁用 */
    @Excel(name = "状态： 0正常 1禁用")
    private Long state;

    /** 序号 */
    @Excel(name = "序号")
    private Long seq;

    /** 类型：1游记 2:攻略 */
    @Excel(name = "类型：1游记 2:攻略")
    private Long type;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("refid", getRefid())
            .append("title", getTitle())
            .append("subtitle", getSubtitle())
            .append("coverUrl", getCoverUrl())
            .append("state", getState())
            .append("seq", getSeq())
            .append("type", getType())
            .toString();
    }
}
