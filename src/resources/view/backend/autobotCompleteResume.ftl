<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <title>培聘网</title>
    <link rel="stylesheet" href="<@url value='/assets/website/backend/css/style.css'/>" type="text/css" media="screen"/>
    <link rel="stylesheet" href="<@url value='/assets/website/backend/css/laydate.css'/>" type="text/css"
          media="screen"/>
    <link rel="stylesheet" href="<@url value='/assets/website/backend/css/date-molv.css'/>" type="text/css"
          media="screen"/>
    <link rel="stylesheet" href="<@url value='/assets/website/backend/css/autobotCompleteResume.css'/>" type="text/css"
          media="screen"/>
    <link rel="stylesheet" href="<@url value='/assets/website/css/bootstrap.min.css'/>" type="text/css" media="screen"/>
    <link rel="stylesheet" href="/assets/website/css/cropper.css" type="text/css" media="screen"/>

</head>

<body>
<#include "/assets/website/common/header.html">

<!-- main开始 -->
<div class="main">
    <div class="content">
        <#--<div class="dq_box">-->
            <#--<div class="dqwz left">当前位置 : <a href="#">首 页</a> > <a href="#">汽车人管理中心</a> > <a href="#">申请记录</a></div>-->
            <#--<div class="wdcf right"><span-->
                    <#--color="#FF66001"><#if Session?? && Session["userDetails"].wealthStartDate??> ${Session["userDetails"].wealthStartDate!?string("dd/MM/yyyy")}-->
                <#--—${Session["userDetails"].wealthEndDate!?string("dd/MM/yyyy")}</#if></span>-->
                <#--我的财富：<font color="#FF66001"><#if Session?? && Session["userDetails"]??> ${Session["userDetails"].wealth!}</#if></font>-->
            <#--</div>-->
            <#--<div class="clear"></div>-->
        <#--</div>-->

        <div class="pxshi_gl">
            <div class="pxshi_gl_l left">

            <#include "/assets/website/backend/common/menu.html">

                <div class="pxshi_gl_r right">
                    <form id="form1">
                        <!--隐藏域-->
                        <input type="hidden" name="upersonalType" value="AUTOBOT">
                        <input type="hidden" name="aid" value="<#if autobot??>${autobot.id!}</#if>">
                        <input type="hidden" name="uid"
                               value="<#if autobot?? && autobot.userCenter??>${autobot.userCenter.id!}</#if>">
                        <!--隐藏域-->
                        <div class="pxshijl">
                            <h5>基本信息</h5>
                            <div class="pxshijl_box">
                                <div class="errMsg"></div>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-sm-7">
                                            <ul class="list-group">
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            姓名:</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"
                                                                   placeholder="请输入姓名"
                                                                   name="uname"
                                                                   value="<#if autobot?? && autobot.userCenter?? && autobot.userCenter.name??>${autobot.userCenter.name!}</#if>"/>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            出生年月:</label>
                                                        <div class="col-sm-9">
                                                            <input type="" class="form-control" name="ubirthday"
                                                                   onclick="laydate()"
                                                                   value="<#if autobot?? && autobot.userCenter?? && autobot.userCenter.name??>${autobot.userCenter.birthday?string("yyyy-MM-dd")!}</#if>"
                                                            />
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            工作状态:</label>
                                                        <div class="col-sm-9">
                                                            <select class="form-control" name="currentWorkStatus">
                                                                <option>在职</option>
                                                                <option>求职</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            婚姻状况:</label>
                                                        <div class="col-sm-9">
                                                            <select class="form-control" name="umarryStatus">
                                                                <option value="UNMARRIED">未婚</option>
                                                                <option value="MARRIED">已婚</option>
                                                                <option value="RAISED">离异</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            行业经验:</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"
                                                                   name="autoYears"
                                                                   placeholder="请输入行业经验"
                                                                   value="<#if autobot?? && autobot.autoYears?? >${autobot.autoYears!}</#if>"/>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            联系方式:</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control" name="umobile"
                                                                   placeholder="请输入联系方式"
                                                                   value="<#if autobot?? && autobot.userCenter?? && autobot.userCenter.mobile??>${autobot.userCenter.mobile!}</#if>"/>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            目前地区:</label>
                                                        <div class="col-sm-9">
                                                            <div class="dropdown" id="province">
                                                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                                    <#if userRegion?? >${userRegion.parent.name}<#else>请选择省</#if>
                                                                    <span class="caret"></span>
                                                                </button>
                                                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                                                    <#list provinces as t>
                                                                        <li ><a href='#' onclick="selectCities(this)" value="${t.id!}">${t.name!}</a></li>
                                                                    </#list>
                                                                </ul>
                                                            </div>
                                                            <div class="dropdown" name="uregionId" id="city">
                                                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                                <#if userRegion?? >${userRegion.name}<#else>请选择市</#if>
                                                                    <span class="caret"></span>
                                                                </button>
                                                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                                                    <#list cities as city>
                                                                        <li value="${city.id!}"><a href='#' onclick="selectCity(this)">${city.name!}</a></li>
                                                                    </#list>
                                                                </ul>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            汽车品牌:</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control" name="autoBrand"
                                                                   placeholder="请输入汽车品牌"
                                                                   value="<#if autobot?? && autobot.autoBrand?? >${autobot.autoBrand!}</#if>"/>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            擅长领域:</label>
                                                        <div class="col-sm-9">
                                                            <input type="hidden" name="autobot.businessCategory"/>
                                                        <#--<#if autobot ?? && autobot.businessCategory??>-->
                                                            <span class="checkBox <#if autobot.businessCategory ? index_of("销售")!=-1>checked</#if>" value="销售" onclick="categoryClicked(this)">销售</span>
                                                            <span class="checkBox <#if autobot.businessCategory ? index_of("售后")!=-1>checked</#if>" value="售后" onclick="categoryClicked(this)">售后</span>
                                                            <span class="checkBox <#if autobot.businessCategory ? index_of("客服")!=-1>checked</#if>" value="客服" onclick="categoryClicked(this)">客服</span>
                                                            <span class="checkBox <#if autobot.businessCategory ? index_of("市场")!=-1>checked</#if>" value="市场" onclick="categoryClicked(this)">市场</span>
                                                            <span class="checkBox <#if autobot.businessCategory ? index_of("管理")!=-1>checked</#if>" value="管理" onclick="categoryClicked(this)">管理</span>
                                                            <span class="checkBox <#if autobot.businessCategory ? index_of("内训")!=-1>checked</#if>" value="内训" onclick="categoryClicked(this)">内训</span>
                                                            <span class="checkBox <#if autobot.businessCategory ? index_of("行政")!=-1>checked</#if>" value="行政" onclick="categoryClicked(this)">行政</span>
                                                            <span class="checkBox <#if autobot.businessCategory ? index_of("生产研发")!=-1>checked</#if>" value="生产研发" onclick="categoryClicked(this)">生产研发</span>
                                                        <#--<#else>-->
                                                            <#--<input type="checkBox" name="autobot.businessCategory"-->
                                                                   <#--id="autobot.businessCategory" value="销售"/>销售-->
                                                            <#--<input type="checkBox" name="autobot.businessCategory"-->
                                                                   <#--id="autobot.businessCategory" value="售后"/>售后-->
                                                            <#--<input type="checkBox" name="autobot.businessCategory"-->
                                                                   <#--id="autobot.businessCategory" value="客服"/>客服-->
                                                            <#--<input type="checkBox" name="autobot.businessCategory"-->
                                                                   <#--id="autobot.businessCategory" value="市场"/>市场-->
                                                            <#--<input type="checkBox" name="autobot.businessCategory"-->
                                                                   <#--id="autobot.businessCategory" value="管理"/>管理-->
                                                            <#--<input type="checkBox" name="autobot.businessCategory"-->
                                                                   <#--id="autobot.businessCategory" value="内训"/>内训-->
                                                            <#--<input type="checkBox" name="autobot.businessCategory"-->
                                                                   <#--id="autobot.businessCategory" value="生产研发"/>生产研发-->
                                                            <#--<input type="checkBox" name="autobot.businessCategory"-->
                                                                   <#--id="autobot.businessCategory" value="行政"/>行政-->
                                                        <#--</#if>-->
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-5">
                                            <ul class="list-group">
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <img id="workPhotoURL1_show" src="${autobot.workPhotoURL1!}">
                                                        <button type="button" class="btn btn-primary btn-lg adminPageBtn"
                                                                data-toggle="modal" data-target="#myModal">
                                                            上传照片
                                                        </button>
                                                        <div class="col-sm-9">
                                                            <input type="hidden" name="workPhotoURL1">
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="pxshijl">
                            <h5>所获认证</h5>
                            <div class="pxshijl_box">
                                <textarea style="width:800px;margin-left:15px;resize:none" name="authHistroy"
                                          id="autobot.authHistroy" cols="45"
                                          rows="5"><#if autobot?? && autobot.authHistroy??> ${autobot.authHistroy!}<#else>
                                    请输入所获认证</#if></textarea>
                            </div>
                        </div>
                        <div class="pxshijl">
                            <h5>工作经历</h5>
                            <div class="pxshijl_box">
                                <textarea style="width:800px;margin-left:15px" name="workingHistroy"
                                          id="autobot.authHistroy" cols="45"
                                          rows="5"><#if autobot?? && autobot.workingHistroy??> ${autobot.workingHistroy!}<#else>
                                    请输入</#if></textarea>
                            </div>
                        </div>
                        <div class="tj">
                            <button type="button" onclick="submitdata()" style="adminPageBtn"/>保存</button>
                        </div>
                </div>
                </form>
                <div class="clear"></div>

            </div>
        </div>
    </div>

    <script src="/assets/website/js/cropper.js" type="text/javascript"></script>
    <script src="/assets/website/js/jquery-3.1.1.min.js" type="text/javascript"></script>
    <script src='/assets/website/js/bootstrap.min.js' type="text/javascript"></script>
    <script src="/assets/website/js/laydate.js?v=1.1.0" type="text/javascript"></script>

    <script>

        function checkform() {
//            var name = $("[name='autobot.userCenter.name']").val();
//            var birthday = $("[name='autobot.userCenter.birthday']").val();
//            var marryStatus = $("[name='autobot.userCenter.marryStatus']").val();
//            var currentWorkStatus = $("[name='autobot.currentWorkStatus']").val();
//            var autoBrand = $("[name='autobot.autoBrand']").val();
//            var mobile = $("input[name='autobot.userCenter.mobile']").val();
//            var authHistroy = $("[name='autobot.authHistroy']").val();
//            var workingHistroy = $("[name='autobot.workingHistroy']").val();
//
//            if (name == undefined || birthday == undefined || marryStatus == undefined || currentWorkStatus == undefined || autoBrand == undefined || mobile == undefined || authHistroy == undefined || workingHistroy == undefined) {
//                alert("带*的为必填字段 ");
//                return false;
//            }
//            if (name == "" || birthday == "" || marryStatus == "" || currentWorkStatus == "" || autoBrand == "" || mobile == "" || authHistroy == "" || workingHistroy == "") {
//                alert("带*的为必填字段 ");
//                return false;
//            }

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
            var url = "/backend/autobotCompleteResume/save";
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
                    if (data.code == 200) {
                        window.location.href = "/backend/autobotCompleteResume";
                    }
                }
            });
        }

        function selectCities(ele) {
            var provinceId = $(ele).attr('value');
            var provinceName = ele.innerHTML;
            $('#province button').val(provinceId);
            $('#province button')[0].innerHTML = provinceName + '<span class="caret"></span>';

            var form_data = {};
            form_data.parentId = provinceId;
            $.ajax({
                type: "POST",
                url: "/backend/regions/getCities",
                data: form_data,
                error: function (request) {
                    showErrMsg("网络出错啦！");
                    return false;
                },
                success: function (data) {
                    if (data.code == 200) {
                        //$("#city").get(0).options.length = data.cities.length + 1;
                        var parent = $("#city ul");
                        parent.empty();
                        for (var i = 0; i < data.cities.length; i++) {
                            var liString = "<li value='" + data.cities[i].id + "'>" +
                                "<a href='#' onclick='selectCity(this)'>" + data.cities[i].name + "</a></li>";
                            parent.append(liString);
                            //$("#city ul").get(0).options[i + 1] = new Option(, );
                        }
                    } else {
                        return false;
                    }
                }
            });
        }

        function selectCity(ele) {
            var regionId = $(ele).attr('value');
            var regionName = ele.innerHTML;
            $('#city button').val(regionId);
            $('#city button')[0].innerHTML = regionName + '<span class="caret"></span>';
        }
    </script>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">上传图片</h4>
                </div>
                <div class="modal-body">
                    <input type="file" inputmode="" accept=".jpeg,.jpg,.png,.bmp" onchange="selectImage(this)">
                    <input type="hidden" id="input_url">
                    <div>
                        <img id="cropperimg" src="/assets/website/images/blank.jpg">
                    </div>
                    <!-- sadjkfj -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" id="save_btn" class="btn btn-primary" onclick="save()">保存</button>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
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
    </script>

</body>
</html>
