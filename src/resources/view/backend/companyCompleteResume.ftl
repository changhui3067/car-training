<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value='/assets/website/backend/css/style.css'/>" type="text/css" media="screen" />
<script src="<@url value="/assets/website/js/jquery-1.8.0.min.js?v=1.1.0"/>"></script>

</head>

<body>
<#include "/assets/website/common/header.html">
	
<!-- main开始 -->
<div class="main">
	<div class="content">
    <div class="dq_box">
    <div class="dqwz left">当前位置 : <a href="#">首 页</a> > <a href="#">企业管理中心</a> > <a href="#">完善资料</a></div>
    <div class="wdcf right"><span color="#FF66001"><#if Session?exists && Session["userDetails"].wealthStartDate??> ${Session["userDetails"].wealthStartDate!?string("dd/MM/yyyy")}—${Session["userDetails"].wealthEndDate!?string("dd/MM/yyyy")}</#if></span>我的财富：<font color="#FF66001"><#if Session?exists && Session["userDetails"]??> ${Session["userDetails"].wealth!}</#if></font></div><div class="clear"></div>
    </div>
    <div class="pxshi_gl">
    	<div class="pxshi_gl_l left">
 		<#include "/assets/website/backend/common/menu.ftl">
 		
        <div class="pxshi_gl_r right">
        
        <form id="form1">
        <!--隐藏域-->
        <input type="hidden" name="company.id" value="<#if company??>${company.id!}</#if>">
        <!--隐藏域-->
       	  <div class="pxshijl">
               	  <h5>企业基本信息</h5>
                    <div class="pxshijl_box">
                   	  <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
					  <tr>
					    <td colspan="2"width="420" align="left" valign="top"><table width="400" border="0" cellspacing="0" cellpadding="0">
					      <tr>
					        <td width="69" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 企业名称：</td>
					        <td width="292">
					        <#if company?? && company.name??>
					        <input type="text" name="company.name" value="${company.name!}" id="company.name" />
					        <#else>
					        <input type="text" name="company.name" value="" id="company.name" />
					        </#if>
					        </td>
					      </tr>
					      <tr>
					        <td width="69" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 汽车品牌：</td>
					        <td width="292">
					        <#if company?? && company.autoBrand??>
					        <input type="text" name="company.autoBrand" value="${company.autoBrand!}" id="company.autoBrand" />
					        <#else>
					        <input type="text" name="company.autoBrand" value="" id="company.autoBrand" />
					        </#if>
					        </td>
					      </tr>
					      <tr>
                    	    <td width="125" align="right" valign="middle"><font color="#ff0000">*</font>企业规模：</td>
                    	    <td width="337">
                    	    <select name="company.scale" id="company.scale">
                    	    <option value="">请选择</option>
                    	    <#if company?? && company.scale?? && company.scale.name() = 'UNDER50'>
							<option selected="selected" value="UNDER50">50人以下</option>
							<#else>
							<option value="UNDER50">50人以下</option>
							</#if>
							<#if company?? && company.scale?? && company.scale.name() = 'FROM51TO100'>
							<option selected="selected" value="FROM51TO100">51人-100人</option>
							<#else>
							<option value="FROM51TO100">51人-100人</option>
							</#if>
							<#if company?? && company.scale?? && company.scale.name() = 'FROM101TO200'>
							<option selected="selected" value="FROM51TO100">101人-200人</option>
							<#else>
							<option value="FROM101TO200">101人-200人</option>
							</#if>
							<#if company?? && company.scale?? && company.scale.name() = 'FROM201TO500'>
							<option selected="selected" value="FROM51TO100">201人-500人</option>
							<#else>
							<option value="FROM201TO500">201人-500人</option>
							</#if>
							<#if company?? && company.scale?? && company.scale.name() = 'FROM501TO1000'>
							<option selected="selected" value="FROM51TO100">501人-1000人</option>
							<#else>
							<option value="FROM501TO1000">501人-1000</option>
							</#if>
							<#if company?? && company.scale?? && company.scale.name() = 'ABOVE1000'>
							<option selected="selected" value="ABOVE1000">1000人以上</option>
							<#else>
							<option value="ABOVE1000">1000人以上</option>
							</#if>
                            </select>
                    	    </td>
                  	    </tr>
                  	     <tr>
                    	    <td width="125" align="right" valign="middle"><font color="#ff0000">*</font>经营范围：</td>
                    	    <td width="337">
                    	    <select name="company.industry" id="company.industry">
                    	    <option value="">请选择</option>
                    	    <#if company?? && company.industry?? && company.industry.name() = 'AUTO'>
							<option selected="selected" value="AUTO">汽车</option>
							<#else>
							<option value="AUTO">汽车</option>
							</#if>
							<#if company?? && company.industry?? && company.industry.name() = 'TRAINING'>
							<option selected="selected" value="TRAINING">培训</option>
							<#else>
							<option value="TRAINING">培训</option>
							</#if>
							<#if company?? && company.industry?? && company.industry.name() = 'SELL'>
							<option selected="selected" value="SELL">销售</option>
							<#else>
							<option value="SELL">销售</option>
							</#if>
                            </select>
                    	    </td>
                  	    </tr>
                  	    <tr>
                    	    <td width="125" align="right" valign="middle"><font color="#ff0000">*</font>公司地址：</td>
                    	    <td   colspan="3">
                    	    <#if company?? && company.address??>
					        <input type="text" name="company.address" value="${company.address!}" id="company.address" />
					        <#else>
					        <input type="text" name="company.address" value="" id="company.address"  style="width:300px"/>
					        </#if>
                    	    </td>
                  	    </tr>
                  	    <tr>
                    	    <td width="125" align="right" valign="middle"><font color="#ff0000">*</font>所在地：</td>
                    	    <td colspan="3">
                    	     <select name="province" id="province" onChange="selectCities()">
                                 <option value="">请选择省</option>
							 <#list provinces as t>
                                 <option value="${t.id!}"<#if userRegion?? && userRegion.parent.id == t.id>selected="selected"</#if>>${t.name!}</option>
							 </#list>
                             </select>
                                <select name="city" id="city">
                                    <option value="">请选择市</option>
								<#list cities as city>
                                    <option value="${city.id!}" <#if userRegion ?? && city.id == userRegion.id>selected="selected"</#if>>${city.name!}</option>
								</#list>
							</select>
                    	    </td>
                  	    </tr>
                  	    <tr>
                    	    <td width="125" align="right" valign="middle"><font color="#ff0000">*</font>公司福利：</td>
                    	    <td colspan="3">
                    	    <#if company?? && company.welfare??>
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare" <#if company.welfare ? index_of("五险一金")!=-1> checked </#if> value="五险一金"/>五险一金
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare" <#if company.welfare ? index_of("工作餐")!=-1> checked </#if> value="工作餐"/>工作餐
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare" <#if company.welfare ? index_of("免费班车")!=-1> checked </#if> value="免费班车"/>免费班车
                	   		<input type="checkBox" name="company.welfare" id="company.welfare" <#if company.welfare ? index_of("股票期权")!=-1> checked </#if> value="股票期权"/>股票期权
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare" <#if company.welfare ? index_of("带薪休假")!=-1> checked </#if> value="带薪休假"/>带薪休假
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare" <#if company.welfare ? index_of("年底双薪")!=-1> checked </#if> value="年底双薪"/>年底双薪
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare" <#if company.welfare ? index_of("绩效奖金")!=-1> checked </#if> value="绩效奖金"/>绩效奖金
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare" <#if company.welfare ? index_of("定期体检")!=-1> checked </#if> value="定期体检"/>定期体检
                    	    <#else>
                    	     	<input type="checkBox" name="company.welfare" id="company.welfare"  value="五险一金"/>五险一金
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare"  value="工作餐"/>工作餐
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare"  value="免费班车"/>免费班车
                	   		<input type="checkBox" name="company.welfare" id="company.welfare"  value="股票期权"/>股票期权
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare"  value="带薪休假"/>带薪休假
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare"  value="年底双薪"/>年底双薪
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare"  value="绩效奖金"/>绩效奖金
                    	   	<input type="checkBox" name="company.welfare" id="company.welfare"  value="定期体检"/>定期体检
                    	    </#if>
                    	    </td>
                    	   
                  	    </tr>
					    </table></td>
					    <td width="439" colspan="4" align="left" valign="top"><table width="400" border="0" cellspacing="0" cellpadding="0">
					      <tr>
					        <td><img id="company.logo"  src="<#if company.logo??>${company.logo!}<#else>http://obu3flkwk.bkt.clouddn.com/backend/images/zw.jpg</#if>" style="width:40px;height:40px;" />
					        </tr>
					      <tr>
					        <td>
					        <table width="400" border="0" cellspacing="0" cellpadding="0">
					          <tr>
					            <td  width="15%" height="40" align="left" valign="middle"><input type="file" name="logo" id="logo" value="浏 览" onChange="selectImage(this)"/></td>
					            <td width="23%" align="left" valign="middle"></td>
					            <td width="62%" align="left" valign="middle"></td>
					            </tr>
					          </table>
					          
					          </td>
					        </tr>
					      <tr>
					        <td><font color="#CCCCCC">请上传宽度为100px,高度为50px,格式：jpg,gif, 大小&lt;500kb的图片LOGO</font></td>
					        </tr>
					      </table></td>
					  </tr>
					  </table>


                </div>
          </div>
        <!-- <div class="pxshijl">
         <h5>上传公司环境</h5>
                    <div class="pxshijl_box">
                    	
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40" align="left" valign="middle"><font color="#CCCCCC">将有效的工商营业执照副本原件或加盖红色单位公章的复印件拍照或扫描后在此上传，由客服人员认证审核。必须上传与公司名称一致，
已年检通过的证照。</font></td>
  </tr>
  <tr>
    <td><font color="#ff0000">*</font> 公司名称：
      <input name="txt_email2" type="text" id="txt_email2" /></td>
  </tr>
  <tr>
    <td><table width="500" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="90" height="50" align="left" valign="middle"><font color="#ff0000">*</font> 上传证件照：</td>
        <td width="60" align="left" valign="middle"><input type="button" name="button3" id="button3" value="浏览" /></td>
        <td width="80" align="left" valign="middle">未选择图片。</td>
        <td width="80" align="left" valign="middle"><input type="button" name="button4" id="button4" value="上传照片" /></td>
        <td width="190" align="left" valign="middle">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>

            </div>
          </div>-->
          <div class="pxshijl">
               	  <h5>上传企业环境照片</h5>
                    <div class="pxshijl_box">
                    	
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40" align="left" valign="middle"><font color="#CCCCCC">请上传宽度260px,高度为170px,格式：jpg,gif, 大小&lt;500kb的图片</font></td>
  </tr>
  
  <tr>
    <td><table width="500" border="0" cellspacing="0" cellpadding="0">
      <tr>
       
        <td width="50" align="left" valign="middle"> 
        <img id="company.environmentURL1" src="<#if company.environmentURL1??>${company.environmentURL1!}<#else>http://obu3flkwk.bkt.clouddn.com/backend/images/zw.jpg</#if>" style="width:40px;height:40px;" />
        <input type="file" name="environmentURL1" id="environmentURL1" value="浏览" onChange="selectImage(this)"/></td>
        <td width="80" align="left" valign="middle">
        <img id="company.environmentURL2" src="<#if company.environmentURL2??>${company.environmentURL2!}<#else>http://obu3flkwk.bkt.clouddn.com/backend/images/zw.jpg</#if>" style="width:40px;height:40px;" />
        <input type="file" name="environmentURL2" id="environmentURL2" value="浏览" onChange="selectImage(this)"/></td>
        <td width="80" align="left" valign="middle"></td>
        <td width="190" align="left" valign="middle">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>

    </div>
  </div>
         
          <div class="pxshijl">
               	  <h5>企业介绍</h5>
                    <div class="pxshijl_box">
    	<table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  
     <tr>
    <td height="40" colspan="4" align="left" valign="middle"><table width="90%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="11%"><font color="#ff0000">*</font>企业介绍：</td>
    <td width="89%"><textarea style="width:600px;" name="company.intro" id="intro" cols="45" rows="5"><#if company?? && company.intro??>${company.intro!}<#else>请输入企业介绍</#if></textarea></td>
  </tr>
