<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>培聘网</title>
    <link rel="stylesheet" href="/assets/website/css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="/assets/website/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="/assets/website/css/pxshi.css" type="text/css"/>
    <link rel="stylesheet" href="/assets/website/css/iconfont.css" type="text/css"/>
</head>

<body>
<!-- 头部开始 -->
<#include "/assets/website/common/header.html">
<!-- 头部结束 -->

<!-- main开始 -->

<div class="content">
<#if autobot??>
    <div class="ny_pxshi">
        <div class="ny_pxshi_l left">
            <div class="people_detail_basic_info">
                <div class="photo left">
                    <img src="${autobot.personInfo.avatarUrl!}"/>
                </div>
                <div class="detail right">
                    <div class="autbotpeople_info">
                        <h1 class="left">${autobot.personInfo.name!}</h1>
                        <div class="iconbox right alignCenter">
                            <span><i class="iconfont alignCenter" title="评论">&#xe69b;</i><#if commentList??><span id="commentNumber">${commentList.size()!}</span><#else><span id="commentNumber">0</span></#if></span>
                            <#if like?? && like>
                            <span class="alignCenter like" id="autobotDetailLike" value=${autobot.id!} onClick="like('',this.id)"><i class="iconfont praise" title="点赞">&#xe717;</i><span>${likeNumber!}</span></span>
                            <#else>
                            <span class="alignCenter unLike" id="autobotDetailLike" value=${autobot.id!} onClick="like('',this.id)"><i class="iconfont praise" title="点赞">&#xe717;</i><span>${likeNumber!}</span></span>
                            </#if>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div>
                        <span class="paddingLeftNull">${autobot.currentPosition!}</span>
                        <span>${autobot.education!}</span>
                        <span>${autobot.autoYears!}年工作经验</span>
                        <span>${autobot.workingStatus!}</span>
                        <span>${autobot.personInfo.region.fullname!}</span>
                    </div>
                    <div>
                        擅长领域：
                        <#list autobot.businessCategory as c>
                            <tr>
                                <span>${c}</span>
                            </tr>
                        </#list>
                    </div>
                    <div>
                        汽车品牌:<span>${autobot.autoBrand!}</span>
                    </div>
                    <div>
                        联系方式: <span>${autobot.personInfo.mobile!}</span><span>${autobot.personInfo.email!}</span>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>培训经历</h4></div>
                <div class="people_other_info_list">
                ${autobot.trainingHistory!}
                </div>
            </div>
            <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>所获认证</h4></div>
                <div class="people_other_info_list">
                ${autobot.certRecords!}
                </div>
            </div>
            <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>工作经历</h4></div>
                <div class="people_other_info_list">
                ${autobot.workingHistory!}
                </div>
            </div>
            <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>学员评论</h4></div>
                <div class="add_comment_box">
                    <textarea id="add_comment"></textarea>
                    <button id=${autobot.id!} class="commonClickButton btn btn-info" onclick="addComment(this.id)">提交</button>
                </div>
            </div>
        </div>
        <div class="ny_pxshi_r right">
            <div class="people_comments people_other_info_bar">
                <h4>学员评价</h4>
                <div class="people_comments_list">
                    <#include "/resources/view/meta/result/commentListResult.ftl">
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</#if>
</div>

<!-- main结束 -->
<#include "/assets/website/common/footer.html">
<script src="<@url value="/assets/website/backend/js/common.js"/>"></script>
</body>
</html>
