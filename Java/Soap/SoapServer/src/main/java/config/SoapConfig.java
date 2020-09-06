package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import services.SoapService;
import services.impl.SoapServiceImpl;


@Configuration
public class SoapConfig {


    @Bean
    public SoapService getSoapService() {
        return new SoapServiceImpl();
    }

    @Bean
    public SimpleJaxWsServiceExporter exporter() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8899/");// путь до wsdl  http://localhost:8899/SoapServiceImpl?wsdl
        return exporter;
    }
}
