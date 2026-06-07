package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;

    public Portfolio(Client client, String name, String description) {
        this.client = client;
        this.name = name;
        this.description = description;
    }

    public Portfolio() {}

    // Getters

    public long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    // Setters (no setter for portfolioId)

    public void setClient(Client client) {
        this.client = client;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
