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
                    <div>
                        <h1 class="left">${autobot.personInfo.name!}</h1>
                        <div class="iconbox right alignCenter">
                            <span><i class="iconfont" title="评论">&#xe69b;</i>0</span>
                        <#--<span><i class="iconfont" title="点赞">&#xe717;</i>${autobot.starLevel!}</span>-->
                            <span><i class="iconfont" title="点赞">&#xe717;</i>3</span>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div>
                    <#--<span class="paddingLeftNull">${autobot.currentPosition!}</span>-->
                    <#--大学本科-->
                    <#--<span>三年工作经验</span>-->
                    <#--<span>${autobot.personInfo.regionId!}</span>-->
                        <span class="paddingLeftNull">汽车人经理${autobot.currentPosition!}</span>
                        <span>大学本科</span>
                        <span>${autobot.autoYears!}年工作经验</span>
                        <span>${autobot.personInfo.regionId!}</span>
                    </div>
                    <div>
                        擅长领域：<span>${autobot.businessCategory!}</span><span>销售</span><span>客服</span>
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
                ${autobot.trainingHistroy!}
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


        </div>
        <div class="ny_pxshi_r right">
            <div class="people_comments people_other_info_bar">
                <h4>学员评价</h4>
                <div class="people_comments_list">
                    [No received] people_comments_list
                    <#if autobot.commentList??>
                        Fairy
                    <#else>
                        <p>暂无数据</p>
                    </#if>
                <#--<#if trainer.autobotsCommentList??>-->
                <#--<ul>-->
                <#--<#list trainer.autobotsCommentList as c>-->
                <#--<#if c?? && c.content??>-->
                <#--<li>-->
                <#--<div class="comments">-->
                <#--<div class="comments_desc">${c.content}</div>-->
                <#--<div class="comments_date">2016-10-12</div>-->
                <#--</div>-->
                <#--</li>-->
                <#--</#if>-->
                <#--</#list>-->
                <#--</ul>-->
                <#--</#if>-->
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</#if>
</div>

<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html>
