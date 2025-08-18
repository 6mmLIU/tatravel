package cn.sixmm.sixsixsix.business.vo;

import cn.sixmm.sixsixsix.business.api.domain.Destination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ThemeVO {
    private String themeName;
    private List<Destination> dests = new ArrayList<>();
}
