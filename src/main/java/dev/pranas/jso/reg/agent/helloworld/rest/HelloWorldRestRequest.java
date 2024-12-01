package dev.pranas.jso.reg.agent.helloworld.rest;

import jakarta.validation.constraints.NotBlank;

public record HelloWorldRestRequest(@NotBlank String helloMessage) {
}
