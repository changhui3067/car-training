// JavaScript Document

//注册选项卡切换
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


//点赞   author: Xiu  
function like(prix, id) {
	var dom = $(prix + " #" + id),
		number = new Number(dom[0].childNodes[1].innerHTML),
		data = {};
		data["targetUserId"] = dom[0].getAttribute("value");
	if (dom.hasClass("unLike")) {
		dom.removeClass("unLike");
		dom[0].childNodes[1].innerHTML = number + 1;
		$.ajax({
	        type: "POST",
	        url: "/backend/Like/like",
	        data: data,
	        error: function() {
	            return false;
	        },
	        success: function (data) {
	        	return true;
	        }
	    });
	} else {
		dom.addClass("unLike");
		dom[0].childNodes[1].innerHTML = number - 1;
		$.ajax({
	        type: "POST",
	        url: "/backend/Like/unLike",
	        data: data,
	        error: function() {
	            return false;
	        },
	        success: function (data) {
	        	return true;
	        }
	    });
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

//点赞
function guarantee(id) {
	var dom = $("#" + id),
		data = {};
		data["companyId"] = dom[0].getAttribute("value");
	if (dom.hasClass("guarantee")) {
		dom.removeClass("guarantee");
		$.ajax({
	        type: "POST",
	        url: "/backend/Guarantee/unGuarantee",
	        data: data,
	        error: function() {
	            return false;
	        },
	        success: function (result) {
	        	$(".companyGuaranteeList")[0].innerHTML = result;
	        	return true;
	        }
	    });
	} else {
		dom.addClass("guarantee");
		$.ajax({
	        type: "POST",
	        url: "/backend/Guarantee/guarantee",
	        data: data,
	        error: function() {
	            return false;
	        },
	        success: function (result) {
	        	$(".companyGuaranteeList")[0].innerHTML = result;
	        	return true;
	        }
	    });
	}
}

//评论
function addComment (id) {
    var data = {};
    data["content"] = $("#add_comment").val(),
    data["targetId"] = id;
    if (data.content) {
        $.ajax({
            type: "POST",
            url: "/backend/Comment/addComment",
            data: data,
            error: function() {
                return false;
            },
            success: function (result) {
                $(".people_comments_list")[0].innerHTML = result;
                return true;
            }
        });
    }
}


function addNewJob(e) {
	e.preventDefault();
    $("input[name='businessCategory']").val($('#inputType').val());
    $("input[name='educationRequirement']").val($('#inputEducationRequired').val());

    var form_data = $("#newJobForm").serialize();
    console.log(form_data);
    var url = "/backend/publishJobHistory/add"

    $.ajax({
        type: "POST",
        url: url,
        data: form_data,
        cache: false,
        error: function (request) {
            alert("网络出错啦！");
            return false;
        },
        success: function (data) {
            $('#manageCenterContent').innerHTML = data;
            //window.location.href = "/backend/autobotCompleteResume";
        }
    });
};