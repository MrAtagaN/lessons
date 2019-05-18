package mailClient;

import javax.mail.*;
import java.io.*;
import java.util.Properties;

/**
 * Клиент для почтового ящика
 */
public class MailClient {

    private String host;
    private String userName;
    private String mailStoreType;
    private String password;

    public MailClient(String host, String userName, String mailStoreType, String password) {
        this.host = host;
        this.userName = userName;
        this.mailStoreType = mailStoreType;
        this.password = password;
    }


    public void readMessages() {
        try {
            //create properties field
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore(mailStoreType);

            store.connect(host, userName, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length:  " + messages.length);

            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("===================================================================================" +
                "======================================================================================================");
                System.out.println("Email Number " +  message.getMessageNumber());
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());

                //сохранить письмо
                if (i == 10) {
                    FileOutputStream fileOutputStream = new FileOutputStream("MyEmail.eml");
                    message.writeTo(fileOutputStream);
                    fileOutputStream.close();
                }

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}