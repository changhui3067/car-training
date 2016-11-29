function checkform() {
    return true;
}

function categoryClicked(that) {
    if ($(that).hasClass('checked')) {
        $(that).removeClass('checked');
    } else {
        $(that).addClass('checked');
    }
}

function submitdata() {
    if (!checkform()) {
        return;
    }
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
    var form_data = $("#form1").serialize();

    //validate if any required field is null
    if (form_data.indexOf('=&') > 0) {
        $('.errMsg')[0].innerHTML = '必填项不能为空';
        return;
    } else {
        $('.errMsg')[0].innerHTML = '';
    }

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


function filter4Clicked(ele, name) {
    console.log($('#city button').val());
}