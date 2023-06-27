package com.banck.ebankbackend.dtos;

import com.banck.ebankbackend.entities.AccountOperation;
import com.banck.ebankbackend.entities.Customer;
import com.banck.ebankbackend.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
public class SavingBankAccountDTO extends BankAccountDto {
    private  String id;
    private double balance;
    private Date creatdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
}
