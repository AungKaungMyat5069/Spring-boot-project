package org.example.paymentgateway.service;

import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.paymentgateway.dao.AccountDao;
import org.example.paymentgateway.entity.Account;
import org.example.paymentgateway.exception.InsufficientAmountException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public double getBalance(String cardNumber, String name) {
        return accountDao.getBalance(cardNumber, name);
    }

    @Transactional
    public void deposit(String cardNumber, String name, double amount) {
        double newBalance = getBalance(cardNumber, name);
        newBalance += amount;
        Account account = getAccount(cardNumber, name);
        account.setAmount(newBalance);
    }

    private Account getAccount(String cardNumber, String name)  {
        return accountDao.findByCardNumberAndName(cardNumber, name)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
    }

    @Transactional
    public void withdraw(String cardNumber, String name, double amount) {
        double newBalance = getBalance(cardNumber, name);
        if (newBalance - amount < 0) {
            throw new InsufficientAmountException("Insufficient Amount");
        } else {
            newBalance -= amount;
        }
        Account account = getAccount(cardNumber, name);
        account.setAmount(newBalance);
    }

    @Transactional
    public double buyItemsTransaction(String cardNumber, String name, double amount
    , String ownerCardNumber, String ownerName) {
        withdraw(cardNumber, name, amount);
        deposit(ownerCardNumber, ownerName, amount);
        return amount;
    }

    public boolean accountExistsByCardNumberAndName(String cardNumber, String name) {
        return accountDao.existsByCardNumberAndName(cardNumber, name);
    }

    public Account accountCreate(String name, double amount) {
        Account account = new Account();
        account.setName(name);
        account.setAmount(amount);
        account.setCardNumber(generateRandomNumber());
        return accountDao.save(account);
    }

    public String generateRandomNumber() {
        int desiredDigit = 7;
        return RandomStringUtils.randomNumeric(desiredDigit);
    }
}
