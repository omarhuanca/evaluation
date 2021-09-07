package com.pichincha.backend.test.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class NewTransactionDto {

    @Min(value = 0, message = "The id can not be greater than zero")
	private Long accountId;

	private String type;

	private String comment;
}
