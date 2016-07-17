 package com.car.training.action;

 import java.util.List;
import java.util.Set;

import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.training.domain.Trainer;
import com.car.training.service.TrainerService;


@AutoConfig
public class TrainerAction extends BaseAction {

	private static final long serialVersionUID = 4839883380537115435L;

	@Autowired
	private TrainerService trainerService;

	/** 按条件筛选培训师列表 */
	private List<Trainer> trainerList;
	
	/** 业务类型 */
	private Set<String> businessCategories;
	/** 执行类别 */
	private Set<String> executionCategories;
	/**培训经验 */
	private Integer trainingYears;
	/** 关健字 */
	private String keyword;
	
	@Override
	public String execute() throws Exception {
		Trainer trainer = new Trainer();
		trainer.setAutoYears(trainingYears);
		trainer.setBusinessCategory(businessCategories);
		trainer.setExecutionCategory(executionCategories);
		trainer.setCurrentPosition(keyword);
		//按条件筛选培训师列表(包含分页)
		trainerList = trainerService.findListByTrainer(trainer);
		
		return SUCCESS;
	}
	
	public List<Trainer> getTrainerList() {
		return trainerList;
	}

	public Set<String> getBusinessCategories() {
		return businessCategories;
	}

	public void setBusinessCategories(Set<String> businessCategories) {
		this.businessCategories = businessCategories;
	}

	public Set<String> getExecutionCategories() {
		return executionCategories;
	}

	public void setExecutionCategories(Set<String> executionCategories) {
		this.executionCategories = executionCategories;
	}

	public Integer getTrainingYears() {
		return trainingYears;
	}

	public void setTrainingYears(Integer trainingYears) {
		this.trainingYears = trainingYears;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
