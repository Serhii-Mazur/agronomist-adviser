package edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AiMlMessage(

        @JsonProperty("role")
        String role,

        @JsonProperty("content")
        String content
) {
}
