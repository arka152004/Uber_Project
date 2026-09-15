package com.arka.reviewService.dto;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonToken;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.apache.logging.log4j.message.Message;

@Getter
@Setter

public class CreateReviewDto {
    private String content;
    private Double rating;
    @NotNull
    private Long bookingId;

}
