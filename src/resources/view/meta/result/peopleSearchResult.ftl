<div class="pxshilist">
<#if trainerList??>
    <ul>
        <#list trainerList as t>
            <li class="oneBox">
                <#if t?? && t.userCenter??>
                    <div class="picContainer"><a href="/website/trainerDetail?trainer.id=${t.id!}"><img
                            src="${t.userCenter.headLogo!}"/></a></div>
                    <div class="intro">
                        <div>
                            <div class="name">${t.userCenter.name!}</div>
                            <div class="right"><i class="iconfont" title="点赞">&#xe717;</i>${t.starLevel!}</div>
                            <div class="right"><i class="iconfont" title="评论">
                                &#xe69b;</i><#if t.autobotsCommentList??> ${t.autobotsCommentList.size!}<#else>0</#if>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div>${t.currentPosition!}</div>
                        <div>
                            <span><i class="iconfont" title="留言多">&#xe756;</i></span>
                            <span><i class="iconfont" title="资料完整">&#xe69f;</i></span>
                            <span><i class="iconfont" title="身份信息可靠">&#xe70a;</i></span>
                            <span><i class="iconfont" title="培训经验超过10年">&#xe735;</i></span>
                            <span><i class="iconfont" title="行业经验超过20年">&#xe726;</i></span>
                        </div>
                    </div>
                </#if>
            </li>

        </#list>
    </ul>
</#if>
</div>

    

