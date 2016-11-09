package com.car.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.ironrhino.core.metadata.NotInCopy;
import org.ironrhino.core.metadata.UiConfig;
import org.ironrhino.core.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

//@Searchable
//@AutoConfig
//@javax.persistence.Entity
//@Table(name = "delivery_resume")
public class DeliveryResume extends BaseEntity {

    private static final long serialVersionUID = -2813198005704327613L;

    @NotInCopy
    @JoinColumn(name = "jobsId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.LAZY)
    private Jobs jobs;

    @JoinColumn(name = "trainerId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.LAZY)
    private OldTrainer oldTrainer;

    @JoinColumn(name = "autobotsId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.LAZY)
    private Autobots autobots;

    @UiConfig(hidden = true)
    @Column(updatable = false)
    private Date createDate = new Date();

    @JsonIgnore
    private boolean enabled = true;

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public OldTrainer getOldTrainer() {
        return oldTrainer;
    }

    public void setOldTrainer(OldTrainer oldTrainer) {
        this.oldTrainer = oldTrainer;
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
