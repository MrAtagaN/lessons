package mailClient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String USER_NAME = "atagan@rambler.ru";
    private static final String HOST = "pop.rambler.ru";
    private static final String MAIL_STORE_TYPE = "pop3s";


    public static void main(String[] args) throws IOException {

        //считываем пароль от mail
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("INPUT PASSWORD FOR: " + USER_NAME);
        String password = reader.readLine();
        reader.close();

        MailClient mailClient = new MailClient(HOST, USER_NAME, MAIL_STORE_TYPE, password);

        mailClient.readMessages();
    }
}
