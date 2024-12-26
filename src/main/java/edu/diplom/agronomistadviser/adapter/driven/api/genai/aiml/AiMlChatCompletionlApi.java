package edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml;

import edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.requests.AiMlChatCompletionsRequest;
import edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.responses.AiMlChatCompletionsResponse;
import edu.diplom.agronomistadviser.config.AiMlApiConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "AI-ML-API",
        url = "${aiml.api.url}",
        configuration = AiMlApiConfig.class
)
public interface AiMlChatCompletionlApi {

    @PostMapping()
    AiMlChatCompletionsResponse completeChat(
            @RequestBody
            AiMlChatCompletionsRequest request
    );
}
