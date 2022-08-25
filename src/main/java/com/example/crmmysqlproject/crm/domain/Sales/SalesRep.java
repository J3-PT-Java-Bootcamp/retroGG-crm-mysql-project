package com.example.crmmysqlproject.crm.domain.Sales;

import com.example.crmmysqlproject.crm.domain.Lead.Lead;
import com.example.crmmysqlproject.crm.domain.Opportunity.Opportunity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales_rep")
public class SalesRep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "salesRep")
    private List<Opportunity> opportunities;

    @OneToMany(mappedBy = "salesRep")
    private List<Lead> leads;

    public SalesRep(String name) {
        this.name = name;
    }
}
