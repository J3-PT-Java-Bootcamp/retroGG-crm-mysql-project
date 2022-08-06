package com.example.crmmysqlproject.crm.application.Leads.FindAll;

import com.example.crmmysqlproject.crm.domain.Lead.Lead;
import com.example.crmmysqlproject.crm.domain.Lead.LeadRepository;
import crm.domain.Lead.Lead;
import crm.domain.Lead.LeadRepository;

import java.util.ArrayList;

public final class FindAllLeads {
    private final LeadRepository leadRepository;

    public FindAllLeads(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public ArrayList<Lead> run() {
        return this.leadRepository.findAll();
    }
}
