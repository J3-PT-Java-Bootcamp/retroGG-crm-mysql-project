package com.example.crmmysqlproject.crm.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
   //  @Override
   // Object save(Account account);
}
