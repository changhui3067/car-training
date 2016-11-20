<form id="form1">
    <div class="pxshijl">
        <h5>基本信息</h5>
        <div class="pxshijl_box">
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
                                               name="uname"
                                               value="<#if company?? && cpmany.name??>${company.name!}</#if>"/>
                                    </div>
                                </li>

                                <li class="list-group-item pxshijl_li">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        汽车品牌:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"
                                               placeholder="请输入企业拥有的汽车品牌"
                                               name="uname"
                                               value="<#if company?? && cpmany.autoBrand??>${company.autoBrand!}</#if>"/>
                                    </div>
                                </li>

                                <li class="list-group-item pxshijl_li">
                                    <div class="form-group">
                                        <label class="col-sm-3 pxshijl_label"><span
                                                style="color: red">*</span>
                                            公司规模:</label>
                                        <div class="col-sm-9">
                                            <select class="form-control" name="currentWorkStatus">
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
                                            <select class="form-control" name="currentWorkStatus">
                                                <option>汽车</option>
                                                <option>培训</option>
                                                <option>销售</option>
                                            </select>
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
                                        <div class="dropdown" name="uregionId" id="city">
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
                                    </div>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"
                                               placeholder="请填入具体地址"
                                               name="uaddress"
                                               value="<#if company?? && cpmany.address??>${company.address!}</#if>"/>
                                    </div>
                                </div>
                                </li>

                                <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        公司福利:</label>
                                    <div class="col-sm-9">
                                        <input type="hidden" name="company.welfare"/>
                                        <span class="checkBox <#if company.welfare ? index_of("工作餐")!=-1>checked</#if>"
                                              value="销售" onclick="categoryClicked(this)">工作餐</span>
                                        <span class="checkBox <#if company.welfare ? index_of("五险一金")!=-1>checked</#if>"
                                              value="售后" onclick="categoryClicked(this)">五险一金</span>
                                        <span class="checkBox <#if company.welfare ? index_of("免费班车")!=-1>checked</#if>"
                                              value="客服" onclick="categoryClicked(this)">免费班车</span>
                                        <span class="checkBox <#if company.welfare ? index_of("股票期权")!=-1>checked</#if>"
                                              value="市场" onclick="categoryClicked(this)">股票期权</span>
                                        <span class="checkBox <#if company.welfare ? index_of("带薪休假")!=-1>checked</#if>"
                                              value="管理" onclick="categoryClicked(this)">带薪休假</span>
                                        <span class="checkBox <#if company.welfare ? index_of("绩效奖金")!=-1>checked</#if>"
                                              value="内训" onclick="categoryClicked(this)">绩效奖金</span>
                                        <span class="checkBox <#if company.welfare ? index_of("定期体检")!=-1>checked</#if>"
                                              value="行政" onclick="categoryClicked(this)">定期体检</span>
                                    </div>
                                </div>
                            </li>
                            </ul>
                        </div>

                        <div class="col-sm-5">
                            <ul class="list-group">
                                <li class="list-group-item pxshijl_li">
                                    <div class="form-group">
                                        <img id="workPhotoURL1_show" src="${autobot.workPhotoURL1!}">
                                        <button type="button" class="btn btn-primary btn-lg adminPageBtn"
                                            data-toggle="modal" data-target="#myModal">上传照片</button>
                                        <div class="col-sm-9">
                                            <input type="hidden" name="workPhotoURL1">
                                        </div>
                                    </div>
                                </li>

                                <li class="list-group-item pxshijl_li">
                                    <div class="form-group">
                                        <img id="workPhotoURL2_show" src="${autobot.workPhotoURL1!}">
                                        <button type="button" class="btn btn-primary btn-lg adminPageBtn"
                                            data-toggle="modal" data-target="#myModal">上传工商营业执照副本</button>
                                        <div class="col-sm-9">
                                            <input type="hidden" name="workPhotoURL1">
                                            <!-- 将有效的工商营业执照副本原件或加盖红色单位公章的复印件拍照或扫描后在此上传，由客服人员认证审核。必须上传与公司名称一致，
已年检通过的证照。 -->
                                        </div>
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
                id="company.introduction" cols="45" rows="5" placeholder="请输入企业介绍">
                <#if company?? && company.introduction??> ${company.introduction!}</#if>
            </textarea>
        </div>
    </div>
</form>

					      <!-- <tr>company.name</tr>
					      <tr>company.autoBrand</tr>
					      <tr>company.scale</tr>
                <tr>company.industry.name()</tr>
                <tr>company.address</tr>
                <tr>company.welfare</tr> -->
