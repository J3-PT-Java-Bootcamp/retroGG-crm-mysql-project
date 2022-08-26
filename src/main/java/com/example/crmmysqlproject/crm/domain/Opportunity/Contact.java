package com.example.crmmysqlproject.crm.domain.Opportunity;

import com.example.crmmysqlproject.crm.domain.Account.Account;
import com.example.crmmysqlproject.crm.domain.Lead.Lead;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "contacts")
public class Contact {
    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String phoneNumber;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    private Contact(UUID id, String phoneNumber, String name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }
    public static Contact fromLead(Lead lead) {
        return new Contact(UUID.randomUUID(), lead.getPhoneNumber(), lead.getName());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
