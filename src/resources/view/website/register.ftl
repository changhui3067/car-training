<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="/assets/website/css/style.css" type="text/css" />
<link rel="stylesheet" href="/assets/website/css/bootstrap.min.css" type="text/css" />

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
			<ul id="tags1" class="mb0">
				<li class="cn" onclick="selectTag('item_con_0',this)">个人注册</li>
				<li onclick="selectTag('item_con_1',this)">企业注册</li>
			</ul>
		</div>
		<div class="linksmain" id="item_con">
			<div id="item_con_0">
			  <div action="" id="personal_loginform">
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
                      <input type="button" id="personal" value="免费获取验证码" onclick="sendmsg(this)" style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:120px;" /></td>
                  <td><font color="#999999">请输入手机验证码</font></td>
                </tr>
                <tr>
                    <td colspan="2">
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
                  <td height="80" colspan="4" align="center" valign="middle"><button id="personal" class="btn btn-info" onClick='register(this.id)'>提 交</button></td>
                </tr>
              </table>
              </div>
			</div>
			<div id="item_con_1" style="display:none">
			  <div action="" id="company_loginform">
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
                   <input type="button" id="company" style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:120px;" value="免费获取验证码" onclick="sendmsg(this)" /></td>
                  <td><font color="#999999">请输入手机验证码</font></td>
                </tr>
                <tr>
                	<td colspan="2">
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
                  <td height="80" colspan="4" align="center" valign="middle"><button id="company" class="btn btn-info" onClick='register(this.id)'>提 交</button></td>
                </tr>
              </table>
              </div>
			</div>
			
		</div>
	</div>
        
        </div>
        <div class="zc_r right">已有培聘账号？<a href="<@url value='/website/index'/>">立即登录</a>。</div>
        <div class="clear"></div>
    </div>
    </div>
</div>
<!-- main结束 -->
<#include "/assets/website/common/footer.html">
<script src="/assets/website/js/jquery-3.1.1.min.js"></script>
<script src="/assets/website/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/assets/website/js/common.js"></script>
<script type="text/javascript" src="/assets/website/js/Util.js"></script>  
<script>
var phoneReg = /^1[3|4|5|7|8][0-9]{9}$/, //手机验证规则
    passwordReg = /^.{6,12}$/;
function register(id){
	var form_data={},
	    errMsg = $("#" + id + "_loginform .errMsg")[0];
	  form_data["username"] = $("#" + id + "_loginform #username").val(),
    form_data["password"] = $("#" + id + "_loginform #password").val(),
    form_data["vercode"] = $("#" + id + "_loginform #verCode").val(),
    form_data["userType"] = $("input[name=\'" + id + "Type\']:checked").val();
	var comfirmPassword = $("#" + id + "_loginform #confirmPassword").val();
	
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
	if(!form_data.userType){
		errMsg.innerHTML = "请选择注册类型";
		return false;
	}
	$.ajax({
		type: "POST",
	    url: "/backend/UserCenter/register",
	    data: form_data,
        error: function(request) {
            Util.msgToast({
                message: '请求失败',
                mode: Util.MSGTYPE.ERROR
            });
            return false;
         },
	      success: function (data) {
          if(data.error){
            errMsg.innerHTML = data.error;
          } else if(data.target){
            window.location.href = data.target;
          } else {
				 	  window.location.href = "/backend/applyJobHistory";
				  }
	     }
	});
}
  
 function sendmsg(obj){
	var form_data={},
      errMsg = $("#" + obj.id + "_loginform .errMsg")[0];
  form_data["username"] = $("#" + obj.id + "_loginform #username").val();
//	if(!form_data.username){
////    errMsg.innerHTML = "请输入手机号";
//		return false;
//	}
  settime(obj);
	$.ajax({
		 type: "POST",
	     url: "/backend/UserCenter/sendmsgForRegister",
	     data: form_data,
	     error: function(request) {
	         Util.msgToast({
               message: '请求失败',
               mode: Util.MSGTYPE.ERROR
           });
	         return false;
	     },
	     success: function (data) {
             Util.msgToast({
                 message: '发送成功',
                 mode: Util.MSGTYPE.SUCCESS
             });
	     }
	});
}
</script>
</body>
</html>
