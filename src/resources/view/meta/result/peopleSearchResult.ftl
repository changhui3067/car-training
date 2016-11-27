<div class="pxshilist">
<#if peopleList??>
    <ul>
        <#list peopleList as t>
            <li class="oneBox">
                <#if t??>
                    <div class="picContainer">
                        <#if t.loginUser.type=='TRAINER'>
                        <a href="/website/trainerDetail?trainerId=${t.id!}">
                        <#elseif t.loginUser.type=='AUTOBOT'>
                        <a href="/website/autobotDetail?autobotId=${t.id!}">
                        </#if>
                            <img src="${t.personInfo.avatarUrl!}"/>
                        </a>
                    </div>
                    <div class="intro">
                        <div>
                            <div class="name">${t.personInfo.name!}</div>
                            <div class="right"><i class="iconfont" title="点赞">&#xe717;</i>${t.starLevel!}</div>
                            <div class="right"><i class="iconfont" title="评论">
                                &#xe69b;</i><#if t.autobotsCommentList??> ${t.autobotsCommentList.size!}<#else>0</#if>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div>${t.currentPosition!}</div>
                    </div>
                </#if>
            </li>

        </#list>
    </ul>
</#if>
</div>

    

