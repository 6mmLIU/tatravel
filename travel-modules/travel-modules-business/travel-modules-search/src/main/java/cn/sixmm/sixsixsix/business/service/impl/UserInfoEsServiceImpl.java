package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.domain.UserInfoES;
import cn.sixmm.sixsixsix.business.respository.UserInfoRepository;
import cn.sixmm.sixsixsix.business.service.IUserInfoEsService;
import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.utils.bean.BeanUtils;
import cn.sixmm.sixsixsix.member.api.RemoteUserInfoService;
import cn.sixmm.sixsixsix.member.api.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserInfoEsServiceImpl implements IUserInfoEsService {
    private final UserInfoRepository repository;
    private final RemoteUserInfoService remoteUserInfoService;

    @Override
    public void initData() {
        List<UserInfo> list = remoteUserInfoService.list(SecurityConstants.INNER).getData();
        List<UserInfoES> esList = new ArrayList<>();
        for (UserInfo userInfo : list) {
            UserInfoES es = new UserInfoES();
            BeanUtils.copyProperties(userInfo, es);
            esList.add(es);
        }
        repository.saveAll(esList);
    }
}
