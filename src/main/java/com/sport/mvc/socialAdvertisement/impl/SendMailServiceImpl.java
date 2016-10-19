package com.sport.mvc.socialAdvertisement.impl;

import com.sport.mvc.socialAdvertisement.SendMailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service(value = "mail")
public class SendMailServiceImpl implements SendMailService {

    private String subject;
    private String body;

    // @Resource(name = "art")
    Session session;
@Override
@Transactional
    public void sendMailTo(String mail, String subjectTo,String bodyTo)  {
subject =subjectTo;
    body=bodyTo;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("artyrgetman@gmail.com", "capoeira0904");
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("artyrgetman@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject(subject);
            // message.setText("Dear Mail Crawler," + "\n\n No spam to my email,
            // please!");
            message.setText(body);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}