package dev.pranas.jso.reg.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
