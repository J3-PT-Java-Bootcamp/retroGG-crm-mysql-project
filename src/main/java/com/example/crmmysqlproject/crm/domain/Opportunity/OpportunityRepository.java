package com.example.crmmysqlproject.crm.domain.Opportunity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, UUID> {

    @Query("SELECT s.name, size(s.opportunities) FROM Opportunity o INNER JOIN SalesRep s ON o.salesRep.id = s.id GROUP BY s.id")
    List<Object[]> opportunitiesBySalesRep();

    @Query("SELECT s.name, count(o.id) FROM Opportunity o INNER JOIN SalesRep s ON o.salesRep.id = s.id WHERE o.status = :status GROUP BY s.id")
    List<Object[]> opportunitiesBySalesRep(@Param("status") OpportunityStatus status);

}
