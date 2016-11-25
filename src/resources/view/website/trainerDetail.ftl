<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
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
<#if trainer??>
    <div class="ny_pxshi">
        <div class="ny_pxshi_l left">
            <div class="people_detail_basic_info">
                <div class="photo left">
                    <img src="${trainer.personInfo.avatarUrl!}"/>
                </div>
                <div class="detail left">
                    <h1 class="left">${trainer.personInfo.name!}</h1>
                    <div>
                        <div class="iconbox right alignCenter">
                            <span class="alignCenter"><i class="iconfont" title="评论">&#xe69b;</i><#if commentList??> ${commentList.size()!}<#else>0</#if></span>
                            <span class="alignCenter"><i class="iconfont" title="点赞">&#xe717;</i>${likeNumber!}</span>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div>
                        <span class="paddingLeftNull">${trainer.currentPosition!}</span>
                        <span>${trainer.autoYears!}年</span>
                        <span>${trainer.education}</span>
                        <span class="noBorder"><#if trainer.personInfo?? && trainer.personInfo.region??>${trainer.personInfo.region.fullname!}</#if></span>
                    </div>
                    <div>
                        擅长形式:
                        <#list trainer.businessCategory as c>
                        <tr>
                            <span>${c}</span>
                        </tr>
                    </#list>
                    </div>
                    <div>
                        培训领域:
                        <#list trainer.businessCategory as c>
                            <tr>
                                <span>${c}</span>
                            </tr>
                        </#list>
                    </div>
                    <div>
                        联系方式: <span>${trainer.personInfo.email!}</span><span>${trainer.personInfo.mobile!}</span>
                    </div>
                </div>
                <div class="clear"></div>
            </div>

            <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>视频链接</h4></div>
                <div class="people_other_info_video">
                    <embed src="${trainer.videoUrl1!}" allowfullscreen="true" quality="high" width="360" height="300" align="middle" allowscriptaccess="always" type="application/x-shockwave-flash" />

                    <!-- http://player.youku.com/player.php/sid/XMTgyNzI5NTY5Mg==/v.swf -->

                    <embed src="${trainer.videoUrl2!}" allowfullscreen="true" quality="high" width="360" height="300" align="middle" allowscriptaccess="always" type="application/x-shockwave-flash" />

                </div>
            </div>

        <#--暂时隐藏文章模块-->
        <#--<div class="pxshi_wz">-->
        <#--<div class="pxshi_bt">-->
        <#--</div>-->
        <#--<div class="pxshi_wz_box">-->
        <#--[No received] the trainerEssay-->
        <#--<#if trainerEssayList??>-->
        <#--<ul>-->
        <#--<#list trainerEssayList as te>-->
        <#--<li><span><a href="#">${te.publishDate!?string("yyyy-MM-dd")}</a></span><a href="/website/trainerEssayDetail?trainerEssay.id=${te.id!}" target="_blank">${te.title!}</a></li>-->
        <#--</#list>-->
        <#--</ul>-->
        <#--</#if>-->
        <#--</div>-->
        <#--</div>-->
        <#--培训课程 暂时隐藏-->
        <#--<div class="people_other_info_box">-->
        <#--<div class="people_other_info_bar"><h4>培训课程</h4></div>-->
        <#--<div class="people_other_info_list">-->
        <#--[No received]the courseList-->
        <#--<#if coursesList??>-->
        <#--Fairy-->
        <#--<ul>-->
        <#--<#list coursesList as c>-->
        <#--<li>-->
        <#--<a href="/website/courseDetail?course.id=${c.id!}" target="_blank">-->
        <#--<span class="info_name">${c.courseName!}（${c.longTime!}天</span>-->
        <#--<span class="info_date">${c.publishDate!?string("yyyy-MM-dd")}</span>-->
        <#--</a>-->
        <#--</li>-->
        <#--</#list>-->
        <#--</ul>-->
        <#--</#if>-->
        <#--</div>-->
        <#--</div>-->

            <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>学员评论</h4></div>
                <div class="add_comment_box">
                    <textarea id="add_comment"></textarea>
                    <button id=${trainer.id!} class="commonClickButton btn btn-info" onclick="addComment(this.id)">提交</button>
                </div>
            </div>
        </div>
        <div class="ny_pxshi_r right">
            <!-- <div class="pxshi_lx"> -->
            <!-- <h4>联系方式</h4> -->
            <!-- <div class="lx_box"> -->
            <!-- <div class="xingming">${trainer.personInfo.name!}(培训师本人)</div> -->
        <#--<!-- <#if Session?exists && Session["loginState"]=='Y'> &ndash;&gt;-->
        <#--<!-- 电话：${trainer.personInfo.mobile!}<br /> &ndash;&gt;-->
        <#--<!-- 邮箱：${trainer.personInfo.email!}<br /> &ndash;&gt;-->
        <#--<!-- 微信：${trainer.personInfo.weixin!}<br /> &ndash;&gt;-->
        <#--<!-- <#else>-->
        <#--请联系培训网  400-820-6666-->
        <#--</#if>-->
        <#--</div>-->
        <#--</div> -->
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
    <!-- main结束 -->
<#include "/assets/website/common/footer.html">
<script src="<@url value="/assets/website/js/jquery-3.1.1.min.js"/>"></script>
<script src="<@url value="/assets/website/js/bootstrap.min.js"/>"></script>
<script src="<@url value="/assets/website/backend/js/common.js"/>"></script>
</body>
</html>