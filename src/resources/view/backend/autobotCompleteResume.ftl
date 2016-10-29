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
    <script src="<@url value="/assets/website/js/jquery-1.8.0.min.js?v=1.1.0"/>"></script>
    <script src="<@url value="/assets/website/js/laydate.js?v=1.1.0"/>"></script>
</head>

<body>
<#include "/assets/website/common/header.html">

<!-- main开始 -->
<div class="main">
    <div class="content">
        <div class="dq_box">
            <div class="dqwz left">当前位置 : <a href="#">首 页</a> > <a href="#">汽车人管理中心</a> > <a href="#">申请记录</a></div>
            <div class="wdcf right"><span
                    color="#FF66001"><#if Session?exists && Session["userDetails"].wealthStartDate??> ${Session["userDetails"].wealthStartDate!?string("dd/MM/yyyy")}
                —${Session["userDetails"].wealthEndDate!?string("dd/MM/yyyy")}</#if></span>我的财富：<font
                    color="#FF66001"><#if Session?exists && Session["userDetails"]??> ${Session["userDetails"].wealth!}</#if></font>
            </div>
            <div class="clear"></div>
        </div>

        <div class="pxshi_gl">
            <div class="pxshi_gl_l left">

            <#include "/assets/website/backend/common/menu.html">

                <div class="pxshi_gl_r right">
                    <form id="form1">
                        <!--隐藏域-->
                        <input type="hidden" name="autobot.userCenter.personalType" value="AUTOBOT">
                        <input type="hidden" name="autobot.id" value="<#if autobot??>${autobot.id!}</#if>">
                        <input type="hidden" name="autobot.userCenter.id"
                               value="<#if autobot?? && autobot.userCenter??>${autobot.userCenter.id!}</#if>">
                        <!--隐藏域-->
                        <div class="pxshijl">
                            <h5>基本信息</h5>
                            <div class="pxshijl_box">
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
                                                        <#if autobot?? && autobot.userCenter?? && autobot.userCenter.name??>
                                                            <input type="text" class="form-control"
                                                                   placeholder="请输入姓名"
                                                                   name="autobot.userCenter.name"
                                                                   value="${autobot.userCenter.name!}"/>
                                                        <#else>
                                                            <input type="text" class="form-control"
                                                                   placeholder="请输入姓名"
                                                                   name="autobot.userCenter.name" value=""/>
                                                        </#if>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            出生年月:</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"
                                                                   placeholder="请输入出生年月">
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            工作状态:</label>
                                                        <div class="col-sm-9">
                                                            <select class="form-control">
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
                                                            <select class="form-control">
                                                                <option>未婚</option>
                                                                <option>已婚</option>
                                                                <option>离异</option>
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
                                                                   placeholder="请输入行业经验">
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            联系方式:</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"
                                                                   placeholder="请输入联系方式">
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            目前地区:</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"
                                                                   placeholder="修改">
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            汽车品牌:</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"
                                                                   placeholder="请输入汽车品牌">
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            擅长领域:</label>
                                                        <div class="col-sm-9">
                                                        <#if autobot ?? && autobot.businessCategory??>
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("销售")!=-1>
                                                                   checked </#if> value="销售"/>销售
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("售后")!=-1>
                                                                   checked </#if> value="售后"/>售后
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("客服")!=-1>
                                                                   checked </#if> value="客服"/>客服
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("市场")!=-1>
                                                                   checked </#if> value="市场"/>市场
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("管理")!=-1>
                                                                   checked </#if> value="管理"/>管理
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("内训")!=-1>
                                                                   checked </#if> value="内训"/>内训
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("生产研发")!=-1>
                                                                   checked </#if> value="生产研发"/>生产研发
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" <#if autobot.businessCategory ? index_of("行政")!=-1>
                                                                   checked </#if> value="行政"/>行政
                                                        <#else>
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" value="销售"/>销售
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" value="售后"/>售后
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" value="客服"/>客服
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" value="市场"/>市场
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" value="管理"/>管理
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" value="内训"/>内训
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" value="生产研发"/>生产研发
                                                            <input type="checkBox" name="autobot.businessCategory"
                                                                   id="autobot.businessCategory" value="行政"/>行政
                                                        </#if>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-5">
                                            <ul class="list-group">
                                                <li class="list-group-item pxshijl_li">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 pxshijl_label"><span
                                                                style="color: red">*</span>
                                                            头像:</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"
                                                                   placeholder="修改">
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
                                <textarea style="width:800px;margin-left:15px;resize:none" name="autobot.authHistroy"
                                          id="autobot.authHistroy" cols="45"
                                          rows="5"><#if autobot?? && autobot.authHistroy??> ${autobot.authHistroy!}<#else>
                                    请输入所获认证</#if></textarea>
                            </div>
                        </div>
                        <div class="pxshijl">
                            <h5>工作经历</h5>
                            <div class="pxshijl_box">
                                <textarea style="width:800px;margin-left:15px" name="autobot.authHistroy"
                                          id="autobot.authHistroy" cols="45"
                                          rows="5"><#if autobot?? && autobot.authHistroy??> ${autobot.authHistroy!}<#else>
                                    请输入</#if></textarea>
                            </div>
                        </div>
                        <div class="tj">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td height="60" align="center" valign="middle">
                                        <input type="button" onclick="submitdata()"
                                               style="width:58px;height:28px;background-repeat:no-repeat;background-image:url(http://obu3flkwk.bkt.clouddn.com/backend/images/bc.jpg);border:0;"/>
                                </tr>
                            </table>
                        </div>
                </div>
                </form>
                <div class="clear"></div>

            </div>
        </div>
    </div>

    <script>

        function checkform() {
            var name = $("[name='autobot.userCenter.name']").val();
            var birthday = $("[name='autobot.userCenter.birthday']").val();
            var marryStatus = $("[name='autobot.userCenter.marryStatus']").val();
            var currentWorkStatus = $("[name='autobot.currentWorkStatus']").val();
            var autoBrand = $("[name='autobot.autoBrand']").val();
            var mobile = $("input[name='autobot.userCenter.mobile']").val();
            var authHistroy = $("[name='autobot.authHistroy']").val();
            var workingHistroy = $("[name='autobot.workingHistroy']").val();

            if (name == undefined || birthday == undefined || marryStatus == undefined || currentWorkStatus == undefined || autoBrand == undefined || mobile == undefined || authHistroy == undefined || workingHistroy == undefined) {
                alert("带*的为必填字段 ");
                return false;
            }
            if (name == "" || birthday == "" || marryStatus == "" || currentWorkStatus == "" || autoBrand == "" || mobile == "" || authHistroy == "" || workingHistroy == "") {
                alert("带*的为必填字段 ");
                return false;
            }

            return true;
        }

        function submitdata() {

            if (!checkform()) {
                return;
            }

            var form_data = {};
            var url = "/backend/autobotCompleteResume/save";

            var uheadLogo = document.getElementById('autobot.userCenter.headLogo').src;
            var upersonalType = $("[name='autobot.userCenter.personalType']").val();
            var aid = $("[name='autobot.id']").val();
            var uid = $("[name='autobot.userCenter.id']").val();
            var uname = $("[name='autobot.userCenter.name']").val();
            var ubirthday = $("[name='autobot.userCenter.birthday']").val();
            var uemail = $("[name='autobot.userCenter.email']").val();
            var uregionId = $("[name='city']").val();
            var umarryStatus = $("[name='autobot.userCenter.marryStatus']").val();
            var currentWorkStatus = $("[name='autobot.currentWorkStatus']").val();
            var autoBrand = $("[name='autobot.autoBrand']").val();
            var umobile = $("input[name='autobot.userCenter.mobile']").val();
            var autoYears = $("[name='autobot.autoYears']").val();
            var authHistroy = $("[name='autobot.authHistroy']").val();
            var workingHistroy = $("[name='autobot.workingHistroy']").val();
            var businessCategory = '';
            $("input:checkbox[name='autobot.businessCategory']:checked").each(function (index, element) {
                businessCategory += $(this).val() + ",";
            });
            var workPhotoURL1 = document.getElementById('autobot.workPhotoURL1').src;
            var workPhotoURL2 = document.getElementById('autobot.workPhotoURL2').src;

            form_data.aid = aid;
            form_data.uid = uid;
            form_data.uname = uname;
            form_data.uheadLogo = uheadLogo;
            form_data.ubirthday = ubirthday;
            form_data.umarryStatus = umarryStatus;
            form_data.currentWorkStatus = currentWorkStatus;
            form_data.autoBrand = autoBrand;
            form_data.umobile = umobile;
            form_data.uemail = uemail;
            form_data.uregionId = uregionId;
            form_data.autoYears = autoYears;
            form_data.authHistroy = authHistroy;
            form_data.workingHistroy = workingHistroy;
            form_data.upersonalType = upersonalType;
            form_data.workPhotoURL1 = workPhotoURL1;
            form_data.workPhotoURL2 = workPhotoURL2;
            form_data.businessCategory = businessCategory;

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

        function selectCities() {
            var form_data = {};
            form_data.parentId = $("[name='province']").val();
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
                        $("#city").get(0).options.length = data.cities.length + 1;
                        for (var i = 0; i < data.cities.length; i++) {
                            $("#city").get(0).options[i + 1] = new Option(data.cities[i].name, data.cities[i].id);
                        }
                    } else {
                        return false;
                    }
                }
            });
        }


        var image = '';
        function selectImage(file) {
            if (!file.files || !file.files[0]) {
                return;
            }

            var reader = new FileReader();
            reader.onload = function (evt) {
                if (file.name == 'headLogo') {
                    document.getElementById('autobot.userCenter.headLogo').src = evt.target.result;
                }
                if (file.name == 'workPhotoURL1') {
                    document.getElementById('autobot.workPhotoURL1').src = evt.target.result;
                }
                if (file.name == 'workPhotoURL2') {
                    document.getElementById('autobot.workPhotoURL2').src = evt.target.result;
                }
                image = evt.target.result;
            }
            reader.readAsDataURL(file.files[0]);
        }

        function getFilePath(ext) {
            var timestamp = new Date().getTime();
            return ("autobot/upload/" + timestamp + "." + ext);
        }
    </script>

    <!-- main结束 -->
<#--<#include "/assets/backend/common/footer.html">-->

</body>
</html>
