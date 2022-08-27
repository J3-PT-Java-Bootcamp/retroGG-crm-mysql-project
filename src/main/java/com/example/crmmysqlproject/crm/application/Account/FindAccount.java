package com.example.crmmysqlproject.crm.application.Account;

import com.example.crmmysqlproject.crm.domain.Account.Account;
import com.example.crmmysqlproject.crm.domain.Account.AccountNotFoundException;
import com.example.crmmysqlproject.crm.domain.Account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class FindAccount {

    @Autowired
    private AccountRepository accountRepository;

    public Account run(UUID id) throws AccountNotFoundException{
        var account = this.accountRepository.findById(id);
        if (account.isEmpty()){
            throw new AccountNotFoundException(id);
        }
        return account.get();
    }
}
