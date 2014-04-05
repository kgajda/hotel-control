/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector;

import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * Konfiguracja Springa.
 *
 * @author karol
 */
@Configuration
@ComponentScan(basePackages = "pl.hotel.database.connector")
@PropertySource(value = {"classpath:/jdbc.properties", "classpath:/hibernate.properties"})
public class SpringConfig {

    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;

    private Properties hibernateProperties;

    public SpringConfig() {
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");

    }

    @Bean
    org.apache.commons.dbcp.BasicDataSource basicDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setUrl(url);
        return basicDataSource;
    }

    org.springframework.orm.hibernate4.LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(basicDataSource());
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        return localSessionFactoryBean;
    }

    org.springframework.orm.hibernate4.HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory((SessionFactory) localSessionFactoryBean());
        return hibernateTransactionManager;
    }
}
