package com.example.crmmysqlproject.crm.application.Leads.ConvertLeadToOpportunity;

import com.example.crmmysqlproject.crm.domain.Account.Industry;
import com.example.crmmysqlproject.crm.domain.Opportunity.ProductType;
import crm.domain.Account.Industry;
import crm.domain.Opportunity.ProductType;

public record ConvertLeadToOpportunityRequest(
        Integer leadId,
        ProductType productType,
        Integer quantity,
        Industry companyIndustry,
        Integer numberOfEmployees,
        String companyCity,
        String companyCountry
) {
}
