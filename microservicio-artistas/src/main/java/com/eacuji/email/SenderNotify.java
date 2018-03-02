package com.eacuji.email;

import com.eacuji.services.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenderNotify {
    @Autowired
    private EmailService emailService;

    @Autowired
    private SingerService singerService;

    public void sender(String instrument) {
        List<String> emails = singerService.findAllEmails();
        String subject = "Notificación de nuevo instrumento";
        String message = "Le informamos que se ha añadido el instrumento " + instrument + " a la lista";

        for (String email : emails) {
            emailService.sendMail(email, subject, message);
        }
    }

}
