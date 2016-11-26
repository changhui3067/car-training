<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#escape x as x?html><html>
<head>
    <title>培聘网</title>
    <link rel="stylesheet" href="/assets/website/css/style.css?v=1.1.0" type="text/css"/>
    <link rel="stylesheet" href="/assets/website/css/bootstrap.min.css?v=1.1.0" type="text/css"/>
</head>
<body>
<#include "/assets/website/common/header.html">
<div class="main">
    <div class="content">
            <div class="forgetPsd">
                <div>
                    <div class="form-group row">
                        <label  class="col-sm-2 control-label">账号：</label>
                        <div class="col-sm-5">
                            <input class="form-control text-size" id="username" name="username" placeholder="请输入找回密码的手机号"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label">验证码：</label>
                        <div class="col-sm-3">
                            <input class="form-control text-size" type="vercode" name="vercode" id="vercode" placeholder="请输入密码"/>
                        </div>
                        <div class="col-sm-2">
                          <input type="button" class="btn btn-default active" value="获取验证码" onClick="sendMsg(this)"></input>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label">新密码：</label>
                        <div class="col-sm-5">
                            <input class="form-control text-size" type="password" name="password" id="password" placeholder="请输入新密码"/>
                        </div>
                    </div>
                    <div>
                        <div class="errMsg"></div>
                    </div>
                    <div class="form-group row" id="submit">
                        <div class="col-sm-offset-2 col-sm-10">
                          <button type="submit" class="btn btn-info" onClick="resetPsd()">提  交</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
    </div>
</div>
<#include "/assets/website/common/footer.html">
<script src="<@url value="/assets/website/js/jquery-3.1.1.min.js"/>"></script>
<script src="<@url value="/assets/website/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="/assets/website/js/common.js"></script>
<script type="text/javascript">
    var phoneReg = /^1[3|4|5|7|8][0-9]{9}$/;
    function sendMsg (obj) {
        var form_data={},
            errMsg = $(".errMsg")[0];
        form_data["username"] = $(".forgetPsd #username").val();
        if(form_data.username == "" || form_data.username == null){
            errMsg.innerHTML = "请输入用户名";
            return false;
        }else if(!phoneReg.test(form_data.username)){
            errMsg.innerHTML = "手机格式不正确";
            return false;
        }
        settime(obj);
        $.ajax({
            type: "POST",
            url: "/backend/UserCenter/sendmsgForResetPassword",
            data: form_data,
            error: function(request) {
                errMsg.innerHTML = "网络出错啦!";
                return false;
            },
            success: function (data) {
                if (data.error) {
                    errMsg.innerHTML = data.error;
                    return false;
                }
            }
        });
    }

    function resetPsd () {
        var form_data={},
            errMsg = $(".errMsg")[0];
        form_data["username"] = $(".forgetPsd #username").val(),
        form_data["vercode"] = $(".forgetPsd #vercode").val()
        form_data["password"] = $(".forgetPsd #password").val();
        if(form_data.username == "" || form_data.username == null){
            errMsg.innerHTML = "请输入用户名";
            return false;
        }else if(!phoneReg.test(form_data.username)){
            errMsg.innerHTML = "手机格式不正确";
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/backend/UserCenter/resetPassword",
            data: form_data,
            error: function(request) {
                errMsg.innerHTML = "网络出错啦!";
                return false;
            },
            success: function (data) {
                if (data.error) {
                    errMsg.innerHTML = data.error;
                } if(data.target){
                    window.location.href = data.target;
                } else {
                    window.location.href = "/backend/applyJobHistory";
                }
            }
        });
    }
</script>
</body>
</html></#escape>