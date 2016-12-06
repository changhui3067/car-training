<#if commentList?? && commentList.size() gt 0>
    <ul>
        <#list commentList as c>
            <#if c?? && c.content??>
                <li>
                    <div class="comments">
                        <div class="comments_desc">${c.content}</div>
                        <div class="comments_bottom">
                            <div class="left ellipsis commentsName">${commentNameMap.get(c)!}</div>
                            <div class="right">${c.createTime?string("yyyy-MM-dd")}</div>
                            <div class="clear"></div>
                        </div>
                        <#--see the above line to get name-->
                    </div>
                </li>
            </#if>
        </#list>
    </ul>
<#else>
    <p>暂无数据</p>
</#if>