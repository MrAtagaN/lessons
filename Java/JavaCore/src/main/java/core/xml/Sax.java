package core.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


public class Sax {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                //вывести аттрибут тега
                String value = attributes.getValue("uuid");
                if (value != null && !value.isEmpty()) {
                    System.out.println(value);
                }

                //вывести имя тега
                System.out.println(qName);
            }


//            @Override
//            public void characters(char[] ch, int start, int length) throws SAXException {
//                StringBuilder stringBuilder = new StringBuilder();
//                for (int i = 0; i < length; i++) {
//                    stringBuilder.append(ch);
//                }
//                System.out.println(stringBuilder);
//            }
        };


        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("JavaCore\\src\\main\\resources\\Blank_A4.jrxml"), handler);
    }

}
