package com.car.training.domain;

import java.io.Serializable;
import java.util.Date;

public class DeliveryResume implements Serializable {

    private static final long serialVersionUID = 555506496775574089L;

    private String id;

    private Jobs jobs;

    private Trainer trainer;

    private Autobots autobots;

    private Date createDate;

    private boolean enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Autobots getAutobots() {
        return autobots;
    }

    public void setAutobots(Autobots autobots) {
        this.autobots = autobots;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
