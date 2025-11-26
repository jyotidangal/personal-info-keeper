package com.framework.java.datakeeper.service.excelservice;

import com.framework.java.datakeeper.dto.ExcelWriteDto;
import com.framework.java.datakeeper.entity.ExcelEntity;
import org.springframework.web.multipart.MultipartFile;
import com.framework.java.datakeeper.service.GenericService;

import java.util.List;

public interface ExcelService extends GenericService<ExcelWriteDto , ExcelEntity> {
    public List<List<String>> uploadFile(MultipartFile file);
}
