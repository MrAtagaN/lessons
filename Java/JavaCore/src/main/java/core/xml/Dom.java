package core.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class Dom {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse("JavaCore\\src\\main\\resources\\Blank_A4.jrxml");

        //Получить элемент
        Element element = document.getDocumentElement();

        //Получить имя тега
        System.out.println(element.getTagName());

        //Есть ли аттрибут у элемента
        System.out.println("Element " + element.getTagName() + " have attribute xmlns: " + element.hasAttribute("xmlns"));


        //Вывести childNodes
        System.out.println("childNodes of Element " + element.getTagName());
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element) {
                System.out.println(((Element) item).getTagName());
            }
        }

        //Текст элемента
        System.out.println("Text of element");
        NodeList nodeList = element.getElementsByTagName("textFieldExpression");
        System.out.println(nodeList.item(0).getTextContent());


        //XPath
        System.out.println("xPath");
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        System.out.println(xPath.evaluate("/jasperReport/columnHeader/band/textField[2]/textFieldExpression", document));

    }
}
