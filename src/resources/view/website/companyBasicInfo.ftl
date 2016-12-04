<div>
    <div class="companyBasicInfoBox">
        <h4>基本信息</h4>
        <div class="companyBasicInfoBoxContent">
        <#if company??>
            <h5>${company.name!}</h5>
            <button id=${company.id!} value="<#if Session?exists && '{}' != '${session}' && Session["loginVO"]??>true<#else>false</#if>" class="<#if guarantee?? && guarantee>guarantee</#if>" onClick="guarantee('.companyBasicInfoBoxContent',this.id)">我为公司担保</button>
            <div><b>经营范围：</b><#if company.businessRange??>${company.businessRange!}</#if></div>
            <div><b>公司规模：</b>${company.scale!}</div>
            <div><b>公司地址：</b><#if company.region?? && company.region.fullname??>${company.region.fullname!}</#if></div>
        </#if>
        </div>
    </div>
    <div class="companyBasicInfoBox">
        <h4>担保人列表</h4>
        <div class="companyGuaranteeList">
            <#include "/resources/view/meta/result/guaranteePersonListResult.ftl">
        </div>
    </div>
</div>