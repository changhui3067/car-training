function checkform() {
    return true;
}

function categoryClicked(that){
    if($(that).hasClass('checked')){
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
    $('span.checkBox.checked').each(function (index, element) {
        businessCategoryValue += (businessCategoryValue === '') ? $(this).val() : (','+$(this).val());
    });
    $("input[name='autobot.businessCategory']").val(businessCategoryValue);
    // var url = "/backend/autobotCompleteResume/save";
    var url = "/website/completeInfo/save";
    var form_data = $("#form1").serialize();

    //validate if any required field is null
    if(form_data.indexOf('=&')>0) {
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
            alert(data.msg);
            window.location.href = "/website/completeInfo";
        }
    });
}

// Picture
var BLANK_IMG_URL = "/assets/website/images/blank.jpg";
function showCrop(url) {
    if (!!window.cropper && !!url) { // reset url
        cropper.replace(url);
        $("#save_btn").removeClass("disabled");
    } else if (!!window.cropper) { //second open reset url
        cropper.replace(BLANK_IMG_URL);
    } else {//first open need init
        var image = document.getElementById('cropperimg');
        image.src = BLANK_IMG_URL;
        cropper = new Cropper(image, {
            aspectRatio: 1,
            toggleDragModeOnDblclick: false,
            zoomable: false,
            movable: false,
            minCropBoxWidth: 100,
            minCropBoxHeight: 100,
            dragMode: 'none',
            checkCrossOrigin: true,
            autoCrop: true
        });
    }
}

$("#myModal").on("shown.bs.modal", function () {
    showCrop();
    $("#save_btn").addClass("disabled");
});

function save() {
    var url = cropper.getCroppedCanvas().toDataURL();
    $("[name='workPhotoURL1']").val(url);
    $("#workPhotoURL1_show").attr("src", url);
    $('#myModal').modal('hide');
}

function selectImage(file) {
    if (file.files && file.files[0]) {
        var reader = new FileReader();
        reader.onload = function (evt) {
            showCrop(evt.target.result);
        };
        reader.readAsDataURL(file.files[0]);
    }
}

// function checkform(){
//     // var name = $("[name='trainer.userCenter.name']").val();
//     // var education = $("[name='trainer.education']").val();
//     // var birthday = $("[name='trainer.userCenter.birthday']").val();
//     // var marryStatus = $("[name='trainer.userCenter.marryStatus']").val();
//     // var mobile = $("input[name='trainer.userCenter.mobile']").val();
//     // var intro = $("[name='trainer.userCenter.intro']").val();
//     // var mainCourse = $("[name='trainer.mainCourse']").val();
//     //
//     // if(name == undefined || education == undefined || birthday == undefined || marryStatus == undefined || mobile == undefined || intro == undefined || mainCourse == undefined){
//     //     alert("带*的为必填字段 ");
//     //     return false;
//     // }
//     // if(name == '' || education == '' || birthday == '' || marryStatus == '' || mobile == '' || intro == '' || mainCourse == ''){
//     //     alert("带*的为必填字段 ");
//     //     return false;
//     // }
//     //
//     return true;
// }
//
// function categoryClicked(that){
//     if($(that).hasClass('checked')){
//         $(that).removeClass('checked');
//     } else {
//         $(that).addClass('checked');
//     }
// }
//
// var image = '';
// function selectImage(file){
//     if(!file.files || !file.files[0]){
//         return;
//     }
//
//     var reader = new FileReader();
//     reader.onload = function(evt){
//         if(file.name=='headLogo'){
//             document.getElementById('trainer.userCenter.headLogo').src = evt.target.result;
//         }
//
//         image = evt.target.result;
//     }
//     reader.readAsDataURL(file.files[0]);
// }
//
// function submitdata() {
//     if (!checkform()) {
//         return;
//     }
//     var businessCategoryValue = '';
//     $('span.checkBox.checked').each(function (index, element) {
//         businessCategoryValue += (businessCategoryValue === '') ? $(this).val() : (','+$(this).val());
//     });
//     $("input[name='autobot.businessCategory']").val(businessCategoryValue);
//     var url = "/backend/autobotCompleteResume/save";
//     var form_data = $("#form1").serialize();
//
//     //validate if any required field is null
//     if(form_data.indexOf('=&')>0) {
//         $('.errMsg')[0].innerHTML = '必填项不能为空';
//         return;
//     } else {
//         $('.errMsg')[0].innerHTML = '';
//     }
//
//     $.ajax({
//         type: "POST",
//         url: url,
//         data: form_data,
//         error: function (request) {
//             alert("网络出错啦！");
//             return false;
//         },
//         success: function (data) {
//             alert(data.msg);
//             window.location.href = "/backend/autobotCompleteResume";
//         }
//     });
// }


