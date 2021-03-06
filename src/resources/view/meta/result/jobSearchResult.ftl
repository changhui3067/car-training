<div id="jobList" class="jobList hidden" xmlns="http://www.w3.org/1999/html">
    <ul>
        <li v-for="job in jobList" class="zp_box">
            <div class="left zp_box_l">
                <a :href="'/website/jobDetail?jobId='+job.id">
                    <div class="zw_name">{{job.title}}</div>
                </a>
                <div class="dy_box">
                    <#--<span class="cn jobSalary ellipsis" style="padding-left:0px;" :title="job.salary+'元'">{{job.salary}}元</span>-->
                    <span style="padding-left:0px;">{{job.workExperienceRequirement}}年经验</span>
                    <span style="background:none;" class="jobRegion ellipsis" :title="!!job.region ? job.region.fullname : ''">{{!!job.region ? job.region.fullname : ""}}</span>
                </div>
                <div class="fb_box">
                    <span style="padding-left:0px;">发布于: {{job.createDate}}</span>
                    <span style="background:none;">投递后：48小时反馈</span>
                </div>
            </div>
            <div class="right zp_box_r">
                <div class="qy">
                    <a :href="'/website/companyDetail?companyId='+ job.company.id">
                        <div class="qy_l left zp_box_r_l"><img :src="job.company.logoUrl"/></div>
                        <div class="qy_r right zp_box_r_r">
                            <div class="qy_name">
                                <span class="ellipsis">{{!!job.company ? job.company.name : ""}}</span></br>
                                <span>{{!!job.company ? job.company.guaranteeNumber : ""}}人担保</span>
                            </div>
                            <div class="jyfw">{{!!job.company ? job.company.autoBrand : ""}}</div>
                            <div class="fl" :title="job.company.welfare">
                                <span v-for="w in job.company.welfare">{{w}}</span>
                            </div>
                        </div>
                    </a>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="clear"></div>
        </li>
    </ul>
    <div class="fypage">
        <span :class="{active:fst}" @click="specialJump('fst')">首页</span>
        <span :class="{active:pre}" @click="specialJump('pre')">上一页</span>
        <a v-for="page in pages" :class="{current:page.current}" @click="getPage(page.no)">{{page.no}}</a>
        <span :class="{active:nex}" @click="specialJump('nex')">下一页</span>
        <span :class="{active:Lst}" @click="specialJump('Lst')">尾页</span>
    </div>
</div>