package com.example.transactionmanagement.repository;
import com.example.transactionmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccountRepository extends JpaRepository<Account, Long> {}
