package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.UserInfoES;
import cn.wolfcode.wolf2w.business.respository.UserInfoRepository;
import cn.wolfcode.wolf2w.business.service.IUserInfoEsService;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.utils.bean.BeanUtils;
import cn.wolfcode.wolf2w.member.api.RemoteUserInfoService;
import cn.wolfcode.wolf2w.member.api.domain.UserInfo;
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
