package services.impl;

import model.Goods;
import model.SoapRequset;
import model.SoapResponse;
import org.springframework.stereotype.Component;
import services.SoapService;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@Component
@HandlerChain(file = "handler-chain.xml")   // включение обработчика входящих/исходящих запросов
@WebService(endpointInterface = "services.SoapService", serviceName = "SoapServiceImpl")
public class SoapServiceImpl implements SoapService {

    @Override
    public String inputText(String text) {
        return "Server receive your text: " + text;
    }

    @Override
    public Goods getGoods() {
        return new Goods(5, "gold");
    }

    @Override
    public SoapResponse getTestSoapResponse(SoapRequset soapRequset) {
        System.out.println("get soap requset ->" + soapRequset);
        SoapResponse soapResponse = new SoapResponse();
        soapResponse.setResponseValue("some value");
        return soapResponse;
    }
}
