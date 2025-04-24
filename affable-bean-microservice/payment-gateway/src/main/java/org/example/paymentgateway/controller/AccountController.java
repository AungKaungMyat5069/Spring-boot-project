package org.example.paymentgateway.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import org.example.paymentgateway.entity.Account;
import org.example.paymentgateway.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@RestController
@RequestMapping("/api/payment")
public class AccountController {

    private final AccountService accountService;

    record RequestClient(@JsonProperty("credit_number") String creditNumber, String name, double amount) {

    }

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    // Note : when you use Or url like below, you need to add @Nullable in arguments where your arguments is optional
    @PostMapping(value = {"/deposit/{name}/{amount}/{cardNumber}", "/deposit/{name}/{amount}"})
    public ResponseEntity<String > deposit(@PathVariable("name") String name,@PathVariable("amount") double amount,@PathVariable("cardNumber") @Nullable String cardNumber) {
        if (accountService.accountExistsByCardNumberAndName(cardNumber, name)) {
            accountService.deposit(cardNumber,name,amount);
        } else {
            Account account = accountService.accountCreate(name, amount);
            accountService.deposit(account.getCardNumber(),account.getName(),0);
        }
        return ResponseEntity.ok("Deposit successful");
    }

    @PostMapping("/withdraw/{name}/{cardNumber}/{amount}")
    public ResponseEntity<String> withdraw(@PathVariable("name") String name, @PathVariable("cardNumber") String cardNumber,@PathVariable("amount") double amount) throws AccountNotFoundException {
        if (accountService.accountExistsByCardNumberAndName(cardNumber, name)) {
            accountService.withdraw(cardNumber,name,amount);
        } else {

            throw new AccountNotFoundException("Account not found");
        }
        return ResponseEntity.ok("Withdraw successful");
    }

    @PostMapping("/buy-transaction")
    public ResponseEntity<String> buyTransaction(@RequestBody RequestClient requestClient) throws AccountNotFoundException {

        if (accountService.accountExistsByCardNumberAndName(requestClient.creditNumber, requestClient.name)) {
            accountService.buyItemsTransaction(requestClient.creditNumber, requestClient.name, requestClient.amount, "4551217", "alex");

        } else throw new AccountNotFoundException("Account not found");

        return ResponseEntity.ok("Buy successful");
    }
}
