package com.framework.java.datakeeper.controller;

import com.framework.java.datakeeper.service.excelservice.ExcelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/excel")
public class ExcelController {

    public final ExcelService excelService;

    public ExcelController( ExcelService excelService) {

        this.excelService = excelService;
    }

    @GetMapping
    public String showExcel(){

        return "excel/readExcelFiles";
    }
    @PostMapping("/save")
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
