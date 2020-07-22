package services;


import model.Goods;
import model.SoapRequset;
import model.SoapResponse;

import javax.jws.WebService;

@WebService
public interface SoapService {

    String inputText(String text);

    Goods getGoods();

    SoapResponse getTestSoapResponse(SoapRequset soapRequset);

}
