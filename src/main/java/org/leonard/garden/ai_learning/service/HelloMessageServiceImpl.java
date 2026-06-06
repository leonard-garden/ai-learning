package org.leonard.garden.ai_learning.service;

import com.anthropic.client.AnthropicClient;
import com.anthropic.models.messages.CacheControlEphemeral;
import com.anthropic.models.messages.ContentBlock;
import com.anthropic.models.messages.MessageCreateParams;
import com.anthropic.models.messages.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloMessageServiceImpl implements HelloMessageService {

    private final AnthropicClient anthropicClient;

    @Override
    public String helloClaude(String message) {
        var messageParams = MessageCreateParams.builder()
                .model(Model.CLAUDE_HAIKU_4_5)
                .maxTokens(1024L)
                .cacheControl(CacheControlEphemeral.builder().build())
                .system("You are an AI assistant tasked with great English teacher. You are teaching Leonard")
                .addUserMessage(message)
                .build();

        var anthropicMessage = anthropicClient.messages().create(messageParams);

        return anthropicMessage.content().stream()
                .filter(ContentBlock::isText)
                .map(contentBlock -> contentBlock.asText().text())
                .findFirst()
                .orElse("");
    }
}
