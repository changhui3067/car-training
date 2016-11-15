<div>
    <div class="companyBasicInfoBox">
        <h4>基本信息</h4>
        <div class="companyBasicInfoBoxContent">
            <h5>${company.name!}</h5>
            <button class="commonClickButton">我为公司担保</button>
            <div><b>经营范围：</b>汽车销售/以及原厂配件/售后服务</div>
            <div><b>公司规模：</b>${company.scale!}</div>
            <div><b>公司地址：</b><#if company.region.fullname??>${company.region.fullname!}</#if></div>
        </div>
    </div>
    <div class="companyBasicInfoBox">
        <h4>担保人列表</h4>
        <div class="companyGuaranteeList">
            <#if bondsmanList??>
            <#list bondsmanList as b>
                <div class="guaranteeInfo left">
                    <a href="#"><img src="${b.headLogo!}" title="guarentee name"/></a>
                </div>
            </#list>
            </#if>
            <div class="clear"></div>
        </div>
    </div>
</div>