 package com.car.training.action.backend;

 import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.service.EntityManager;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.training.domain.Trainer;
import com.car.training.domain.UserCenter;
import com.car.training.service.TrainerService;

@AutoConfig
public class TrainerCompleteResumeAction extends BaseAction {

	private static final long serialVersionUID = 4839883380537115435L;

	@Autowired
	private TrainerService trainerService;
	@Autowired
	private transient EntityManager<Region> entityManager;

	/** 培训师 */
	private Trainer  trainer;
	
	private List<Region> provinces;
	
	private List<Region> cities;
	
	private Object data;
	
	private Long parentId;
	
	
	public List<Region> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Region> provinces) {
		this.provinces = provinces;
	}

	public List<Region> getCities() {
		return cities;
	}

	public void setCities(List<Region> cities) {
		this.cities = cities;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		UserCenter uc = new UserCenter();
		uc = (UserCenter) request.getSession().getAttribute("userDetails");
		if (uc != null) {
			trainer = trainerService.findByUserCenter(uc.getId());
		}
		
		entityManager.setEntityClass(Region.class);
		DetachedCriteria dc = entityManager.detachedCriteria();
		dc.add(Restrictions.isNull("parent"));
		dc.addOrder(Order.asc("displayOrder"));
		dc.addOrder(Order.asc("name"));
		provinces = entityManager.findListByCriteria(dc);
		return SUCCESS;
	}
	
	@JsonConfig(root = "data")
	public String getcities(){
		Map<String,Object> map = new HashMap<>();
		Region region = new Region();
		entityManager.setEntityClass(Region.class);
		if (parentId != null && parentId > 0) {
			region = entityManager.get(parentId);
		} else {
			DetachedCriteria dc = entityManager.detachedCriteria();
			dc.add(Restrictions.isNull("parent"));
			dc.addOrder(Order.asc("displayOrder"));
			dc.addOrder(Order.asc("name"));
			region.setChildren(entityManager.findListByCriteria(dc));
		}
		cities = (List<Region>) region.getChildren();
		map.put("code", "200");
		map.put("cities", cities);
		setData(map);
		return JSON;
	}
	
	@JsonConfig(root = "data")
	public String save() throws Exception{
		if(trainer != null){
			trainerService.save(trainer);
		}
		Map<String,Object> map = new HashMap<>();
		map.put("code", "200");
		map.put("msg", "保存成功");
		data = map;
		return JSON;
	}


	public Trainer getTrainer() {
		return trainer;
	}


	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
