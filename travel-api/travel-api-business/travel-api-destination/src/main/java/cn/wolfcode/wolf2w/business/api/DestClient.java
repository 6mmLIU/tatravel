package cn.wolfcode.wolf2w.business.api;

import cn.wolfcode.wolf2w.business.api.domain.DTO.DestinationDTO;
import cn.wolfcode.wolf2w.business.api.factory.DestClientFallbackFactory;
import cn.wolfcode.wolf2w.common.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        value = "travel-destination",
        contextId = "destClient",
        path = "/destinations",
        fallbackFactory = DestClientFallbackFactory.class
)
public interface DestClient {
    @GetMapping("/feign/list")
    R<List<DestinationDTO>> list(@RequestParam("type") Integer type, @RequestParam(value = "name", required = false) String name);
}

