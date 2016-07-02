package com.car.training.domain;

import java.io.Serializable;
import java.util.Date;

public class Autobots implements Serializable{
	
	private static final long serialVersionUID = 4029227868768483061L;

	/**系统Id**/
	private String id;
	
	/**用户编号外键UserCenter**/
	private String uid;
	
	/**当前职位**/
	private String currentPosition;  
	
	/**关注培训师**/
	private String attentionTrainer;
	
	/**公司发起的橄榄枝**/
	private String olives;
	
	/**汽车经验**/
	private Integer autoYears;
	
	/**是否认证**/
	private boolean authFaithed;
	
	/**工作照片1**/
	private String workPhotoURL1;
	
	/**工作照片2**/
	private String workPhotoURL2;
	
	/**创建日期**/
	private Date createDate;
	
	/**修改日期**/
	private Date modifyDate;
	
	/**创建用户**/
	private String createUser;

	/**修改用户**/
	private String modifyUser;
	
	/**是否启用**/
	private boolean enabed;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Integer getAutoYears() {
		return autoYears;
	}

	public void setAutoYears(Integer autoYears) {
		this.autoYears = autoYears;
	}

	public boolean isAuthFaithed() {
		return authFaithed;
	}

	public void setAuthFaithed(boolean authFaithed) {
		this.authFaithed = authFaithed;
	}

	public String getWorkPhotoURL1() {
		return workPhotoURL1;
	}

	public void setWorkPhotoURL1(String workPhotoURL1) {
		this.workPhotoURL1 = workPhotoURL1;
	}

	public String getWorkPhotoURL2() {
		return workPhotoURL2;
	}

	public void setWorkPhotoURL2(String workPhotoURL2) {
		this.workPhotoURL2 = workPhotoURL2;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public boolean isEnabed() {
		return enabed;
	}

	public void setEnabed(boolean enabed) {
		this.enabed = enabed;
	}

	public String getAttentionTrainer() {
		return attentionTrainer;
	}

	public void setAttentionTrainer(String attentionTrainer) {
		this.attentionTrainer = attentionTrainer;
	}

	public String getOlives() {
		return olives;
	}

	public void setOlives(String olives) {
		this.olives = olives;
	}
}
