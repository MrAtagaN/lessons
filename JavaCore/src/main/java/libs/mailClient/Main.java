package libs.mailClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final String USER_NAME = "atagan@rambler.ru";
    private static final String IMAP_HOST = "imap.rambler.ru";
    private static final String MAIL_STORE_TYPE = "imaps";
    private static final int IMAP_PORT = 993;


    public static void main(String[] args) throws Exception {

        //считываем пароль от mail
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("INPUT PASSWORD FOR: " + USER_NAME);
        String password = reader.readLine();
        reader.close();

        //чтение почты
        MailClient mailClient = new MailClient(IMAP_HOST, IMAP_PORT, USER_NAME, MAIL_STORE_TYPE, password);

        //отправка почты
        MailSender mailSender = new MailSender("smtp.rambler.ru", 465,  "atagan@rambler.ru", "atagan", password);

        //отправка почты через Spring client
        SpringMailSender springMailSender = new SpringMailSender("smtp.rambler.ru", 465, "atagan", password);



//        mailSender.sendMail("atagan@rambler.ru");
//
//        mailClient.readMessages("INBOX",20);
//        mailClient.saveMessage("INBOX",11);
//
//        springMailSender.sendMail("atagan@rambler.ru");
        springMailSender.sendMailWithAttachments("atagan@rambler.ru");
    }



}
