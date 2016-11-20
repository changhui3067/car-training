<form id="form1">
<<<<<<< Updated upstream
	<div class="pxshijl">
   		<h5>基本信息</h5>
    	<div class="pxshijl_box">
    		<div class="errMsg"></div>
    		<div class="container">
    			<div class="row">
    				<div class="col-sm-7">
    					<ul class="list-group">
    						<li class="list-group-item pxshijl_li">
=======
<!--隐藏域-->
<#--<input type="hidden" name="trainer.userCenter.personalType" value="TRAINER">-->
<#--<input type="hidden" name="trainer.id" value="<#if trainer??>${trainer.id!}</#if>">-->
<#--<input type="hidden" name="trainer.userCenter.id" value="<#if trainer?? && trainer.userCenter??>${trainer.userCenter.id!}</#if>">-->
<!--隐藏域-->
    <div class="pxshijl">
        <h5>基本信息</h5>
        <div class="pxshijl_box">
            <div class="errMsg"></div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-7">
                        <ul class="list-group">
                            <li class="list-group-item pxshijl_li">
>>>>>>> Stashed changes
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        姓名:</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control"
                                               placeholder="请输入姓名"
                                               name="uname"
<<<<<<< Updated upstream
                                               value="<#if trainer?? && trainer.personInfo.name??>${autobot.personInfo.name!}</#if>"/>
                                    </div>
                                </div>
                            </li>
    					</ul>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>

	<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td colspan="2"width="420" align="left" valign="top"><table width="400" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="69" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 姓 名：</td>
	        <td width="292">
	        <#if trainer?? && trainer.userCenter?? && trainer.userCenter.name?? >
	        <input type="text" name="trainer.userCenter.name" value="${trainer.userCenter.name!}" />
			<#else>
			<input type="text" name="trainer.userCenter.name" value="" />
			</#if></td>
			</tr>
	      <tr>
	        <td height="40" align="right" valign="middle"><font color="#ff0000">*</font>出生年月：</td>
	        <td>
	         <#if trainer?? && trainer.userCenter?? && trainer.userCenter.birthday?? >
	        <input type="date" name="trainer.userCenter.birthday" value="${trainer.userCenter.birthday!?string("yyyy-MM-dd")}" onclick="laydate()" />
	        <#else>
	        <input type="date" name="trainer.userCenter.birthday" value=""  onclick="laydate()"/>
	     	</#if>
	      </td>
	      </tr>
	      <tr>
	        <td height="40" align="right" valign="middle"><font color="#ff0000">*</font>婚姻状况：</td>
	        <td>
	       		<#if trainer?? && trainer.userCenter?? && trainer.userCenter.marryStatus?? && trainer.userCenter.marryStatus.name() = 'UNMARRIED' >
	        	<input checked="checked" type="radio" name="trainer.userCenter.marryStatus" value="UNMARRIED" id="ty_per10" />
	        	<#else>
	        	<input type="radio" name="trainer.userCenter.marryStatus" value="UNMARRIED" id="ty_per10" />
	        	</#if>
				未婚
				<#if trainer?? && trainer.userCenter?? && trainer.userCenter.marryStatus?? && trainer.userCenter.marryStatus.name() = 'MARRIED'>
				<input checked="checked" type="radio" name="trainer.userCenter.marryStatus" value="MARRIED" id="ty_per11" />
				<#else>
				<input type="radio" name="trainer.userCenter.marryStatus" value="MARRIED" id="ty_per11" />
				</#if>
				已婚
				<#if trainer?? && trainer.userCenter?? && trainer.userCenter.marryStatus?? && trainer.userCenter.marryStatus.name() = 'RAISED'>
				<input checked="checked" type="radio" name="trainer.userCenter.marryStatus" value="RAISED" id="ty_per12" />
				<#else>
				<input type="radio" name="trainer.userCenter.marryStatus" value="RAISED" id="ty_per12" />
				</#if>
				已育</td>
	      </tr>
	    </table></td>
	    <td width="439" colspan="4" align="left" valign="top"><table width="400" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td><img id="trainer.userCenter.headLogo" src="<#if trainer.personInfo.avatarUrl??>${trainer.personInfo.avatarUrl!}<#else>http://obu3flkwk.bkt.clouddn.com/backend/images/zw.jpg</#if>" style="width:50px;height:50px;"/></td>
	        </tr>
	      <tr>
	        <td>
	        
	        
		        <table width="400" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td  width="15%" height="40" align="left" valign="middle"><input type="file" name="headLogo" id="headLogo" value="浏 览" onChange="selectImage(this)"/></td>
		            <td width="23%" align="left" valign="middle"></td>
		            <td width="62%" align="left" valign="middle"></td>
		            </tr>
		          </table></td>
		        </tr>
		      <tr>
		        <td><font color="#CCCCCC">请上传宽度为180px,高度为150px,格式：jpg,gif, 大小&lt;500kb的图片</font></td>
		        </tr>
		      </table>
