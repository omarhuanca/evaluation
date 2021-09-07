package com.pichincha.backend.test.service;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.model.Transaction;
import com.pichincha.backend.test.repository.account.AccountRepository;
import com.pichincha.backend.test.repository.transaction.TransactionMapper;
import com.pichincha.backend.test.repository.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

	public AccountDto getAccount(Long id) {
		return accountRepository.findById(id)
			.map(account -> new AccountDto(account.getNumber(), account.getType(), account.getCreationDate()))
			.orElse(null);
	}

	/**
	 * Returns a list of all transactions for a account with passed id.
	 *
	 * @param accountId id of the account
	 * @return list of transactions sorted by creation date descending - most recent first
	 */
	public List<TransactionDto> getTransactionsForAccount(Long accountId) {
        return this.getFilterTransaction(accountId).stream().map(item -> new TransactionDto(item.getId(), item.getComment(), item.getType(), item.getCreationDate()))
                                                            .collect(Collectors.toList());
	}

	/**
	 * Creates a new transaction
	 *
	 * @param newTransactionDto data of new transaction
	 * @return id of the created transaction
	 * @throws IllegalArgumentException if there is no account for passed newTransactionDto.accountId
	 */
	public Long addTransaction(NewTransactionDto newTransactionDto) {
        List<Transaction> listTransaction = this.getFilterTransaction(newTransactionDto.getAccountId());

        if (1 <= listTransaction.size()) {
            throw new RuntimeException();
        }

        Transaction object = transactionRepository.save(transactionMapper.convertModel(newTransactionDto));
        transactionRepository.flush();
        return object.getId();
    }

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getFilterTransaction(Long accountId) {
        if (0 >= accountId) {
            throw new RuntimeException();
        }
        return transactionRepository.findAll().stream().filter(filter -> filter.getAccountId().equals(accountId))
                                                       .collect(Collectors.toList());
    }
}
