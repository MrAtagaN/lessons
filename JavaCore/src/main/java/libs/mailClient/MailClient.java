package libs.mailClient;

import javax.mail.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Клиент для почтового ящика
 */
public class MailClient {

    private String host;
    private int port;
    private String userName;
    private String mailStoreType;
    private String password;


    public MailClient(String host, int port, String userName, String mailStoreType, String password) {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.mailStoreType = mailStoreType;
        this.password = password;
    }


    public void readMessages(String folderName, int numberOfReadMessages) {
        Store store = null;
        Folder inFolder = null;

        try {
            Session emailSession = Session.getDefaultInstance(new Properties());
            store = emailSession.getStore(mailStoreType);
            store.connect(host, port, userName, password);

            inFolder = store.getFolder(folderName);

            inFolder.open(Folder.READ_ONLY);
            UIDFolder uidFolder = (UIDFolder) inFolder;

            Message[] messages = inFolder.getMessages();
            System.out.println("messages.length:  " + messages.length);

            for (int i = 0; i < numberOfReadMessages && i < messages.length; i++) {
                Message message = messages[i];
                long messageUID = uidFolder.getUID(message); //уникальный ID в folder

                System.out.println("\n===================================================================================" +
                        "======================================================================================================");
                log(message, messageUID);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inFolder != null && inFolder.isOpen()) {
                    inFolder.close();
                }
                if (store != null && store.isConnected()) {
                    store.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void saveMessage(String folderName, long messageUID) {
        Store store = null;
        Folder inFolder = null;

        try {
            Session emailSession = Session.getDefaultInstance(new Properties());
            store = emailSession.getStore(mailStoreType);
            store.connect(host, port, userName, password);

            inFolder = store.getFolder(folderName);

            inFolder.open(Folder.READ_ONLY);
            UIDFolder uidFolder = (UIDFolder) inFolder;

            Message message = uidFolder.getMessageByUID(messageUID);

            System.out.println("\n================================================================== DOWNLOAD MESSAGE " +
                    "============================================================================================");
            log(message, messageUID);

            //Сохраняем письмо
            try (FileOutputStream fileOutputStream = new FileOutputStream("MyEmail_" + messageUID + ".eml")) {
                message.writeTo(fileOutputStream);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inFolder != null && inFolder.isOpen()) {
                    inFolder.close();
                }
                if (store != null && store.isConnected()) {
                    store.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void log(Message message, long messageUID) throws MessagingException, IOException {
        System.out.println("Email Number: " + message.getMessageNumber());
        System.out.println("Date: " + message.getSentDate());
        System.out.println("UID: " + messageUID);
        System.out.println("Subject: " + message.getSubject());
        System.out.println("From: " + message.getFrom()[0]);
        System.out.println("Content: " + MailUtils.getTextFromMessage(message));
    }


}
