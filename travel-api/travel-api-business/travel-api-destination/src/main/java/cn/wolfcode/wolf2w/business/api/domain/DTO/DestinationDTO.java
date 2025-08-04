package cn.wolfcode.wolf2w.business.api.domain.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
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
     * The {@link JsonInclude} annotation forces serialization of the field
     * even when the list is empty so the frontend never sees an undefined value.
     */
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private List<DestinationDTO> children = new ArrayList<>();

}
