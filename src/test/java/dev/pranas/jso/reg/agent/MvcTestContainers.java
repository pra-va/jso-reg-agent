package dev.pranas.jso.reg.agent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

public class MvcTestContainers {
    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer(@Value("${testcontainers.reuse:false}") boolean reuse) {
        return new PostgreSQLContainer<>("postgres:17.2")
                .withDatabaseName("jso_reg_agent_test")
                .withUsername("test")
                .withPassword("test")
                .withReuse(reuse);
    }
}
