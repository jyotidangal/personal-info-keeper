package com.framework.java.datakeeper.controller;

import com.framework.java.datakeeper.service.excelservice.ExcelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/excel/readExcelFiles")
public class ExcelReadController {

    public final ExcelService excelService;

    public ExcelReadController(ExcelService excelService) {

        this.excelService = excelService;
    }

    @GetMapping
    public String showExcel(){

        return "excel/readExcelFiles";
    }
    @PostMapping("readExcelFiles/save")
    public String saveExcel(@RequestParam("file")MultipartFile multipartFile , RedirectAttributes redirectAttributes){
        if(multipartFile.isEmpty()){
          System.out.println("File is not selected!!");
        }
        MultipartFile file = multipartFile;
//        retrieve the filepath
        List<List<String>> excelData= excelService.uploadFile(file);
        redirectAttributes.addFlashAttribute("excelData",excelData);
        return "redirect:/excel";
    }
}
