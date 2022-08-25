package com.example.crmmysqlproject.crm.domain.Sales;

public class SalesRepNotFoundException extends Exception {
    public SalesRepNotFoundException(Integer id) {
        super(String.format("SalesRep with id: %d not found", id));
    }
}
