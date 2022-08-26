package com.example.crmmysqlproject.crm.domain.Opportunity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OpportunityController {

    @Autowired
    private OpportunityService opportunityService;

    @GetMapping("/reportOpportunityByCountry")
    public List<Opportunity> getAllOpportunities() {
        return opportunityService.findAll();
    }

    @GetMapping("/reportCLOSED-WONByCountry")
    public List<Opportunity> getAllCLOSEDWONOpportunities() {
        return opportunityService.findAllByStatus("CLOSED-WON");
    }

    @GetMapping("/reportCLOSED-LOSTByCountry")
    public List<Opportunity> getAllCLOSEDLOSTOpportunities() {
        return opportunityService.findAllByStatus("CLOSED-LOST");
    }

    @GetMapping("/reportOPENByCountry")
    public List<Opportunity> getAllOPENOpportunities() {
        return opportunityService.findAllByStatus("OPEN");
    }
}

