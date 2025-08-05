package cn.wolfcode.wolf2w.business.service.impl;

import cn.wolfcode.wolf2w.business.api.RemoteNoteService;
import cn.wolfcode.wolf2w.business.api.domain.Note;
import cn.wolfcode.wolf2w.business.api.domain.NoteES;
import cn.wolfcode.wolf2w.business.respository.NoteEsRepository;
import cn.wolfcode.wolf2w.business.service.INoteEsService;
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
public class NoteEsServiceImpl implements INoteEsService {
    private final NoteEsRepository repository;
    private final RemoteNoteService remoteNoteService;

    @Override
    public boolean initData() {
        R<List<Note>> result = remoteNoteService.list(SecurityConstants.INNER);
        if (R.isError(result) || result.getData() == null) {
            log.warn("获取游记数据失败:{}", result.getMsg());
            return false;
        }
        List<NoteES> esList = new ArrayList<>();
        for (Note note : result.getData()) {
            NoteES es = new NoteES();
            BeanUtils.copyProperties(note, es);
            esList.add(es);
        }
        repository.saveAll(esList);
        return true;
    }
}
