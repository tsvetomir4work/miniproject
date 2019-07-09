package com.saproject.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "action")
public class Action {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    public enum actionType {
       email,
        slack,
        mongodb
    }
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private actionType type;
    @Column(name = "description")
    private String description;
    @Column(name = "attribute")
    private String attribute;
    @JsonBackReference
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "subscription_action",
            joinColumns = @JoinColumn(name = "action_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id"))
    private List<Subscription> subscriptions;

    public Action(){
        //default
    }

    public Action(long id, String name, actionType type, String description, String attribute, List<Subscription> subscriptions) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.attribute = attribute;
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

    public actionType getType() {
        return type;
    }

    public void setType(actionType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
