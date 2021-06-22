package active_mq;

import active_mq.model.BalanceRequest;
import active_mq.model.ObjectFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

@Component
public class BalanceMarshaller {

    private final JAXBContext requestContext = JAXBContext.newInstance(BalanceRequest.class);
    private final MessageFactory messageFactory = MessageFactory.newInstance();
    private final JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

    public BalanceMarshaller() throws JAXBException, SOAPException {

    }

    public String marshall(Object obj) throws JAXBException, SOAPException, ParserConfigurationException, IOException, IOException {
        SOAPMessage soapMessage = messageFactory.createMessage();

        SOAPPart soapPart = soapMessage.getSOAPPart();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        SOAPBody soapBody = envelope.getBody();

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.marshal(obj, document);

        soapBody.addDocument(document);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        soapMessage.writeTo(out);
        String result = new String(out.toByteArray());
        return result;
    }

    public Object unmarshal(String msgText) throws JAXBException, SOAPException, IOException {
        SOAPMessage message = MessageFactory.newInstance().createMessage(
                null,
                new ByteArrayInputStream(msgText.getBytes(StandardCharsets.UTF_8))
        );
        Unmarshaller unmarshaller = requestContext.createUnmarshaller();
        return unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
    }


}
