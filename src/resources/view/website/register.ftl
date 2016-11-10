<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value="/assets/website/css/style.css?v=1.1.0"/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<@url value='/assets/website/backend/css/login_style.css'/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<@url value="/assets/website/css/bootstrap.min.css?v=1.1.0"/>" type="text/css" media="screen" />

</head>

<body>
<!-- 头部开始 -->	
<#include "/assets/website/common/header.html">
<!-- 头部结束 -->	
	
<!-- main开始 -->
<div class="main">
	<div class="content">
    <div class="zc">
    	<div class="zc_l left">
        	<div class="links">
		<div class="linksTop">
			<ul id="tags1">
				<li class="cn" onclick="selectTag('item_con_0',this)">个人注册</li>
				<li onclick="selectTag('item_con_1',this)">企业注册</li>
			</ul>
		</div>
		<div class="linksmain" id="item_con">
			<div id="item_con_0">
			  <form action="" id="personal_loginform">
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="60" colspan="4" align="left" valign="middle" style="background:url(http://obu3flkwk.bkt.clouddn.com/backend/images/icon2.jpg) no-repeat left center; padding:20px 0px; height:30px; line-height:30px; padding-left:30px;">每个手机只能申请一个账号</td>
                  </tr>
                <tr>
                  <td width="106" height="60" align="right" valign="middle"><font color="#ff0000">*</font>个人账号：</td>
                  <td colspan="2"><input style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="text" name="username" id="username"  data-reg="/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/" placeholder="请输入11位手机号" required/></td>
                  <td width="282"><font color="#999999">作为登录账号，请填写未注册过的手机</font></td>
                </tr>
                <tr>
                  <td height="60" align="right" valign="middle"><font color="#ff0000">*</font>密码：</td>
                  <td colspan="2"><input  style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="password" name="password" id="password"   data-reg="/^[A-Za-z0-9]{6,16}$/"  placeholder="请输入6-16位字母、数字组成的登录密码" required/></td>
                  <td><font color="#999999">6~16个字符，包含字母，数字，下划线</font></td>
                </tr>
                <tr>
                  <td height="60" align="right" valign="middle"><font color="#ff0000">*</font>确认密码：</td>
                  <td colspan="2"><input  style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="password" name="confirmPassword" id="confirmPassword"   data-reg="/^[A-Za-z0-9]{6,16}$/"  placeholder="请再次输入登录密码" required/></td>
                  <td><font color="#999999">请再次输入密码</font></td>
                </tr>
                <tr>
                  <td height="60" align="right" valign="middle"><font color="#ff0000">*</font>验证码：</td>
                  <td width="100"><input  style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:120px;" type="text" name="verCode" id="verCode" /></td>
                  <td width="72"> 
                      <input type="button" id="personal_msgsend" value="免费获取验证码" onclick="javascript:settime(this);sendmsg(this.id);return false;" style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:120px;" /></td>
                  <td><font color="#999999">请输入手机验证码</font></td>
                </tr>
                <tr>
                    <td>
                        <div class="errMsg"></div>
                    </td>
                </tr>
                <tr>
                  <td height="60" colspan="4" align="center" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                    	<div id="checkeRadio">
                    	    <label class="radio-inline col-sm-3"> 
                    	        <input name="personalType" id="personalType" type="radio"  value="AUTOBOT" checked/>汽车人
                    	    </label>
                    	    <label class="radio-inline col-sm-3">
                    	        <input type="radio" name="personalType" id="personalType" value="TRAINER" />培训师
                    	    </label>
                    	</div>
                    </tr>
                  </table></td>
                  </tr>
                <tr>
                  <td height="80" colspan="4" align="center" valign="middle"><input type="image" name="imageField" id="imageField" src="http://obu3flkwk.bkt.clouddn.com/backend/images/tj.jpg" onClick='javascript:personal_register();return false;'/></td>
                </tr>
              </table>
              </form>
			</div>
			<div id="item_con_1" style="display:none">
			  <form action="" id="company_loginform">
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="60" colspan="4" align="left" valign="middle" style="background:url(http://obu3flkwk.bkt.clouddn.com/backend/images/icon2.jpg) no-repeat left center; padding:20px 0px; height:30px; line-height:30px; padding-left:30px;">每个手机只能申请一个账号</td>
                  </tr>
                <tr>
                  <td width="106" height="60" align="right" valign="middle"><font color="#ff0000">*</font>企业账号：</td>
                  <td colspan="2"><input style="30px;border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="text" name="username" id="username"  data-reg="/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/" placeholder="请输入11位手机号" required/></td>
                  <td width="282"><font color="#999999">作为登录账号，请填写未注册过的手机</font></td>
                </tr>
                <tr>
                  <td height="60" align="right" valign="middle"><font color="#ff0000">*</font>密码：</td>
                  <td colspan="2"><input  style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="password" name="password" id="password"   data-reg="/^[A-Za-z0-9]{6,16}$/"  placeholder="请输入6-16位字母、数字组成的登录密码" required/></td>
                  <td><font color="#999999">6~16个字符，包含字母，数字，下划线</font></td>
                </tr>
                <tr>
                  <td height="60" align="right" valign="middle"><font color="#ff0000">*</font>确认密码：</td>
                  <td colspan="2"><input  style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="password" name="confirmPassword" id="confirmPassword"   data-reg="/^[A-Za-z0-9]{6,16}$/"   placeholder="请再次输入登录密码" required/></td>
                  <td><font color="#999999">请再次输入密码</font></td>
                </tr>
                <tr>
                  <td height="60" align="right" valign="middle"><font color="#ff0000">*</font>验证码：</td>
                  <td width="100"><input  style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:120px;" type="text" name="verCode" id="verCode" /></td>
                  <td width="72" align="left"> 
                   <input type="button" id="company_msgsend" style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:120px;" value="免费获取验证码" onclick="settime(this);sendmsg(this.id);return false;" /></td>
                  <td><font color="#999999">请输入手机验证码</font></td>
                </tr>
                <tr>
                	<td>
                        <div class="errMsg"></div>
                    </td>
                </tr>
                <tr>
                  <td height="60" colspan="4" align="center" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                    	<div id="checkeRadio">
                    	    <label class="radio-inline col-sm-3"> 
                    	        <input name="companyType" id="companyType" type="radio"  value="COMPANY" checked/>培训企业
                    	    </label>
                    	    <label class="radio-inline col-sm-3">
                    	        <input type="radio" name="companyType" id="companyType" value="STORE" />汽车公司
                    	    </label>
                    	</div>
                    </tr>
                  </table></td>
                  </tr>
                <tr>
                  <td height="80" colspan="4" align="center" valign="middle"><img id="imageField" src="http://obu3flkwk.bkt.clouddn.com/backend/images/tj.jpg"  onClick='company_register()'/></td>
                </tr>
              </table>
              </form>
			</div>
			
		</div>
	</div>
        
        </div>
        <div class="zc_r right">已有培聘账号？<a href="<@url value='/website/index'/>">立即登录</a>。</div>
        <div class="clear"></div>
    </div>
    </div>
