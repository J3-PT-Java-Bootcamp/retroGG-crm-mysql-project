package com.example.crmmysqlproject.crm.application.SalesRep.reporting;

import com.example.crmmysqlproject.crm.domain.Lead.LeadRepository;
import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityRepository;
import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityStatus;
import com.example.crmmysqlproject.crm.domain.Opportunity.ProductType;
import com.example.crmmysqlproject.crm.domain.Sales.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private SalesRepRepository salesRepRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    public List<Object[]> listLeadsBySalesRep() {
        return this.salesRepRepository.leadsBySalesRep();
    }

    public List<Object[]> opportunitiesBySalesRep() {
        return this.opportunityRepository.opportunitiesBySalesRep();
    }

    public List<Object[]> closedWonOpportunitiesBySalesRep() {
        return this.opportunityRepository.opportunitiesBySalesRep(OpportunityStatus.CLOSED_WON);
    }

    public List<Object[]> closedLostOpportunitiesBySalesRep() {
        return this.opportunityRepository.opportunitiesBySalesRep(OpportunityStatus.CLOSED_LOST);
    }

    public List<Object[]> openOpportunitiesBySalesRep() {
        return this.opportunityRepository.opportunitiesBySalesRep(OpportunityStatus.OPEN);
    }

    public ReportService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public Integer getCountByProduct(ProductType productType) {
        return opportunityRepository.findAllByProduct(productType).size();
    }

    public Integer getCountByProductAndStatus(ProductType productType, OpportunityStatus status) {
        return opportunityRepository.findAllByProductAndStatus(productType, status).size();
    }
}