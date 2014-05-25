/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.emailsender.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import pl.hotel.control.Transport.Email;

/**
 *
 * @author karol
 */
@Component("prototype")
public class Task implements Runnable {

    @Autowired
    private JavaMailSenderImpl sender;

    private Email email;

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public void run() {
        sender.send(createMail());
    }

    private SimpleMailMessage createMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getTo());
        message.setText("test");
        message.setText(email.getToken());
        return message;
    }

}
