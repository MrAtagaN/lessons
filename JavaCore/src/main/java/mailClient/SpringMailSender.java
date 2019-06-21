package mailClient;


import org.jsoup.Jsoup;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public void sendMailWithAttachments(String mailRecipient) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(mailRecipient);
        helper.setSubject("subject");
        message.setFrom("atagan@rambler.ru");
        helper.setText("text");

        byte[] bytes = Files.readAllBytes(Paths.get("JavaCore/src/main/resources/GenieMoveRight_1.png"));
        ByteArrayResource byteArrayResource = new ByteArrayResource(bytes);

        helper.addAttachment("GenieMoveRight_1.png", byteArrayResource);

        System.out.println(getTextFromMessage(message));

        mailSender.send(message);
    }

    /**
     * Получение текста из письма
     */
    private String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        } else if (message.isMimeType("text/html")) {
            String html = (String) message.getContent();
            result = result + "\n" + Jsoup.parse(html).text();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }


    /**
     * Получение текста из MimeMultipart
     */
    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        for (int i = 0; i < mimeMultipart.getCount(); i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
                break;
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + Jsoup.parse(html).text();
            } else if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
            }
        }
        return result;
    }
}
