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
    <div class="dqwz left">当前位置 : <a href="#">首 页</a> > <a href="#">企业管理中心</a> > <a href="#">发布职位</a></div>
    <div class="wdcf right"><span color="#FF66001"><#if Session?exists && Session["userDetails"].wealthStartDate??> ${Session["userDetails"].wealthStartDate!?string("dd/MM/yyyy")}—${Session["userDetails"].wealthEndDate!?string("dd/MM/yyyy")}</#if></span>我的财富：<font color="#FF66001"><#if Session?exists && Session["userDetails"]??> ${Session["userDetails"].wealth!}</#if></font></div><div class="clear"></div>
    </div>
    <div class="pxshi_gl">
    	<div class="pxshi_gl_l left">
        
        <#include "/assets/website/backend/common/menu.html">
        
        <div class="pxshi_gl_r right">
        
        <form id="form1"  >
        
       	  <div class="pxshijl">
               	  <h5>职位描述</h5>
                    <div class="pxshijl_box">
                   	 <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			   <tr>
			    <td width="79" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 工作性质：</td>
			    <td width="721"><input type="radio" name="job.jobType" value="FULLTIME" id="ty_per7" />
			全职&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="job.jobType" value="PARTTIME" id="ty_per8" />
			兼职</td>
			  </tr>
			  <tr>
			    <td width="79" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 职位名称：</td>
			    <td width="721">
			    <input type="text" name="job.name" id="job.name" />
			    </td>
			  </tr>
			  <tr>
			    <td width="79" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 汽车品牌：</td>
			    <td width="721">
			    <input type="text" name="job.autoBrand" id="job.autoBrand" />
			    </td>
			  </tr>
			  <tr>
			    <td width="79" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 要求年限：</td>
			    <td width="721">
			    <select name="job.workExprience" id="job.workExprience">
	        	    <option value="">请选择</option>
					<#list 0..20 as t>
					<option value="${t}">${t}</option>
					</#list>	
					</select>&nbsp;
					<font color="red" >选择0表示应界毕业生</font>
				</td>
			  </tr>
			   <tr>
			    <td width="79" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 待遇：</td>
			    <td width="721">
			    <input type="text" name="job.salary" id="job.salary" />元/月
				</td>
			  </tr>
			   <tr>
			    <td width="79" height="40" align="right" valign="middle"><font color="#ff0000">*</font>语言要求：</td>
			    <td width="721">
			   	<input type="checkBox" name="job.languages" id="job.languages" value="普通语"/>普通语
	    	   	<input type="checkBox" name="job.languages" id="job.languages" value="英语"/>英语
	    	   	<input type="checkBox" name="job.languages" id="job.languages" value="日语"/>日语
		   		<input type="checkBox" name="job.languages" id="job.languages" value="德语"/>德语
	    	   	<input type="checkBox" name="job.languages" id="job.languages" value="韩语"/>韩语
				</td>
			  </tr>
			   <tr>
			    <td width="79" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 工作区域：</td>
			    <td width="721">
			     <select name="province" id="province" onChange="selectCities()">
        	    <option value="">请选择省</option>
				<#list provinces as t>
				<option value="${t.id!}">${t.fullname!}</option>
				</#list>
				</select>
				<select name="city" id="city">
        	    <option value="">请选择市</option>
				</select>
				</td>
			  </tr>
			   <tr>
			    <td width="79" height="40" align="right" valign="middle"><font color="#ff0000">*</font>公司福利：</td>
			    <td width="721">
			       	<input type="checkBox" name="job.welfare" id="job.welfare" value="五险一金"/>五险一金
		    	   	<input type="checkBox" name="job.welfare" id="job.welfare" value="工作餐"/>工作餐
		    	   	<input type="checkBox" name="job.welfare" id="job.welfare" value="免费班车"/>免费班车
			   		<input type="checkBox" name="job.welfare" id="job.welfare" value="股票期权"/>股票期权
		    	   	<input type="checkBox" name="job.welfare" id="job.welfare" value="带薪休假"/>带薪休假
		    	   	<input type="checkBox" name="job.welfare" id="job.welfare" value="年底双薪"/>年底双薪
		    	   	<input type="checkBox" name="job.welfare" id="job.welfare" value="绩效奖金研发"/>绩效奖金
		    	   	<input type="checkBox" name="job.welfare" id="job.welfare" value="定期体检"/>定期体检
				</td>
			  </tr>
			  <tr>
			    <td height="150" align="right" valign="top"><font color="#ff0000">*</font> 职位描述：</td>
			    <td align="left" valign="top"><textarea style="width:600px;" name="job.jobDescription" id="job.jobDescription" cols="45" rows="5"></textarea></td>
			  </tr>
			</table>
 
            </div>
          </div>
          
          <div class="tj">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="60" align="center" valign="middle"> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<img  onClick="javascript:submitdata();" src="http://obu3flkwk.bkt.clouddn.com/backend/images/fb.jpg" /></td>
                  </tr>
            </table>
          </div>
      </div>
      
      </form>
      
        <div class="clear"></div>
    
    </div>
    </div>
