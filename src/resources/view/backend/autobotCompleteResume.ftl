<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value='/assets/website/backend/css/style.css'/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<@url value='/assets/website/backend/css/laydate.css'/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<@url value='/assets/website/backend/css/date-molv.css'/>" type="text/css" media="screen" />
<script src="<@url value="/assets/website/js/jquery-1.8.0.min.js?v=1.1.0"/>"></script>
<script src="<@url value="/assets/website/js/laydate.js?v=1.1.0"/>"></script>
</head>

<body>
<#include "/assets/website/common/header.html">

<!-- main开始 -->
<div class="main">
	<div class="content">
    <div class="dq_box">
    <div class="dqwz left">当前位置 : <a href="#">首 页</a> > <a href="#">汽车人管理中心</a> > <a href="#">申请记录</a></div>
   <div class="wdcf right"><span color="#FF66001"><#if Session?exists && Session["userDetails"].wealthStartDate??> ${Session["userDetails"].wealthStartDate!?string("dd/MM/yyyy")}—${Session["userDetails"].wealthEndDate!?string("dd/MM/yyyy")}</#if></span>我的财富：<font color="#FF66001"><#if Session?exists && Session["userDetails"]??> ${Session["userDetails"].wealth!}</#if></font></div><div class="clear"></div>
    </div>
    <div class="pxshi_gl">
    	<div class="pxshi_gl_l left">

        <#include "/assets/website/backend/common/menu.html">

        <div class="pxshi_gl_r right">
        <form id="form1">
        <!--隐藏域-->
        <input type="hidden" name="autobot.userCenter.personalType" value="AUTOBOT">
        <input type="hidden" name="autobot.id" value="<#if autobot??>${autobot.id!}</#if>">
        <input type="hidden" name="autobot.userCenter.id" value="<#if autobot?? && autobot.userCenter??>${autobot.userCenter.id!}</#if>">
        <!--隐藏域-->
       	  <div class="pxshijl">
               	  <h5>基本信息</h5>
                    <div class="pxshijl_box">
    	<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td colspan="2"width="420" align="left" valign="top"><table width="400" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td width="69" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 姓 名：</td>
		        <td>
		        <#if autobot?? && autobot.userCenter?? && autobot.userCenter.name??>
		        <input type="text" name="autobot.userCenter.name" value="${autobot.userCenter.name!}" />
		        <#else>
		        <input type="text" name="autobot.userCenter.name" value=""  />
		        </#if>
		        </td>
		      </tr>
		      <tr>
		        <td height="40" align="right" valign="middle"><font color="#ff0000">*</font>出生年月：</td>
		        <td>
		        <#if autobot?? && autobot.userCenter?? && autobot.userCenter.name??>
		        <input name="autobot.userCenter.birthday" value="${autobot.userCenter.birthday?string("yyyy-MM-dd")!}" type="date" onclick="laydate()"/>
		        <#else>
		        <input name="autobot.userCenter.birthday" value="" type="date" onclick="laydate()" class="laydate-icon"/>
		        </#if>
		        </td>
		      </tr>
		      <tr>
		        <td height="40" align="right" valign="middle"><font color="#ff0000">*</font>婚姻状况：</td>
		        <td>
		        	<#if autobot?? && autobot.userCenter?? && autobot.userCenter.marryStatus?? && autobot.userCenter.marryStatus.name() = 'UNMARRIED'>
		        	<input checked="checked" type="radio" name="autobot.userCenter.marryStatus" value="UNMARRIED" id="ty_per10" />
		        	<#else>
		        	<input type="radio" name="autobot.userCenter.marryStatus" value="UNMARRIED" id="ty_per10" />
		        	</#if>
					未婚
					<#if autobot?? && autobot.userCenter?? && autobot.userCenter.marryStatus?? && autobot.userCenter.marryStatus.name() = 'MARRIED'>
					<input checked="checked" type="radio" name="autobot.userCenter.marryStatus" value="MARRIED" id="ty_per11" />
					<#else>
					<input type="radio" name="autobot.userCenter.marryStatus" value="MARRIED" id="ty_per11" />
					</#if>
					已婚
					<#if autobot?? && autobot.userCenter?? && autobot.userCenter.marryStatus?? && autobot.userCenter.marryStatus.name() = 'RAISED'>
					<input checked="checked" type="radio" name="autobot.userCenter.marryStatus" value="RAISED" id="ty_per12" />
					<#else>
					<input type="radio" name="autobot.userCenter.marryStatus" value="RAISED" id="ty_per12" />
					</#if>
					离异</td>
		      </tr>
		    </table></td>
    <td width="439" colspan="4" align="left" valign="top"><table width="400" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>
        <img id="autobot.userCenter.headLogo" src="<#if autobot.userCenter.headLogo?? >${autobot.userCenter.headLogo!}<#else>http://obu3flkwk.bkt.clouddn.com/backend/images/zw.jpg</#if>" style="width:40px;height:40px;" />
        <input type="hidden" id="autobot.userCenter.headLogo" name="autobot.userCenter.headLogo" />
        </td>
        </tr>
      <tr>
        <td>

        <table width="400" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td  width="15%" height="40" align="left" valign="middle"><input type="file" name="headLogo" id="headLogo" value="浏 览" onChange="selectImage(this)"/></td>
            <td width="23%" align="left" valign="middle"></td>
            <td width="62%" align="left" valign="middle"></td>
            </tr>
          </table>

          </td>
        </tr>
      <tr>
        <td><font color="#CCCCCC">请上传宽度为180px,高度为150px,格式：jpg,gif, 大小&lt;500kb的图片</font></td>
        </tr>
      </table></td>
  </tr>
  </table>
                    	<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
                    	  <tr>
                    	    <td width="76" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 工作状态：</td>
                    	    <td width="262">
                    	    <#if autobot?? && autobot.currentWorkStatus?? >
                    	    <input type="text" name="autobot.currentWorkStatus" value="${autobot.currentWorkStatus!}"  />
                    	    <#else>
                    	    <input type="text" name="autobot.currentWorkStatus" value=""  />
                    	    </#if>
                    	    </td>
                    	    <td width="125" align="right" valign="middle"><font color="#ff0000">*</font> 当前汽车品牌：</td>
                    	    <td width="337">
                    	    <#if autobot?? && autobot.autoBrand?? >
                    	    <input type="text" name="autobot.autoBrand" value="${autobot.autoBrand!}"  />
                    	    <#else>
                    	    <input type="text" name="autobot.autoBrand" value="" />
                    	    </#if>
                    	    </td>
                  	    </tr>
                        <tr>
                    	    <td height="40" align="right" valign="middle"><font color="#ff0000">*</font> 手 机：</td>
                    	    <td>
                    	    <#if autobot?? && autobot.userCenter?? && autobot.userCenter.mobile??>
                    	    <input type="mobile" name="autobot.userCenter.mobile" value="${autobot.userCenter.mobile!}" />
                    	    <#else>
                    	    <input type="mobile" name="autobot.userCenter.mobile" value=""  />
                    	    </#if>
                    	    </td>
                    	    <td width="125" align="right" valign="middle"><font color="#ff0000">*</font> 邮箱：</td>
                    	    <td width="337">
                    	     <#if autobot?? && autobot.userCenter?? && autobot.userCenter.email??>
	                	    <input type="eamil" name="autobot.userCenter.email" value="${autobot.userCenter.email!}" />
	                	    <#else>
	                	    <input type="email" name="autobot.userCenter.email" value=""  />
	                        </#if>
                            </td>
                  	    </tr>
                  	     <tr>
                    	    <td height="40" align="right" valign="middle"><font color="#ff0000">*</font> 区域：</td>
                    	    <td>
                    	    <select name="province" id="province" onChange="selectCities()">
                    	    <option value="">请选择省</option>
                            <#list provinces as t>
							<option value="${t.id!}"<#if userRegion?? && userRegion.parent.id == t.id>selected="selected"</#if>>${t.name!}</option>
							</#list>
							</select>
							<select name="city" id="city">
                    	    <option value="">请选择市</option>
                            <#list cities as city>
                                <option value="${city.id!}" <#if userRegion ?? && city.id == userRegion.id>selected="selected"</#if>>${city.name!}</option>
                            </#list>
							</select>
                    	    </td>
                    	    <td width="125" align="right" valign="middle"><font color="#ff0000">*</font> 汽车行业经验：</td>
                    	    <td width="337">
	                	    <select name="autobot.autoYears" id="autobot.autoYears">
                    	    <option value="">请选择</option>
                    	    <#if autobot?? && autobot.autoYears?? >
                    	    <option selected="selected" value="${autobot.autoYears!}">${autobot.autoYears!}</option>
							</#if>
							<#list 0..20 as t>
							<option value="${t}">${t}</option>
							</#list>
							</select>&nbsp;
							<font color="red" >选择0表示应界毕业生</font>
                    	    </td>
                  	    </tr>
                  	     <tr>
                    	    <td height="40" align="right" valign="middle"><font color="#ff0000">*</font>擅长领域：</td>
                    	    <td colspan="3">
                    	    <#if autobot ?? && autobot.businessCategory??>
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("销售")!=-1> checked </#if> value="销售"/>销售
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("售后")!=-1> checked </#if> value="售后"/>售后
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("客服")!=-1> checked </#if> value="客服"/>客服
                	   		<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("市场")!=-1> checked </#if> value="市场"/>市场
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("管理")!=-1> checked </#if> value="管理"/>管理
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("内训")!=-1> checked </#if> value="内训"/>内训
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("生产研发")!=-1> checked </#if> value="生产研发"/>生产研发
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("行政")!=-1> checked </#if> value="行政"/>行政
                    	    <#else>
                    	     	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory"  value="销售"/>销售
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory"  value="售后"/>售后
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory"  value="客服"/>客服
                	   		<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory"  value="市场"/>市场
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory"  value="管理"/>管理
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory"  value="内训"/>内训
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory"  value="生产研发"/>生产研发
                    	   	<input type="checkBox" name="autobot.businessCategory" id="autobot.businessCategory"  value="行政"/>行政
                    	    </#if>
                    	    </td>

                  	    </tr>

                  	    <tr>
                  	     <td height="40" align="right" valign="middle"><font color="#ff0000">*</font>工作照：</td>
                  	     <td colspan="3" align="left" valign="middle">
                  	     <img id="autobot.workPhotoURL1" src="<#if autobot.workPhotoURL1??>${autobot.workPhotoURL1!}<#else>http://obu3flkwk.bkt.clouddn.com/backend/images/zw.jpg</#if>" style="width:40px;height:40px;" />
                  	     <input type="file" name="workPhotoURL1" id="workPhotoURL1" value="浏览" onChange="selectImage(this)"/>
                  	     <img id="autobot.workPhotoURL2" src="<#if autobot.workPhotoURL2??>${autobot.workPhotoURL2!}<#else>http://obu3flkwk.bkt.clouddn.com/backend/images/zw.jpg</#if>" style="width:40px;height:40px;" />
                  	     <input type="file" name="workPhotoURL2" id="workPhotoURL2" value="浏览" onChange="selectImage(this)"/></td>
                  	  	</tr>

                  	  </table>
                </div>
                </div>

          <div class="pxshijl">
               	  <h5>所获认证</h5>
                    <div class="pxshijl_box">
                    	<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">

		     <tr>
		    <td height="40" colspan="4" align="left" valign="middle"><table width="90%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td width="11%"><font color="#ff0000">*</font>所获认证：</td>
		    <td width="89%"><textarea style="width:600px;" name="autobot.authHistroy" id="autobot.authHistroy" cols="45" rows="5"><#if autobot?? && autobot.authHistroy??> ${autobot.authHistroy!}<#else>请输入所获认证</#if></textarea></td>
		  </tr>
		</table></td>
		    </tr>
		</table>


                </div>
          </div>
          <div class="pxshijl">
               	  <h5>工作经历</h5>
                    <div class="pxshijl_box">
                    	<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">



     <tr>
    <td height="40" colspan="4" align="left" valign="middle"><table width="90%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="11%"><font color="#ff0000">*</font>工作经历：</td>
    <td width="89%"><textarea style="width:600px;" name="autobot.workingHistroy" id="textarea2" cols="45" rows="5"><#if autobot?? && autobot.workingHistroy??> ${autobot.workingHistroy!} <#else>请输入工作经历</#if></textarea></td>
  </tr>
