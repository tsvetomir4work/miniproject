package com.saproject.project.entity;

import com.saproject.project.entity.Action;
import com.saproject.project.entity.Condition;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "subscriptions", cascade = {CascadeType.ALL})
    List<Action> actions;
    @ManyToMany(mappedBy = "subscriptions", cascade = {CascadeType.ALL})
    List<Condition> conditions;

    public Subscription(){
        //default
    }

    public Subscription(long id, String name, List<Action> actions, List<Condition> conditions) {
        this.id = id;
        this.name = name;
        this.actions = actions;
        this.conditions = conditions;
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

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}
