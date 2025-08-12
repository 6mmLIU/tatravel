package cn.wolfcode.wolf2w.business.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import java.util.Date;

/**
 * 攻略对象 ta_strategy
 *
 * @author y
 * @date 2025-07-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ta_strategy")
public class StrategyCanal {

    private Long id;
    @Column(name = "dest_id")
    private Long destId;
    @Column(name = "dest_name")
    private String destName;
    @Column(name = "theme_id")
    private Long themeId;
    @Column(name = "theme_name")
    private String themeName;
    @Column(name = "catalog_id")
    private Long catalogId;
    @Column(name = "catalog_name")
    private String catalogName;

    private String title;
    @Column(name = "sub_title")
    private String subTitle;

    private String summary;
    @Column(name = "cover_url")
    private String coverUrl;

    private Long isabroad;

    private Long viewnum;

    private Long replynum;

    private Long favornum;

    private Long sharenum;

    private Long thumbsupnum;

    private Long state;

    @Column(name = "create_time")
    private Date createTime;


}
