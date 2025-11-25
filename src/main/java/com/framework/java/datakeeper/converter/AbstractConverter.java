package com.framework.java.datakeeper.converter;
import java.util.List;

public interface AbstractConverter<DTO ,ENTITY> {
    public DTO toDTO(ENTITY entity);
    public ENTITY toEntity(DTO dto);
    public List<ENTITY> toEntity(List<DTO> dtoList);
    public List<DTO> toDTOList(List<ENTITY> entityList);

}
