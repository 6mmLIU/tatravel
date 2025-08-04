package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.business.api.domain.DTO.DestinationDTO;
import cn.wolfcode.wolf2w.business.api.DestClient;
import cn.wolfcode.wolf2w.common.core.domain.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/destinations")
public class DestinationBffController {
    private final DestClient destClient;

    @GetMapping("/list")
    public R<List<DestinationDTO>> list(@RequestParam Integer type,
                                        @RequestParam(required = false) String name) {
        R<List<DestinationDTO>> r = destClient.list(type, name);
        // 打点方便追根因
        System.out.println("[BFF] feign code=" + (r==null?null:r.getCode())
                + ", size=" + (r==null||r.getData()==null?0:r.getData().size()));

        // 只要下游返回了数据，统一按 200 返回，前端就会渲染
        return R.ok(r != null && r.getData() != null ? r.getData() : Collections.emptyList());
    }
}
