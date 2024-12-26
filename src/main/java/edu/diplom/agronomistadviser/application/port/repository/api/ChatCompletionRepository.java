package edu.diplom.agronomistadviser.application.port.repository.api;

import edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.AiMlChatParams;

public interface ChatCompletionRepository {
    String completeChat(String message, AiMlChatParams aiMlChatParams);
}
