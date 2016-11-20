package com.car.training.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bill on 11/19/2016.
 */
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"job_id","loginUser_id"}))
@Entity
public class Apply {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne()
    private Job job;

//    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    @ManyToOne()
//    private LoginUser loginUser;

    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne()
    private Trainer trainer;

    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne()
    private Autobot autobot;

    @Column
    private Date applyTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

//    public LoginUser getLoginUser() {
//        return loginUser;
//    }
//
//    public void setLoginUser(LoginUser loginUser) {
//        this.loginUser = loginUser;
//    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Autobot getAutobot() {
        return autobot;
    }

    public void setAutobot(Autobot autobot) {
        this.autobot = autobot;
    }
}
