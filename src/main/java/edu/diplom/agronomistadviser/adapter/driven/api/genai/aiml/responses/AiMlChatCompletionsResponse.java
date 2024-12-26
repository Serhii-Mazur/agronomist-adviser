package edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AiMlChatCompletionsResponse(
        @JsonProperty("id")
        String id,

        @JsonProperty("object")
        String object,

        @JsonProperty("choices")
        List<AiMlChoiseResponse> choices,

        @JsonProperty("created")
        long created,

        @JsonProperty("model")
        String model,

        @JsonProperty("usage")
        AiMlUsage usage
) {
}
