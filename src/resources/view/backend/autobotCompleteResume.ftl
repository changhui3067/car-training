<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>汽车培聘网</title>
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
    <div class="wdcf right"><span>2016-07-20 — 2016-08-20</span>我的财富：<font color="#FF66001">845</font></div>
    <div class="clear"></div>
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
        <input name="autobot.userCenter.birthday" value="${autobot.userCenter.birthday?string("yyyy-MM-dd")!}" type="date"/>
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
        <td><img src="http://7xtuyf.com1.z0.glb.clouddn.com/backend/http://7xtuyf.com1.z0.glb.clouddn.com/backend/images/zw.jpg" /></td>
        </tr>
      <tr>
        <td>
        
        <table width="400" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td  width="15%" height="40" align="left" valign="middle"><input type="button" name="button" id="button" value="浏 览" /></td>
            <td width="23%" align="left" valign="middle">未选这图片。</td>
            <td width="62%" align="left" valign="middle"><input type="button" name="button2" id="button2" value="上 传" /></td>
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
                    	    <td width="76" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 目前状态：</td>
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
                    	    <input type="tel" name="autobot.userCenter.mobile" value="${autobot.userCenter.mobile!}" />
                    	    <#else>
                    	    <input type="tel" name="autobot.userCenter.mobile" value=""  />
                    	    </#if>
                    	    </td>
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
                    <input type="button" onclick="submitdata()" style="width:58px;height:28px;background-repeat:no-repeat;background-image:url(http://7xtuyf.com1.z0.glb.clouddn.com/backend/images/bc.jpg);border:0;"/>
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

	var url  = "/backend/autobotCompleteResume/save";
	var data = $("#form1").serialize();
	$.ajax({
			 type: "POST",
		     url: url,
		     data: data,
		     error: function(request) {
	             alert("网络出错啦！");
	             return false;
	         },
		     success: function (data) {
		    	 alert(data.msg);
		    	 	if(data.code==200){
		    	 		var tid = $("[name='autobot.id']").val();
		    	 		if(tid != undefined && tid != ""){
		    	 			window.location.href = "/website/autobotDetail?autobot.id=" + tid;
		    	 		}
		    	 	}
		     }
	});
}

</script>

<!-- main结束 -->
<#--<#include "/assets/backend/common/footer.html">-->

</body>
</html>
