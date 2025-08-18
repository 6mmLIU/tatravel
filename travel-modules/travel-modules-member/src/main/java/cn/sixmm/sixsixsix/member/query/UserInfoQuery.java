package cn.sixmm.sixsixsix.member.query;


import cn.sixmm.sixsixsix.common.core.query.QueryObject;
import lombok.Getter;
import lombok.Setter;

/**
* 生日查询参数封装对象
*/
@Setter
@Getter
public class UserInfoQuery extends  QueryObject{
    private String nickname;
    private String phone;
    private Integer state;
}
