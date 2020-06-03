package libs.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File input = new File("JavaCore/src/main/resources/hh.html");
        Document document = Jsoup.parse(input, "UTF-8", "hh.ru");

        Elements title = document.select("head > title");
        System.out.println("title = " + title.html());


    }
}
