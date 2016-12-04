<form id="form1" xmlns="http://www.w3.org/1999/html">
    <div class="pxshijl">
        <h5>基本信息</h5>
        <div class="pxshijl_box">
            <div class="errMsg"></div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-7">
                        <ul class="list-group">
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        姓名:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"
                                               placeholder="请输入姓名"
                                               name="name"
                                               value="${autobot.personInfo.name!}"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        性别:</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="gender" value="${autobot.personInfo.gender?? ?then(autobot.personInfo.gender, '')}">
                                            <option value="男" ${(autobot.personInfo.gender?? && autobot.personInfo.gender="男") ?then('selected', '')}>男
                                            </option>
                                            <option value="女" ${(autobot.personInfo.gender?? && autobot.personInfo.gender="男") ?then('selected', '')}>女
                                            </option>
                                        </select>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        出生年月:</label>
                                    <div class="col-sm-9">
                                        <input type="" class="form-control" name="birthday"
                                               onclick="laydate()"
                                               value="<#if autobot.personInfo.birthday??>${autobot.personInfo.birthday?string("yyyy-MM-dd")!}</#if>"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        联系方式:</label>
                                    <div class="col-sm-9">
                                        <label class="pxshijl_label">${autobot.personInfo.mobile!}<label/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        邮箱:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="email"
                                               placeholder="请输入邮箱"
                                               value="<#if autobot?? && autobot.personInfo.email??>${autobot.personInfo.email!}</#if>"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        工作状态:</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="workingStatus" value="<#if autobot.workingStatus??>${autobot.workingStatus}</#if>">
                                            <option value="在职" ${(autobot.workingStatus?? && autobot.workingStatus = "在职") ?then('selected','')}>在职</option>
                                            <option value="求职" ${(autobot.workingStatus?? && autobot.workingStatus = "求职") ?then('selected','')}>求职</option>
                                        </select>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        行业经验:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"
                                               name="autoYears"
                                               placeholder="请输入行业经验"
                                               onkeyup="verifyNumber(this)"
                                               value="${autobot.autoYears!}"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        学历:</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="education" value="<#if autobot.education??>${autobot.education}</#if>">
                                            <option value="小学" ${(autobot.education?? && autobot.education = "小学") ?then('selected','')}>小学</option>
                                            <option value="初中" ${(autobot.education?? && autobot.education = "初中") ?then('selected','')}>初中</option>
                                            <option value="高中" ${(autobot.education?? && autobot.education = "高中") ?then('selected','')}>高中</option>
                                            <option value="本科" ${(autobot.education?? && autobot.education = "本科") ?then('selected','')}>本科</option>
                                            <option value="研究生" ${(autobot.education?? && autobot.education = "研究生") ?then('selected','')}>研究生</option>
                                            <option value="博士" ${(autobot.education?? && autobot.education = "博士") ?then('selected','')}>博士</option>
                                        </select>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        目前地区:</label>
                                    <div class="col-sm-9">
                                        <div class="dropdown" id="province">
                                            <input name="regionId" type="hidden" value="<#if userRegion?? >${userRegion.id}<#else>${1}</#if>">
                                            <button class="btn btn-default dropdown-toggle" type="button"
                                                    id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="true">
                                                ${userRegion?? ?then(userRegion.parent.name, "请选择省")}
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                            <#list provinces as t>
                                                <li><a href='#' onclick="selectCities(this, false)"
                                                       value="${t.id!}">${t.name!}</a></li>
                                            </#list>
                                            </ul>
                                        </div>
                                        <div class="dropdown" name="uregionId" id="city">
                                            <button class="btn btn-default dropdown-toggle" type="button"
                                                    id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="true">
                                                ${userRegion?? ?then(userRegion.name, "请选择市")}
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                            <#if cities??>
                                                <#list cities as city>
                                                    <li value="${city.id!}">
                                                        <a href='#' onclick="selectCity(this)">${city.name!}</a>
                                                    </li>
                                                </#list>
                                            </#if>
                                            </ul>
                                        </div>

                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        汽车品牌:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="autoBrand"
                                               placeholder="请输入汽车品牌"
                                               value="${autobot.autoBrand!}"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        当前职位:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="currentPosition"
                                               placeholder="请输入当前职位"
                                               value="${autobot.currentPosition!}"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        擅长领域:</label>
                                    <div class="col-sm-9 businessCategoryFather">
                                        <input type="hidden" name="businessCategory"/>
                                    <#if autobot ?? && autobot.businessCategory??>
                                    <#--<span class="checkBox <#if autobot.businessCategory ? index_of("Sales")!=-1>checked</#if>"-->
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("内训")!=-1>checked</#if>"
                                              value="内训" onclick="categoryClicked(this)">内训</span>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("销售市场")!=-1>checked</#if>"
                                              value="销售市场" onclick="categoryClicked(this)">销售市场</span>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("售后客服")!=-1>checked</#if>"
                                              value="售后客服" onclick="categoryClicked(this)">售后客服</span>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("高级管理")!=-1>checked</#if>"
                                              value="高级管理" onclick="categoryClicked(this)">高级管理</span>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("人事财务")!=-1>checked</#if>"
                                              value="人事财务" onclick="categoryClicked(this)">人事财务</span>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("生产研发")!=-1>checked</#if>"
                                              value="生产研发" onclick="categoryClicked(this)">生产研发</span>
                                    </#if>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-5">
                        <ul class="list-group">
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <img id="avatar_show" src="${autobot.personInfo.avatarUrl!}">
                                    <button id="avatar_btn" type="button" class="btn btn-primary btn-lg adminPageBtn">
                                        上传照片
                                    </button>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="pxshijl">
        <h5>所获认证</h5>
        <div class="pxshijl_box">
            <textarea style="width:800px;margin-left:15px;resize:none" name="certRecords" id="autobot.authHistroy" cols="45" rows="5" placeholder="请输入所获认证"
                    value="<#if autobot?? && autobot.certRecords??> ${autobot.certRecords!}</#if>">
            <#if autobot?? && autobot.certRecords??> ${autobot.certRecords!}</#if>
            </textarea>
        </div>
    </div>
    <div class="pxshijl">
        <h5>工作经历</h5>
        <div class="pxshijl_box">
            <textarea style="width:800px;margin-left:15px;resize:none" name="workingHistory" id="autobot.authHistroy" cols="45"rows="5" placeholder="请输入工作经历"
                    value="<#if autobot?? && autobot.workingHistory??> ${autobot.workingHistory!}</#if>">
            <#if autobot?? && autobot.workingHistory??> ${autobot.workingHistory!}</#if>
            </textarea>
        </div>
    </div>
    <div class="tj">
        <button type="button" class="btn btn-primary" onclick="submitAutobotInfo()" style=""/>保存</button>
    </div>
    