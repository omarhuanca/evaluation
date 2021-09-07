package com.pichincha.backend.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class AccountDto {

    private String number;

    private String type;

    private LocalDateTime creationDate;

}
