package com.arka.uberprojectsocketservice.Dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequest {
    private String username;
    private String message;

}
