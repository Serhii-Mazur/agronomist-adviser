package edu.diplom.agronomistadviser.adapter.driven.api.genai.aiml.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AiMlChoiseResponse(

        @JsonProperty("index" )
        int index,

        @JsonProperty("finish_reason" )
        String finishReason,

        @JsonProperty("logprobs" )
        String logProbs,

        @JsonProperty("message" )
        AiMlMessageResponse message
) {
}
