package SpringData.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;


@Configuration
public class DbConfig {

    private static final String FS = File.separator;
    private static final String URL = "jdbc:sqlite:JDBC" + FS + "src" + FS + "main" + FS + "resources" + FS + "lessonsJDBC.db";

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl(URL);
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource getDataSource) {
        return new JdbcTemplate(getDataSource);
    }
}
