package com.example.crmmysqlproject.crm.application.Opportunity.FindOpportunity;

import com.example.crmmysqlproject.crm.domain.Opportunity.Opportunity;
import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityNotFoundException;
import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class FindOpportunity {

    @Autowired
    private OpportunityRepository opportunityRepository;

    public Opportunity run(UUID id) throws OpportunityNotFoundException {
        var opportunity = this.opportunityRepository.findById(id);
        if (opportunity.isEmpty()) {
            throw new OpportunityNotFoundException(id);
        }
        return opportunity.get();
    }
}
