package libs.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;


/**
 * Слекторы:
 * > дочерние элементы
 * <имя тега>.<имя класса>
 * :nth-child(1) первый вложеный элемент
 *
 *
 * Elements методы:
 *
 * outerHtml - Внешний HTML of all matched elements.
 * html - Внутренний  HTML of all matched elements.
 * get(0) -
 * size -
 * text -
 * remove -
 * attr -
 *
 *
 * Селекторы:
 * https://jsoup.org/cookbook/extracting-data/selector-syntax
 * https://www.w3schools.com/cssref/css_selectors.asp
 */
public class Main {

    public static void main(String[] args) throws IOException {
        parseTestPage();
        //parseHH();


    }


    private static void parseTestPage() throws IOException {
        File file = new File("JavaCore/src/main/resources/hh-test.html");
        Document document = Jsoup.parse(file, "UTF-8", "hh.ru");

//        getElementsByTag
//        findFirstElementByTagName

        //<h1>Работа найдется для каждого</h1>
        Elements h1 = document.select("h1");
        //System.out.println(h1);

        Elements titleElem = document.select("head > title");
        //System.out.println(titleElem.html());

        //Все div
        Elements divs = document.select("body > div");
        //System.out.println(divs.outerHtml());

        //<div class="header">
        //  <h1>Работа найдется для каждого</h1>
        //  <div>
        //    Поиск вакансий
        //  </div>
        //</div>
        Elements firstDiv = document.select("body > div:nth-child(1)");
        //System.out.println(firstDiv.outerHtml());

        Element firstDiv2 = document.select("body > div").first();
//        System.out.println(firstDiv2.outerHtml());


        //<div>
        //  Поиск вакансий
        //</div>
        Elements divHeader = document.select("body > div:nth-child(1) :not(h1)");
        //System.out.println(divHeader.outerHtml());


        //<div class="content">
        //  <div>
        //    Вакансии дня
        //  </div>
        //  <div>
        //    Компании дня
        //  </div>
        //  <div>
        //    Работа из дома
        //  </div>
        //</div>
        Elements contentElem = document.select("body > div.content");
        //System.out.println(contentElem.outerHtml());


        //<div id="123">
        // Компании дня
        //</div>
        Elements idElem = document.select("#123");
        //System.out.println(idElem);

        Element image = document.select("body > div.footer > img").get(1);
        System.out.println(image.attr("src"));

    }




    private static void parseHH() throws IOException {
        File input = new File("JavaCore/src/main/resources/hh.html");
        Document document = Jsoup.parse(input, "UTF-8", "hh.ru");

        System.out.println(document.title());

        Elements title = document.select("head > title");
        System.out.println("title = " + title.html());
    }



}
