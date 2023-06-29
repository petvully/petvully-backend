package com.hackathon.petvully.dto.DonateDTO;

import com.hackathon.petvully.entity.Donate;
import com.hackathon.petvully.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonateSaveDTO {
    private Long userId;
    private String product;
    private Long price;
    private String category;
    private String shelter;

    public Donate toEntity(User userId) {
        return Donate.builder()
                .userId(userId)
                .product(product)
                .price(price)
                .category(category)
                .shelter(shelter)
                .build();
    }
}
