package edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AiMlChatCompletionsRequest(

        @JsonProperty("messages" )
        @NotNull
        List<AiMlMessage> messages,

        @JsonProperty("model" )
        @NotNull
        String model,

        @JsonProperty("max_tokens" )
        int maxTokens,

        @JsonProperty("temperature" )
        float temperature,

        @JsonProperty("stream" )
        boolean stream

//        @JsonProperty("frequency_penalty" )
//        float frequencyPenalty,
//
//        @JsonProperty("top_p" )
//        float topP
) {
}
