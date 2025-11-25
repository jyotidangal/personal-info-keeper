package com.framework.java.datakeeper.service;
import java.util.List;
public interface GenericService <DTO, ID> {
    DTO save(DTO dto);
    DTO update(DTO dto);
    DTO findById(ID id);
    List<DTO> findAll();
    void delete(ID id);

}
