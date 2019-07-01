package libs.restClient;

public class Main {

    public static void main(String[] args) {
        RestClient restClient = new RestClient();

        restClient.get("https://postman-echo.com/get?foo1=bar1&foo2=bar2", null);
        restClient.post("https://postman-echo.com/post","TEST BODY", null);

    }
}
