package dev.pranas.jso.reg.agent;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
@Import({MvcTestContainers.class, TestBeanConfig.class})
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = {"classpath:sql/clean-all.sql"})
public abstract class MvcTest {
    @Autowired
    protected MockMvc api;

    @Autowired
    protected DbManager dbManager;

    @Autowired
    protected ObjectMapper objectMapper;
}
