package edu.diplom.agronomistadviser.adapter.driver.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record AiAdviceResponse(

        @JsonProperty("diseasePreventionAiChat")
        Map<String, String> diseasePreventionAiChat
) {

    public static AiAdviceResponse toResponse(Map<String, String> domain) {

        return new AiAdviceResponse(domain);
    }
}
