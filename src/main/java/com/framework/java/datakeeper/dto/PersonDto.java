package com.framework.java.datakeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String gender;
    private List<MultipartFile> profilePictureList;
    private List<String> filePathList;

}
