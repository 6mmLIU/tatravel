package cn.wolfcode.wolf2w.member.api.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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
 * 前台用户对象 ta_user_info
 *
 * @author dafei
 * @date 2023-06-18
 */

@TableName("ta_user_info")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;



    public static final int STATE_NORMAL = 0;  //正常
    public static final int STATE_FREEZE = 1;  //冻结

    /** 主键 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 手机 */
    @Excel(name = "手机")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 密码 */
    private String password;

    /** 性别 */
    @Excel(name = "性别")
    private Integer gender;

    /** 级别 */
    @Excel(name = "级别")
    private Integer level;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 头像 */
    @Excel(name = "头像")
    private String headImgUrl;

    /** 简介 */
    @Excel(name = "简介")
    private String info;

    /** 状态 0正常  1冻结 */
    @Excel(name = "状态 0正常  1冻结")
    private Integer state= STATE_NORMAL;

    /** 注册ip */
    @Excel(name = "注册ip")
    private String registerIp;

    /** 注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date registerTime;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;
}
