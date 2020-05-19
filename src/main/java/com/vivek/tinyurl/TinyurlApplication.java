package com.vivek.tinyurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.vivek.tinyurl.model.SequentialGeneratorModel;

@SpringBootApplication
public class TinyurlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyurlApplication.class, args);
	}

	@Bean
	public SequentialGeneratorModel getSGM() {
		return new SequentialGeneratorModel();
	}
	
}
