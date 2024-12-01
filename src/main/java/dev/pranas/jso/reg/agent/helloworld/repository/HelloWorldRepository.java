package dev.pranas.jso.reg.agent.helloworld.repository;

import dev.pranas.jso.reg.agent.helloworld.entity.HelloWorldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloWorldRepository extends JpaRepository<HelloWorldEntity, Long> {
}
