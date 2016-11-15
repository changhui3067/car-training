<div class="jobList pxxq">
<#if jobList??>
	<ul>
		<#list jobList as t>
			<li class="zp_box">
				<#if t??>
					<div class="qz"></div>
					<div class="left zp_box_l">
						<a href="/website/jobDetail?jobId=${t.id!}">
							<div class="zw_name">${t.title!}</div>
						</a>
						<div class="dy_box">
                        	<span class="cn" style="padding-left:0px;">${t.salary!}元</span>
                        	<span>${t.workExperienceRequirement!}年工作经验</span>
                        	<span style="background:none;"><#if t.region??>${t.region.fullname!}</#if></span>
                    	</div>
                    	<div class="fb_box">
                        	<span  style="padding-left:0px;">发布于: <#if t.createDate??>${t.createDate!?string("yyyy-MM-dd")}</#if></span>
                            <span style="background:none;">投递后：48小时反馈</span>
                    	</div>
					</div>
					<div class="right zp_box_r">
                    <div class="qy">
                        <#if t.company??>
                         <a href="/website/companyDetail?companyId=${t.company.id!}">
                             <div class="qy_l left zp_box_r_l"><img src="${t.company.logo!}"/></div>
                             <div class="qy_r right zp_box_r_r">
                                 <div class="qy_name">
                                     <span>${t.company.name!}</span>
                                     <span>已有9人担保</span>
                                 </div>
                                 <div class="jyfw">${t.company.industry!}</div>
                                 <div class="fl">
                                     <#if t.welfare??>
                                         <#list trainerJob.welfare as w><span>${w!}</span></#list>
                                     </#if>
                                 </div>
                             </div>
                         </a>
                         </#if>
                         <div class="clear"></div>
                    </div>
                    </div>
                    <div class="clear"></div>
				</#if>
			</li>
		</#list>
	</ul>
</#if>
</div>