package edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AiMlMessageResponse(

        @JsonProperty("role")
        String role,

        @JsonProperty("content")
        String content,

        @JsonProperty("refusal")
        String refusal
) {
}