</div>

<script>

function checkform(){
	var name = $("[name='job.name']").val();
	var jobType = $("[name='job.jobType']").val();
	var jobDescription = $("[name='job.jobDescription']").val();
	
	if(name == undefined || jobType == undefined || jobDescription == undefined){
		alert("带*的为必填字段 ");
		return false;
	}
	if(name == "" || jobType == "" || jobDescription == ""){
		alert("带*的为必填字段 ");
		return false;
	}
	
	return true;
}

function submitdata(){

	var url  = "/backend/publishJob/save";
	var form_data = {};
	var jobType = $("[name='job.jobType']:checked").val();
	var name = $("[name='job.name']").val();
	var autoBrand = $("[name='job.autoBrand']").val();
	var workExprience = $("[name='job.workExprience']").val();
	var salary = $("[name='job.salary']").val();
	var languages = '';
	$("input:checkbox[name='job.languages']:checked").each(function(index, element) {
                         languages += $(this).val() + ",";
	 });
	var welfare = '';
	$("input:checkbox[name='job.welfare']:checked").each(function(index, element) {
                         welfare += $(this).val() + ",";
	 });
	var regionId = $("[name='city']").val();
	var description = $("[name='job.jobDescription']").val();
	
	form_data.jobType = jobType;
	form_data.name = name;
	form_data.autoBrand = autoBrand;
	form_data.workExprience= workExprience;
	form_data.salary = salary;
	form_data.languages = languages;
	form_data.welfare = welfare;
	form_data.regionId=regionId;
	form_data.description =description;
	
	$.ajax({
			 type: "POST",
		     url: url,
		     data: form_data,
		     error: function(request) {
	             showErrMsg("网络出错啦！");
	             return false;
	         },
		     success: function (data) {
		    	 if(data.code==200){
					 showErrMsg("添加成功！");
					 window.location.href = "/backend/companyJobManage";
		    	 }else if(data.code==400){
		    	 	 showErrMsg(data.msg);
		    	 	 return false;
		    	 }else{
		    	 	 return false;
		    	 }
		     }
	});
}


function selectCities(){
	var form_data={};
	form_data.parentId = $("[name='province']").val();;
	$.ajax({
		 type: "POST",
	     url: "/backend/regions/getCities",
	     data: form_data,
	     error: function(request) {
	         showErrMsg("网络出错啦！");
	         return false;
	     },
	     success: function (data) {
	    	 if(data.code==200){
				$("#city").get(0).options.length=data.cities.length+1;
	    		for(var i=0;i<data.cities.length;i++)
	    		{
	    		  $("#city").get(0).options[i+1]=new Option(data.cities[i].name,data.cities[i].id);
	    		}
	    	 }else{
	    	 	 return false;
	    	 }
	     }
	});
}

function showErrMsg(errMsg){
    	alert(errMsg);
 }
</script>

<!-- main结束 -->
<#--<#include "/assets/backend/common/footer.html">-->

</body>
</html>
