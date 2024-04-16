package com.java.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "toy_category")
    private String category;
    @Column(name = "toy_name")
    private String name;
    @Column(name = "toy_price")
    private int price;
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Toydetails toyDetails;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<transaction> transactions;

    public User(int id, String category, String name, int price, Toydetails toyDetails,
            List<transaction> transactions) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.toyDetails = toyDetails;
        this.transactions = transactions;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Toydetails getToyDetails() {
        return toyDetails;
    }

    public void setToyDetails(Toydetails toyDetails) {
        this.toyDetails = toyDetails;
    }

    public List<transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<transaction> transactions) {
        this.transactions = transactions;
    }
}

    



   