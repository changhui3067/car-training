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
            alert("网络出错啦！");
            return false;
        },
        success: function (data) {
            alert(data);
            // window.location.href = "/website/completeInfo";
        }
    });
}