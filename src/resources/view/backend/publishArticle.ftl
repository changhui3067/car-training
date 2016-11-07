<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value='/assets/website/backend/css/style.css'/>" type="text/css" media="screen" />
<script src="<@url value='/assets/website/js/jquery-1.8.0.min.js'/>" ></script>
</head>

<body>
<#include "/assets/website/common/header.html">
	
<!-- main开始 -->
<div class="main">
	<div class="content">
    <div class="dq_box">
    <div class="dqwz left">当前位置 : <a href="#">首 页</a> > <a href="#">企业管理中心</a> > <a href="#">发布文章</a></div>
    <div class="wdcf right"><span color="#FF66001"><#if Session?exists && Session["userDetails"].wealthStartDate??> ${Session["userDetails"].wealthStartDate!?string("dd/MM/yyyy")}—${Session["userDetails"].wealthEndDate!?string("dd/MM/yyyy")}</#if></span>我的财富：<font color="#FF66001"><#if Session?exists && Session["userDetails"]??> ${Session["userDetails"].wealth!}</#if></font></div><div class="clear"></div>
    </div>
    <div class="pxshi_gl">
    	<div class="pxshi_gl_l left">
        
        <#include "/assets/website/backend/common/menu.html">
        
        <div class="pxshi_gl_r right">
        
        <form action=""  id="form1">
        <input type="hidden" name="trainer.id" id="trainer.id" value="<#if trainer??>${trainer.id!}</#if>"/>
       	  <div class="pxshijl">
               	  <h5>发布文章</h5>
                    <div class="pxshijl_box">
                   	 <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
			  <tr>
			    <td width="79" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 标题：</td>
			    <td width="721"><input type="text" name="trainerEssay.title" id="trainerEssay.title" style="width:500px;"/></td>
			  </tr>
			
			  <tr>
			    <td height="150" align="right" valign="top"><font color="#ff0000">*</font> 文章内容：</td>
			    <td align="left" valign="top"><textarea style="width:500px;" name="trainerEssay.content" id="trainerEssay.content" cols="45" rows="8"></textarea></td>
			  </tr>
			</table>
            </div>
          </div>
          
          <div class="tj">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="60" align="center" valign="middle"><img onclick="submitdata()"  src="http://obu3flkwk.bkt.clouddn.com/backend/images/fb.jpg" /></td>
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
function submitdata(){
	var form_data = {};
	var url  = "/backend/publishArticle/save";

	var tid = $("[name='trainer.id']").val();
	var title = $("[name='trainerEssay.title']").val();
	var content = $("[name='trainerEssay.content']").val();
	
	if(title == undefined || content == undefined){
		alert("带*的为必填字段 ");
		return false;
	}
	if(title == "" || content == ""){
		alert("带*的为必填字段 ");
		return false;
	}
	form_data.id = tid;
	form_data.title = title;
	form_data.content = content;
	
	$.ajax({
			 type: "POST",
		     url: url,
		     data: form_data,
		     error: function(request) {
	             showErrMsg("网络出错啦！");
	             return false;
	         },
		     success: function (data) {
					 showErrMsg("添加成功！");
					 window.location.href = "/backend/articleManage";

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
