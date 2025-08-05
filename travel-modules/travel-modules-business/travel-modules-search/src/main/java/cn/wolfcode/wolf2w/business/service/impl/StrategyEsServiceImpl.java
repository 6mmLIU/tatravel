package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.RemoteStrategyService;
import cn.wolfcode.wolf2w.business.api.domain.Strategy;
import cn.wolfcode.wolf2w.business.api.domain.StrategyES;
import cn.wolfcode.wolf2w.business.respository.StrategyEsRepository;
import cn.wolfcode.wolf2w.business.service.IStrategyEsService;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.utils.bean.BeanUtils;
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
