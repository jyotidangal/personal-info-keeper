package com.framework.java.datakeeper.service.excelservice;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelService {
    public List<List<String>> uploadFile(MultipartFile file);
}
