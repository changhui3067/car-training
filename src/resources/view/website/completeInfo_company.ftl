<form id="form1">
    <div class="pxshijl">
        <h5>基本信息</h5>
        <div class="pxshijl_box companyInfoComplete">
            <div class="errMsg"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-sm-7">
                            <ul class="list-group">
                                <li class="list-group-item pxshijl_li">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        公司名称:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"
                                               placeholder="请输入企业名称"
                                               name="name"
                                               value="<#if companyInfo?? && companyInfo.name??>${companyInfo.name!}</#if>"/>
                                    </div>
                                </li>

                                <li class="list-group-item pxshijl_li">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        汽车品牌:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"
                                               placeholder="请输入企业拥有的汽车品牌"
                                               name="autoBrand"
                                               value="<#if companyInfo?? && companyInfo.autoBrand??>${companyInfo.autoBrand!}</#if>"/>
                                    </div>
                                </li>

                                <li class="list-group-item pxshijl_li">
                                    <div class="form-group">
                                        <label class="col-sm-3 pxshijl_label"><span
                                                style="color: red">*</span>
                                            公司规模:</label>
                                        <div class="col-sm-9">
                                            <select class="form-control" name="scale">
                                                <option>50人以下</option>
                                                <option>50-100人</option>
                                                <option>101-200人</option>
                                                <option>200-500人</option>
                                                <option>500-1000人</option>
                                                <option>1000人以上</option>
                                            </select>
                                        </div>
                                    </div>
                                </li>

                                <li class="list-group-item pxshijl_li">
                                    <div class="form-group">
                                        <label class="col-sm-3 pxshijl_label"><span
                                                style="color: red">*</span>
                                          经营范围:</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control"
                                               placeholder="请输入公司经营范围"
                                               name="businessRange"
                                               value="<#if companyInfo?? && companyInfo.businessRange??>${companyInfo.businessRange!}</#if>"/>
                                    </div>
                                    </div>
                                </li>

                                <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        公司地址:</label>
                                    <div class="col-sm-9">
                                        <div class="dropdown" id="province">
                                            <button class="btn btn-default dropdown-toggle" type="button"
                                                    id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="true">
                                                <#if userRegion?? >${userRegion.parent.name}<#else>请选择省</#if>
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                            <#list provinces as t>
                                                <li><a href='#' onclick="selectCities(this)"
                                                       value="${t.id!}">${t.name!}</a></li>
                                            </#list>
                                            </ul>
                                        </div>
                                        <div class="dropdown" id="city">
                                            <button class="btn btn-default dropdown-toggle" type="button"
                                                    id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="true">
                                            <#if userRegion?? >${userRegion.name}<#else>请选择市</#if>
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                            <#list cities as city>
                                                <li value="${city.id!}"><a href='#'
                                                                           onclick="selectCity(this)">${city.name!}</a>
                                                </li>
                                            </#list>
                                            </ul>
                                        </div>
                                        <input name="regionId" type="hidden" value="<#if userRegion?? >${userRegion.id}<#else>${1}</#if>">
                                    </div>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"
                                               placeholder="请填入具体地址"
                                               name="address"
                                               value="<#if companyInfo?? && companyInfo.address??>${companyInfo.address!}</#if>"/>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                                </li>

                                <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        公司福利:</label>
                                    <div class="col-sm-9">
                                        <input type="hidden" name="welfare" value="No"/>
                                        <span class="checkBox <#if companyInfo.welfare?? && companyInfo.welfare ? index_of("包吃")!=-1>checked</#if>"
                                              value="包吃" onclick="categoryClicked(this)">包吃</span>
                                        <span class="checkBox <#if companyInfo.welfare?? && companyInfo.welfare ? index_of("包住")!=-1>checked</#if>"
                                              value="包住" onclick="categoryClicked(this)">包住</span>
                                        <span class="checkBox <#if companyInfo.welfare?? && companyInfo.welfare ? index_of("五险一金")!=-1>checked</#if>"
                                              value="五险一金" onclick="categoryClicked(this)">五险一金</span>
                                        <span class="checkBox <#if companyInfo.welfare?? && companyInfo.welfare ? index_of("免费班车")!=-1>checked</#if>"
                                              value="免费班车" onclick="categoryClicked(this)">免费班车</span>
                                        <span class="checkBox <#if companyInfo.welfare?? && companyInfo.welfare ? index_of("员工旅游")!=-1>checked</#if>"
                                              value="员工旅游" onclick="categoryClicked(this)">员工旅游</span>
                                        <span class="checkBox <#if companyInfo.welfare?? && companyInfo.welfare ? index_of("工作补贴")!=-1>checked</#if>"
                                              value="工作补贴" onclick="categoryClicked(this)">工作补贴</span>
                                        <span class="checkBox <#if companyInfo.welfare?? && companyInfo.welfare ? index_of("员工培训")!=-1>checked</#if>"
                                              value="员工培训" onclick="categoryClicked(this)">员工培训</span>
                                        <span class="checkBox <#if companyInfo.welfare?? && companyInfo.welfare ? index_of("绩效奖金")!=-1>checked</#if>"
                                              value="绩效奖金" onclick="categoryClicked(this)">绩效奖金</span>
                                        <span class="checkBox <#if companyInfo.welfare?? && companyInfo.welfare ? index_of("定期体检")!=-1>checked</#if>"
                                              value="定期体检" onclick="categoryClicked(this)">定期体检</span>
                                    </div>
                                </div>
                            </li>
                            </ul>
                        </div>

                        <div class="col-sm-5">
                            <ul class="list-group">
                                <li class="list-group-item pxshijl_li">
                                    <div class="form-group photo">
                                        <img id="logo_show" src="${companyInfo.logoUrl!}">
                                        <button id="logo_btn" type="button" class="btn btn-primary btn-lg adminPageBtn">
                                            上传照片
                                        </button>
                                    </div>
                                </li>

                                <li class="list-group-item pxshijl_li">
                                    <div class="form-group photo">
                                        <img id="photo_show" src="${companyInfo.photoUrl!}">
                                        <button id="photo_btn" type="button"
                                                class="btn btn-primary btn-lg adminPageBtn">上传工商营业执照副本
                                        </button>
                                        <!-- 将有效的工商营业执照副本原件或加盖红色单位公章的复印件拍照或扫描后在此上传，由客服人员认证审核。必须上传与公司名称一致，
已年检通过的证照。 -->
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
        </div>
    </div>

    <div class="pxshijl">
        <h5>企业介绍</h5>
        <div class="pxshijl_box">
            <textarea style="width:800px;margin-left:15px;resize:none" name="introduction"
                id="companyInfo.introduction" cols="45" rows="5" placeholder="请输入企业介绍">
                <#if companyInfo?? && companyInfo.introduction??> ${companyInfo.introduction!}</#if>
            </textarea>
        </div>
    </div>
    <div class="tj">
        <button type="button" onclick="submitdata()" class="btn btn-primary">保存</button>
    </div>
</form>