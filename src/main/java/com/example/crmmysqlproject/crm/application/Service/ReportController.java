package com.example.crmmysqlproject.crm.application.Service;

import com.example.crmmysqlproject.crm.domain.Opportunity.OpportunityStatus;
import com.example.crmmysqlproject.crm.domain.Opportunity.ProductType;
import com.example.crmmysqlproject.crm.domain.Opportunity.ProductTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report/opportunity/{product}")
    public Integer getOpportunityCountByProduct(@PathVariable String product) throws ProductTypeNotFoundException {
        ProductType productType = ProductType.fromString(product);
        return reportService.getCountByProduct(productType);
    }

    @GetMapping("/report/opportunity/{product}/status/{status}")
    public Integer getOpportunityCountByProductAndStatus(@PathVariable String product, @PathVariable String status) throws ProductTypeNotFoundException {
        ProductType productType = ProductType.fromString(product);
        OpportunityStatus opportunityStatus = OpportunityStatus.valueOf(status.toUpperCase());
        return reportService.getCountByProductAndStatus(productType, opportunityStatus);
    }
}