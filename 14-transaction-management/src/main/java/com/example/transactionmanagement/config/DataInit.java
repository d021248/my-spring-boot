package com.example.transactionmanagement.config;
import com.example.transactionmanagement.entity.Account;
import com.example.transactionmanagement.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

@Configuration
public class DataInit {
    @Bean
    CommandLineRunner init(AccountRepository repo) {
        return args -> {
            Account a1 = new Account();
            a1.setName("Alice");
            a1.setBalance(new BigDecimal("1000.00"));
            repo.save(a1);

            Account a2 = new Account();
            a2.setName("Bob");
            a2.setBalance(new BigDecimal("500.00"));
            repo.save(a2);
        };
    }
}
