package com.framework.java.datakeeper.service;

import com.framework.java.datakeeper.dto.PersonDto;
import com.framework.java.datakeeper.entity.InformationEntity;

public interface PersonalService extends GenericService<PersonDto, InformationEntity> {
    public void deleteById(Integer id);


}
