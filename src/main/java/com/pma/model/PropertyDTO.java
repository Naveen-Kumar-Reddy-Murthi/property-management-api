package com.pma.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class PropertyDTO {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotNull(message = "Type is mandatory")
    private PropertyType propertyType;
    @NotNull(message = "occupancyStatus is mandatory")
    private OccupancyStatus occupancyStatus;
    @NotNull(message = "address is mandatory")
    private String address;
    private Boolean authorized;
    private Instant createdAt;
    private Instant updatedAt;
}
