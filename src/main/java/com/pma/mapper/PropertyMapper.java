package com.pma.mapper;

import com.pma.model.Property;
import com.pma.model.PropertyDTO;
import org.mapstruct.*;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        componentModel = "spring")
public abstract class PropertyMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "authorized", expression = "java(false)")
    @Mapping(target = "propertyType", source = "propertyType")
    @Mapping(target = "occupancyStatus", source = "occupancyStatus")
    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    @Mapping(target = "address", source = "address")
    public abstract Property mapEntity(PropertyDTO propertyDTO);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "propertyType", source = "propertyType")
    @Mapping(target = "occupancyStatus", source = "occupancyStatus")
    @Mapping(target = "updatedAt", expression = "java(java.time.Instant.now())")
    public abstract Property updateEntity(@MappingTarget Property property, PropertyDTO propertyDTO);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "propertyType", source = "propertyType")
    @Mapping(target = "occupancyStatus", source = "occupancyStatus")
    @Mapping(target = "authorized", source = "authorized")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "createdAt")
    public abstract PropertyDTO mapDTO(Property property);
}
