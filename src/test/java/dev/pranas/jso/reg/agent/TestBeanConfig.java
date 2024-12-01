package dev.pranas.jso.reg.agent;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;

public class TestBeanConfig {
    @Bean
    public DbManager dbManager(EntityManager entityManager) {
        return new DbManager(entityManager);
    }
}
