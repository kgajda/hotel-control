/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.hotel.control.database.connector;

import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Konfiguracja Springa.
 *
 * @author karol
 */
@Configuration
@ComponentScan(basePackages = "pl.hotel.database.connector")
@PropertySource(value = {"classpath:/jdbc.properties", "classpath:/Hibernate.properties"})
@EnableTransactionManagement
public class SpringConfig {

    @Autowired
    private Environment environment;

    @Bean(destroyMethod = "close")
    org.apache.commons.dbcp.BasicDataSource basicDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUsername(environment.getProperty("jdbc.username"));
        basicDataSource.setPassword(environment.getProperty("jdbc.password"));
        basicDataSource.setUrl(environment.getProperty("jdbc.url"));
        return basicDataSource;
    }

    @Bean
    org.springframework.orm.hibernate4.LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(basicDataSource());
        localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
        localSessionFactoryBean.setPackagesToScan(new String[]{"pl.hotel.control.database.connector.orm"});
        return localSessionFactoryBean;
    }

    @Bean
    org.springframework.orm.hibernate4.HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(localSessionFactoryBean().getObject());
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties getHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        hibernateProperties.setProperty("hibernate.current_session_context_class", environment.getProperty("hibernate.current_session_context_class"));
        hibernateProperties.setProperty("hibernate.connection.useUnicode", environment.getProperty("hibernate.connection.useUnicode"));
        System.out.println("############################");
        System.out.println(environment.getProperty("hibernate.dialect"));
        return hibernateProperties;
    }
}
