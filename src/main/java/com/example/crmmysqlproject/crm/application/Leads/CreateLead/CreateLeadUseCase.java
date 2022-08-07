package com.example.crmmysqlproject.crm.application.Leads.CreateLead;

import com.example.crmmysqlproject.crm.domain.Lead.Lead;
import com.example.crmmysqlproject.crm.domain.Lead.LeadRepository;

public final class CreateLeadUseCase {

    private final LeadRepository leadRepository;

    public CreateLeadUseCase(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public void run(CreateLeadRequest request) {
        var lead = new Lead(request.name(), request.phoneNumber(), request.email(), request.company());
        this.leadRepository.save(lead);
    }
}
