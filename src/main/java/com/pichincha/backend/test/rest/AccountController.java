package com.pichincha.backend.test.rest;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.model.Transaction;
import com.pichincha.backend.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService aService;

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AccountDto getAccount(@PathVariable Long id) {
		return aService.getAccount(id);
	}

    @GetMapping(value = "/{id}/transactions")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDto> getTransactionsForAccount(@PathVariable Long id) {
        return aService.getTransactionsForAccount(id);
    }

    @GetMapping(value = "/transactions")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> getAllTransaction() {
        return aService.getAllTransaction();
    }

    @PostMapping(value = "/{id}/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addTransaction(@Valid @RequestBody NewTransactionDto objectDTO) {
        return aService.addTransaction(objectDTO);
    }
}
