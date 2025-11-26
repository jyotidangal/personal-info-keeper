package com.framework.java.datakeeper.converter;

import com.framework.java.datakeeper.dto.ExcelWriteDto;
import com.framework.java.datakeeper.entity.ExcelEntity;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExcelConverter implements AbstractConverter<ExcelWriteDto, ExcelEntity> {

    @Override
    public ExcelWriteDto toDTO(ExcelEntity excelEntity) {
        return null;
    }

    @Override
    public ExcelEntity toEntity(ExcelWriteDto excelWriteDto) {
        ExcelEntity excelEntity = new ExcelEntity();
        excelEntity.setNameList(excelWriteDto.getNameList());
        excelEntity.setEmailList(excelWriteDto.getGmailList());
        excelEntity.setAgeList(excelEntity.getAgeList());
        return excelEntity;
    }

    @Override
    public List<ExcelEntity> toEntity(List<ExcelWriteDto> excelWriteDtos) {
        return List.of();
    }

    @Override
    public List<ExcelWriteDto> toDTOList(List<ExcelEntity> excelEntities) {
        return List.of();
    }
}
