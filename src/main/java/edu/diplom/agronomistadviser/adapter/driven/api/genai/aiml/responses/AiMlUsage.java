package edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AiMlUsage(

        @JsonProperty("prompt_tokens")
        int promptTokens,

        @JsonProperty("completion_tokens")
        int completionTokens,

        @JsonProperty("total_tokens")
        int totalTokens
) {
}
