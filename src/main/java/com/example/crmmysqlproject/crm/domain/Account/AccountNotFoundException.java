package com.example.crmmysqlproject.crm.domain.Account;

import java.util.UUID;

public class AccountNotFoundException extends Exception{

    public AccountNotFoundException(UUID id){super(String.format("Opportunity with id: %s not found", id));}
}
