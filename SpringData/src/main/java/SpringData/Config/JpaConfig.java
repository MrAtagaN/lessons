package SpringData.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class JpaConfig {

    @Bean("entityManagerFactory")
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
        bean.setPersistenceUnitName("myUnit");
        return bean;
    }

    @Bean("transactionManager")
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }
}
