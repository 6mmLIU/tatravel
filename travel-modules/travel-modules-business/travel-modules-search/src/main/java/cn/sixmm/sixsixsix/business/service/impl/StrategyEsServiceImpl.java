package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.RemoteStrategyService;
import cn.sixmm.sixsixsix.business.api.domain.Strategy;
import cn.sixmm.sixsixsix.business.api.domain.StrategyES;
import cn.sixmm.sixsixsix.business.respository.StrategyEsRepository;
import cn.sixmm.sixsixsix.business.service.IStrategyEsService;
import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.utils.bean.BeanUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StrategyEsServiceImpl implements IStrategyEsService {
    private final StrategyEsRepository repository;
    private final RemoteStrategyService remoteStrategyService;

    @Override
    public void initData() {
        List<Strategy> list = remoteStrategyService.list2(SecurityConstants.INNER).getData();
        List<StrategyES> esList = new ArrayList<>();
        for (Strategy strategy : list) {
            StrategyES es = new StrategyES();
            BeanUtils.copyProperties(strategy, es);
            esList.add(es);
        }
        repository.saveAll(esList);
    }
}
