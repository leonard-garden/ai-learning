package org.leonard.garden.ai_learning.features.system_check;

public record SystemCheckResponse(
        String message,
        long inputTokens,
        long outputTokens,
        String model
) {

}
