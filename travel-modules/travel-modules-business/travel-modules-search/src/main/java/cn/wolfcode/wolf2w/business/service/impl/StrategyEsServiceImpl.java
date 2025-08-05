package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.RemoteStrategyService;
import cn.wolfcode.wolf2w.business.api.domain.Strategy;
import cn.wolfcode.wolf2w.business.api.domain.StrategyES;
import cn.wolfcode.wolf2w.business.respository.StrategyEsRepository;
import cn.wolfcode.wolf2w.business.service.IStrategyEsService;
import cn.wolfcode.wolf2w.common.core.constant.SecurityConstants;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.core.utils.bean.BeanUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class StrategyEsServiceImpl implements IStrategyEsService {
    private final StrategyEsRepository repository;
    private final RemoteStrategyService remoteStrategyService;

    @Override
    public void initData() {
        R<List<Strategy>> result = remoteStrategyService.list2(SecurityConstants.INNER);
        if (R.isError(result) || result.getData() == null) {
            log.warn("获取攻略数据失败:{}", result.getMsg());
            return;
        }
        List<StrategyES> esList = new ArrayList<>();
        for (Strategy strategy : result.getData()) {
            StrategyES es = new StrategyES();
            BeanUtils.copyProperties(strategy, es);
            esList.add(es);
        }
        repository.saveAll(esList);
    }
}
