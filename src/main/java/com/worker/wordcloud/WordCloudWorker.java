package com.worker.wordcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordCloudWorker {
	public static void main(String[] args) {
		SpringApplication.run(WordCloudWorker.class, args);
	}

}
