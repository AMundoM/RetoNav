package com.banana.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PropertiesConfig.class, PropertiesConfigDev.class, /*PersistenceConfig.class,*/ ReposConfig.class, ServicesConfig.class})
@ComponentScan(basePackages = {"com.banana.persistence", "com.banana.services"})
@EntityScan(basePackages = {"com.banana.models"}) // for scaning entities when emf bean no set and using properties
public class SpringConfig {

}
