package com.example.crmmysqlproject.crm.domain.Account;

import com.example.crmmysqlproject.crm.domain.Opportunity.Contact;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "accounts")
public class Account {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String name;

    @Column
    private Industry industry;

    @Column
    private int employeeCount;

    @Column
    private String city;

    @Column
    private String country;

    @OneToMany(mappedBy = "account")
    private List<Contact> contacts;


    private Account(UUID id, String name, Industry industry, int employeeCount, String city, String country, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contacts = contacts;
    }

    public static Account create(String name, Industry industry, int employeeCount, String city, String country) {
        return new Account(UUID.randomUUID(), name, industry, employeeCount, city, country, new ArrayList<>());
    }

}
