package com.framework.java.datakeeper.service.excelservice;

import com.framework.java.datakeeper.converter.ExcelConverter;
import com.framework.java.datakeeper.dto.ExcelWriteDto;
import com.framework.java.datakeeper.entity.ExcelEntity;
import com.framework.java.datakeeper.repository.ExcelRepo;
import com.framework.java.datakeeper.utils.FilesStoreUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;


@Service
public class ExcelServiceImpl implements ExcelService{
    public final FilesStoreUtils filesStoreUtils;
    public final ExcelRepo excelRepo;
    public final ExcelConverter excelConverter;

    public ExcelServiceImpl(FilesStoreUtils filesStoreUtils, ExcelRepo excelRepo, ExcelConverter excelConverter) {
        this.filesStoreUtils = filesStoreUtils;
        this.excelRepo = excelRepo;
        this.excelConverter = excelConverter;
    }


    @Override
    public List<List<String>> uploadFile(MultipartFile file) {
        String filePath = filesStoreUtils.uploadFile(file);
        List<List<String>> excelData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row == null) continue;

                List<String> rowData = new ArrayList<>();

                for (Cell cell : row) {
                    if (cell == null) {
                        rowData.add("");
                        continue;
                    }

                    String cellValue = "";
                    switch (cell.getCellType()) {
                        case STRING:
                            cellValue = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            cellValue = String.valueOf(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            cellValue = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            cellValue = cell.getCellFormula();
                            break;
                        default:
                            cellValue = "";
                    }

                    rowData.add(cellValue);
                }

                excelData.add(rowData);
            }

            return excelData;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ExcelWriteDto save(ExcelWriteDto excelWriteDto) {
        ExcelEntity excelEntity = excelConverter.toEntity(excelWriteDto);
        excelRepo.save(excelEntity);
        return excelConverter.toDTO(excelEntity);
    }

    @Override
    public ExcelWriteDto update(ExcelWriteDto excelWriteDto) {
        return null;
    }

    @Override
    public ExcelWriteDto findById(ExcelEntity excelEntity) {
        return null;
    }

    @Override
    public List<ExcelWriteDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(ExcelEntity excelEntity) {

    }
}
