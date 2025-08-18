package cn.sixmm.sixsixsix.business.controller;

import cn.sixmm.sixsixsix.business.api.domain.Region;
import cn.sixmm.sixsixsix.business.api.domain.vo.DestinationOptionVO;
import cn.sixmm.sixsixsix.business.service.IRegionService;
import cn.sixmm.sixsixsix.common.core.domain.R;
import cn.sixmm.sixsixsix.common.security.annotation.InnerAuth;
import cn.sixmm.sixsixsix.business.api.domain.Destination;
import cn.sixmm.sixsixsix.business.api.domain.DTO.DestinationDTO;
import cn.sixmm.sixsixsix.business.query.DestinationQuery;
import cn.sixmm.sixsixsix.business.service.IDestinationService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     * 目的地 列表（分页查询）
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

    /**
     * 原始列表（不建议前端直连用）
     */
    @GetMapping("list")
    public R<?> list() {
        List<Destination> list = destinationService.list();
        return R.ok(list);
    }

    /**
     * 供管理端选择器用的选项接口
     */
    @GetMapping(value = "/list", params = "type")
    public R<List<DestinationOptionVO>> listForSelector(
            @RequestParam Integer type,
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "30") Integer size
    ) {
        return R.ok(destinationService.listForSelector(type, name, size));
    }

    /***************************************** 对外暴露的 Feign 接口 **********************************************/

    /**
     * 给 BFF（travel-business）调用的接口：
     * 统一返回 DestinationDTO，且 children 一律非空（即使是热门叶子也返回 []）
     * 这样前端可以安全地访问 node.children.length 而不抛错。
     */
    @GetMapping("/feign/list")
    public R<List<DestinationDTO>> feignList(
            @RequestParam("type") Integer type,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "size", required = false, defaultValue = "30") Integer size
    ) {
        // 复用已有的 selector 逻辑，拿到 id/name 列表
        List<DestinationOptionVO> options = destinationService.listForSelector(type, name, size);

        // 关键：把所有项都转成“规整”的 DTO（children 永远不是 null）
        List<DestinationDTO> dtoList = options.stream()
                .map(opt -> leafDto(opt.getId(), opt.getName()))
                .collect(Collectors.toList());

        return R.ok(dtoList);
    }

    @GetMapping("/feign/list2")
    public R<List<Destination>> feignList2() {
        return R.ok( destinationService.list());
    }

    /**
     * 把完整实体转成树形 DTO（用于你们内部需要整棵树时）
     */
    private DestinationDTO toDto(Destination dest) {
        DestinationDTO dto = new DestinationDTO();
        dto.setId(dest.getId());
        dto.setName(dest.getName());
        // 保证 children 非空
        if (dto.getChildren() == null) {
            dto.setChildren(new ArrayList<>());
        }
        if (dest.getChildren() != null) {
            dest.getChildren().forEach(child -> dto.getChildren().add(toDto(child)));
        }
        return dto;
    }

    /**
     * 生成“叶子”DTO（热门/纯选项场景）— children 一定是 []
     */
    private DestinationDTO leafDto(Long id, String name) {
        DestinationDTO dto = new DestinationDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setChildren(new ArrayList<>()); // 关键点：非空，避免前端 .length 报错
        return dto;
    }

    @InnerAuth
    @GetMapping("/feign/{id}")
    public R<Destination> feignGet(@PathVariable Long id) {
        return R.ok(destinationService.getById(id));
    }

    @GetMapping("/isAbroad/{destId}")
    public R<Long> isAbroad(@PathVariable("destId") Long destId) {
        List<Destination> list = destinationService.queryToasts(destId);
        return R.ok("中国".equals(list.get(0).getName()) ? 0L : 1L);
    }
}
