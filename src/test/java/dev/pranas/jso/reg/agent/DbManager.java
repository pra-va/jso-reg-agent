package dev.pranas.jso.reg.agent;

import dev.pranas.jso.reg.agent.helloworld.entity.HelloWorldEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DbManager {
    private final EntityManager entityManager;

    public HelloWorldEntity retrieveSingleHelloWorldEntity() {
        return entityManager
                .createQuery("SELECT hw FROM HelloWorldEntity hw", HelloWorldEntity.class)
                .getSingleResult();
    }
}
