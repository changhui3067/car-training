 package com.car.training.action.backend;

 import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.training.domain.Jobs;
import com.car.training.service.JobsService;

@AutoConfig
public class CompanyJobManageAction extends BaseAction {

	private static final long serialVersionUID = 4839883380537115435L;

	@Autowired
	private JobsService jobsService;
	/**简历投递记录列表 */
	private ResultPage<Jobs> jobsList;
	/** 页大小 */
	private Integer pageSize = 10;
	/** 页号 */
	private Integer pageNo = 1;
	
	@Override
	public String execute() throws Exception {
		jobsList = jobsService.findPageByJobs(new Jobs(), pageSize, pageNo);
		return SUCCESS;
	}

	public ResultPage<Jobs> getJobsList() {
		return jobsList;
	}

	public void setJobsList(ResultPage<Jobs> jobsList) {
		this.jobsList = jobsList;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
}
