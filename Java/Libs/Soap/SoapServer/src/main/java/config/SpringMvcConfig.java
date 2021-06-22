package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * инициализация Spring MVC через аннотации
 *
 * запускаем на сервере приложений
 */
public class SpringMvcConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{
                SoapConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}