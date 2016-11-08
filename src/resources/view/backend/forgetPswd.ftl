<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#escape x as x?html><html>
<head>
    <title>培聘网</title>
    <link rel="stylesheet" href="<@url value="/assets/website/css/style.css?v=1.1.0"/>" type="text/css" media="screen" />
    <link rel="stylesheet" href="<@url value="/assets/website/css/bootstrap.min.css?v=1.1.0"/>" type="text/css" media="screen" />
</head>
<body>
<#include "/assets/website/common/header.html">
<div class="main">
    <div class="content">
        <div>
            <div>
                <div class="col-sm-2">个人账号：</div>
                <div class="col-sm-10">
                    <input id="username" name="username" placeholder="请输入手机号"/>
                </div>
            </div>
            <div>
                <div class="col-sm-2">验证码</div>
                <div class="col-sm-5">
                    <input class="verCode" type="text" name="verCode" id="verCode" />
                </div>
                <div class="col-sm-5">
                    <input class="verCodeBtn" type="button" id="personal_msgsend" value="免费获取验证码" onclick="javascript:settime(this);sendmsg(this.id);return false;" />
                </div>
            </div>
            <div class="errMsg"></div>
            <div>提交</div>
        </div>
    </div>
<div class="clear"></div>
</div>
<#include "/assets/website/common/footer.html">
</body>
</html></#escape>