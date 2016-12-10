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
<input name="currLocation" type="hidden" value="1" />
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
                            <span class="alignCenter"><i class="iconfont" title="评论">&#xe69b;</i><#if commentList??><span id="commentNumber">${commentList.size()!}</span><#else><span id="commentNumber">0</span></#if></span>
                            <#if like?? && like>
                            <span class="alignCenter praise" id=${trainer.loginUser.id!} value="<#if Session?exists && '{}' != '${session}' && Session["loginVO"]??>true<#else>false</#if>" onClick="like('.people_detail_basic_info .detail .iconbox',this.id)"><i class="iconfont icon-icon02" title="点赞"></i><span>${likeNumber!}</span></span>
                            <#else>
                            <span class="alignCenter praise" id=${trainer.loginUser.id!} value="<#if Session?exists && '{}' != '${session}' && Session["loginVO"]??>true<#else>false</#if>" onClick="like('.people_detail_basic_info .detail .iconbox',this.id)"><i class="iconfont icon-good" title="点赞"></i><span>${likeNumber!}</span></span>
                            </#if>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div>
                        <span class="paddingLeftNull">${trainer.currentPosition!}</span>
                        <span>${trainer.autoYears!}年</span>
                        <span>${trainer.education!}</span>
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
                        <#list trainer.executionCategory as c>
                            <tr>
                                <span>${c}</span>
                            </tr>
                        </#list>
                    </div>
                    <div>
                        <#if hideContact>
                            联系方式: <span>********************</span><span>***********</span>
                        <#else>
                        联系方式: <span>${trainer.personInfo.email!}</span><span>${trainer.personInfo.mobile!}</span>
                        </#if>
                    </div>
                </div>
                <div class="clear"></div>
            </div>

            <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>个人介绍</h4></div>
                <div class="people_other_info_list">
                <#if trainer.introduction??>${trainer.introduction!}</#if>
                </div>
            </div>

            <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>课程介绍</h4></div>
                <div class="people_other_info_list">
                <#if trainer.mainCourse??>${trainer.mainCourse!}</#if>
                </div>
            </div>

            <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>视频链接</h4></div>
                <div class="people_other_info_video">
                    <#if trainer.videoUrl1?? >
                        <embed src="${trainer.videoUrl1!}" allowfullscreen="true" quality="high" width="360" height="300" align="middle" allowscriptaccess="always" type="application/x-shockwave-flash" />
                    </#if>
                    <#if trainer.videoUrl2?? >
                        <embed src="${trainer.videoUrl2!}" allowfullscreen="true" quality="high" width="360" height="300" align="middle" allowscriptaccess="always" type="application/x-shockwave-flash" />
                    </#if>
                </div>
            </div>

            <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>学员评论</h4></div>
                <div class="add_comment_box">
                    <#if canComment>
                    <textarea id="add_comment"></textarea>
                    <button id=${trainer.loginUser.id!} value="<#if Session?exists && '{}' != '${session}' && Session["loginVO"]??>true<#else>false</#if>" class="commonClickButton btn btn-primary" onclick="addComment(this.id)">提交</button>
                    <#else>没有评论权限
                    </#if>
                </div>
            </div>

        </div>
        <div class="ny_pxshi_r right">
            <div class="people_comments people_other_info_bar">
                <h4>评论列表</h4>
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
<script src="<@url value="/assets/website/js/common.js"/>"></script>
<script type="text/javascript" src="/assets/website/js/Util.js"></script>
</body>
</html>