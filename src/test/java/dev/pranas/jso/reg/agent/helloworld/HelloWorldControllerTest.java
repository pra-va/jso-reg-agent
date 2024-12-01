package dev.pranas.jso.reg.agent.helloworld;

import dev.pranas.jso.reg.agent.MvcTest;
import dev.pranas.jso.reg.agent.helloworld.rest.HelloWorldRestRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HelloWorldControllerTest extends MvcTest {
    @Test
    void helloWorld_validHelloMessage_createdResponseAndEntityCreated() throws Exception {
        var helloMessageRequest = new HelloWorldRestRequest("Hello, World!");

        api.perform(post("/")
                            .content(objectMapper.writeValueAsString(helloMessageRequest))
                            .contentType("application/json")
                            .accept("application/json"))
                .andExpect(status().isCreated());

        assertThat(dbManager.retrieveSingleHelloWorldEntity())
                .hasFieldOrPropertyWithValue("helloMessage", helloMessageRequest.helloMessage());
        assertThat(dbManager.retrieveSingleHelloWorldEntity().getId())
                .isNotNull();
    }
}
