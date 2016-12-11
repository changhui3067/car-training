// JavaScript Document
//网站头部导航js切换
$(document).ready(function() {
    if(document.getElementById("headerMenu")) {
        var selectedTabIndex = $("input[name='currLocation']").val();
        if(selectedTabIndex>=0){
            var selectedTab = $('.menu li')[selectedTabIndex];
            $(selectedTab).addClass('cn');
            $(selectedTab).siblings().removeClass('cn');
        } else {
            $('.menu li').removeClass('cn');
        }
    }
});

//尾部友情链接选项卡切换
function selectTag(showContent,selfObj){
	if(document.getElementById("tags1")){
		var tag = document.getElementById("tags1").getElementsByTagName("li");
		var taglength = tag.length;
		for(i=0; i<taglength; i++){
			tag[i].className = "";
		}
		selfObj.className = "cn";
		for(i=0; j=document.getElementById("item_con_"+i); i++){
			j.style.display = "none";
		}
		document.getElementById(showContent).style.display = "block";
	}
}

//倒计时
var countdown=60;
function settime(obj) {
    if (countdown == 0) {
        obj.removeAttribute("disabled");
        obj.value="免费获取验证码";
        countdown = 60;
        return;
    } else {
        obj.setAttribute("disabled", true);
        obj.value="重新发送(" + countdown + ")";
        countdown--;
    }
    setTimeout(function() {
        settime(obj)},1000)
}


//点赞   author: Xiu
function like(prix, id) {
    var dom = $(prix + " #" + id);
    if (dom[0].getAttribute("value") === "true") {
        var number = new Number(dom[0].childNodes[1].innerHTML),
            data = {};
        data["targetUserId"] = id;
        if (dom[0].childNodes[0].className === "iconfont icon-good") {
            $.ajax({
                type: "POST",
                url: "/backend/Like/like",
                data: data,
                error: function() {
                    Util.msgToast({
                        message: '请求失败',
                        mode: Util.MSGTYPE.ERROR
                    });
                    return false;
                },
                success: function (data) {
                    if (data.error) {
                        Util.msgToast({
                            message: data.error,
                            mode: Util.MSGTYPE.ERROR
                        });
                        return false;
                    }
                    dom[0].childNodes[0].className = "iconfont icon-icon02";
                    dom[0].childNodes[1].innerHTML = number + 1;
                    return true;
                }
            });
        } else {
            $.ajax({
                type: "POST",
                url: "/backend/Like/unLike",
                data: data,
                error: function() {
                    Util.msgToast({
                        message: '请求失败',
                        mode: Util.MSGTYPE.ERROR
                    });
                    return false;
                },
                success: function (data) {
                    if (data.error) {
                        Util.msgToast({
                            message: data.error,
                            mode: Util.MSGTYPE.ERROR
                        });
                        return false;
                    }
                    dom[0].childNodes[0].className = "iconfont icon-good";
                    dom[0].childNodes[1].innerHTML = number - 1;
                    return true;
                }
            });
        }
    }
    
}

//点赞
function guarantee(prix, id) {
    var dom = $(prix + " #" + id);
    if (dom[0].getAttribute("value") === "true") {
        if ($("#companyGuarateeNumber")[0]) {
            var number = new Number($("#companyGuarateeNumber")[0].innerHTML)
        }
        var data = {};
        data["companyId"] = id;
        if (dom.hasClass("guarantee")) {
            $.ajax({
                type: "POST",
                url: "/backend/Guarantee/unGuarantee",
                data: data,
                error: function() {
                    Util.msgToast({
                        message: '请求失败',
                        mode: Util.MSGTYPE.ERROR
                    });
                    return false;
                },
                success: function (result) {
                    if (result.actionErrors) {
                        Util.msgToast({
                            message: '操作失败',
                            mode: Util.MSGTYPE.ERROR
                        });
                        return false;
                    }
                    dom.removeClass("guarantee");
                    if ($("#companyGuarateeNumber")[0]) {
                        $("#companyGuarateeNumber")[0].innerHTML = number - 1;
                    }
                    $(".companyGuaranteeList")[0].innerHTML = result;
                    return true;
                }
            });
        } else {
            $.ajax({
                type: "POST",
                url: "/backend/Guarantee/guarantee",
                data: data,
                error: function() {
                    Util.msgToast({
                        message: '请求失败',
                        mode: Util.MSGTYPE.ERROR
                    });
                    return false;
                },
                success: function (result) {
                    if (result.actionErrors) {
                        Util.msgToast({
                            message: '操作失败',
                            mode: Util.MSGTYPE.ERROR
                        });
                        return false;
                    }
                    dom.addClass("guarantee");
                    if ($("#companyGuarateeNumber")[0]) {
                        $("#companyGuarateeNumber")[0].innerHTML = number + 1;
                    }
                    $(".companyGuaranteeList")[0].innerHTML = result;
                    return true;
                }
            });
        }
    }
}

