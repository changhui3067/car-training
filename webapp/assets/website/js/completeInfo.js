function categoryClicked(that) {
    if ($(that).hasClass('checked')) {
        $(that).removeClass('checked');
    } else {
        $(that).addClass('checked');
    }
}

function submitTrainerInfo() {
    var businessCategoryValue = '';
    $('.businessCategoryFather .checked').each(function (index, element) {
        index != 0 ? businessCategoryValue += "," : null;
        businessCategoryValue += element.innerHTML;
    });
    $("input[name='businessCategory']").val(businessCategoryValue);

    var executionCategory = '';
    $('.executionCategoryFather .checked').each(function (index, element) {
        index != 0 ? executionCategory += "," : null;
        executionCategory += element.innerHTML;
    });
    $("input[name='executionCategory']").val(executionCategory);

    var videoInput1 = $("input[name='videoURL1']").val();
    if(!(typeof videoInput1 === "string" && videoInput1.indexOf("http://player.youku.com/player.php/"))) {
        if($(videoInput1)[0] && $(videoInput1)[0].getAttribute('src')){
            $("input[name='videoURL1']").val($(videoInput1)[0].getAttribute('src'));
        } else {
            $('.errMsg')[0].innerHTML = '视频地址格式不对';
            $("input[name='videoURL1']").val();
        }
    }

    var videoInput2 = $("input[name='videoURL2']").val();
    if(!(typeof videoInput2 === "string" && videoInput1.indexOf("http://player.youku.com/player.php/"))) {
        if($(videoInput2)[0] && $(videoInput2)[0].getAttribute('src')){
            $("input[name='videoURL2']").val($(videoInput2)[0].getAttribute('src'));
        } else {
            $('.errMsg')[0].innerHTML = '视频地址格式不对';
            $("input[name='videoURL2']").val();
        }
    }

    // var url = "/backend/autobotCompleteResume/save";
    var url = "/backend/saveInfo";
    var form_data = $("#form1").serialize();

    //validate if any required field is null
    if (form_data.indexOf('=&') > 0) {
        $('.errMsg')[0].innerHTML = '必填项不能为空';
        return;
    } else {
        $('.errMsg')[0].innerHTML = '';
    }

    var introduction = $("#introduction").val();
    var mainCourse = $("mainCourse").val();
    form_data = form_data + "&introduction="+introduction + "&mainCourse="+mainCourse;

    $.ajax({
        type: "POST",
        url: url,
        data: form_data,
        error: function (request) {
            Util.msgToast({
                message: error,
                mode: Util.MSGTYPE.ERROR
            });
        },
        success: function (data) {
            //alert(data);
            Util.msgToast({
                message: '保存成功',
                mode: Util.MSGTYPE.SUCCESS
            });
        }
    });
}

function submitAutobotInfo() {
    var businessCategoryValue = '';
    $('.businessCategoryFather .checked').each(function (index, element) {
        index != 0 ? businessCategoryValue += "," : null;
        businessCategoryValue += element.innerHTML;
    });
    $("input[name='businessCategory']").val(businessCategoryValue);

    var executionCategory = '';
    $('.executionCategoryFather .checked').each(function (index, element) {
        index != 0 ? executionCategory += "," : null;
        executionCategory += element.innerHTML;
    });
    $("input[name='executionCategory']").val(executionCategory);

    // var url = "/backend/autobotCompleteResume/save";
    var url = "/backend/saveInfo";
    var form_data1 = $("#form1").serialize();

    //validate if any required field is null
    if (form_data1.indexOf('=&') > 0) {
        $('.errMsg')[0].innerHTML = '必填项不能为空';
        return;
    } else {
        $('.errMsg')[0].innerHTML = '';
    }

    var certRecords = document.getElementById("certRecords").value;
    var workingHistory = document.getElementById("workingHistory").value;
    var form_data = form_data1 + "&certRecords="+certRecords + "&workingHistory="+workingHistory;

    $.ajax({
        type: "POST",
        url: url,
        data: form_data,
        error: function (request) {
            Util.msgToast({
                message: error,
                mode: Util.MSGTYPE.ERROR
            });
        },
        success: function (data) {
            //alert(data);
            Util.msgToast({
                message: '保存成功',
                mode: Util.MSGTYPE.SUCCESS
            });
        }
    });
}

function submitCompanyInfo() {
    var welfareValue = '';
    $('.welfareBox .checked').each(function (index, element) {
        index != 0 ? welfareValue += "," : null;
        welfareValue += element.innerHTML;
    });
    $("input[name='welfare']").val(welfareValue);

    var url = "/backend/saveInfo";
    var form_data = $("#form1").serialize();

    if (form_data.indexOf('=&') > 0) {
        $('.errMsg')[0].innerHTML = '必填项不能为空';
        return;
    } else {
        $('.errMsg')[0].innerHTML = '';
    }

    var introduction = $("#introduction").val();
    form_data = form_data + "&introduction="+introduction;

    $.ajax({
        type: "POST",
        url: url,
        data: form_data,
        error: function (error) {
            //alert("网络出错啦！");
            Util.msgToast({
                message: error,
                mode: Util.MSGTYPE.ERROR
            });
        },
        success: function (data) {
            //alert(data);
            Util.msgToast({
                message: '保存成功',
                mode: Util.MSGTYPE.SUCCESS
            });
        }
    });
}




function verifyNumber(obj) {
    if (isNaN(obj.value)) {
        alert("行业经验请输入数字");
    }
}