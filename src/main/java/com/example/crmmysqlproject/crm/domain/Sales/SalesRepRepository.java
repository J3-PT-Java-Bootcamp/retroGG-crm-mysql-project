package com.example.crmmysqlproject.crm.domain.Sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Integer> {
    @Query("SELECT name, SUM(leads.size) FROM SalesRep GROUP BY id")
    List<Object[]> leadsBySalesRep();
}
