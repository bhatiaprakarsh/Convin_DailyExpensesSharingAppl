package com.expensesharing.expense_sharing_app.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*@GeneratedValue: indicate that the value of the primary key ko denote kiya h
    GenerationType.IDENTITY auto-increment ke liye use kiya h */
    private Long id;

    private String description;
    private Double totalAmount;
    private String splitMethod;
    private LocalDateTime createdAt;

    @ManyToMany
    private List<User> participants;

    @ElementCollection
    private Map<Long, Double> amountSplit;

    /* Getters and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSplitMethod() {
        return splitMethod;
    }

    public void setSplitMethod(String splitMethod) {
        this.splitMethod = splitMethod;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public Map<Long, Double> getAmountSplit() {
        return amountSplit;
    }

    public void setAmountSplit(Map<Long, Double> amountSplit) {
        this.amountSplit = amountSplit;
    }
}
