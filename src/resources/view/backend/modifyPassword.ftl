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
    <div class="dqwz left">当前位置 : <a href="#">首 页</a> > <a href="#">培训师管理中心</a> > <a href="#">申请记录</a></div>
    <div class="wdcf right"><span color="#FF66001"><#if Session?exists && Session["userDetails"].wealthStartDate??> ${Session["userDetails"].wealthStartDate!?string("dd/MM/yyyy")}—${Session["userDetails"].wealthEndDate!?string("dd/MM/yyyy")}</#if></span>我的财富：<font color="#FF66001"><#if Session?exists && Session["userDetails"]??> ${Session["userDetails"].wealth!}</#if></font></div><div class="clear"></div>
    </div>
    <div class="pxshi_gl">
    	<div class="pxshi_gl_l left">
        
        <#include "/assets/website/backend/common/menu.html">
        <div class="pxshi_gl_r right">
       	  <input type="hidden" name="userType" id="userType" value="${Session["loginType"]!}"/>
          <table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="67" height="80" align="right" valign="middle"><font color="#ff0000">*</font>用户名：</td>
                  <td colspan="2"><input style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="text" name="username" id="username" value="${Session["userDetails"].username}" /></td>
                  <td width="224"><font color="#999999">输入您的账号</font></td>
                </tr>
                <tr>
                  <td height="80" align="right" valign="middle"><font color="#ff0000">*</font>旧密码：</td>
                  <td colspan="2"><input  style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="password" name="oldpasswd" id="oldpasswd" /></td>
                  <td><font color="#999999">请输入旧密码</font></td>
                </tr>
                <tr>
                  <td height="80" align="right" valign="middle"><font color="#ff0000">*</font>新密码：</td>
                  <td colspan="2"><input style="border:1px solid #e7e6eb; height:30px; line-height:30px; width:280px;" type="password" name="newpasswd" id="newpasswd" /></td>
                  <td><font color="#999999">6~16个字符，包含字母，数字，特殊符号</font></td>
                </tr>
                
                <tr>
                  <td height="150" colspan="4" align="center" valign="middle"><img onclick="modifyPassword()" src="http://obu3flkwk.bkt.clouddn.com/backend/images/tj.jpg" /></td>
                </tr>
              </table>
          
      </div>
        <div class="clear"></div>
    
    </div>
    </div>
<script>
function modifyPassword(){
	var form_data={};
	var userType = $("#userType").val();
	var username = $("#username").val();
	var oldpasswd = $("#oldpasswd").val();
	var newpasswd = $("#newpasswd").val();

	if(userType==''||userType==null){
		alert('您 还没有登陆');
		return false;
	}
	if(username==''||username==null){
		alert('请输入用户名');
		return false;
	}
	if(oldpasswd==''||oldpasswd==null){
		alert('请输入原始密码');
		return false;
	}
	if(newpasswd==''||newpasswd==null){
		alert('请输入新密码');
		return false;
	}
	
	form_data.userType = userType;
	form_data.username = username;
	form_data.oldpasswd = oldpasswd;
	form_data.newpasswd = newpasswd;
	
	$.ajax({
		 type: "POST",
	     url: "/backend/modifyPassword/modifypasswd",
	     data: form_data,
	     error: function(request) {
             showErrMsg("网络出错啦！");
             return false;
         },
	     success: function (data) {
				 showErrMsg("密码修改成功！");
				 if(data.target == "" || data.target == null){
				 	setTimeout(function(){
		     	 			window.location.href = "/website/index/logout";
		     	 		},300);
				 }else{
				 	setTimeout(function(){
		     	 			window.location.href = data.target;
		     	 		},300);
				 }

	     }
	});
}
    
function showErrMsg(errMsg){
	alert(errMsg);
}
</script>
<!-- main结束 -->
<#include "/assets/website/backend/common/footer.html">

</body>
</html>
