从没panydetail<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#escape x as x?html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="/assets/website/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="/assets/website/css/iconfont.css" type="text/css" />
<link rel="stylesheet" href="/assets/website/css/pxshi.css" type="text/css" />
<link rel="stylesheet" href="/assets/website/css/style.css" type="text/css" />
</head>

<body>
<!-- 头部开始 -->	
<#include "/assets/website/common/header.html">
<!-- 头部结束 -->		

<!-- main开始 -->

<div class="zhaopin_qy">
    <div class="content" >
    
    	<#if company??>
    
    	<div class="companyDetailTop" >
        	<div class="companyLogo left">
                <img src="${company.logoUrl!}" />
            </div>
            <div class="companyNameBox left">
                <div>
               	    <h1 class="left">${company.name!}</h1>
                    <div class="right">已有<span id="companyGuarateeNumber">${personList.size()!}</span>人担保</div>
                    <div class="clear"></div>
                </div>
                <div>
                    <#if company.welfare??>
                        <#list company.welfare as w>
                    		<span>${w!}</span>
                        </#list>
                    </#if>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="companyDetailContent">
        	<div class="companyDetailOther left">
            	<div class="company_other_info_box">
                    <div class="company_other_info_bar"><h4>公司简介</h4></div>
                	<div class="company_other_info_text">
    	                 ${company.introduction!}
               	    </div>
                </div>
            	<div class="company_other_info_box">
            	   <div class="company_other_info_bar">
            	       <h4><span>共<#if jobList??>${jobList?size!}<#else>0</#if>个职位</span>招聘职位</h4>
                    </div>
            	   <div class="autoCompany_zp">
                        <#if jobList??>
                        <ul>
                        <#list jobList as t>
                        <li class="zp_box">
                            <div class="left zp_box_l autoCompany_zp_l">
                                <a href="/website/jobDetail?jobId=${t.id!}"> <div class="zw_name">${t.title!}</div></a>
                                <div class="dy_box">
                                    <span class="cn" style="padding-left:0px;">${t.salary!}元</span>
                                    <span>${t.workExperienceRequirement!}年工作经验</span>
                                    <span style="background:none;"><#if t.region.fullname??>${t.region.fullname}</#if></span>
                                </div>
                        
                                <div class="fb_box">
                                    <span  style="padding-left:0px;">发布于：<#if t.publishDate??>${t.publishDate!?string("yyyy-MM-dd")}</#if></span>
                                    <span style="background:none;">投递后：48小时反馈</span>
                                </div>
                            </div>
                            <div class="right zp_box_r autoCompany_zp_r">
                                <button>立即应聘</button>
                            </div>
                            <div class="clear"></div>
                        </li>
                        </#list>
                        </ul>
                        </#if>
                    </div>

                </div>
            </div>
            <div class="companyBasicInfo right">
                <#include "/resources/view/website/companyBasicInfo.ftl">
            </div>
            <div class="clear"></div>
        </div>
        
        </#if>
       
  </div>
</div>
	

<!-- main结束 -->
<#include "/assets/website/common/footer.html">

<script src="/assets/website/js/common.js" type="text/javascript"></script>
</body>
</html>
</#escape>
