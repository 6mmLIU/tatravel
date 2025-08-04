package cn.wolfcode.wolf2w.business.controller;

import cn.wolfcode.wolf2w.business.api.domain.Region;
import cn.wolfcode.wolf2w.business.api.domain.vo.DestinationOptionVO;
import cn.wolfcode.wolf2w.business.service.IRegionService;
import cn.wolfcode.wolf2w.common.core.domain.R;
import cn.wolfcode.wolf2w.common.security.annotation.InnerAuth;
import cn.wolfcode.wolf2w.business.api.domain.Destination;
import cn.wolfcode.wolf2w.business.api.domain.DTO.DestinationDTO;
import cn.wolfcode.wolf2w.business.query.DestinationQuery;
import cn.wolfcode.wolf2w.business.service.IDestinationService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 目的地 Controller
 *
 * @author liuhaoming
 * @date 2025-07-22
 */
@RestController
@RequestMapping("/destinations")
public class DestinationController {
    @Autowired
    private IDestinationService destinationService;
    @Autowired
    private IRegionService regionService;

    @GetMapping("/search")
    public R<List<Destination>> search(Long regionId) {
        List<Destination> list = destinationService.queryByRegionId(regionId);
        return R.ok(list);
    }

    @GetMapping("/regions")
    public R<List<Region>> queryRegions(Long ishot) {
        List<Region> list = regionService.queryRegion(ishot);
        return R.ok(list);
    }

    /**
     * 目的地详情
     */
    @GetMapping("/detail/{id}")
    public R<Destination> detail(@PathVariable Long id) {
        Destination destination = destinationService.getById(id);
        return R.ok(destination);
    }

    /**
     * 目的地 列表
     */
    @GetMapping("/query")
    public R<IPage<Destination>> query(DestinationQuery qo) {
        IPage<Destination> page = destinationService.queryPage(qo);
        return R.ok(page);
    }

    @GetMapping("/toasts")
    public R<List<Destination>> toasts(@RequestParam Long destId) {
        return R.ok(destinationService.queryToasts(destId));
    }

    @GetMapping("list")
    public R<?> list() {
        List<Destination> list = destinationService.list();
        return R.ok(list);
    }
    @GetMapping(value = "/list",params = "type")
    public R<List<DestinationOptionVO>> listForSelector(
            @RequestParam Integer type,
            @RequestParam(required = false) String name,
            @RequestParam(required = false,defaultValue = "30") Integer size
    ){
        return R.ok(destinationService.listForSelector(type,name,size));
    }
    /*****************************************对外暴露Fegin接口**********************************************/
    /**
     * Feign 接口
     */
    @GetMapping("/feign/list")
    public R<List<DestinationDTO>> feignList(@RequestParam(value = "type", required = false) Integer type,
                                            @RequestParam(value = "name", required = false) String name) {
        List<Destination> all = destinationService.list();
        Map<Long, DestinationDTO> dtoMap = new HashMap<>(all.size());
        for (Destination dest : all) {
            DestinationDTO dto = new DestinationDTO();
            dto.setId(dest.getId());
            dto.setName(dest.getName());
            dtoMap.put(dest.getId(), dto);
        }

        List<DestinationDTO> roots = new ArrayList<>();
        for (Destination dest : all) {
            DestinationDTO dto = dtoMap.get(dest.getId());
            Long parentId = dest.getParentId();
            if (parentId == null) {
                roots.add(dto);
            } else {
                DestinationDTO parent = dtoMap.get(parentId);
                if (parent != null) {
                    parent.getChildren().add(dto);
                } else {
                    roots.add(dto);
                }
            }
        }

        return R.ok(roots);
    }

    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<Destination> feignGet(@PathVariable Long id) {
        return R.ok(destinationService.getById(id));
    }

    @GetMapping("/isAbroad/{destId}")
    public R<Long> isAbroad(@PathVariable("destId") Long destId) {
        List<Destination> list = destinationService.queryToasts(destId);
        return R.ok("中国".equals(list.get(0).getName()) ? 0l : 1l);
    }

}
