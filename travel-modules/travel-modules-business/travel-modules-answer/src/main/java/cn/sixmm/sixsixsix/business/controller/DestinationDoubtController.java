package cn.sixmm.sixsixsix.business.controller;

import cn.sixmm.sixsixsix.business.api.domain.dto.QuestionCreateDTO;
import cn.sixmm.sixsixsix.business.api.domain.dto.AnswerDTO;
import cn.sixmm.sixsixsix.business.service.DestinationDoubtService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.security.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/destinationDoubt")
@Valid
public class DestinationDoubtController {
    private final DestinationDoubtService destinationDoubtService;

    @PostMapping("/create")
    public R<Long> create(@RequestBody @Valid QuestionCreateDTO dto, @RequestHeader(value = "user-id", required = false) Long headerUserId) {
        Long userId = SecurityUtils.getUserId();
        if (userId == null) userId = headerUserId;
        if (userId == null) return R.fail("未登录或用户ID缺失");
        Long id = destinationDoubtService.create(dto, userId);
        return R.ok(id);
    }
    @PostMapping("/answer")
    public R<Long> answer(@RequestBody @Valid AnswerDTO dto,@RequestHeader(value="user-id",required = false)Long headerUserId){
        Long userId=SecurityUtils.getUserId();
        if (userId==null) userId=headerUserId;
        if (userId==null) return R.fail("未登录或用户缺失");
        Long answerId=destinationDoubtService.createAnswer(dto,userId);
        return R.ok(answerId);
    }

}
