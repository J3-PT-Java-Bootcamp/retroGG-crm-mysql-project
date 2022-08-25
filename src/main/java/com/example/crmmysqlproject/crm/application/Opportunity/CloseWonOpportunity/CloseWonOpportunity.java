package com.example.crmmysqlproject.crm.application.Opportunity.CloseWonOpportunity;

import com.example.crmmysqlproject.crm.application.Opportunity.FindOpportunity.FindOpportunity;
import com.example.crmmysqlproject.crm.application.Shared.UUIDRequest;
import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityNotFoundException;
import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class CloseWonOpportunity {

    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private FindOpportunity findOpportunity;

    public void run(UUIDRequest request) throws OpportunityNotFoundException {
        var opportunity = this.findOpportunity.run(request.id());
        opportunity.closeWon();
        this.opportunityRepository.save(opportunity);
    }
}
