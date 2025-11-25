package com.framework.java.datakeeper.controller;

import com.framework.java.datakeeper.dto.EmailDto;
import com.framework.java.datakeeper.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/email")
public class EmailController {
    public final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public String email(Model model){
    model.addAttribute("emailDto", new EmailDto());
    return "/email/emailLanding";
}
@PostMapping("/send")
    public String saveEmail(@ModelAttribute("emailDto") EmailDto emailDto, RedirectAttributes redirectAttributes){
        emailService.sendEmailWithAttachment(emailDto);
        redirectAttributes.addFlashAttribute("message","Mail sent successfully!!!");

    return "redirect:/email";

}
}
