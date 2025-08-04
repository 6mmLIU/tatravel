package cn.wolfcode.wolf2w.business.vo;

import cn.wolfcode.wolf2w.business.api.domain.Destination;
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
