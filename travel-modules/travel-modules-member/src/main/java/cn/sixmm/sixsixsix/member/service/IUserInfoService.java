package cn.sixmm.sixsixsix.member.service;

import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import cn.sixmm.sixsixsix.member.query.UserInfoQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 前台用户Service接口
 * 
 * @author dafei
 * @date 2023-06-18
 */
public interface IUserInfoService extends IService<UserInfo>{
    /**
    * 分页
    * @param qo
    * @return
    */
    IPage<UserInfo> queryPage(UserInfoQuery qo);

    /**
     * 根据usernam查询用户
     * @param username
     * @return
     */
    UserInfo queryByUsername(String username);

    boolean checkPhoneUnique(UserInfo userInfo);
}
