package com.saproject.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "condition")
public class Condition {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "predicate")
    private boolean predicate;
    @Column(name = "value")
    private String value;
    @JsonBackReference
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "subscription_condition",
            joinColumns = @JoinColumn(name = "condition_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id"))
    private List<Subscription> subscriptions;

    public Condition()
    {
        //default
    }

    public Condition(long id, String name, boolean predicate, String value, List<Subscription> subscriptions) {
        this.id = id;
        this.name = name;
        this.predicate = predicate;
        this.value = value;
        this.subscriptions = subscriptions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPredicate() {
        return predicate;
    }

    public void setPredicate(boolean predicate) {
        this.predicate = predicate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}