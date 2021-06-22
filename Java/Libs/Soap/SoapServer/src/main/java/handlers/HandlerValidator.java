package handlers;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;
import java.util.UUID;

public class HandlerValidator implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean isResponce = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (isResponce) {  // добавляем в ответ поле UUID в заголовок
            try {
                SOAPFactory soapFactory = SOAPFactory.newInstance();
                SOAPElement soapElement = soapFactory.createElement("UUID");
                soapElement.addTextNode(UUID.randomUUID().toString());

                SOAPEnvelope soapEnv = context.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader soapHeader = soapEnv.getHeader();

                soapHeader.addChildElement(soapElement);
            } catch (SOAPException e) {
                System.err.println(e);
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }
}
