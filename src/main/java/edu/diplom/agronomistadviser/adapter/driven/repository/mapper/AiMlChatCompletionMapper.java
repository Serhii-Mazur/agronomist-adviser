package edu.diplom.agronomistadviser.adapter.driven.repository.mapper;

import edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.requests.AiMlChatCompletionsRequest;
import edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.requests.AiMlMessage;
import edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.AiMlChatParams;

import java.util.ArrayList;
import java.util.List;

public class AiMlChatCompletionMapper {

    public static AiMlChatCompletionsRequest toRequest(String message, AiMlChatParams params) {
        List<AiMlMessage> messages = new ArrayList<>();
        messages.add(0, new AiMlMessage(params.role(), message));

        return new AiMlChatCompletionsRequest(
                messages,
                params.model(),
                params.maxTokens(),
                params.temperature(),
                params.stream()
        );
    }
}

