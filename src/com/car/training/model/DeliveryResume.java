package com.car.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.NotInCopy;
import org.ironrhino.core.metadata.UiConfig;
import org.ironrhino.core.model.BaseEntity;
import org.ironrhino.core.search.elasticsearch.annotations.Searchable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Searchable
@AutoConfig
@javax.persistence.Entity
@Table(name = "delivery_resume")
public class DeliveryResume extends BaseEntity {

	private static final long serialVersionUID = -2813198005704327613L;

	@NotInCopy
	@JoinColumn(name = "jobsId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT) )
	@ManyToOne(fetch = FetchType.LAZY)
	private Jobs	jobs;
	
	@JoinColumn(name = "trainerId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT) )
	@ManyToOne(fetch = FetchType.LAZY)
	private Trainer	trainer;
	
	@JoinColumn(name = "autobotsId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT) )
	@ManyToOne(fetch = FetchType.LAZY)
	private Autobots	 autobots;
	
	@UiConfig(hidden = true)
	@Column(updatable = false) 
	private Date createDate = new Date();
	
	@JsonIgnore
	private boolean enabed = true;

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

	public boolean isEnabed() {
		return enabed;
	}

	public void setEnabed(boolean enabed) {
		this.enabed = enabed;
	}
}
