package com.pichincha.backend.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class TransactionDto {

    private Long id;

    private String comment;

    private String type;

    private LocalDateTime creationDate;

}
