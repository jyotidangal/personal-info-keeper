package com.framework.java.datakeeper.controller;

import com.framework.java.datakeeper.dto.ExcelWriteDto;
import com.framework.java.datakeeper.service.PersonalService;
import com.framework.java.datakeeper.service.excelservice.ExcelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/excel/writeInExcel")
public class ExcelWriteController {
    public final ExcelService excelService;

    public ExcelWriteController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @GetMapping
    public String toExcel(Model model){
        model.addAttribute("writeDto",new ExcelWriteDto());
        return "excel/writeInExcel";
    }
    @PostMapping("/write-multiple")
    public String saveExcel(@ModelAttribute("writeDto") ExcelWriteDto excelWriteDto){

        excelService.save(excelWriteDto);

        return "redirect:/excel/writeInExcel";
    }
}
