package br.com.csmastery.integration.impl;

import br.com.csmastery.integration.MainIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailIntegrationImpl implements MainIntegration {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(String subject, String mailTo, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setTo(mailTo);
        simpleMailMessage.setText(message);
        javaMailSender.send(simpleMailMessage);
    }
}
