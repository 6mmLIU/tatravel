package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.domain.UserInfoES;
import cn.wolfcode.wolf2w.business.respository.UserInfoRepository;
import cn.wolfcode.wolf2w.business.service.IUserInfoEsService;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.core.utils.bean.BeanUtils;
import cn.wolfcode.wolf2w.member.api.RemoteUserInfoService;
import cn.wolfcode.wolf2w.member.api.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserInfoEsServiceImpl implements IUserInfoEsService {
    private final UserInfoRepository repository;
    private final RemoteUserInfoService remoteUserInfoService;

    @Override
    public boolean initData() {
        R<List<UserInfo>> result = remoteUserInfoService.list(SecurityConstants.INNER);
        if (R.isError(result) || result.getData() == null) {
            log.warn("获取用户数据失败:{}", result.getMsg());
            return false;
        }
        List<UserInfoES> esList = new ArrayList<>();
        for (UserInfo userInfo : result.getData()) {
            UserInfoES es = new UserInfoES();
            BeanUtils.copyProperties(userInfo, es);
            esList.add(es);
        }
        repository.saveAll(esList);
        return true;
    }
}
