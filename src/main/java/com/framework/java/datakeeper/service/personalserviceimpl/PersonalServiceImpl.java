package com.framework.java.datakeeper.service.personalserviceimpl;

import com.framework.java.datakeeper.converter.PersonalInfoConverter;
import com.framework.java.datakeeper.dto.PersonDto;
import com.framework.java.datakeeper.service.PersonalService;
import org.springframework.stereotype.Service;
import com.framework.java.datakeeper.entity.InformationEntity;
import com.framework.java.datakeeper.repository.PersonalRepo;
import org.springframework.web.multipart.MultipartFile;
import com.framework.java.datakeeper.utils.FilesStoreUtils;

import java.util.List;
import java.util.Optional;


@Service
public class PersonalServiceImpl  implements PersonalService {

    private  final PersonalRepo personalRepo ;
    private final PersonalInfoConverter personalInfoConverter;
    private final FilesStoreUtils filesStoreUtils;

    //Dependency injection by constructor injection
    public PersonalServiceImpl(PersonalRepo personalRepo, PersonalInfoConverter personalInfoConverter, FilesStoreUtils filesStoreUtils) {
        this.personalRepo = personalRepo;
        this.personalInfoConverter = personalInfoConverter;
        this.filesStoreUtils = filesStoreUtils;
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        InformationEntity informationEntity = personalInfoConverter.toEntity(personDto);
        //now we have to deal with the file part , there we haven't
        // saved the files at any location so let proceed from the fact of saving file

        List<MultipartFile> multipartFileList = personDto.getProfilePictureList();
       List<String>filePathList = filesStoreUtils.uploadFileList(multipartFileList);
       informationEntity.setImagePaths(filePathList);
       informationEntity = personalRepo.save(informationEntity);

       return personalInfoConverter.toDTO(informationEntity);
   }

    @Override
    public PersonDto update(PersonDto personDto) {

        return null;
    }

    @Override
    public void deleteById(Integer id){
        Optional<InformationEntity> entity=personalRepo.findById(id);
       entity.ifPresent(this::delete);
    }

    @Override
    public PersonDto findById(InformationEntity informationEntity) {

        return null;
    }

    @Override
    public List<PersonDto> findAll() {
        List<PersonDto> personDtoList = personalInfoConverter.toDTOList(personalRepo.findAll());
    return personDtoList;
    }


    @Override
    public void delete(InformationEntity informationEntity) {
        personalRepo.delete(informationEntity);

    }






}
