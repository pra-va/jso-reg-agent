package dev.pranas.jso.reg.agent.helloworld.controller;

import dev.pranas.jso.reg.agent.helloworld.entity.HelloWorldEntity;
import dev.pranas.jso.reg.agent.helloworld.repository.HelloWorldRepository;
import dev.pranas.jso.reg.agent.helloworld.rest.HelloWorldRestRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HelloWorldController {
    // Poor practice. Using repo directly in controller just for testing purposes.
    private final HelloWorldRepository helloWorldRepository;

    @GetMapping
    public String sayHello() {
        return "<h1>Hello, World!</h1>";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void helloWorld(@Validated @RequestBody HelloWorldRestRequest request) {
        helloWorldRepository
                .save(
                        new HelloWorldEntity()
                                .setHelloMessage(request.helloMessage())
                );
    }
}
