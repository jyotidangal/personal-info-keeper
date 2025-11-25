package com.framework.java.datakeeper.converter;

import com.framework.java.datakeeper.dto.PersonDto;
import com.framework.java.datakeeper.entity.InformationEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonalInfoConverter implements AbstractConverter<PersonDto, InformationEntity> {
    @Override
    public PersonDto toDTO(InformationEntity informationEntity) {
       PersonDto personDto = new PersonDto();
       personDto.setId(informationEntity.getId());
       personDto.setFirstName(informationEntity.getFirstName());
       personDto.setLastName(informationEntity.getLastName());
       personDto.setEmail(informationEntity.getEmail());
       personDto.setAddress(informationEntity.getAddress());
       personDto.setGender(informationEntity.getGender());
       personDto.setFilePathList(informationEntity.getImagePaths());

        return personDto;
    }
//function that map or pass the data from dto to the entity to save in database
    @Override
    public InformationEntity toEntity(PersonDto personDto) {

        InformationEntity informationEntity = new InformationEntity();
        informationEntity.setId(personDto.getId());
        informationEntity.setFirstName(personDto.getFirstName());
        informationEntity.setLastName(personDto.getLastName());
        informationEntity.setEmail(personDto.getEmail());
        informationEntity.setAddress(personDto.getAddress());
        informationEntity.setGender(personDto.getGender());
     return informationEntity;
    }

    @Override
    public List<InformationEntity> toEntity(List<PersonDto> personDtos) {
        return List.of();
    }

    @Override
    public List<PersonDto> toDTOList(List<InformationEntity> informationEntities) {
        return informationEntities.stream().map(this::toDTO).toList();
    }
}


