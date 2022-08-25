package com.example.crmmysqlproject.crm.domain.Opportunity;

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

    private Opportunity(UUID id, Contact decisionMaker, int quantity, ProductType productType, OpportunityStatus status) {
        this.id = id;
        System.out.println(this.id);
        this.decisionMaker = decisionMaker;
        this.quantity = quantity;
        this.productType = productType;
        this.status = status;
    }

    public static Opportunity create(Contact decisionMaker, int quantity, ProductType productType) {
        return new Opportunity(UUID.randomUUID(), decisionMaker, quantity, productType, OpportunityStatus.OPEN);
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
