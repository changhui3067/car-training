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
<meta name="keyword" content="培聘网-汽车、招聘、培训一站式的服务网站"/>
<#else>
<meta name="keyword" content=""/>
<meta name="Description" content=""/>
</#if>

<title>培聘网-专业的汽车培训招聘平台</title>
<#noescape>${head}</#noescape>
</head>
<body>
<#if action.hasActionMessages() || action.hasActionErrors()>
<@s.actionerror />
<@s.actionmessage />
</#if>
<#noescape>${body}</#noescape>

</body>
</html></#escape></#compress>