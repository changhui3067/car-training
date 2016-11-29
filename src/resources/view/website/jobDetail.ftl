<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/html">
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
                <div class="qymc"><span>${job.autoBrand!}</span><span>当前汽车品牌：</span></div>
            </div>
            <div class="zhaopin_box">
                <div class="xzdy">
                    <div class="zwdy right">
                        <span><button name="yp" id="yp" onclick="applyJob('${job.id!}')"/>我要应聘</button></span>
                    </div>
                    <!--<div class="shoucang">收藏</div>-->
                    <div class="gzdd">
                        <div class="didian left"><#if job.region??>${job.region.fullname!}</#if></div>
                        <div class="didian left">${job.salary!} （元/月）</div>
                        <div class="fb_sj left">发布日期：<#if job.createDate??>${job.createDate?string("yyyy-MM-dd")!}</#if></div>
                        <div class="clear"></div>
                    </div>
                    <div class="zwyq">
                        <ul>
                            <li>${job.educationRequirement!}</li>
                            <li><#if job.workExperienceRequirement=0 > 应界毕业生 <#else> ${job.workExperienceRequirement!}
                                年以上经验</#if></li>
                            <li>语言需求: ${job.languageRequirement!}</li>
                            <li style="background:none;"></li>
                        </ul>
                        <div class="clear"></div>
                    </div>
                    <div class="fldy">
                        <#if company.welfare??>
                            <ul>
                            <#--<#list company.welfare as w>-->
                            <#--<li>${w.name!}</li>-->
                            <#--</#list>-->
                                <li>${company.welfare.description!}</li>
                            </ul>
                        </#if>
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
                                <td width="42%">${job.department!}</td>
                                <td width="8%">专业要求：</td>
                                <td width="42%">${job.majorRequirement!}</td>
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
<script type="text/javascript" src="/assets/website/js/Util.js"></script>        
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
         Util.msgToast({
             message: '请求失败',
             mode: Util.MSGTYPE.ERROR
         });
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

function showErrMsg(errMsg){
	alert(errMsg);
}
</script>

</body>
</html>
