<!DOCTYPE html>
<html>
<#compress><#escape x as x?html>
<head>
<title><#noescape>${title}</#noescape></title>
<meta charset="utf-8">
<link rel="shortcut icon" href="<@url value="/assets/images/favicon.ico"/>" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <#if request.requestURI?starts_with('/website/backend/login')>
    <meta name="keyword" content="汽车培聘网-汽车、招聘、培训一站式的服务网站"/>
	<#else>
	<meta name="keyword" content=""/>
    <meta name="Description" content=""/>
    </#if>
    
    <link href="<@url value="/assets/website/backend/css/jquery.jslides.css?v=1.1.0"/>" type="text/css" rel="stylesheet"  media="screen"/>
    <link href="<@url value="/assets/website/backend/css/pxshi.css?v=1.1.0"/>" type="text/css" rel="stylesheet" />
	<link href="<@url value="/assets/website/backend/css/style.css?v=1.1.0"/>" type="text/css" rel="stylesheet"  media="screen" />	
	<script src="<@url value="/assets/website/backend/js/common.js?v=1.1.1"/>"></script>
    <script src="<@url value="/assets/website/backend/js/jquery-1.8.0.min.js?v=1.1.0"/>"></script>
    <script src="<@url value="/assets/website/backend/js/jquery.jslides.js?v=1.1.1"/>"></script>

    <title>汽车培聘网后台管理</title>
<#noescape>${head}</#noescape>
</head>
<body>
<#if action.hasActionMessages() || action.hasActionErrors()>
<@s.actionerror />
<@s.actionmessage />
</#if>
<#noescape>${body}</#noescape>
<script>
	var _hmt = _hmt || [];
	(function() {
	  var hm = document.createElement("script");
	  var code = '${request.serverName?ends_with('.com')?string('64a5b5c6a1df2d5e2d7adb4b11bd330d','f343ca0459e308819950f55102a4c353')}';
	  hm.src = "//hm.baidu.com/hm.js?"+code;
	  var s = document.getElementsByTagName("script")[0]; 
	  s.parentNode.insertBefore(hm, s);
	})();
</script>
</body>
</html></#escape></#compress>