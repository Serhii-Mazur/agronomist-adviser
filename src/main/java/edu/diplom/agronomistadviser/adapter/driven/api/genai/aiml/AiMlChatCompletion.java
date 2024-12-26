package edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml;

import edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.responses.AiMlMessageResponse;

import java.util.List;

public record AiMlChatCompletion(
        String model,
        List<AiMlMessageResponse> messages,
        int maxTokens,
        float temperature,
        boolean stream,
        float frequencyPenalty,
        float topP
) {
}
