package com.banck.ebankbackend.services;

import com.banck.ebankbackend.entities.BankAccount;
import com.banck.ebankbackend.entities.CurrentAccount;
import com.banck.ebankbackend.entities.SavingAccount;
import com.banck.ebankbackend.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount=bankAccountRepository.findById("487966cf-cfe5-4383-8bfa-c786818d45ee").orElse(null);
        if (bankAccount!=null) {
            System.out.println("*********************************************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatdAt());
            System.out.println(bankAccount.getCustomer().getNom());
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over Draft=>" + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate=>" + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(op -> {
                System.out.println("==================================");
                System.out.println(op.getType() + "\t" + op.getOperationDate() + "\t" + op.getAmount());
                System.out.println("+++++++++++++++++++++++++++++");
//                    System.out.println(op.getOperationDate());
//                    System.out.println(op.getAmount());
            });
        }
    }
}