</table></td>
    </tr>
</table>


                </div>
          </div>
          <div class="tj">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="60" align="center" valign="middle">
                    <input type="button" onclick="submitdata()" style="width:58px;height:28px;background-repeat:no-repeat;background-image:url(http://obu3flkwk.bkt.clouddn.com/backend/images/bc.jpg);border:0;"/>
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
	var name = $("[name='autobot.userCenter.name']").val();
	var birthday = $("[name='autobot.userCenter.birthday']").val();
	var marryStatus = $("[name='autobot.userCenter.marryStatus']").val();
	var currentWorkStatus = $("[name='autobot.currentWorkStatus']").val();
	var autoBrand = $("[name='autobot.autoBrand']").val();
	var mobile = $("input[name='autobot.userCenter.mobile']").val();
	var authHistroy = $("[name='autobot.authHistroy']").val();
	var workingHistroy = $("[name='autobot.workingHistroy']").val();

	if(name == undefined || birthday == undefined || marryStatus == undefined || currentWorkStatus == undefined || autoBrand == undefined || mobile == undefined || authHistroy == undefined || workingHistroy == undefined){
		alert("带*的为必填字段 ");
		return false;
	}
	if(name == "" || birthday == "" || marryStatus == "" || currentWorkStatus == "" || autoBrand == "" || mobile == "" || authHistroy == "" || workingHistroy == ""){
		alert("带*的为必填字段 ");
		return false;
	}

	return true;
}

