package org.example.paymentgateway.util;

import org.example.paymentgateway.dto.AccountDto;
import org.example.paymentgateway.entity.Account;
import org.springframework.beans.BeanUtils;

public class EntityUtil {

    public static Account toEntityAccount(AccountDto accountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        return account;
    }

    public static AccountDto toDtoAccount(Account account) {
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(account, accountDto);
        return accountDto;
    }
}
