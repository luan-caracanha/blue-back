package br.com.blue.back.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan("br.com.blue.back.model")
@ComponentScan(basePackages = {"br.com.blue.back.controller", "br.com.blue.back.service"})
@EnableJpaRepositories("br.com.blue.back.repository")
public class BackApplicationConfig {

	public static void main(String[] args) {
		SpringApplication.run(BackApplicationConfig.class, args);
	}

}