//评论
function addComment (id) {
    if ($(".add_comment_box button")[0].getAttribute("value") === "true") {
        var data = {},
            number = new Number($("#commentNumber")[0].innerHTML);
        data["content"] = $("#add_comment").val(),
        data["targetId"] = id;
        if (data.content) {
            $.ajax({
                type: "POST",
                url: "/backend/Comment/addComment",
                data: data,
                error: function() {
                    Util.msgToast({
                        message: '请求失败',
                        mode: Util.MSGTYPE.ERROR
                    });
                    return false;
                },
                success: function (result) {
                    if (result.actionErrors) {
                        Util.msgToast({
                            message: '操作失败',
                            mode: Util.MSGTYPE.ERROR
                        });
                        return false;
                    }
                    $("#commentNumber")[0].innerHTML = number + 1;
                    scrollTo(0,0);
                    $("#add_comment").val('')
                    $(".people_comments_list")[0].innerHTML = result;
                    return true;
                }
            });
        }
    }
}

function addNewJob(e) {
    e.preventDefault();
    //$("input[name='businessCategory']").val($('#inputType').val());
    $("input[name='educationRequirement']").val($('#inputEducationRequired').val());

    if(!$('#inputTitle').val()) {
        $('#newJobErr').css('display','inline-block');
        return;
    }
    //var reg = /^\d+$/;
    //if($('#inputExperienceRequirement').val() &&){
    //
    //}
    var form_data = $("#newJobForm").serialize();
    console.log(form_data);
    var url = "/backend/publishJobHistory/add"

    $.ajax({
        type: "POST",
        url: url,
        data: form_data,
        cache: false,
        error: function (request) {
            Util.msgToast({
                message: '请求失败',
                mode: Util.MSGTYPE.ERROR
            });
            return false;
        },
        success: function (data) {
            if (data.errors) {
                $('#newJob').modal('hide');
                Util.msgToast({
                    message: data.errors,
                    mode: Util.MSGTYPE.ERROR
                });
                return false;
            }
            $('#newJob').modal('hide');
            navigate("companyRecord");
            //$('#manageCenterContent').innerHTML = data;
            //window.location.href = "/backend/autobotCompleteResume";
        }
    });
};

function modifyPassword(){
    var form_data={},
        errMsg = $(".errMsg")[0],
        passwordReg = /^[\S]{6,12}$/;
    form_data["oldPassword"] = $("#oldpasswd").val(),
    form_data["password"] = $("#newpasswd").val();
    var confirmPsd = $("#confirmPsd").val();
    if(!passwordReg.test(form_data.oldPassword) || !passwordReg.test(form_data.password)){
        errMsg.innerHTML = '密码格式不正确';
        return false;
    }
    if(!form_data.oldPassword){
        errMsg.innerHTML = '请输入原始密码';
        return false;
    }
    if(!form_data.password){
        errMsg.innerHTML = '请输入新密码';
        return false;
    }
    if(!confirmPsd){
        errMsg.innerHTML = '请输入确认密码';
        return false;
    }
    if(form_data.password !== confirmPsd){
        errMsg.innerHTML = '请确认新密码';
        return false;
    }
    
    $.ajax({
         type: "POST",
         url: "/backend/userCenter/resetPassword",
         data: form_data,
         error: function(request) {
             Util.msgToast({
                message: '请求失败',
                mode: Util.MSGTYPE.ERROR
            });
             return false;
         },
         success: function (data) {
             errMsg.innerHTML = "密码修改成功!";
         }
    });
}
