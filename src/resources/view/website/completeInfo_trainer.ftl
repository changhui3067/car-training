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
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        姓名:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"
                                               placeholder="请输入姓名"
                                               name="name"
                                               value="<#if trainer?? && trainer.personInfo.name??>${trainer.personInfo.name!}</#if>"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        性别:</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="gender" value="<#if trainer.personInfo.gender??>${trainer.personInfo.gender}</#if>">
                                            <option value="男" <#if trainer.personInfo.gender = "男">selected</#if>>男</option>
                                            <option value="女" <#if trainer.personInfo.gender = "女">selected</#if>>女</option>
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
                                               value="<#if trainer?? && trainer.personInfo.birthday??>${trainer.personInfo.birthday!}</#if>"/>
									<#--value="<#if trainer?? && trainer.personInfo.birthday??>${trainer.personInfo.birthday?string("yyyy-MM-dd")!}</#if>"/>-->
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        联系方式:</label>
                                    <div class="col-sm-9">
                                        <label class="pxshijl_label"><#if trainer?? && trainer.personInfo.mobile??>${trainer.personInfo.mobile!}</#if><label/>
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
                                               value="<#if trainer?? && trainer.personInfo.email??>${trainer.personInfo.email!}</#if>"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        学历:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="education"
                                               placeholder="请输入学历"
                                               value="<#if trainer?? && trainer.education??>${trainer.education!}</#if>"/>
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
                                               value="<#if trainer?? && trainer.autoYears?? >${trainer.autoYears!}</#if>"/>
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
											<#if trainer.personInfo.region.parent?? >${trainer.personInfo.region.parent.name}<#else>请选择省</#if>
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<#list provinces as t>
                                                <li><a href='#' onclick="selectCities(this, false)"
                                                       value="${t.id!}">${t.name!}</a></li>
											</#list>
                                            </ul>
                                        </div>
                                        <div class="dropdown" id="city">
                                            <button class="btn btn-default dropdown-toggle" type="button"
                                                    id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="true">
											<#if trainer.personInfo.region?? >${trainer.personInfo.region.name}<#else>请选择市</#if>
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                                <#if cities??>
                                                    <#list cities as city>
                                                        <li value="${city.id!}"><a href='#'
                                                                                   onclick="selectCity(this)">${city.name!}</a>
                                                        </li>
                                                    </#list>
                                                </#if>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <#--"个人介绍" & "主要课程" ， 暂时隐藏-->
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        当前职位:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="currentPosition"
                                               placeholder="请输入当前职位"
                                               value="<#if trainer?? && trainer.currentPosition?? >${trainer.currentPosition!}</#if>"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        视频链接1:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"
                                               name="videoURL1"
                                               placeholder="请输入视频链接1"
                                               value="<#if trainer?? && trainer.videoUrl1?? >${trainer.videoUrl1!}</#if>"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        视频链接2:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"
                                               name="videoURL2"
                                               placeholder="请输入视频链接2"
                                               value="<#if trainer?? && trainer.videoUrl2?? >${trainer.videoUrl2!}</#if>"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group mb0">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        擅长领域:</label>
                                    <div class="col-sm-9 businessCategoryFather">
                                        <input type="hidden" name="businessCategory"/>
									<#if trainer ?? && trainer.businessCategory??>
                                        <#--<span class="checkBox <#if trainer.businessCategory ? index_of("Sales")!=-1>checked</#if>"-->
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("销售")!=-1>checked</#if>"
                                              value="销售" onclick="categoryClicked(this)">销售</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("产品")!=-1>checked</#if>"
                                              value="产品" onclick="categoryClicked(this)">产品</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("技术")!=-1>checked</#if>"
                                              value="技术" onclick="categoryClicked(this)">技术</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("管理")!=-1>checked</#if>"
                                              value="管理" onclick="categoryClicked(this)">管理</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("财务")!=-1>checked</#if>"
                                              value="财务" onclick="categoryClicked(this)">财务</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("人事")!=-1>checked</#if>"
                                              value="人事" onclick="categoryClicked(this)">人事</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("生产")!=-1>checked</#if>"
                                              value="生产" onclick="categoryClicked(this)">生产</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("非技术")!=-1>checked</#if>"
                                              value="非技术" onclick="categoryClicked(this)">非技术</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("领导力")!=-1>checked</#if>"
                                              value="领导力" onclick="categoryClicked(this)">领导力</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("新能源")!=-1>checked</#if>"
                                              value="新能源" onclick="categoryClicked(this)">新能源</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("市场营销")!=-1>checked</#if>"
                                              value="市场营销" onclick="categoryClicked(this)">市场营销</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("客户关系")!=-1>checked</#if>"
                                              value="客户关系" onclick="categoryClicked(this)">客户关系</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("其他")!=-1>checked</#if>"
                                              value="其他" onclick="categoryClicked(this)">其他</span>
									</#if>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li pt0">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        执行类型:</label>
                                    <div class="col-sm-9 executionCategoryFather">
                                        <input type="hidden" name="executionCategory"/>
									  <#if trainer ?? && trainer.executionCategory??>
                                        <span class="checkBox <#if trainer.executionCategory ? index_of("开发")!=-1>checked</#if>"
                                              value="开发" onclick="categoryClicked(this)">开发</span>
                                        <span class="checkBox <#if trainer.executionCategory ? index_of("培训")!=-1>checked</#if>"
                                              value="培训" onclick="categoryClicked(this)">培训</span>
                                        <span class="checkBox <#if trainer.executionCategory ? index_of("辅导")!=-1>checked</#if>"
                                              value="辅导" onclick="categoryClicked(this)">辅导</span>
                                        <span class="checkBox <#if trainer.executionCategory ? index_of("项目管理")!=-1>checked</#if>"
                                              value="项目管理" onclick="categoryClicked(this)">项目管理</span>
                                        <span class="checkBox <#if trainer.executionCategory ? index_of("经销商托管")!=-1>checked</#if>"
                                              value="经销商托管" onclick="categoryClicked(this)">经销商托管</span>
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
                                    <img id="avatar_show" src="${trainer.personInfo.avatarUrl!}">
                                    <button id="avatar_btn" type="button" class="btn btn-primary btn-lg adminPageBtn">
                                        上传照片
                                    </button>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li trainerVideoExample">
                                <div class="form-group ">
                                    <img id="avatar_show" src="/assets/website/images/example.png">
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="pxshijl">
        <h5>培训师简介</h5>
        <div class="pxshijl_box">
            <textarea style="width:800px;margin-left:15px;resize:none" name="introduction" cols="45" rows="5" placeholder="请输入培训师简介"
                    value="<#if trainer?? && trainer.introduction??> ${trainer.introduction!}</#if>">
            </textarea>
        </div>
    </div>

    <#--主讲课程-->

    <div class="tj">
        <button type="button" class="btn btn-primary" onclick="submitTrainerInfo()" style=""/>
        保存</button>
    </div>
</form>