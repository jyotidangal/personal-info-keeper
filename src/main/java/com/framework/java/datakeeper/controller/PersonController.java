package com.framework.java.datakeeper.controller;

import com.framework.java.datakeeper.dto.PersonDto;
import com.framework.java.datakeeper.entity.InformationEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import  com.framework.java.datakeeper.service.PersonalService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("/personalInfo")
public class PersonController {
    // constructor injection
   private final PersonalService personService;
    public PersonController(PersonalService personalService){
        this.personService = personalService;
    }

   // private  List<PersonDto> listOfPeople = new ArrayList<>();
    @GetMapping
    public String personalInfo(Model model){
        model.addAttribute("personDto", new PersonDto());
        model.addAttribute("personDtoList",personService.findAll());
        return "personalInfo/person";
    }
    @PostMapping("/save")
    public String personalInfo(@ModelAttribute("personDto") PersonDto personDto,Model model){
          //Save information
        personService.save(personDto);

        return "redirect:/personalInfo";

    }
    @GetMapping("/image")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@RequestParam("fileName") String filename) throws IOException {
        String baseDir = "D:/JavaCourse/springboot/Peoples_Images/";
        Path path = Paths.get(baseDir+ filename);
        byte[] image = Files.readAllBytes(path);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);


        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }
    // Delete User Details
    @GetMapping("/delete/{id}")
            public String delete(@PathVariable("id") Integer id){
            personService.deleteById(id);
        return "redirect:/personalInfo";
    }




}
