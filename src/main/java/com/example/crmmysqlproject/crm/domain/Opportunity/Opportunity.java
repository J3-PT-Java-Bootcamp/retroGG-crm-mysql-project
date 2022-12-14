package com.example.crmmysqlproject.crm.domain.Opportunity;

import com.example.crmmysqlproject.crm.domain.Sales.SalesRep;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "opportunities")
public class Opportunity {
    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private int quantity;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column
    @Enumerated(EnumType.STRING)
    private OpportunityStatus status;

    @ManyToOne
    @JoinColumn(name = "decision_maker_id")
    private Contact decisionMaker;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    private Opportunity(UUID id, Contact decisionMaker, int quantity, ProductType productType, OpportunityStatus status, SalesRep salesRep) {
        this.id = id;
        System.out.println(this.id);
        this.decisionMaker = decisionMaker;
        this.quantity = quantity;
        this.productType = productType;
        this.status = status;
        this.salesRep = salesRep;
    }

    public static Opportunity create(Contact decisionMaker, int quantity, ProductType productType, SalesRep salesRep) {
        return new Opportunity(UUID.randomUUID(), decisionMaker, quantity, productType, OpportunityStatus.OPEN, salesRep);
    }

    public void closeLost() {
        this.status = OpportunityStatus.CLOSED_LOST;
    }

    public void closeWon() {
        this.status = OpportunityStatus.CLOSED_WON;
    }

    @Override
    public String toString() {
        return "OPPORTUNITY{" +
                "id=" + id +
                ", decisionMaker=" + decisionMaker +
                ", quantity=" + quantity +
                ", productType=" + productType +
                ", status=" + status +
                '}';
    }


}
