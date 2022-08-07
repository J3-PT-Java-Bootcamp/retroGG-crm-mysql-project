package com.example.crmmysqlproject.crm.application.Opportunity.CloseWonOpportunity;

import com.example.crmmysqlproject.crm.application.Opportunity.FindOpportunity.FindOpportunity;
import com.example.crmmysqlproject.crm.application.Shared.UUIDRequest;
import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityNotFoundException;
import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityRepository;

public final class CloseWonOpportunity {
    private final OpportunityRepository opportunityRepository;
    private final FindOpportunity findOpportunity;

    public CloseWonOpportunity(OpportunityRepository opportunityRepository, FindOpportunity findOpportunity) {
        this.opportunityRepository = opportunityRepository;
        this.findOpportunity = findOpportunity;
    }

    public void run(UUIDRequest request) throws OpportunityNotFoundException {
        var opportunity = this.findOpportunity.run(request.id());
        opportunity.closeWon();
        opportunity.addNote(request.note());
        this.opportunityRepository.save(opportunity);
    }
}
