package com.controller;
import com.model.ACCOUNT;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")

public class AccountController {
	@Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<ACCOUNT> createAccount(@RequestBody ACCOUNT account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ACCOUNT> getAccountById(@PathVariable Integer id) {
        ACCOUNT account = accountService.getAccountById(id);
        return (account != null) ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ACCOUNT>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ACCOUNT> updateAccount(@PathVariable Integer id, @RequestBody ACCOUNT account) {
        System.out.println("Received PUT request for ID: " + id); // TEMP log
        try {
            ACCOUNT updatedAccount = accountService.updateAccount(id, account);
            return ResponseEntity.ok(updatedAccount);
        } catch (RuntimeException ex) {
            System.err.println("Erreur lors de la mise à jour: " + ex.getMessage()); // TEMP log
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Integer id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public ResponseEntity<List<ACCOUNT>> searchAccounts(@RequestParam("word") String searchWord) {
        List<ACCOUNT> accounts = accountService.searchAccounts(searchWord);
        return ResponseEntity.ok(accounts);
    }
    
}
