package com.example.crmmysqlproject.crm.application.Leads.ConvertLeadToOpportunity;

import com.example.crmmysqlproject.crm.domain.Account.Account;
import com.example.crmmysqlproject.crm.domain.Account.AccountRepository;
import com.example.crmmysqlproject.crm.domain.Lead.LeadNotFoundException;
import com.example.crmmysqlproject.crm.domain.Lead.LeadRepository;
import com.example.crmmysqlproject.crm.domain.Opportunity.Contact;
import com.example.crmmysqlproject.crm.domain.Opportunity.ContactRepository;
import com.example.crmmysqlproject.crm.domain.Opportunity.Opportunity;
import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class ConvertLeadToOpportunityUseCase {

    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private ContactRepository contactRepository;

    public void run(ConvertLeadToOpportunityRequest request) throws LeadNotFoundException {
        var lead = this.leadRepository.findById(request.leadId()).orElseThrow(() -> new LeadNotFoundException(request.leadId()));
        var account = Account.create(
                lead.getCompanyName(),
                request.companyIndustry(),
                request.numberOfEmployees(),
                request.companyCity(),
                request.companyCountry()
        );
        var storedAccount = this.accountRepository.save(account);
        var decisionMaker = Contact.fromLead(lead);
        decisionMaker.setAccount(storedAccount);
        var storedContact = this.contactRepository.save(decisionMaker);
        var opportunity = Opportunity.create(
                storedContact,
                request.quantity(),
                request.productType(),
                lead.getSalesRep());
        this.opportunityRepository.save(opportunity);
        this.leadRepository.delete(lead);
    }
}

