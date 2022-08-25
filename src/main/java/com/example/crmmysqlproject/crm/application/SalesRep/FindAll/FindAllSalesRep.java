package com.example.crmmysqlproject.crm.application.SalesRep.FindAll;

import com.example.crmmysqlproject.crm.domain.Sales.SalesRep;
import com.example.crmmysqlproject.crm.domain.Sales.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllSalesRep {
    @Autowired
    private SalesRepRepository repository;

    public List<SalesRep> run() {
        return this.repository.findAll();
    }
}
