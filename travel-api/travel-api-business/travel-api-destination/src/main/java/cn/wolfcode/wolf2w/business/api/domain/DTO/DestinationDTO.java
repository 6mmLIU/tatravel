package cn.wolfcode.wolf2w.business.api.domain.DTO;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DestinationDTO {
    private Long id;
    private String name;
    /**
     * Child destinations used for building a destination tree.
     * Initialized to an empty list to avoid null checks on the frontend.
     */
    private List<DestinationDTO> children = new ArrayList<>();

}