</div>
<script src="<@url value="/assets/website/js/jquery-3.1.1.min.js?v=1.1.0"/>"></script>
<script src="<@url value="/assets/website/js/bootstrap.min.js?v=1.1.0"/>"></script>
<script type="text/javascript" src="<@url value="/assets/website/backend/js/common.js"/>"></script>
<script>
var phoneReg = /^1[3|4|5|7|8][0-9]{9}$/, //手机验证规则
    passwordReg = /^[\w]{6,12}$/;
function personal_register(){
	var form_data={},
	    errMsg = $("#personal_loginform .errMsg")[0];
	form_data["username"] = $("#personal_loginform #username").val(),
    form_data["password"] = $("#personal_loginform #password").val(),
    form_data["vercode"] = $("#personal_loginform #verCode").val(),
    form_data["personalType"] = $("input[name='personalType']:checked").val();
	var comfirmPassword = $("#personal_loginform #confirmPassword").val();
	
	if(!form_data.username){
		errMsg.innerHTML = "请输入用户名";
        return false;
	}else if(!phoneReg.test(form_data.username)){
        errMsg.innerHTML = "手机格式不正确";
        return false;
    }
	if(form_data.password ==''||form_data.password==null){
		errMsg.innerHTML = "请输入密码";
        return false;
	}else if(!passwordReg.test(form_data.password)){
        errMsg.innerHTML = "密码格式不正确";
        return false;
    }
	if(comfirmPassword==''||comfirmPassword==null){
		errMsg.innerHTML = "请输入确认密码";
		return false;
	}
	if(comfirmPassword!=form_data.password){
		errMsg.innerHTML = "您输入的密码和确认密码不一致";
		return false;
	}
	if(form_data.vercode==''||form_data.vercode==null){
		errMsg.innerHTML = "请选择短信验证码";
		return false;
	}
	if(!form_data.personalType){
		errMsg.innerHTML = "请选择个人类型";
		return false;
	}
	$.ajax({
		type: "POST",
	    url: "/backend/register/register",
	    data: form_data,
        error: function(request) {
            errMsg.innerHTML = "网络出错啦！";
            return false;
         },
	     success: function (data) {
				 showErrMsg("注册成功！");
				 if(data.target == "" || data.target == null){
				 	setTimeout(function(){
		     	 			window.location.href = "/backend/applyJobHistory";
		     	 		},300);
				 }else{
				 	setTimeout(function(){
		     	 			window.location.href = data.target;
		     	 		},300);
				 }

	     }
	    }
	});
}

