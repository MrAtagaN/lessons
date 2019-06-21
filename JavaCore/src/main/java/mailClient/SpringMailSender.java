package mailClient;


import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

public class SpringMailSender {

    JavaMailSenderImpl mailSender;

    public SpringMailSender(String host, int smtpPort, String userName, String password) {
        mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(smtpPort);

        mailSender.setUsername(userName);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
    }

    //simple Message
    public void sendMail(String mailRecipient) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailRecipient);
        message.setFrom("atagan@rambler.ru");
        message.setSubject("subject");
        message.setText("text");

        mailSender.send(message);
    }

    public void sendMailWithAttachments(String mailRecipient) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(mailRecipient);
        helper.setSubject("subject");
        message.setFrom("atagan@rambler.ru");
        helper.setText("text");

        FileSystemResource file = new FileSystemResource(new File("JavaCore/src/main/resources/GenieMoveRight_1.png"));
        helper.addAttachment("GenieMoveRight_1.png", file);

        mailSender.send(message);
    }
}
