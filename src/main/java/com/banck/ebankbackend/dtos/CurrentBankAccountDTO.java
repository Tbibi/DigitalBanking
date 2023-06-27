package com.banck.ebankbackend.dtos;

import com.banck.ebankbackend.enums.AccountStatus;
import lombok.Data;

import java.util.Date;


@Data
public class CurrentBankAccountDTO extends BankAccountDto{
    private  String id;
    private double balance;
    private Date creatdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double overDraft;
}
