
package com.arka.reviewService.dto;

import lombok.*;

        import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long Id;
    private String content;
    private Double rating;
    private Long booking;
    private Date createdAt;
    private Date updatedAt;


}