=======
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
                                        <select class="form-control" name="ugender">
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
                                        <input type="" class="form-control" name="ubirthday"
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
                                        <input type="text" class="form-control" name="uemail"
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
                                        <input type="text" class="form-control" name="trainer.education"
                                               placeholder="请输入学历"
                                               value="<#if trainer?? && trainer.education??>${trainer.education!}</#if>"/>
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
                                            <option value="UNMARRIED" <#if trainer.personInfo.marriageStatus = "未婚">selected</#if>>未婚</option>
                                            <option value="MARRIED" <#if trainer.personInfo.marriageStatus = "已婚">selected</#if>>已婚</option>
                                            <option value="RAISED" <#if trainer.personInfo.marriageStatus = "离异">selected</#if>>离异</option>
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
                                            <button class="btn btn-default dropdown-toggle" type="button"
                                                    id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="true">
											<#if trainer.personInfo.region.parent?? >${trainer.personInfo.region.parent.name}<#else>请选择省</#if>
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
											<#if trainer.personInfo.region?? >${trainer.personInfo.region.name}<#else>请选择市</#if>
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
>>>>>>> Stashed changes

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
                                               name="trainer.vedioURL1"
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
                                               name="trainer.vedioURL2"
                                               placeholder="请输入视频链接1"
                                               value="<#if trainer?? && trainer.videoUrl2?? >${trainer.videoUrl2!}</#if>"/>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        擅长领域:</label>
                                    <div class="col-sm-9">
                                        <input type="hidden" name="trainer.businessCategory"/>
									<#if trainer ?? && trainer.businessCategory??>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("销售")!=-1>checked</#if>"
                                              value="销售" onclick="categoryClicked(this)">[h]销售</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("售后")!=-1>checked</#if>"
                                              value="售后" onclick="categoryClicked(this)">售后</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("客服")!=-1>checked</#if>"
                                              value="客服" onclick="categoryClicked(this)">客服</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("市场")!=-1>checked</#if>"
                                              value="市场" onclick="categoryClicked(this)">市场</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("管理")!=-1>checked</#if>"
                                              value="管理" onclick="categoryClicked(this)">管理</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("内训")!=-1>checked</#if>"
                                              value="内训" onclick="categoryClicked(this)">内训</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("行政")!=-1>checked</#if>"
                                              value="行政" onclick="categoryClicked(this)">行政</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("生产研发")!=-1>checked</#if>"
                                              value="生产研发" onclick="categoryClicked(this)">生产研发</span>
									<#--<#else>-->
									<#--<input type="checkBox" name="trainer.businessCategory"-->
									<#--id="trainer.businessCategory" value="销售"/>销售-->
									<#--<input type="checkBox" name="trainer.businessCategory"-->
									<#--id="trainer.businessCategory" value="售后"/>售后-->
									<#--<input type="checkBox" name="trainer.businessCategory"-->
									<#--id="trainer.businessCategory" value="客服"/>客服-->
									<#--<input type="checkBox" name="trainer.businessCategory"-->
									<#--id="trainer.businessCategory" value="市场"/>市场-->
									<#--<input type="checkBox" name="trainer.businessCategory"-->
									<#--id="trainer.businessCategory" value="管理"/>管理-->
									<#--<input type="checkBox" name="trainer.businessCategory"-->
									<#--id="trainer.businessCategory" value="内训"/>内训-->
									<#--<input type="checkBox" name="trainer.businessCategory"-->
									<#--id="trainer.businessCategory" value="生产研发"/>生产研发-->
									<#--<input type="checkBox" name="trainer.businessCategory"-->
									<#--id="trainer.businessCategory" value="行政"/>行政-->
									</#if>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item pxshijl_li">
                                <div class="form-group">
                                    <label class="col-sm-3 pxshijl_label"><span
                                            style="color: red">*</span>
                                        执行类型:</label>
                                    <div class="col-sm-9">
									  <#if trainer ?? && trainer.executionCategory??>
                                        <input type="hidden" name="trainer.executionCategory"/>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("销售")!=-1>checked</#if>"
                                              value="销售" onclick="categoryClicked(this)">[h]销售</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("售后")!=-1>checked</#if>"
                                              value="售后" onclick="categoryClicked(this)">售后</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("客服")!=-1>checked</#if>"
                                              value="客服" onclick="categoryClicked(this)">客服</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("市场")!=-1>checked</#if>"
                                              value="市场" onclick="categoryClicked(this)">市场</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("管理")!=-1>checked</#if>"
                                              value="管理" onclick="categoryClicked(this)">管理</span>
                                        <span class="checkBox <#if trainer.businessCategory ? index_of("内训")!=-1>checked</#if>"
                                              value="内训" onclick="categoryClicked(this)">内训</span>
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
                                    <img id="workPhotoURL1_show" src="${trainer.personInfo.avatarUrl!}">
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
        <h5>培训师简介</h5>
        <div class="pxshijl_box">
                                <textarea style="width:800px;margin-left:15px;resize:none" name="trainer.userCenter.intro"
                                          id="autobot.authHistroy" cols="45"
                                          rows="5"><#if trainer?? && trainer.introduction??> ${trainer.introduction!}<#else>
                                    请输入培训师简介</#if></textarea>
        </div>
    </div>

    <div class="tj">
        <button type="button" class="btn btn-primary" onclick="submitdata()" style=""/>
        保存</button>
    </div>
	
	  <#--<div class="pxshijl">-->
   <#--<h5>基本信息</h5>-->
    <#--<div class="pxshijl_box">-->
	<#--<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">-->
	  <#--<tr>-->
	    <#--<td colspan="2"width="420" align="left" valign="top"><table width="400" border="0" cellspacing="0" cellpadding="0">-->
	      <#--<tr>-->
	        <#--<td width="69" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 姓 名：</td>-->
	        <#--<td width="292">-->
	        <#--<#if trainer?? && trainer.userCenter?? && trainer.userCenter.name?? >-->
	        <#--<input type="text" name="trainer.userCenter.name" value="${trainer.userCenter.name!}" />-->
			<#--<#else>-->
			<#--<input type="text" name="trainer.userCenter.name" value="" />-->
			<#--</#if></td>-->
			<#--</tr>-->
	      <#--<tr>-->
	        <#--<td height="40" align="right" valign="middle"><font color="#ff0000">*</font>出生年月：</td>-->
	        <#--<td>-->
	         <#--<#if trainer?? && trainer.userCenter?? && trainer.userCenter.birthday?? >-->
	        <#--<input type="date" name="trainer.userCenter.birthday" value="${trainer.userCenter.birthday!?string("yyyy-MM-dd")}" onclick="laydate()" />-->
	        <#--<#else>-->
	        <#--<input type="date" name="trainer.userCenter.birthday" value=""  onclick="laydate()"/>-->
	     	<#--</#if>-->
	      <#--</td>-->
	      <#--</tr>-->
	      <#--<tr>-->
	        <#--<td height="40" align="right" valign="middle"><font color="#ff0000">*</font>婚姻状况：</td>-->
	        <#--<td>-->
	       		<#--<#if trainer?? && trainer.userCenter?? && trainer.userCenter.marryStatus?? && trainer.userCenter.marryStatus.name() = 'UNMARRIED' >-->
	        	<#--<input checked="checked" type="radio" name="trainer.userCenter.marryStatus" value="UNMARRIED" id="ty_per10" />-->
	        	<#--<#else>-->
	        	<#--<input type="radio" name="trainer.userCenter.marryStatus" value="UNMARRIED" id="ty_per10" />-->
	        	<#--</#if>-->
				<#--未婚-->
				<#--<#if trainer?? && trainer.userCenter?? && trainer.userCenter.marryStatus?? && trainer.userCenter.marryStatus.name() = 'MARRIED'>-->
				<#--<input checked="checked" type="radio" name="trainer.userCenter.marryStatus" value="MARRIED" id="ty_per11" />-->
				<#--<#else>-->
				<#--<input type="radio" name="trainer.userCenter.marryStatus" value="MARRIED" id="ty_per11" />-->
				<#--</#if>-->
				<#--已婚-->
				<#--<#if trainer?? && trainer.userCenter?? && trainer.userCenter.marryStatus?? && trainer.userCenter.marryStatus.name() = 'RAISED'>-->
				<#--<input checked="checked" type="radio" name="trainer.userCenter.marryStatus" value="RAISED" id="ty_per12" />-->
				<#--<#else>-->
				<#--<input type="radio" name="trainer.userCenter.marryStatus" value="RAISED" id="ty_per12" />-->
				<#--</#if>-->
				<#--已育</td>-->
	      <#--</tr>-->
	    <#--</table></td>-->
	    <#--<td width="439" colspan="4" align="left" valign="top"><table width="400" border="0" cellspacing="0" cellpadding="0">-->
	      <#--<tr>-->
	        <#--<td><img id="trainer.userCenter.headLogo" src="<#if trainer.personInfo.avatarUrl??>${trainer.personInfo.avatarUrl!}<#else>http://obu3flkwk.bkt.clouddn.com/backend/images/zw.jpg</#if>" style="width:50px;height:50px;"/></td>-->
	        <#--</tr>-->
	      <#--<tr>-->
	        <#--<td>-->
	        <#---->
	        <#---->
		        <#--<table width="400" border="0" cellspacing="0" cellpadding="0">-->
		          <#--<tr>-->
		            <#--<td  width="15%" height="40" align="left" valign="middle"><input type="file" name="headLogo" id="headLogo" value="浏 览" onChange="selectImage(this)"/></td>-->
		            <#--<td width="23%" align="left" valign="middle"></td>-->
		            <#--<td width="62%" align="left" valign="middle"></td>-->
		            <#--</tr>-->
		          <#--</table></td>-->
		        <#--</tr>-->
		      <#--<tr>-->
		        <#--<td><font color="#CCCCCC">请上传宽度为180px,高度为150px,格式：jpg,gif, 大小&lt;500kb的图片</font></td>-->
		        <#--</tr>-->
		      <#--</table>-->


	      <#--</td>-->
	  <#--</tr>-->
	  <#--</table>-->
	<#--<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" align="left">-->
      <#--<tr>-->
	    <#--<td height="40" align="right" valign="middle"><font color="#ff0000">*</font> 学历：</td>-->
	    <#--<td>-->

	    <#--</td>-->

	    <#--<td align="right" valign="middle"><font color="#ff0000">*</font> 手机：</td>-->
	    <#--<td>-->
	    <#--<#if trainer?? && trainer.personInfo?? && trainer.personInfo.mobile??>-->
	    <#--<input type="tel" name="trainer.userCenter.mobile" value="${trainer.personInfo.mobile!}" />-->
	    <#--<#else>-->
	    <#--<input type="tel" name="trainer.userCenter.mobile" value="" />-->
	    <#--</#if>-->
	    <#--</td>-->
	    <#--</tr>-->
	    <#--<tr>-->
	     <#--<td height="40" align="right" valign="middle"><font color="#ff0000">*</font> 区域：</td>-->
            	    <#--<td>-->
            	   <#--<select name="province" id="province" onChange="selectCities()">-->
                       <#--<option value="">请选择省</option>-->
				   <#--<#list provinces as t>-->
                       <#--<option value="${t.id!}"<#if userRegion?? && userRegion.parent.id == t.id>selected="selected"</#if>>${t.name!}</option>-->
				   <#--</#list>-->
                   <#--</select>-->
                        <#--<select name="city" id="city">-->
                            <#--<option value="">请选择市</option>-->
						<#--<#list cities as city>-->
                            <#--<option value="${city.id!}" <#if userRegion ?? && city.id == userRegion.id>selected="selected"</#if>>${city.name!}</option>-->
						<#--</#list>-->
					<#--</select>-->
            	    <#--</td>-->
		      	    <#--<td width="125" align="right" valign="middle"><font color="#ff0000">*</font> 邮箱：</td>-->
		    	    <#--<td width="337">-->
		    	     <#--<#if trainer?? && trainer.userCenter?? && trainer.userCenter.email??>-->
		    	    <#--<input type="eamil" name="trainer.userCenter.email" value="${trainer.userCenter.email!}" />-->
		    	    <#--<#else>-->
		    	    <#--<input type="email" name="trainer.userCenter.email" value=""  />-->
		    	    <#--</#if>-->
		    	    <#--</td>-->

		    	    <#--</tr>-->
		    	     <#--<tr>-->
            	   <#--<td width="125" align="right" valign="middle"><font color="#ff0000">*</font> 汽车行业经验：</td>-->
            	    <#--<td width="337">-->
            	    <#--<select name="trainer.autoYears" id="trainer.autoYears">-->
            	    <#--<option value="">请选择</option>-->
            	    <#--<#if trainer?? && trainer.autoYears?? >-->
            	    <#--<option selected="selected" value="${trainer.autoYears!}">${trainer.autoYears!}</option>-->
					<#--</#if>-->
            	    <#--<#list 0..20 as t>-->
					<#--<option  value="${t}">${t}</option>-->
					<#--</#list>-->
					<#--</select>&nbsp;<font color="red" >选择0表示应界毕业生</font>-->
            	    <#--</td>-->
          	    <#--</tr>-->
     			<#--<tr>-->
            	    <#--<td height="40" align="right" valign="middle"><font color="#ff0000">*</font>擅长领域：</td>-->
            	    <#--<td colspan="3">-->
            	    <#--<#if trainer ?? && trainer.businessCategory??>-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory" <#if trainer.businessCategory ? index_of("销售")!=-1> checked </#if> value="销售"/>销售-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory" <#if trainer.businessCategory ? index_of("售后")!=-1> checked </#if> value="售后"/>售后-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory" <#if trainer.businessCategory ? index_of("客服")!=-1> checked </#if> value="客服"/>客服-->
        	   		<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory" <#if trainer.businessCategory ? index_of("市场")!=-1> checked </#if> value="市场"/>市场-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory" <#if trainer.businessCategory ? index_of("管理")!=-1> checked </#if> value="管理"/>管理-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory" <#if trainer.businessCategory ? index_of("内训")!=-1> checked </#if> value="内训"/>内训-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory" <#if trainer.businessCategory ? index_of("生产研发")!=-1> checked </#if> value="生产研发"/>生产研发-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory" <#if trainer.businessCategory ? index_of("行政")!=-1> checked </#if> value="行政"/>行政-->
            	    <#--<#else>-->
            	    	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory"  value="销售"/>销售-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory"  value="售后"/>售后-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory"  value="客服"/>客服-->
        	   		<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory"  value="市场"/>市场-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory"  value="管理"/>管理-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory"  value="内训"/>内训-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory"  value="生产研发"/>生产研发-->
            	   	<#--<input type="checkBox" name="trainer.businessCategory" id="trainer.businessCategory"  value="行政"/>行政-->
            	   	<#--</#if>-->
            	    <#--</td>-->
          	    <#--</tr>-->
          	    <#--<tr>-->
            	    <#--<td height="40" align="right" valign="middle"><font color="#ff0000">*</font>执行类型：</td>-->
            	    <#--<td colspan="3">-->
            	    <#--<#if trainer ?? && trainer.executionCategory??>-->
            	   	<#--<input type="checkBox" name="trainer.executionCategory" id="trainer.executionCategory" <#if trainer.executionCategory ? index_of("开发")!=-1> checked </#if> value="开发"/>开发-->
            	   	<#--<input type="checkBox" name="trainer.executionCategory" id="trainer.executionCategory" <#if trainer.executionCategory ? index_of("培训")!=-1> checked </#if> value="培训"/>培训-->
            	   	<#--<input type="checkBox" name="trainer.executionCategory" id="trainer.executionCategory" <#if trainer.executionCategory ? index_of("辅导")!=-1> checked </#if> value="辅导"/>辅导-->
        	   		<#--<input type="checkBox" name="trainer.executionCategory" id="trainer.executionCategory" <#if trainer.executionCategory ? index_of("项目管理")!=-1> checked </#if> value="项目管理"/>项目管理-->
            	   	<#--<input type="checkBox" name="trainer.executionCategory" id="trainer.executionCategory" <#if trainer.executionCategory ? index_of("经销商托管")!=-1> checked </#if> value="经销商托管"/>经销商托管-->
            	    <#--<#else>-->
            	    <#--<input type="checkBox" name="trainer.executionCategory" id="trainer.executionCategory"  value="开发"/>开发-->
            	   	<#--<input type="checkBox" name="trainer.executionCategory" id="trainer.executionCategory"  value="培训"/>培训-->
            	   	<#--<input type="checkBox" name="trainer.executionCategory" id="trainer.executionCategory"  value="辅导"/>辅导-->
        	   		<#--<input type="checkBox" name="trainer.executionCategory" id="trainer.executionCategory"  value="项目管理"/>项目管理-->
            	   	<#--<input type="checkBox" name="trainer.executionCategory" id="trainer.executionCategory"  value="经销商托管"/>经销商托管-->
            	   	<#--</#if>-->
            	    <#--</td>-->
          	    <#--</tr>-->
          	    	<#--<tr>-->
            	    <#--<td height="40" align="right" valign="middle"><font color="#ff0000">*</font>视频链接1：</td>-->
            	    <#--<td colspan="3">-->
            	    <#--<#if trainer?? && trainer.vedioURL1?? >-->
			        <#--<input type="text" name="trainer.vedioURL1" value="${trainer.vedioURL1!}" style="width:400px;"/>-->
					<#--<#else>-->
					<#--<input type="text" name="trainer.vedioURL1" value="" style="width:400px;"/>-->
					<#--</#if>-->
            	    <#--</td>-->

          	    <#--</tr>-->
          	     <#--</tr>-->
          	    	<#--<tr>-->
            	    <#--<td height="40" align="right" valign="middle"><font color="#ff0000">*</font>视频链接2：</td>-->
            	    <#--<td colspan="3">-->
					<#--<#if trainer?? && trainer.vedioURL2?? >-->
			        <#--<input type="text" name="trainer.vedioURL2" value="${trainer.vedioURL2!}" style="width:400px;"/>-->
					<#--<#else>-->
					<#--<input type="text" name="trainer.vedioURL2" value="" style="width:400px;"/>-->
					<#--</#if>-->
            	    <#--</td>-->

          	    <#--</tr>-->
	  <#--</table>-->