// function submitdata(){
//
//     if(!checkform()){
//         return;
//     }
//     var form_data = {};
//     var url  = "/backend/trainerCompleteResume/save";
//
//     var uheadLogo = document.getElementById('trainer.userCenter.headLogo').src;
//     var upersonalType = $("[name='trainer.userCenter.personalType']").val();
//     var tid = $("[name='trainer.id']").val();
//     var uid = $("[name='trainer.userCenter.id']").val();
//     var uname = $("[name='trainer.userCenter.name']").val();
//     var ubirthday = $("[name='trainer.userCenter.birthday']").val();
//     var uemail = $("[name='trainer.userCenter.email']").val();
//     var uregionId = $("[name='city']").val();
//     var umarryStatus = $("[name='trainer.userCenter.marryStatus']").val();
//     var umobile = $("input[name='trainer.userCenter.mobile']").val();
//     var autoYears = $("[name='trainer.autoYears']").val();
//     var education = $("[name='trainer.education']").val();
//     var intro = $("[name='trainer.userCenter.intro']").val();
//     var mainCourse = $("[name='trainer.mainCourse']").val();
//     var businessCategory = '';
//     $("input:checkbox[name='trainer.businessCategory']:checked").each(function(index, element) {
//         businessCategory += $(this).val() + ",";
//     });
//     var executionCategory = '';
//     $("input:checkbox[name='trainer.executionCategory']:checked").each(function(index, element) {
//         executionCategory += $(this).val() + ",";
//     });
//     var vedioURL1 = $("[name='trainer.vedioURL1']").val();
//     var vedioURL2 = $("[name='trainer.vedioURL2']").val();
//
//     form_data.tid = tid;
//     form_data.uid = uid;
//     form_data.uname = uname;
//     form_data.uheadLogo= uheadLogo;
//     form_data.ubirthday = ubirthday;
//     form_data.umarryStatus = umarryStatus;
//     form_data.education = education;
//     form_data.umobile = umobile;
//     form_data.uemail= uemail;
//     form_data.uregionId=uregionId;
//     form_data.autoYears =autoYears;
//     form_data.mainCourse =mainCourse;
//     form_data.intro =intro;
//     form_data.upersonalType = upersonalType;
//     form_data.vedioURL1 = vedioURL1;
//     form_data.vedioURL2 = vedioURL2;
//     form_data.businessCategory = businessCategory;
//     form_data.executionCategory = executionCategory;
//
//     $.ajax({
//         type: "POST",
//         url: url,
//         data: form_data,
//         error: function(request) {
//             alert("网络出错啦！");
//             return false;
//         },
//         success: function (data) {
//             alert(data.msg);
//             var tid = $("[name='trainer.id']").val();
//             if(tid != undefined && tid != ""){
//                 window.location.href = "/backend/trainerCompleteResume";
//             }
//         }
//     });
// }
//
// function selectCities(){
//     var form_data={};
//     form_data.parentId = $("[name='province']").val();;
//     $.ajax({
//         type: "POST",
//         url: "/backend/regions/getCities",
//         data: form_data,
//         error: function(request) {
//             showErrMsg("网络出错啦！");
//             return false;
//         },
//         success: function (data) {
//             $("#city").get(0).options.length=data.cities.length+1;
//             for(var i=0;i<data.cities.length;i++)
//             {
//                 $("#city").get(0).options[i+1]=new Option(data.cities[i].name,data.cities[i].id);
//             }
//
//         }
//     });
// }
