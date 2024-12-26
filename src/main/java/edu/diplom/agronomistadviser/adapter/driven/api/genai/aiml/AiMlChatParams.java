package edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml;

public record AiMlChatParams(
        String role,
        String model,
        int maxTokens,
        float temperature,
        boolean stream
) {
}
