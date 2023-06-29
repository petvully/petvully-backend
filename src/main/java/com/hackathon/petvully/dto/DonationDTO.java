package com.hackathon.petvully.dto;

import com.hackathon.petvully.dto.UserDTO.SignUpDTO;
import com.hackathon.petvully.entity.Donation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DonationDTO {

    private SignUpDTO userDTO;
    private long petId;
    private String product;
    private long price;

    public Donation toEntity() {
        return Donation.builder()
                .user(userDTO.toEntity())
                .petId(petId)
                .product(product)
                .price(price)
                .build();
    }
}
