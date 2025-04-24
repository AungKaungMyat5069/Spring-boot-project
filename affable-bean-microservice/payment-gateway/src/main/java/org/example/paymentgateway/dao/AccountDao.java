package org.example.paymentgateway.dao;

import org.example.paymentgateway.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountDao extends JpaRepository<Account, Integer> {

    @Query("""
    select a.amount from Account a where a.cardNumber=:cardNumber and a.name=:name
""")
    public double getBalance(@Param("cardNumber") String cardNumber,@Param("name") String name );

    Optional<Account> findByCardNumberAndName(String cardNumber, String name);

    boolean existsByCardNumberAndName(String cardNumber, String name);
}
