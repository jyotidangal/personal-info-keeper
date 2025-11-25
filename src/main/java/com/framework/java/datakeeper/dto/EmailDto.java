package com.framework.java.datakeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private String receiver;
    private String cc;
    private String subject;
    private String Description;
    private List<MultipartFile> file;
}
