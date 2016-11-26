<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="/assets/website/css/style.css" type="text/css" />

</head>

<body>
<#include "/assets/website/common/header.html">	
	
<!-- main开始 -->
<div class="main">
	<div class="content">
    <div class="denglu">
    	<div class="links">
		<div class="linksTop">
			<ul id="tags1">
				<li class="cn" onclick="selectTag('item_con_0',this)">个人登陆</li>
				<li onclick="selectTag('item_con_1',this)">企业登陆</li>
			</ul>
		</div>
		<div class="linksmain" id="item_con">
		<span class="errMsg" style="display:block; padding-left:166px;line-height: 40px;"></span>
			<div id="item_con_0">
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <form action="" id="loginform0">
                <tr>
                  <td width="106" height="60" align="right" valign="middle"><font color="#ff0000">*</font>个人账号：</td>
                  <td colspan="2"><input style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="text" name="gr_username" id="gr_username"  placeholder="请输入11位手机号" required/></td>
                  <td width="282"><font color="#999999">请输入您的账号</font></td>
                </tr>
                <tr>
                  <td height="60" align="right" valign="middle"><font color="#ff0000">*</font>密码：</td>
                  <td colspan="2"><input  style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="password" name="gr_password" id="gr_password" placeholder="请输入6-16位字母、数字组成的登录密码" required/></td>
                  <td><font color="#999999">6~16个字符，包含字母，数字，特殊符号</font></td>
                </tr>
                
                
                <tr>
                  <td height="80" colspan="4" align="center" valign="middle"><img src="http://obu3flkwk.bkt.clouddn.com/backend/images/denglu.jpg" onclick="gr_login()"></td>
                </tr>
                </form>
              </table>
			</div>
			<div id="item_con_1" style="display:none">
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <form action="" id="loginform1">
                <tr>
                  <td width="106" height="60" align="right" valign="middle"><font color="#ff0000">*</font>企业账号：</td>
                  <td colspan="2"><input style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="text" name="qy_username" id="qy_username"  placeholder="请输入11位手机号" required/></td>
                  <td width="282"><font color="#999999">请输入您的账号</font></td>
                </tr>
                <tr>
                  <td height="60" align="right" valign="middle"><font color="#ff0000">*</font>密码：</td>
                  <td colspan="2"><input  style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="password" name="qy_password" id="qy_password" placeholder="请输入6-16位字母、数字组成的登录密码" required/></td>
                  <td><font color="#999999">6~16个字符，包含字母，数字，特殊符号</font></td>
                </tr>
                <tr>
                  <td height="80" colspan="4" align="center" valign="middle"><img src="http://obu3flkwk.bkt.clouddn.com/backend/images/denglu.jpg" onclick="qy_login()"></td>
                </tr>
               </form>
              </table>
			</div>
			
		</div>
	</div>
    </div>
    </div>
</div>


<!-- main结束 -->
<#include "/assets/website/common/footer.html">
<script type="text/javascript" src="/assets/website/backend/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/assets/website/backend/js/common.js"></script>
<script>
    function gr_login(){
		var form_data={};
		var username = $("#gr_username").val();
		var password = $("#gr_password").val();
		var userType = 'PERSONAL';
		if(username==''||username==null){
			alert('请输入用户名');
			return false;
		}
		if(password==''||password==null){
			alert('请输入密码');
			return false;
		}
		if(userType==''||userType==null){
			alert('请选择用户登陆类型');
			return false;
		}
		
		form_data.username = username;
		form_data.password = password;
		form_data.userType = userType;
		$.ajax({
			 type: "POST",
		     url: "/backend/login/login",
		     data: form_data,
		     error: function(request) {
	             showErrMsg("网络出错啦！");
	             return false;
	         },
		     success: function (data) {
		    	 if(data.code==200){
					 //showErrMsg("登录成功！");
					 if(data.target == "" || data.target == null){
					 	setTimeout(function(){
			     	 			window.location.href = "/backend/applyJobHistory";
			     	 		},300);
					 }else{
					 	setTimeout(function(){
			     	 			window.location.href = data.target;
			     	 		},300);
					 }
		    	 }else if(data.code==400){
		    	 	 showErrMsg(data.msg);
		    	 	 return false;
		    	 }else{
		    	 	 return false;
		    	 }
		     }
		});
    }
    
    function qy_login(){
		var form_data={};
		var username = $("#qy_username").val();
		var password = $("#qy_password").val();
		var userType = 'COMPANY';
		if(username==''||username==null){
			alert('请输入用户名');
			return false;
		}
		if(password==''||password==null){
			alert('请输入密码');
			return false;
		}
		if(userType==''||userType==null){
			alert('请选择用户登陆类型');
			return false;
		}
		
		form_data.username = username;
		form_data.password = password;
		form_data.userType = userType;
		$.ajax({
			 type: "POST",
		     url: "/backend/login/login",
		     data: form_data,
		     error: function(request) {
	             showErrMsg("网络出错啦！");
	             return false;
	         },
		     success: function (data) {
		    	 if(data.code==200){
					 //showErrMsg("登录成功！");
					 if(data.target == "" || data.target == null){
					 	setTimeout(function(){
			     	 			window.location.href = "/backend/companyJobManage";
			     	 		},300);
					 }else{
					 	setTimeout(function(){
			     	 			window.location.href = data.target;
			     	 		},300);
					 }
		    	 }else if(data.code==400){
		    	 	 showErrMsg(data.msg);
		    	 	 return false;
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
</body>
</html>
