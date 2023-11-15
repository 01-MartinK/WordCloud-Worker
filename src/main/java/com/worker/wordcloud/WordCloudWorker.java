package com.worker.wordcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.ConnectionFactoryCustomizer;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class WordCloudWorker {

	public static List<WorkRequest> workers;

	@Bean
	ConnectionFactoryCustomizer cust() {
		return cf -> cf.setMaxInboundMessageBodySize(1024 * 1024 * 128);
	}

	public static void createWorker(List<String> list) {
		WorkRequest worker = new WorkRequest();
		worker.setWordList(list);
		worker.calculateWordCloud();
		workers.add(worker);
	}

	public static void main(String[] args) {
		SpringApplication.run(WordCloudWorker.class, args);
	}

}
