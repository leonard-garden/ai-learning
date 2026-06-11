package org.leonard.garden.ai_learning.features.system_check;

import com.anthropic.client.AnthropicClient;
import com.anthropic.models.messages.MessageCreateParams;
import com.anthropic.models.messages.Model;
import com.anthropic.models.messages.TextBlock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SystemCheckServiceImpl implements SystemCheckService {
    private final AnthropicClient anthropicClient;

    @Override
    public SystemCheckResponse execute(SystemCheckRequest request) {
        log.info("Start execute system check service");
        log.debug("Request message: {}", request.message());

        var messageParams = MessageCreateParams.builder()
                .maxTokens(512)
                .model(Model.CLAUDE_HAIKU_4_5)
                .system(SystemCheckSystemPrompt.SYSTEM_PROMPT)
                .addUserMessage(request.message())
                .build();

        var message = anthropicClient.messages().create(messageParams);
        String responseContent = message.content().getFirst().text()
                .map(TextBlock::text)
                .orElseGet(() -> {
                    log.warn("Can not get response from anthropic model.");
                    return "";
                });

        return new SystemCheckResponse(
                responseContent,
                message.usage().inputTokens(),
                message.usage().outputTokens(),
                message.model().asString()
        );
    }
}
