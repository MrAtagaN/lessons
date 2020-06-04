package libs.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        parseTestPage();
        //parseHH();


    }


    private static void parseTestPage() throws IOException {
        File file = new File("JavaCore/src/main/resources/hh-test.html");
        Document document = Jsoup.parse(file, "UTF-8", "hh.ru");

//        getElementsByTag
//                findFirstElementByTagName


        Elements titleElem = document.select("head > title");
        System.out.println(titleElem.text());

        Elements contentElem = document.select("body > div.content");
        System.out.println("content:\n" + contentElem.text());
        System.out.println("content:\n" + contentElem.html());
    }




    private static void parseHH() throws IOException {
        File input = new File("JavaCore/src/main/resources/hh.html");
        Document document = Jsoup.parse(input, "UTF-8", "hh.ru");

        System.out.println(document.title());

        Elements title = document.select("head > title");
        System.out.println("title = " + title.html());
    }



}
