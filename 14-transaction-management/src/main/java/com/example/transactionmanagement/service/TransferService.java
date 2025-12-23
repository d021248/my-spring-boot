package com.example.transactionmanagement.service;
import com.example.transactionmanagement.entity.Account;
import com.example.transactionmanagement.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import java.math.BigDecimal;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        Account from = accountRepository.findById(fromId).orElseThrow();
        Account to = accountRepository.findById(toId).orElseThrow();

        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        accountRepository.save(from);
        accountRepository.save(to);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transferWithNewTransaction(Long fromId, Long toId, BigDecimal amount) {
        transfer(fromId, toId, amount);
    }

    @Transactional(rollbackFor = Exception.class, noRollbackFor = IllegalArgumentException.class)
    public void transferWithRollbackRules(Long fromId, Long toId, BigDecimal amount) {
        transfer(fromId, toId, amount);
    }
}
