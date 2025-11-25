package com.framework.java.datakeeper.service.emailserviceimpl;

import com.framework.java.datakeeper.dto.EmailDto;
import com.framework.java.datakeeper.service.EmailService;
import com.framework.java.datakeeper.utils.FilesStoreUtils;
import com.framework.java.datakeeper.utils.MailSenderUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;
@Service
public class EmailServiceImpl implements EmailService {
    public final FilesStoreUtils filesStoreUtils;
    public final MailSenderUtils mailSenderUtils;

    public EmailServiceImpl(FilesStoreUtils filesStoreUtils, MailSenderUtils mailSenderUtils) {
        this.filesStoreUtils = filesStoreUtils;
        this.mailSenderUtils = mailSenderUtils;
    }

    @Override
    public void sendEmail(EmailDto emailDto) {

    }

    @Override
    public void sendEmailWithAttachment(EmailDto emailDto) {
        String receiver=emailDto.getReceiver();
        String subject=emailDto.getSubject();
        String description=emailDto.getDescription();
        String cc=emailDto.getCc();
        //Convert the comma seperated value to list
        //Feature of JAVA 8  stream API
//        List<String> ccList = Arrays.stream(cc.split(",")).toList();
        String[] ccList=cc.split(",");

       List<MultipartFile > files = emailDto.getFile();
       List<String> filePathList = new ArrayList<>();

       for (MultipartFile multipartFile : files) {
          filePathList.addAll(filesStoreUtils.uploadFileList(List.of(multipartFile)));
       }

        // if needed we can store the file
        //now let send the email
        mailSenderUtils.sendEmailWithTemplateAndAttachment( receiver,
                subject,
                description,
                ccList,
                filePathList);

    }

    @Override
    public EmailDto save(EmailDto emailDto) {
        return null;
    }

    @Override
    public EmailDto update(EmailDto emailDto) {
        return null;
    }

    @Override
    public EmailDto findById(EmailDto emailDto) {
        return null;
    }

    @Override
    public List<EmailDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(EmailDto emailDto) {

    }
}
