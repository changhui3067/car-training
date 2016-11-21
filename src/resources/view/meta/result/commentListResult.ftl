<#if commentList?? && commentList.size() gt 0>
    <ul>
        <#list commentList as c>
            <#if c?? && c.content??>
                <li>
                    <div class="comments">
                        <div class="comments_desc">${c.content}</div>
                        <div class="comments_date">${c.createTime?string("yyyy-MM-dd")}</div>
                    </div>
                </li>
            </#if>
        </#list>
    </ul>
<#else>
    <p>暂无数据</p>
</#if>