<!-- menu开始 -->
<#if Session?? && Session["loginVO"]??>

    <#if Session["loginVO"].userType=='TRAINER'>
    <h4>培训师管理中心</h4>
    <#elseIf Session["loginVO"].userType=='AUTOBOT'>
    <h4>汽车人管理中心</h4>
    <#elseIf Session["loginVO"].userType=='COMPANY'>
    <h4>培训公司管理中心</h4>
    <#elseIf Session["loginVO"].userType=='STORE'>
    <h4>汽车公司管理中心</h4>
    <#else>
    </#if>
<div class="lanmu">
    <ul>
        <#if Session["loginVO"].userType=='TRAINER'>
            <li><a href="/website/trainerDetail">个人资料</a></li>
            <li><a href="/backend/trainerCompleteResume">完善资料</a></li>
            <li><a href="'/backend/applyJobHistory'">申请记录</a></li>
            <li><a href="'/backend/publishArticle'">发布文章</a></li>
            <li><a href="'/backend/articleManage'">我的文章</a></li>
        <#elseIf  Session["loginVO"].userType=='AUTOBOT'>
            <li><a href="/website/autobotDetail">个人资料</a></li>
            <li><a href="/backend/autobotCompleteResume">完善资料</a></li>
            <li><a href="'/backend/applyJobHistory'">申请记录</a></li>
        <#elseIf  ( Session["loginVO"].userType=='COMPANY'||  Session["loginVO"].userType=='STORE')>
            <li><a href="'/website/autoCompany?company.id=${Session["userDetails"].id}'" target="_blank">公司资料</a></li>
            <li><a href="'/backend/companyCompleteResume'">完善资料</a></li>
            <li><a href="'/backend/publishJob'">发布职位</a></li>
            <li><a href="'/backend/companyJobManage'">职位管理</a></li>
        </#if>
    <#--common link -->
        <#if Session?? && Session["loginVO"]?? >
            <li><a href="'/backend/modifyPassword'">修改密码</a></li>
        </#if>
        <li><a href="/backend/userCenter/logout">安全退出</a></li>
    </ul>
</div>
</#if>
