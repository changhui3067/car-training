<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>培聘网</title>
<link rel="stylesheet" href="/assets/website/backend/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/assets/website/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/assets/website/css/bootstrap.min.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/assets/website/css/completeInfo.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/assets/website/backend/css/laydate.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/assets/website/backend/css/date-molv.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/assets/website/css/cropper.css" type="text/css" media="screen"/>

</head>

<body>
<#include "/assets/website/common/header.html">
<!-- main开始 -->
<div class="main">
	<div class="content">
	    <div class="pxshi_gl">
	    	<#include "/resources/view/website/trainerManager.ftl">

	        <#if Session?exists && '{}' != '${session}' && Session["loginVO"]?? && Session["loginVO"].userType=='TRAINER'>
	        </#if>
		</div>
	</div>
	<div class="clear"></div>
</div>
<#include "/assets/website/backend/common/footer.html">

<script src="/assets/website/js/completeInfo.js" type="text/javascript"></script>
<script src="/assets/website/js/region.js" type="text/javascript"></script>
<script src="/assets/website/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="/assets/website/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/assets/website/js/laydate.js" type="text/javascript"></script>
<script src="/assets/website/backend/js/common.js" type="text/javascript"></script>
<#include "/assets/website/common/mycropper.html">

</body>
</html>
