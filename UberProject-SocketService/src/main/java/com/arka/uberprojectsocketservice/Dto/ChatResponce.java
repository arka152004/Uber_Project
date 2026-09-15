package com.arka.uberprojectsocketservice.Dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponce {
    private String name;
    private String message;
    private String timestamp;
}
