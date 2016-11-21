<#if personList??>
<#list personList as person>
    <div class="guaranteeInfo left">
        <a href="#"><img src="${person.personInfo.avatarUrl!}" title="guarentee img"/></a>
    </div>
</#list>
</#if>
<div class="clear"></div>