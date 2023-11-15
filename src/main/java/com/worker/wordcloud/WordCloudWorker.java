package com.worker.wordcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.ConnectionFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WordCloudWorker {

	@Bean
	ConnectionFactoryCustomizer cust() {
		return cf -> cf.setMaxInboundMessageBodySize(1024 * 1024 * 128);
	}

	public static void main(String[] args) {
		SpringApplication.run(WordCloudWorker.class, args);
	}

}
