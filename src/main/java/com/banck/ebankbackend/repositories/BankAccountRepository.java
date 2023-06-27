package com.banck.ebankbackend.repositories;

import com.banck.ebankbackend.entities.BankAccount;
import com.banck.ebankbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
