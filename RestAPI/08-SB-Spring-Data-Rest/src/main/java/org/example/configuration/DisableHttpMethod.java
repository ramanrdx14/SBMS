package org.example.configuration;

import org.example.Entity.Books;
import org.example.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.List;

@Configuration
public class DisableHttpMethod implements RepositoryRestConfigurer {
    @Autowired
    BookRepo bookRepo;
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] httpMethod = {HttpMethod.PUT,HttpMethod.DELETE};
        config.getExposureConfiguration()
                .forDomainType(Books.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(httpMethod)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(httpMethod)));
    }
}
