package com.codeGodfather.giflib.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

/**
 * Created by godfather on 2017-08-30.
 */
//Configuration will make spring pick this class at boot time
@Configuration
@PropertySource("app.properties")
public class DataConfig {
    @Autowired
    private Environment env;
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean()
    {
        //setting the path for config file
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        // creating a local session factory bean to create a session
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        //setting the hibernate configuration to the session
        sessionFactory.setConfigLocation(config);
        //setting session factory to scan for packages which holds entity
        sessionFactory.setPackagesToScan(env.getProperty("giflib.entity.package"));
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        //set driver class
        dataSource.setDriverClassName(env.getProperty("giflib.db.driver"));

        //set URL
        dataSource.setUrl(env.getProperty("giflib.db.url"));

        //setUsername and Password
        dataSource.setUsername(env.getProperty("giflib.db.username"));
        dataSource.setPassword(env.getProperty("giflib.db.password"));
        return dataSource;
    }
}