<#--</div>-->
<#--</div>-->
	
  <#--<div class="pxshijl">-->
       	  <#--<h5>培训师简介</h5>-->
            <#--<div class="pxshijl_box">-->
<#--<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">-->
<#--<tr>-->
<#--<td height="40" colspan="4" align="left" valign="middle"><table width="90%" border="0" cellspacing="0" cellpadding="0">-->
<#--<tr>-->
<#--<td width="11%"><font color="#ff0000">*</font>培训师简介：</td>-->
<#--<td width="89%"><textarea style="width:600px;" name="trainer.userCenter.intro" id="trainer.userCenter.intro" cols="45" rows="5"><#if trainer?? && trainer.userCenter?? && trainer.userCenter.intro??> ${trainer.userCenter.intro!} <#else>请输入个人简介</#if></textarea></td>-->
<#--</tr>-->
<#--</table></td>-->
<#--</tr>-->
<#--</table>-->
        <#--</div>-->
  <#--</div>-->
  <#--<div class="pxshijl">-->
       	  <#--<h5>主讲课程</h5>-->
            <#--<div class="pxshijl_box">-->
            	<#--<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">-->
<#--<tr>-->
<#--<td height="40" colspan="4" align="left" valign="middle"><table width="90%" border="0" cellspacing="0" cellpadding="0">-->
<#--<tr>-->
<#--<td width="11%"><font color="#ff0000">*</font>主讲课程：</td>-->
<#--<td width="89%"><textarea style="width:600px;" name="trainer.mainCourse" id="textarea2" cols="45" rows="5"><#if trainer?? && trainer.mainCourse?? > ${trainer.mainCourse!}<#else>请输入主讲课程</#if></textarea></td>-->
<#--</tr>-->
<#--</table></td>-->
<#--</tr>-->
<#--</table>-->
        <#--</div>-->
  <#--</div>-->

  <#--<div class="tj">-->
        <#--<table width="100%" border="0" cellspacing="0" cellpadding="0">-->
          <#--<tr>-->
            <#--<td height="60" align="center" valign="middle">-->
            <#--<a style="cursor:hand"><input type="button" onclick="submitdata()" style="width:58px;height:28px;background-repeat:no-repeat;background-image:url(http://obu3flkwk.bkt.clouddn.com/backend/images/bc.jpg);border:0;"/></a>-->
             <#--&nbsp;&nbsp;&nbsp;&nbsp;</td>-->
          <#--</tr>-->
        <#--</table>-->
      <#--</div>-->
