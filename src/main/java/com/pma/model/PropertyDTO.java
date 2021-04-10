package com.pma.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyDTO that = (PropertyDTO) o;

        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        if (getPropertyType() != that.getPropertyType()) return false;
        if (getOccupancyStatus() != that.getOccupancyStatus()) return false;
        if (!getAddress().equals(that.getAddress())) return false;
        return getAuthorized().equals(that.getAuthorized());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPropertyType().hashCode();
        result = 31 * result + getOccupancyStatus().hashCode();
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getAuthorized().hashCode();
        return result;
    }
}
