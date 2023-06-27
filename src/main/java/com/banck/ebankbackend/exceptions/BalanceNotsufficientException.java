package com.banck.ebankbackend.exceptions;

public class BalanceNotsufficientException extends Exception {
    public BalanceNotsufficientException(String message) {
        super(message);
    }
}
