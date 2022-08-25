package com.example.crmmysqlproject.crm.application.Leads.CreateLead;

import com.example.crmmysqlproject.crm.domain.Lead.Lead;
import com.example.crmmysqlproject.crm.domain.Lead.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class CreateLeadUseCase {

    @Autowired
    private LeadRepository leadRepository;

    public void run(CreateLeadRequest request) {
        var lead = new Lead(request.name(), request.phoneNumber(), request.email(), request.company());
        this.leadRepository.save(lead);
    }
}
