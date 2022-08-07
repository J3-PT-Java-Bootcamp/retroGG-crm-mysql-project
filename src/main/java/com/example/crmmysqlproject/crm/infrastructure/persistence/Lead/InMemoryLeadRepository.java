package com.example.crmmysqlproject.crm.infrastructure.persistence.Lead;

import com.example.crmmysqlproject.crm.domain.Lead.Lead;
import com.example.crmmysqlproject.crm.domain.Lead.LeadRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryLeadRepository implements LeadRepository {

    private final Map<Integer, Lead> leads;

    public InMemoryLeadRepository() {
        this.leads = new HashMap<>();
    }

    @Override
    public void save(Lead lead) {
        this.leads.put(lead.getId(), lead);
    }

    @Override
    public void remove(Lead lead) {
        this.leads.remove(lead.getId());
    }

    @Override
    public Optional<Lead> findById(Integer id) {
        return Optional.ofNullable(this.leads.get(id));
    }

    @Override
    public ArrayList<Lead> findAll() {
        return new ArrayList<>(this.leads.values());
    }
}
