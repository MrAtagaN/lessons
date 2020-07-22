package soap_client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.MyServiceRequest;
import services.MyServiceResponse;
import services.SoapService;
import services.impl.SoapServiceImpl;


import javax.annotation.PostConstruct;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.util.List;

@Service
public class SoapClient {

    private SoapService soapService;

    @Autowired
    private SoapHandler soapHandler;

    @PostConstruct
    private void postConstruct() {
        SoapServiceImpl soapServiceImpl = new SoapServiceImpl();
        soapService = soapServiceImpl.getSoapServiceImplPort();
        Binding binding = ((BindingProvider) soapService).getBinding();
        List<Handler> handlerList = binding.getHandlerChain();
        handlerList.add(soapHandler);
        binding.setHandlerChain(handlerList);
    }

    public MyServiceResponse soapRequest () {
        MyServiceRequest myServiceRequest = new MyServiceRequest();
        myServiceRequest.setSomeInt(4);
        myServiceRequest.setSomeValue("abc");
        MyServiceResponse myServiceResponse = soapService.getTestSoapResponse(myServiceRequest);
        return myServiceResponse;
    }

}
