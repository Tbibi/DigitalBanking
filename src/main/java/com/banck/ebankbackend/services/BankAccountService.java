package com.banck.ebankbackend.services;

import com.banck.ebankbackend.dtos.*;
import com.banck.ebankbackend.entities.BankAccount;
import com.banck.ebankbackend.entities.CurrentAccount;
import com.banck.ebankbackend.entities.Customer;
import com.banck.ebankbackend.entities.SavingAccount;
import com.banck.ebankbackend.exceptions.BalanceNotsufficientException;
import com.banck.ebankbackend.exceptions.BankAccountNotFoundException;
import com.banck.ebankbackend.exceptions.CustomerNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface BankAccountService {
    CustomerDTO savecustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId)throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId)throws CustomerNotFoundException;
    List<CustomerDTO>listCustomer();
    BankAccountDto getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId,double amount,String description) throws BankAccountNotFoundException, BalanceNotsufficientException;
    void credit(String accountId,double amount,String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource,String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotsufficientException;

    List<BankAccountDto>bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO>accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
    List<CustomerDTO> searchCustomers(String keyword);
}
