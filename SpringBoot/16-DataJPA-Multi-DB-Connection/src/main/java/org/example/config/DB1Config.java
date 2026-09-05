package org.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    transactionManagerRef = "transactionmanager1",
    entityManagerFactoryRef = "entitymanager1",
    basePackages = {"org.example.db1.repo"}
)
public class DB1Config{
    //DataSource
    @ConfigurationProperties(prefix = "spring.db1.datasource")
    @Bean(name = "datasource1")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    //EntityManager
    @Bean(name="entitymanager1")
    public LocalContainerEntityManagerFactoryBean entityManager(@Qualifier("datasource1") DataSource dataSource){
            LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
            bean.setDataSource(dataSource);
            bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
            bean.setPackagesToScan("org.example.db1.entity");
            Map<String , Object> map = new HashMap<>();
            map.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
            map.put("hibernate.show_sql","true");
            map.put("hibernate.hbm2ddl.auto","update");
            bean.setJpaPropertyMap(map);
            return bean;
    }

    //Transaction
    @Bean(name = "transactionmanager1")
    public PlatformTransactionManager transactionManager(@Qualifier("entitymanager1") LocalContainerEntityManagerFactoryBean entityManager){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManager.getObject());
        return manager;
    }
}