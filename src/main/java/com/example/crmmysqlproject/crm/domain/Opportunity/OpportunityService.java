package com.example.crmmysqlproject.crm.domain.Opportunity;

import java.util.List;

public interface OpportunityService {
    List<Opportunity> findAll();

    List<Opportunity> findAllByStatus(String status);

}
