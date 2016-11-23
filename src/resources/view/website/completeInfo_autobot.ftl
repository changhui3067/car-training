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
                                               name="uname"
                                               value="<#if autobot?? && autobot.personInfo.name??>${autobot.personInfo.name!}</#if>"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        性别:</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="ugender">
                                            <option value="男" <#if autobot.personInfo.gender = "男">selected</#if>>男</option>
                                            <option value="女" <#if autobot.personInfo.gender = "女">selected</#if>>女</option>
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
                                        <input type="" class="form-control" name="ubirthday"
                                               onclick="laydate()"
                                        value="<#if autobot?? && autobot.personInfo.birthday??>${autobot.personInfo.birthday!}</#if>"/>
                                        <#--value="<#if autobot?? && autobot.personInfo.birthday??>${autobot.personInfo.birthday?string("yyyy-MM-dd")!}</#if>"/>-->
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        联系方式:</label>
                                    <div class="col-sm-9">
                                        <#--<input type="text" class="form-control" name="umobile"-->
                                               <#--placeholder="请输入联系方式"-->
                                               <#--value="<#if autobot?? && autobot.personInfo.mobile??>${autobot.personInfo.mobile!}</#if>"/>-->
                                           <label class="pxshijl_label"><#if autobot?? && autobot.personInfo.mobile??>${autobot.personInfo.mobile!}</#if><label/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        邮箱:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="uemail"
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
                                        <select class="form-control" name="currentWorkStatus">
                                            <option value="在职" <#if autobot.workingStatus = "在职">selected</#if>>在职</option>
                                            <option value="求职" <#if autobot.workingStatus = "求职">selected</#if>>求职</option>
                                        </select>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        婚姻状况:</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="umarryStatus">
                                            <option value="UNMARRIED" <#if autobot.personInfo.marriageStatus = "未婚">selected</#if>>未婚</option>
                                            <option value="MARRIED" <#if autobot.personInfo.marriageStatus = "已婚">selected</#if>>已婚</option>
                                            <option value="RAISED" <#if autobot.personInfo.marriageStatus = "离异">selected</#if>>离异</option>
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
                                               value="<#if autobot?? && autobot.autoYears?? >${autobot.autoYears!}</#if>"/>
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
                                            <button class="btn btn-default dropdown-toggle" type="button"
                                                    id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="true">
                                            <#if autobot.personInfo.region.parent?? >${autobot.personInfo.region.parent.name}<#else>请选择省</#if>
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
                                            <#if autobot.personInfo.region?? >${autobot.personInfo.region.name}<#else>请选择市</#if>
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
                                               value="<#if autobot?? && autobot.autoBrand?? >${autobot.autoBrand!}</#if>"/>
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
                                               value="<#if autobot?? && autobot.currentPosition?? >${autobot.currentPosition!}</#if>"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        擅长领域:</label>
                                    <div class="col-sm-9">
                                        <input type="hidden" name="autobot.businessCategory"/>
                                    <#if autobot ?? && autobot.businessCategory??>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("销售")!=-1>checked</#if>"
                                              value="销售" onclick="categoryClicked(this)">[h]销售</span>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("售后")!=-1>checked</#if>"
                                              value="售后" onclick="categoryClicked(this)">售后</span>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("客服")!=-1>checked</#if>"
                                              value="客服" onclick="categoryClicked(this)">客服</span>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("市场")!=-1>checked</#if>"
                                              value="市场" onclick="categoryClicked(this)">市场</span>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("管理")!=-1>checked</#if>"
                                              value="管理" onclick="categoryClicked(this)">管理</span>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("内训")!=-1>checked</#if>"
                                              value="内训" onclick="categoryClicked(this)">内训</span>
                                        <span class="checkBox <#if autobot.businessCategory ? index_of("行政")!=-1>checked</#if>"
                                              value="行政" onclick="categoryClicked(this)">行政</span>
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
                                    <img id="workPhotoURL1_show" src="${autobot.personInfo.avatarUrl!}">
                                    <button type="button" class="btn btn-primary btn-lg adminPageBtn"
                                            data-toggle="modal" data-target="#myModal">
                                        上传照片
                                    </button>
                                    <div class="col-sm-9">
                                        <input type="hidden" name="workPhotoURL1">
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
        <h5>所获认证</h5>
        <div class="pxshijl_box">
                                <textarea style="width:800px;margin-left:15px;resize:none" name="authHistroy"
                                          id="autobot.authHistroy" cols="45"
                                          rows="5"><#if autobot?? && autobot.certRecords??> ${autobot.certRecords!}<#else>
                                    请输入所获认证</#if></textarea>
        </div>
    </div>
    <div class="pxshijl">
        <h5>工作经历</h5>
        <div class="pxshijl_box">
                                <textarea style="width:800px;margin-left:15px;resize:none" name="workingHistroy"
                                          id="autobot.authHistroy" cols="45"
                                          rows="5"><#if autobot?? && autobot.workingHistory??> ${autobot.workingHistory!}<#else>
                                    请输入工作经历</#if></textarea>
        </div>
    </div>
    <div class="tj">
        <button type="button" class="btn btn-primary" onclick="submitdata()" style=""/>
        保存</button>
    </div>