</div>
</form>
<script>
function checkform(){
	var name = $("[name='trainer.userCenter.name']").val();
	var education = $("[name='trainer.education']").val();
	var birthday = $("[name='trainer.userCenter.birthday']").val();
	var marryStatus = $("[name='trainer.userCenter.marryStatus']").val();
	var mobile = $("input[name='trainer.userCenter.mobile']").val();
	var intro = $("[name='trainer.userCenter.intro']").val();
	var mainCourse = $("[name='trainer.mainCourse']").val();

	if(name == undefined || education == undefined || birthday == undefined || marryStatus == undefined || mobile == undefined || intro == undefined || mainCourse == undefined){
		alert("带*的为必填字段 ");
		return false;
	}
	if(name == '' || education == '' || birthday == '' || marryStatus == '' || mobile == '' || intro == '' || mainCourse == ''){
		alert("带*的为必填字段 ");
		return false;
	}
	return true;
}

function submitdata(){

	if(!checkform()){
		return;
	}
	var form_data = {};
	var url  = "/backend/trainerCompleteResume/save";

	var uheadLogo = document.getElementById('trainer.userCenter.headLogo').src;
	var upersonalType = $("[name='trainer.userCenter.personalType']").val();
	var tid = $("[name='trainer.id']").val();
	var uid = $("[name='trainer.userCenter.id']").val();
	var uname = $("[name='trainer.userCenter.name']").val();
	var ubirthday = $("[name='trainer.userCenter.birthday']").val();
	var uemail = $("[name='trainer.userCenter.email']").val();
	var uregionId = $("[name='city']").val();
	var umarryStatus = $("[name='trainer.userCenter.marryStatus']").val();
	var umobile = $("input[name='trainer.userCenter.mobile']").val();
	var autoYears = $("[name='trainer.autoYears']").val();
	var education = $("[name='trainer.education']").val();
	var intro = $("[name='trainer.userCenter.intro']").val();
	var mainCourse = $("[name='trainer.mainCourse']").val();
	var businessCategory = '';
	$("input:checkbox[name='trainer.businessCategory']:checked").each(function(index, element) {
                         businessCategory += $(this).val() + ",";
	});
	var executionCategory = '';
	$("input:checkbox[name='trainer.executionCategory']:checked").each(function(index, element) {
                         executionCategory += $(this).val() + ",";
	});
	var vedioURL1 = $("[name='trainer.vedioURL1']").val();
	var vedioURL2 = $("[name='trainer.vedioURL2']").val();

	form_data.tid = tid;
	form_data.uid = uid;
	form_data.uname = uname;
	form_data.uheadLogo= uheadLogo;
	form_data.ubirthday = ubirthday;
	form_data.umarryStatus = umarryStatus;
	form_data.education = education;
	form_data.umobile = umobile;
	form_data.uemail= uemail;
	form_data.uregionId=uregionId;
	form_data.autoYears =autoYears;
	form_data.mainCourse =mainCourse;
	form_data.intro =intro;
	form_data.upersonalType = upersonalType;
	form_data.vedioURL1 = vedioURL1;
	form_data.vedioURL2 = vedioURL2;
	form_data.businessCategory = businessCategory;
	form_data.executionCategory = executionCategory;

	$.ajax({
			 type: "POST",
		     url: url,
		     data: form_data,
		     error: function(request) {
	             alert("网络出错啦！");
	             return false;
	         },
		     success: function (data) {
		    	 alert(data.msg);
		    	 		var tid = $("[name='trainer.id']").val();
		    	 		if(tid != undefined && tid != ""){
		    	 			window.location.href = "/backend/trainerCompleteResume";
		    	 		}
		     }
	});
}

function selectCities(){
	var form_data={};
	form_data.parentId = $("[name='province']").val();;
	$.ajax({
		 type: "POST",
	     url: "/backend/regions/getCities",
	     data: form_data,
	     error: function(request) {
	         showErrMsg("网络出错啦！");
	         return false;
	     },
	     success: function (data) {
				$("#city").get(0).options.length=data.cities.length+1;
	    		for(var i=0;i<data.cities.length;i++)
	    		{
	    		  $("#city").get(0).options[i+1]=new Option(data.cities[i].name,data.cities[i].id);
	    		}

	     }
	});
}

var image = '';
 function selectImage(file){
	 if(!file.files || !file.files[0]){
		return;
	}

	 var reader = new FileReader();
	 reader.onload = function(evt){
	 if(file.name=='headLogo'){
		 document.getElementById('trainer.userCenter.headLogo').src = evt.target.result;
	 }

	 image = evt.target.result;
	}
	reader.readAsDataURL(file.files[0]);
}
</script>