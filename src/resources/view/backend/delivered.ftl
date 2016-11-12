<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value='/assets/website/backend/css/style.css'/>" type="text/css" media="screen" />
<script src="<@url value="/assets/website/js/jquery-1.8.0.min.js?v=1.1.0"/>"></script>

</head>

<body>
<#include "/assets/website/common/header.html">
	
<!-- main开始 -->
<div class="main">
	<div class="content">
    <div class="dq_box">
    <div class="dqwz left">当前位置 : <a href="#">首 页</a> > <a href="#"><#if '{}' != '${session}' && Session["loginState"]=='Y' && Session["loginType"]=='TRAINER'>培训师管理中心<#else>汽车人管理中心</#if></a> > <a href="#">已申请用户</a></div>
    <div class="wdcf right"><span color="#FF66001"><#if Session?exists && Session["userDetails"].wealthStartDate??> ${Session["userDetails"].wealthStartDate!?string("dd/MM/yyyy")}—${Session["userDetails"].wealthEndDate!?string("dd/MM/yyyy")}</#if></span>我的财富：<font color="#FF66001"><#if Session?exists && Session["userDetails"]??> ${Session["userDetails"].wealth!}</#if></font></div><div class="clear"></div>
    </div>
    <div class="pxshi_gl">
    	<div class="pxshi_gl_l left">
      <#include "/assets/website/backend/common/menu.ftl">

        <div class="pxshi_gl_r right">
        	<#if deliveryResumeList??>
         		<table bgcolor="#dedede" border="0" cellpadding="4" cellspacing="1" align="center" width="860">
                    <tbody>
                      <tr>
                        <td width="200" height="50" align="center" valign="middle" bgcolor="#f0faff"> <strong>企业名称</strong></td>
                        <td width="100" align="center" valign="middle" bgcolor="#f0faff"><strong>职位名称</strong></td>
                        <td width="55" align="center" valign="middle" bgcolor="#f0faff"><strong>姓名</strong></td>
                        <td width="100" align="center" valign="middle" bgcolor="#f0faff"><strong>手机</strong></td>
                        <td width="100" align="center" valign="middle" bgcolor="#f0faff"><strong>邮箱</strong></td>
                        <td width="60" align="center" valign="middle" bgcolor="#f0faff"><strong>申请日期</strong></td>
                      </tr>
					 <#if deliveryResumeList ??>
                      <#list deliveryResumeList as t>
                      <tr>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq"><a href="#">${t.jobs.company.name!} </a></td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">${t.jobs.name!}</a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff"><#if t.trainer?? && t.trainer.userCenter??>${t.trainer.userCenter.name!}</#if><#if t.autobots?? && t.autobots.userCenter??>${t.autobots.userCenter.name!}</#if></td>
                        <td align="center" valign="middle" bgcolor="#ffffff"><#if t.trainer?? && t.trainer.userCenter??>${t.trainer.userCenter.mobile!}</#if><#if t.autobots?? && t.autobots.userCenter??>${t.autobots.userCenter.mobile!}</#if></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff"><#if t.trainer?? && t.trainer.userCenter??>${t.trainer.userCenter.email!}</#if><#if t.autobots?? && t.autobots.userCenter??>${t.autobots.userCenter.email!}</#if></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">${t.createDate!?string("yyyy-MM-dd")}</td>
                      </tr>
                      </#list>
                    </#if>
                      <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"></td>
                        <td colspan="7"  align="left" valign="middle" bgcolor="#ffffff" class="sq"><table width="200" border="0" cellspacing="0" cellpadding="0">
                        </table></td>
                      </tr>
                    </tbody>
                  </table>
              </#if>
        

				  

        
      </div>
        <div class="clear"></div>
    
    </div>
    </div>
</div>

<!-- main结束 -->
<script>
$("#chk_all").click(function(){
	if($("#chk_all").attr("checked")){
     	$("input[name='chk_list']").attr("checked",true);
     }else{
     	$("input[name='chk_list']").attr("checked",false);
     }
});
</script>


<#include "/assets/website/backend/common/footer.html">

</body>
</html>
