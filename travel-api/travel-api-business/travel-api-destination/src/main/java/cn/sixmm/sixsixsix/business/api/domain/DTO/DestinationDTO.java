package cn.sixmm.sixsixsix.business.api.domain.DTO;

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

    public static DestinationDTO leaf(Long id, String name) {
        DestinationDTO d = new DestinationDTO();
        d.setId(id);
        d.setName(name);
        d.setChildren(new ArrayList<>());
        return d;
    }

}
