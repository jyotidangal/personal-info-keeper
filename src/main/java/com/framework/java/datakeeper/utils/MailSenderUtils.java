package com.framework.java.datakeeper.utils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;


import java.io.File;
import java.util.List;

@Component

public class MailSenderUtils {

    private  final JavaMailSender emailSender;
    private  final SpringTemplateEngine templateEngine;

    public MailSenderUtils(JavaMailSender emailSender, SpringTemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }


    public void sendEmailWithTemplateAndAttachment(
             String to,
             String subject,
             String description,
             String [] cc,
             List<String> filePathList
        ){
        try{

            // Create MIME message
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");


            // Prepare Thymeleaf context
            Context context = new Context();
            context.setVariable("subject", subject);
            context.setVariable("description", description);

            // Process the Thymeleaf template into HTML
            String htmlContent = templateEngine.process("emailtemplate/template1", context);


            // Configure email
            helper.setTo(to);
            if(cc!=null && cc.length>0){
                helper.setCc(cc);
            }
            helper.setSubject(subject);
            helper.setText(htmlContent, true);
            helper.setFrom("jyotidangal060@gmail.com");


            // Add attachment
            if (filePathList != null) {
                for(String filePath : filePathList){
                    File file = new File(filePath);
                    FileSystemResource resource = new FileSystemResource(file);
                    if(file.exists()){
                        helper.addAttachment(file.getName(), resource);
                    }
                    else{
                        System.out.println("File not found");
                    }
                }

            }


            // Send mail
            emailSender.send(mimeMessage);
            System.out.println("✅ Email sent successfully with  attachment.");
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    }

