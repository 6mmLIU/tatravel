package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.RemoteDestinationService;
import cn.sixmm.sixsixsix.business.api.domain.Destination;
import cn.sixmm.sixsixsix.business.api.domain.DestinationES;
import cn.sixmm.sixsixsix.business.respository.DestinationEsRepository;
import cn.sixmm.sixsixsix.business.service.IDestinationEsService;
import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.core.utils.bean.BeanUtils;
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
        R<List<Destination>> list = remoteDestinationService.list2(SecurityConstants.INNER);
        log.info(list.getMsg()+"异常");
        List<DestinationES> esList = new ArrayList<>();
        for (Destination destination : list.getData()) {
            DestinationES es = new DestinationES();
            BeanUtils.copyProperties(destination, es);
            esList.add(es);
        }
        repository.saveAll(esList);
    }
}
