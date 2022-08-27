package com.example.crmmysqlproject.crm.domain.Opportunity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Override
    public List<Opportunity> findAll() {
        return opportunityRepository.findAll();
    }

    @Override
    public List<Opportunity> findAllByStatus(String status) {
        return opportunityRepository.findAllByStatus(status);
    }

}
