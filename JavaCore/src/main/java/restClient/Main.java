package restClient;

public class Main {

    public static void main(String[] args) {
        RestClient restClient = new RestClient();

        restClient.get("http://google.ru", null);
    }
}
