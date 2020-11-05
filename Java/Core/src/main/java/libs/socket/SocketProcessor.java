package libs.socket;

import java.io.*;
import java.net.Socket;

/**
 * Обрабатывает запрос
 */
public class SocketProcessor implements Runnable {

    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public SocketProcessor(Socket socket) throws IOException {
        this.socket = socket;
        this.inputStream = socket.getInputStream();
        this.outputStream = socket.getOutputStream();
    }


    @Override
    public void run() {
        try {

            String inputRequest = readInputRequest();
            System.out.println(inputRequest);
            writeResponse("<html><body><h1> Hello !!! </h1>\r\n<h3>your request:</h3>\r\n<pre>"+inputRequest+"</pre></body></html>");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("=== Client processing finished ===");
    }

    /**
     * Формирует http ответ
     */
    private void writeResponse(String content) throws Exception {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Server: PlekhanovServer/2018-09-09\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + content.length() + "\r\n" +
                "Connection: close\r\n\r\n";

        String result = response + content;
        outputStream.write(result.getBytes());
        outputStream.flush();
    }

    /**
     * Читает входящий http запрос
     */
    private String readInputRequest() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null || line.trim().length() == 0) {
                break;
            }
            stringBuilder.append(line + "\r\n");
        }
        return stringBuilder.toString();
    }
}
