<!DOCTYPE html>
<html>
<#compress><#escape x as x?html>
<head>
<meta charset="utf-8">
<link rel="shortcut icon" href="/assets/website/images/favicon.png" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta name="keyword" content="培聘网 www.peipin.net -汽车、招聘、培训一站式的服务网站"/>
<meta name="Description" content="培聘网 www.peipin.net 汽车、招聘、培训一站式的服务网站"/>
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