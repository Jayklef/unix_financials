package com.jayklef.unix_financials.service.Impl;

import com.jayklef.unix_financials.dto.EmailDetails;
import com.jayklef.unix_financials.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Override
    public void sendEmail(EmailDetails emailDetails) {

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(senderEmail);
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setSubject(emailDetails.getSubject());
            mailMessage.setCc(emailDetails.getRecipientGroup());
            mailMessage.setText(emailDetails.getMessage());

            javaMailSender.send(mailMessage);
        }catch (MailException e){
            throw new RuntimeException(e);
        }
    }
}