</table></td>
    </tr>
</table>


                </div>
          </div>
          <div class="tj">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="60" align="center" valign="middle">
                    <input type="button" onclick="submitdata()" style="width:95px;height:35px;background-repeat:no-repeat;background-image:url(http://obu3flkwk.bkt.clouddn.com/backend/images/tj.jpg);border:0;"/>
                    </td>
                  </tr>
            </table>
          </div>
      </div>
      
      </form>
        <div class="clear"></div>
    
    </div>
    </div>
</div>

<script>
function checkform(){
	var name = $("[name='company.name']").val();
	var scale = $("[name='company.scale']").val();
	var intro = $("[name='company.intro']").val();
	
	if(name == undefined || scale == undefined || intro == undefined){
		alert("带*的为必填字段 ");
		return false;
	}
	if(name == "" || scale == "" || intro == ""){
		alert("带*的为必填字段 ");
		return false;
	}
	
	return true;
}

function submitdata(){

	if(!checkform()){
		return;
	}

	var url  = "/backend/companyCompleteResume/save";
	var form_data = {};
	var logo = document.getElementById('company.logo').src;
	var name = $("[name='company.name']").val();
	var autoBrand = $("[name='company.autoBrand']").val();
	var cid = $("[name='company.id']").val();
	var scale = $("[name='company.scale']").val();
	var industry = $("[name='company.industry']").val();
	var address = $("[name='company.address']").val();
	var welfare = '';
	$("input:checkbox[name='company.welfare']:checked").each(function(index, element) {
                         welfare += $(this).val() + ",";
	 }); 
	var regionId = $("[name='city']").val();
	var intro = $("[name='company.intro']").val();
	var environmentURL1 = document.getElementById('company.environmentURL1').src;
	var environmentURL2 = document.getElementById('company.environmentURL2').src;
	
	form_data.cid = cid;
	form_data.name = name;
	form_data.autoBrand = autoBrand;
	form_data.logo= logo;
	form_data.industry = industry;
	form_data.address = address;
	form_data.welfare = welfare;
	form_data.regionId=regionId;
	form_data.scale =scale;
	form_data.intro = intro;
	form_data.environmentURL1 = environmentURL1;
	form_data.environmentURL2 = environmentURL2;
	
		$.ajax({
			 type: "POST",
		     url: url,
		     data: form_data,
		     error: function(request) {
	             showErrMsg("网络出错啦！");
	             return false;
	         },
		     success: function (data) {
		    	 showErrMsg("资料完善成功,请耐心等待培聘网的审核！");
                 window.location.href = "/backend/companyCompleteResume";
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
             for(var i=0;i<data.cities.length;i++) {
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
	 if(file.name=='logo'){
		 document.getElementById('company.logo').src = evt.target.result;
	 }
	 if(file.name=='environmentURL1'){
	 	document.getElementById('company.environmentURL1').src = evt.target.result;
	 }
	 if(file.name=='environmentURL2'){
		document.getElementById('company.environmentURL2').src = evt.target.result;
	 }
	 image = evt.target.result;
	}
	reader.readAsDataURL(file.files[0]);
}

function showErrMsg(errMsg){
    	alert(errMsg);
 }
</script>

<!-- main结束 -->
<#--<#include "/assets/backend/common/footer.html">-->

</body>
</html>
