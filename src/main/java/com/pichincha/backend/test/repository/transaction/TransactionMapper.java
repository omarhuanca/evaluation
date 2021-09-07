package com.pichincha.backend.test.repository.transaction;

import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.model.Transaction;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Transaction convertModel(NewTransactionDto objectDTO) {
        return modelMapper.map(objectDTO, Transaction.class);
    }
}
