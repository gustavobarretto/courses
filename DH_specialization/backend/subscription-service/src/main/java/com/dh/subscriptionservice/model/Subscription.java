package com.dh.subscriptionservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name="plan_id", nullable=false)
    private Plan plan;
    @Column(nullable = false)
    private Integer userId;

    public Subscription() {
    }

    public Subscription(Integer id, Date startDate, Date endDate, Plan plan) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = plan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
