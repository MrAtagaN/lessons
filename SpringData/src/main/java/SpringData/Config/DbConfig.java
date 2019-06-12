package SpringData.Config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;
import java.io.File;


@Configuration
public class DbConfig {

    private static final String FS = File.separator;
    private static final String URL = "jdbc:sqlite:SpringData" + FS + "src" + FS + "main" + FS + "resources" + FS + "lessonsSpringData.db";

    @Bean("SQLite")
    public DataSource getDataSourceSqLite() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl(URL);
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }

    /** Пул соединений */
    @Bean("BasicDataSource")
    public DataSource getBasicDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl(URL);
        dataSource.setUsername("");
        dataSource.setPassword("");
        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(20);

        return dataSource;
    }

//    /** Получение через JNDI */
//    @Bean("JNDI")
//    public JndiObjectFactoryBean getDataSource() {
//        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("name JNDI");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
//
//        return jndiObjectFactoryBean;
//    }

    @Bean
    public JdbcTemplate getJdbcTemplate(@Qualifier("SQLite")DataSource getDataSource) {
        return new JdbcTemplate(getDataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(@Qualifier("SQLite")DataSource getDataSource) {
        return new NamedParameterJdbcTemplate(getDataSource);
    }

    /** База в памяти */
    @Bean("H2")
    public DataSource getDataSourceH2() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:H2_Script.sql").build();
    }
}
