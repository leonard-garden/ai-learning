package org.leonard.garden.ai_learning;

import com.anthropic.backends.AnthropicBackend;
import com.anthropic.client.AnthropicClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.leonard.garden.ai_learning.service.HelloMessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class AiLearningApplication implements CommandLineRunner {

	private final HelloMessageService helloMessageService;

	public static void main(String[] args) {
		SpringApplication.run(AiLearningApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var response = helloMessageService.helloClaude("Hello teacher");
		log.info("Response from claude: {}", response);
	}
}