function company_register(){
	var form_data={},
        errMsg = $("#company_loginform .errMsg")[0];
	form_data["username"] = $("#company_loginform #username").val(),
	form_data["password"] = $("#company_loginform #password").val(),
	form_data["vercode"] = $("#company_loginform #verCode").val(),
	form_data["companyType"] = $("input[name='companyType']:checked").val();
    var comfirmPassword = $("#company_loginform").find("#confirmPassword").val();

	if(!form_data.username){
		errMsg.innerHTML = "请输入用户名";
        return false;
	}else if(!phoneReg.test(form_data.username)){
        errMsg.innerHTML = "手机格式不正确";
        return false;
    }
	if(form_data.password==''||form_data.password==null){
		errMsg.innerHTML = "请输入密码";
		return false;
	}else if(!passwordReg.test(form_data.password)){
        errMsg.innerHTML = "密码格式不正确";
        return false;
    }
	if(comfirmPassword==''||comfirmPassword==null){
		errMsg.innerHTML = "请输入确认密码";
		return false;
	}
	if(comfirmPassword!=form_data.password){
		errMsg.innerHTML = "您输入的密码和确认密码不一致";
		return false;
	}
	if(form_data.vercode==''||form_data.vercode==null){
		errMsg.innerHTML = "请选择短信验证码";
		return false;
	}
	if(!form_data.companyType){
		errMsg.innerHTML = "请选择企业类型";
		return false;
	}
	$.ajax({
		type: "POST",
	    url: "/backend/register/register",
	    data: form_data,
	    error: function(request) {
            showErrMsg("网络出错啦！");
            return false;
        },
	    success: function (data) {
				showErrMsg("注册成功！");
				if(data.target == "" || data.target == null){
				 	setTimeout(function(){
		     	 			window.location.href = "/backend/companyJobManage";
		     	 		},300);
				}else{
				 	setTimeout(function(){
		     	 			window.location.href = data.target;
		     	 		},300);
				}

	     }
	});
}
   
 function sendmsg(s_type){
	var form_data={},
        errMsg = $("#errMsg")[0];
	if(s_type=='personal_msgsend'){
	   form_data["username"] = $("#personal_loginform #usernam").val();
	   form_data["userType"]= "PERSON";
	}else if(s_type=='company_msgsend'){
	   form_data["username"] = $("#company_loginform #usernam").val();
	   form_data["userType"]= "COMPANY";
	}
	if(!form_data.username){
        errMsg.innerHTML = "请输入手机号";
		return false;
	}
	$.ajax({
		 type: "POST",
	     url: "/backend/userCenter/sendmsgForRegister",
	     data: form_data,
	     error: function(request) {
	         errMsg.innerHTML = "网络出错啦！";
	         return false;
	     },
	     success: function (data) {
				errMsg.innerHTML = "发送成功！";
	     }
	});
}

var countdown=60; 
function settime(obj) { 
    if (countdown == 0) { 
        obj.removeAttribute("disabled");    
        obj.value="免费获取验证码"; 
        countdown = 60; 
        return;
    } else { 
        obj.setAttribute("disabled", true); 
        obj.value="重新发送(" + countdown + ")"; 
        countdown--; 
    } 
setTimeout(function() { 
    settime(obj) }
    ,1000) 
}
</script>
<!-- main结束 -->
<#include "/assets/website/backend/common/footer.html">
</body>
</html>
