package com.example.crmmysqlproject.crm.application.SalesRep.Create;

import com.example.crmmysqlproject.crm.domain.Sales.SalesRep;
import com.example.crmmysqlproject.crm.domain.Sales.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSalesRep {

    @Autowired
    private SalesRepRepository repository;

    public void run(CreateSalesRepRequest request) {
        var salesRep = new SalesRep(request.name());
        this.repository.save(salesRep);
    }
}
