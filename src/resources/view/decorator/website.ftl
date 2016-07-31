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
    <#if request.requestURI?starts_with('/website/index')>
    <meta name="keyword" content="汽车培聘网-汽车、招聘、培训一站式的服务网站"/>
	<#else>
	<meta name="keyword" content=""/>
    <meta name="Description" content=""/>
    </#if>
    <link href="<@url value="/assets/website/css/jquery.jslides.css?v=1.1.0"/>" type="text/css" rel="stylesheet"  media="screen"/>
    <link href="<@url value="/assets/website/css/pxshi.css?v=1.1.0"/>" type="text/css" rel="stylesheet" />
	<link href="<@url value="/assets/website/css/style.css?v=1.1.0"/>" type="text/css" rel="stylesheet"  media="screen" />	

    <script src="<@url value="/assets/website/js/jquery-1.8.0.min.js?v=1.1.0"/>"></script>
    <script src="<@url value="/assets/website/js/jquery.jslides.js?v=1.1.1"/>"></script>

    <title>汽车培聘网-专业的汽车培训招聘平台</title>
<#noescape>${head}</#noescape>
</head>
<body>

</body>
</html></#escape></#compress>