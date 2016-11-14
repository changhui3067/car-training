<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="/assets/website/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="/assets/website/css/iconfont.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/assets/website/css/pxshi.css" type="text/css" />
<link rel="stylesheet" href="/assets/website/css/style.css" type="text/css" />
</head>

<body>
<!-- 头部开始 -->	
<#include "/assets/website/common/header.html">
<!-- 头部结束 -->	

<!-- main开始 -->


<div class="content">
	<#if job??>
    <div class="ny_zhaopin">
    	<div class="zhaopin_l left">
        	<div class="zp_qy">
            	<div class="zwmc">${job.title!}</div>
                <div class="qymc"><span><#--${jobs.company.autoBrand!}</span>--><span>当前汽车品牌：</span></div>
            </div>
            <div class="zhaopin_box">
            	<div class="xzdy">
                	<div class="zwdy"><span><img style="border:none;"  name="yp" id="yp" src="http://obu3flkwk.bkt.clouddn.com/website/images/yp_an.jpg" onclick="applyJob('${job.id!}')" /></span></div>
               	 	<!--<div class="shoucang">收藏</div>-->
                	<div class="gzdd">
                	<div class="didian left"><#if job.regionId??>${job.regionId!}</#if></div>
                    <div class="didian left">${job.salary!} （元/月）</div>
                    <div class="fb_sj right">发布日期<#--${job.publishDate!?string("yyyy-MM-dd")}--></div>
                    <div class="clear"></div>
                </div>
                	<div class="zwyq">
                	<ul>
                    	<li>${job.educationRequirement!}</li>
                        <li><#if job.workExperienceRequirement=0 > 应界毕业生 <#else> ${job.workExperienceRequirement!}年以上经验</#if></li>
                        <li>语言需求<#--${job.languages!?replace(",","+")?replace("[","")?replace("]","")}--></li>
                    	<li style="background:none;"></li>
                    </ul>
                    <div class="clear"></div>
                </div>
                	<div class="fldy">
                	<ul>
                		<#if job.welfare??>
                        	<#list job.welfare as w>
                        	<li>${w!}</li>
                            </#list>
                        </#if>
                    </ul>
                    <div class="clear"></div>
                </div>
                </div>
                <div class="gwms">
                	<h4>岗位描述：</h4>
                    <div class="gwms_box">
                    	${job.jobDescription!}
                    </div>
                </div>

                <div class="rzyq">
                	<h4>其他信息：</h4>
                    <div class="rzyq_box">
                    	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="8%">所属部门：</td>
    <td width="42%"><#--${jobs.department!}--></td>
    <td width="8%">专业要求：</td>
    <td width="42%"><#--${jobs.major!}--></td>
  </tr>
</table>

                  </div>
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
<!-- main结束 -->
<#include "/assets/website/common/footer.html">  

<script src="<@url value="/assets/website/js/jquery1.42.min.js?v=1.1.0"/>"></script>
<script src="<@url value="/assets/website/js/jquery.superslide.2.1.1.js?v=1.1.0"/>" type="text/javascript"></script>        
<script>
function applyJob(jid){
if(confirm("确定要申请该职位吗?")){
var form_data={};
var jid = jid;

if(jid==''||jid==null){
	alert('您申请的职位已不存在');
	return false;
}

form_data.jid = jid;

$.ajax({
	 type: "POST",
     url: "/website/jobDetail/apply",
     data: form_data,
     error: function(request) {
         showErrMsg("网络出错啦！");
         return false;
     },
     success: function (data) {
			 showErrMsg("恭喜您,您已申请成功了！");
		 	setTimeout(function(){
		 		if(jid==''||jid==null){
     	 			window.location.href = "/website/jobDetail?jobs.id=jid";
     	 			}
     	 		},300);

     }
});
}else{
	return false;
}
}
    
function bondsto(cid,jid){ 
if(confirm("确定要为该公司担保吗?")){
var form_data={};
var cid = cid;
var jid = jid;
if(cid==''||cid==null){
	alert('该公司已不存在');
	return false;
}

form_data.cid = cid;

$.ajax({
	 type: "POST",
     url: "/website/jobDetail/bondsman",
     data: form_data,
     error: function(request) {
         showErrMsg("网络出错啦！");
         return false;
     },
     success: function (data) {
			 showErrMsg("恭喜您,您已成为该公司的担保人！");
			 setTimeout(function(){
		 		if(jid==''||jid==null){
     	 			window.location.href = "/website/jobDetail?jobs.id=jid";
     	 			}
     	 		},300);

     }
});
}else{
	return false;
}
}
function showErrMsg(errMsg){
	alert(errMsg);
}
</script>

</body>
</html>
