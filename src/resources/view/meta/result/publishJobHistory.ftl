<div class="panel panel-default">
  <!-- Default panel contents -->
    <div class="panel-heading">
        职位列表
        <button class="btn btn-primary right" data-toggle="modal" data-target="#newJob">发布新职位</button>
        <div class="clear"></div>
      </div>
    <#if jobList?? >
    <table class="table table-hover">
        <tr>
            <th>职位名称</th>
            <th>所属部门</th>
            <th>工作地点</th>
            <th>发布日期</th>
            <th>申请纪录</th>
            <#--<th>操作</th>-->
        </tr>
        <#list jobList as job>
        <tr>
            <td><#if job.title??><a href="/website/jobDetail?jobId=${job.id}" <#if job.type=='TRAINER'>onclick="setLocation(2)"<#else>onclick="setLocation(4)"</#if>>
                ${job.title}</a><#else>无</#if></td>
            <td><#if job.department??>${job.department}<#else>无</#if></td>
            <td><#if job.region ?? && job.region.fullname??>${job.region.fullname}<#else>无</#if></td>
            <td><#if job.createDate??>${job.createDate}<#else>无</#if></td>
            <#if jobApplyMap?? && jobApplyMap.get(job)??>
            <td>
                <#list jobApplyMap.get(job) as apply>
                  <#if apply?? && apply.trainer??>
                  <a href="/website/trainerDetail?trainerId=${apply.trainer.id}" onclick="setLocation(1)"><span>${apply.trainer.personInfo.name}</span></a>
                  <#elseif apply?? && apply.autobot??>
                  <a href="/website/autobotDetail?autobotId=${apply.autobot.id}" onclick="setLocation(3)"><span>${apply.autobot.personInfo.name}</span></a>
                  </#if>
                </#list>
            </td>
            </#if>
            <#--<td>-->
                <#--<i class="iconfont" title="作废">&#xe69d;</i>-->
            <#--</td>-->
        </tr>
        </#list>
    </table>
    </#if> 
</div>

<div class="modal fade" id="newJob" tabindex="-1" role="dialog" aria-labelledby="myModelLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">发布新职位</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form" id="newJobForm">
                        <div class="form-group">
                            <label for="inputTitle" class="col-sm-2 control-label">职位名称</label>
                            <div class="col-sm-10">
                              <input type="text" class="form-control" id="inputTitle" name="title" value="" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEducationRequired" class="col-sm-2 control-label">学历要求</label>
                            <div class="col-sm-10">
                                <input type="hidden" name="educationRequirement" value="初中"/>
                                <select class="form-control" id="inputEducationRequired">
                                    <option value="初中">初中</option>
                                    <option value="高中">高中</option>
                                    <option value="大学">大学</option>
                                    <option value="研究生">研究生</option>
                                    <option value="博士">博士</option>
                                    <option value="博士后">博士后</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputExperienceRequirement" class="col-sm-2 control-label">经验要求</label>
                            <div class="col-sm-10">
                              <input type="text" class="form-control" name="workExperienceRequirement" value="" id="inputExperienceRequirement" placeholder="请输入数字"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputAddress" class="col-sm-2 control-label">工作地点</label>
                            <div class="col-sm-10">
                                <div class="dropdown" id="province">
                                    <button class="btn btn-default dropdown-toggle" type="button"
                                            id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                                            aria-expanded="true">
                                    <#if userRegion?? >${userRegion.parent.name}<#else>请选择省</#if>
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <#list provinces as t>
                                        <li><a onclick="selectCities(this, false)" value="${t.id!}">${t.name!}</a></li>
                                    </#list>
                                    </ul>
                                </div>
                                <div class="dropdown" id="city">
                                    <button class="btn btn-default dropdown-toggle" type="button"
                                            id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                                            aria-expanded="true">
                                    <#if userRegion?? >${userRegion.name}<#else>请选择市</#if>
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                        <#if cities??>
                                    <#list cities as city>
                                        <li><a onclick="selectCity(this);" value="${city.id!}">${city.name!}</a></li>
                                    </#list>
                                        </#if>
                                    </ul>
                                </div>
                                <input name="regionId" type="hidden" value="<#if userRegion?? >${userRegion.id}<#else>${1}</#if>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputSalary" class="col-sm-2 control-label">工作待遇</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="salary" value="" id="inputSalary" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputJobDescription" class="col-sm-2 control-label">岗位介绍</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" rows="4" name="jobDescription" value="" id="inputJobDescription" placeholder=""></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputRequirement" class="col-sm-2 control-label">岗位要求</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" rows="4" name="jobRequirement" value="" id="inputRequirement" placeholder=""></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                          <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-primary" onclick="addNewJob(event)">发布</button>
                          </div>
                        </div>
                    </form>
                </div>
                <!-- <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" id="save_btn" class="btn btn-primary" onclick="save()">保存</button>
                </div> -->
            </div>
        </div>
   
</div>

