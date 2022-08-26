package com.example.crmmysqlproject.crm.application.Service;

import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityRepository;
import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityStatus;
import com.example.crmmysqlproject.crm.domain.Opportunity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class ReportService {

        private final OpportunityRepository opportunityRepository;

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

