package com.framework.java.datakeeper.service;

import com.framework.java.datakeeper.dto.EmailDto;

public interface EmailService extends GenericService<EmailDto, EmailDto> {
    public void sendEmail(EmailDto emailDto);
    public void sendEmailWithAttachment(EmailDto emailDto);
}
