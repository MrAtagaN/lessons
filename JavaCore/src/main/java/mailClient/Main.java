package mailClient;


import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String USER_NAME = "atagan@rambler.ru";
    private static final String IMAP_HOST = "imap.rambler.ru";
    private static final String MAIL_STORE_TYPE = "imaps";
    private static final int IMAP_PORT = 993;


    public static void main(String[] args) throws IOException, MessagingException {

        //считываем пароль от mail
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("INPUT PASSWORD FOR: " + USER_NAME);
        String password = reader.readLine();
        reader.close();

        //чтение почты
        MailClient mailClient = new MailClient(IMAP_HOST, IMAP_PORT, USER_NAME, MAIL_STORE_TYPE, password);
        mailClient.readMessages("INBOX",20);
        mailClient.saveMessage("INBOX",11);

        //отправка почты
        MailSender mailSender = new MailSender("smtp.rambler.ru", 465,  "atagan@rambler.ru", USER_NAME, password);
        mailSender.sendMail("atagan@rambler.ru");
    }
}
