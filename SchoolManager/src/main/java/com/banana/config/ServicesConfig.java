package com.banana.config;

import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Autowired
    StudentsRepositoryInf repo;

    @Bean
    public IStudentService createStudentService() {
        StudentsService service = new StudentsService();
        service.setRepository(repo);
        return service;
    }
}
