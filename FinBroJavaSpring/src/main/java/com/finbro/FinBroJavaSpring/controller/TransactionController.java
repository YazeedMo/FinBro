package com.finbro.FinBroJavaSpring.controller;

import com.finbro.FinBroJavaSpring.domain.Transaction;
import com.finbro.FinBroJavaSpring.exception.ApiResponse;
import com.finbro.FinBroJavaSpring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }



    @PostMapping()
    public ResponseEntity<ApiResponse<Transaction>> createTransaction(@RequestBody Transaction transaction) {

        Transaction savedTransaction = transactionService.createTransaction(transaction);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(true, savedTransaction));

    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<Transaction>>> getTransactions() {

        List<Transaction> allTransactions = transactionService.getAllTransactions();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(true, allTransactions));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Transaction>> getByTransactionId(@PathVariable Long id) {

        Transaction transaction = transactionService.getTransactionById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(true, transaction));

    }

    @GetMapping("/userId/{id}")
    public ResponseEntity<ApiResponse<List<Transaction>>> getAllByUserId(@PathVariable Long id) {

        List<Transaction> userTransactions = transactionService.getAllByUserId(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(true, userTransactions));

    }

    @GetMapping("/accountId/{id}")
    public ResponseEntity<ApiResponse<List<Transaction>>> getAllByAccountId(@PathVariable Long id) {

        List<Transaction> accountTransactions = transactionService.getAllByAccountId(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(true, accountTransactions));

    }

    @PutMapping()
    public ResponseEntity<ApiResponse<Transaction>> updateTransaction(@RequestBody Transaction transaction) {

        Transaction updatedTransaction = transactionService.updateTransaction(transaction);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(true, updatedTransaction));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteById(@PathVariable Long transactionId) {

        transactionService.deleteByTransactionId(transactionId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(true, null));

    }

}
