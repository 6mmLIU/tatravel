package cn.sixmm.sixsixsix.business.service.impl;

import cn.sixmm.sixsixsix.business.api.RemoteNoteService;
import cn.sixmm.sixsixsix.business.api.domain.Note;
import cn.sixmm.sixsixsix.business.api.domain.NoteES;
import cn.sixmm.sixsixsix.business.respository.NoteEsRepository;
import cn.sixmm.sixsixsix.business.service.INoteEsService;
import cn.sixmm.sixsixsix.common.core.constant.SecurityConstants;
import cn.sixmm.sixsixsix.common.core.utils.bean.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteEsServiceImpl implements INoteEsService {
    private final NoteEsRepository repository;
    private final RemoteNoteService remoteNoteService;

    @Override
    public void initData() {
        List<Note> list = remoteNoteService.list(SecurityConstants.INNER).getData();
        List<NoteES> esList = new ArrayList<>();
        for (Note note : list) {
            NoteES es = new NoteES();
            BeanUtils.copyProperties(note, es);
            esList.add(es);
        }
        repository.saveAll(esList);
    }
}
