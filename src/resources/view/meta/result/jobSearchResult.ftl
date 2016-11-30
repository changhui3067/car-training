<div id="jobList" class="jobList pxxq hidden">
    <ul>
        <li v-for="job in jobList" class="zp_box">
            <div class="left zp_box_l">
                <a :href="'/website/jobDetail?jobId='+job.id">
                    <div class="zw_name">{{job.title}}</div>
                </a>
                <div class="dy_box">
                    <span class="cn" style="padding-left:0px;">{{job.salary}}元</span>
                    <span>{{job.workExperienceRequirement}}年工作经验</span>
                    <span style="background:none;">{{job.region.fullname}}</span>
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
                                <span>{{job.company.name}}</span>
                                <span>已有{{job.company.guaranteeNumber}}人担保</span>
                            </div>
                            <div class="jyfw">{{job.company.autoBrand}}</div>
                            <div class="fl">
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