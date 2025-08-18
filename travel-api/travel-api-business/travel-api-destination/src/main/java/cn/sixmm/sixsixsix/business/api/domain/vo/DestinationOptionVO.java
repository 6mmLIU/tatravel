package cn.sixmm.sixsixsix.business.api.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 前端目的地选择器选项
 * <p>
 * "热门" 等列表返回的节点有时没有 children 字段，
 * 为避免前端访问 node.children.length 时报错，
 * 统一在 VO 中初始化一个空的 children 列表。
 */
@Data
@NoArgsConstructor
public class DestinationOptionVO {
    private Long id;
    private String name;
    /**
     * 子节点列表，默认为空数组，保证前端访问安全
     */
    private List<DestinationOptionVO> children = new ArrayList<>();

    public DestinationOptionVO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