function submitdata(){

	if(!checkform()){
		return;
	}

	var form_data = {};
	var url  = "/backend/autobotCompleteResume/save";

	var uheadLogo = document.getElementById('autobot.userCenter.headLogo').src;
	var upersonalType = $("[name='autobot.userCenter.personalType']").val();
	var aid = $("[name='autobot.id']").val();
	var uid = $("[name='autobot.userCenter.id']").val();
	var uname = $("[name='autobot.userCenter.name']").val();
	var ubirthday = $("[name='autobot.userCenter.birthday']").val();
	var uemail = $("[name='autobot.userCenter.email']").val();
	var uregionId = $("[name='city']").val();
	var umarryStatus = $("[name='autobot.userCenter.marryStatus']").val();
	var currentWorkStatus = $("[name='autobot.currentWorkStatus']").val();
	var autoBrand = $("[name='autobot.autoBrand']").val();
	var umobile = $("input[name='autobot.userCenter.mobile']").val();
	var autoYears = $("[name='autobot.autoYears']").val();
	var authHistroy = $("[name='autobot.authHistroy']").val();
	var workingHistroy = $("[name='autobot.workingHistroy']").val();
	var businessCategory = '';
	$("input:checkbox[name='autobot.businessCategory']:checked").each(function(index, element) {
                         businessCategory += $(this).val() + ",";
	 });
	var workPhotoURL1 = document.getElementById('autobot.workPhotoURL1').src;
	var workPhotoURL2 = document.getElementById('autobot.workPhotoURL2').src;

	form_data.aid = aid;
	form_data.uid = uid;
	form_data.uname = uname;
	form_data.uheadLogo= uheadLogo;
	form_data.ubirthday = ubirthday;
	form_data.umarryStatus = umarryStatus;
	form_data.currentWorkStatus = currentWorkStatus;
	form_data.autoBrand = autoBrand;
	form_data.umobile = umobile;
	form_data.uemail= uemail;
	form_data.uregionId=uregionId;
	form_data.autoYears =autoYears;
	form_data.authHistroy =authHistroy;
	form_data.workingHistroy =workingHistroy;
	form_data.upersonalType = upersonalType;
	form_data.workPhotoURL1 = workPhotoURL1;
	form_data.workPhotoURL2 = workPhotoURL2;
	form_data.businessCategory = businessCategory;

	$.ajax({
			 type: "POST",
		     url: url,
		     data: form_data,
		     error: function(request) {
	             alert("网络出错啦！");
	             return false;
	         },
		     success: function (data) {
		    	 alert(data.msg);
		    	 	if(data.code==200){
		    	 			window.location.href = "/backend/autobotCompleteResume";
		    	 	}
		     }
	});
}

function selectCities(){
	var form_data={};
	form_data.parentId = $("[name='province']").val();
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


 var image = '';
 function selectImage(file){
	 if(!file.files || !file.files[0]){
		return;
	}

	 var reader = new FileReader();
	 reader.onload = function(evt){
	 if(file.name=='headLogo'){
		 document.getElementById('autobot.userCenter.headLogo').src = evt.target.result;
	 }
	 if(file.name=='workPhotoURL1'){
	 	document.getElementById('autobot.workPhotoURL1').src = evt.target.result;
	 }
	 if(file.name=='workPhotoURL2'){
		document.getElementById('autobot.workPhotoURL2').src = evt.target.result;
	 }
	 image = evt.target.result;
	}
	reader.readAsDataURL(file.files[0]);
}

function getFilePath(ext){
    var timestamp=new Date().getTime();
    return ("autobot/upload/" + timestamp + "." + ext);
}
</script>

<!-- main结束 -->
<#--<#include "/assets/backend/common/footer.html">-->

</body>
</html>
