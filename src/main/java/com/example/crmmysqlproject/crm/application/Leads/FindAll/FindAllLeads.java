package com.example.crmmysqlproject.crm.application.Leads.FindAll;

import com.example.crmmysqlproject.crm.domain.Lead.Lead;
import com.example.crmmysqlproject.crm.domain.Lead.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class FindAllLeads {

    @Autowired
    private LeadRepository leadRepository;

    public List<Lead> run() {
        return this.leadRepository.findAll();
    }
}
