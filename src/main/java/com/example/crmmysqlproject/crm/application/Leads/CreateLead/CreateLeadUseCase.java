package com.example.crmmysqlproject.crm.application.Leads.CreateLead;

import com.example.crmmysqlproject.crm.domain.Lead.Lead;
import com.example.crmmysqlproject.crm.domain.Lead.LeadRepository;
import com.example.crmmysqlproject.crm.domain.Sales.SalesRepNotFoundException;
import com.example.crmmysqlproject.crm.domain.Sales.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class CreateLeadUseCase {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private SalesRepRepository salesRepRepository;

    public void run(CreateLeadRequest request) throws SalesRepNotFoundException {
        var salesRep = this.salesRepRepository.findById(request.salesRepId()).orElseThrow(() -> new SalesRepNotFoundException(request.salesRepId()));
        var lead = new Lead(request.name(), request.phoneNumber(), request.email(), request.company(), salesRep);
        this.leadRepository.save(lead);
    }
}
