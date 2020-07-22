package soap_client;

import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

@Component
public class SoapHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {

        Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundProperty) { // добавляем в хедер логин и пароль
            try {
                SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();
                SOAPElement security = header.addChildElement("Security");
                SOAPElement usernameToken = security.addChildElement("UserNameToken");
                SOAPElement username = usernameToken.addChildElement("UserName");
                username.addTextNode("Admin");
                SOAPElement password = usernameToken.addChildElement("Password");
                password.addTextNode("Pass");
            } catch (Exception e) {
                e.printStackTrace();
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
