package com.example.transactionmanagement.controller;
import com.example.transactionmanagement.service.TransferService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public String transfer(@RequestParam Long from, @RequestParam Long to, @RequestParam BigDecimal amount) {
        transferService.transfer(from, to, amount);
        return "Transfer successful";
    }

    @PostMapping("/new-transaction")
    public String transferNew(@RequestParam Long from, @RequestParam Long to, @RequestParam BigDecimal amount) {
        transferService.transferWithNewTransaction(from, to, amount);
        return "Transfer with new transaction successful";
    }
}
