package cn.sixmm.sixsixsix.business.vo;

import cn.sixmm.sixsixsix.business.api.domain.Strategy;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CatalogVO {
    private Long id;
    private String name;
    private List<Strategy> strategies=new ArrayList<>();
}
