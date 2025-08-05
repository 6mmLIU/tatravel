package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.RemoteDestinationService;
import cn.wolfcode.wolf2w.business.api.domain.Destination;
import cn.wolfcode.wolf2w.business.api.domain.DestinationES;
import cn.wolfcode.wolf2w.business.respository.DestinationEsRepository;
import cn.wolfcode.wolf2w.business.service.IDestinationEsService;
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
public class DestinationEsServiceImpl implements IDestinationEsService {
    private final DestinationEsRepository repository;
    private final RemoteDestinationService remoteDestinationService;

    @Override
    public void initData() {
        R<List<Destination>> result = remoteDestinationService.list2(SecurityConstants.INNER);
        if (R.isError(result) || result.getData() == null) {
            log.warn("获取目的地数据失败:{}", result.getMsg());
            return;
        }
        List<DestinationES> esList = new ArrayList<>();
        for (Destination destination : result.getData()) {
            DestinationES es = new DestinationES();
            BeanUtils.copyProperties(destination, es);
            esList.add(es);
        }
        repository.saveAll(esList);
    }
}
