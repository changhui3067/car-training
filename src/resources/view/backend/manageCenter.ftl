<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>培聘网</title>
<link rel="stylesheet" href="<@url value='/assets/website/backend/css/style.css'/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<@url value="/assets/website/css/bootstrap.min.css?v=1.1.0"/>" type="text/css" media="screen" />
<script src="<@url value="/assets/website/js/jquery-3.1.1.min.js?v=1.1.0"/>"></script>
<script src="<@url value="/assets/website/js/bootstrap.min.js?v=1.1.0"/>"></script>
</head>

<body>
<#include "/assets/website/common/header.html">
<!-- main开始 -->
<div class="main">
	<div class="content">
	    <div class="pxshi_gl">
	        <#if Session?exists && '{}' != '${session}' && Session["loginVO"]?? && Session["loginVO"].userType=='TRAINER'>
	        	<#include "/resources/view/website/trainerManager.ftl">
	        <#elseIf Session?exists && '{}' != '${session}' && Session["loginVO"]?? && Session["loginVO"].userType=='AUTOBOT'>

	        </#if>
		</div>
	</div>
	<div class="clear"></div>
</div>
<#include "/assets/website/backend/common/footer.html">
</body>
</html>
