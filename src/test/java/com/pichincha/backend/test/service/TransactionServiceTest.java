package com.pichincha.backend.test.service;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.model.Account;
import com.pichincha.backend.test.repository.account.AccountRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {

    public final String INVALID_ASSIGN = "Can not create two transaction same account reference";

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @Test
    public void test01() throws Exception {
        assertThrows(RuntimeException.class, () -> {
            Account account = createTestAccount();

            NewTransactionDto transaction1 = new NewTransactionDto();
            transaction1.setAccountId(account.getId());
            transaction1.setType("Type01");
            transaction1.setComment("Comment01");

            NewTransactionDto transaction2 = new NewTransactionDto();
            transaction2.setAccountId(account.getId());
            transaction2.setType("Type02");
            transaction2.setComment("Comment02");

            accountService.addTransaction(transaction1);
            accountService.addTransaction(transaction2);

        }, INVALID_ASSIGN);
    }

    private Account createTestAccount() {
        Account account = new Account();
        account.setNumber("TestNumber01");
        account.setType("TestType01");
        LocalDateTime creationDate = LocalDateTime.of(2018, 5, 20, 20, 51, 16);
        account.setCreationDate(creationDate);
        accountRepository.save(account);
        return account;
    }
}
