<div id="peopleList" class="hidden">
    <div class="pxshilist">
        <ul>
            <li v-for="person in peopleList" class="oneBox">
                <div class="picContainer">
                    <a :href="person.homepageUrl"><img :src="person.avatarUrl"/></a></div>
                <div class="intro">
                    <div>
                        <div class="name">{{person.personName}}</div>
                        <div class="right"><i class="iconfont" title="评论">&#xe69b;</i>{{person.commentNumber}}</div>
                        <div class="right"><i class="iconfont" title="点赞">&#xe717;</i>{{person.likeNumber}}</div>
                        <div class="clear"></div>
                    </div>
                    <#--<div class="clear"></div>-->
                    <div>{{person.currentPosition}}</div>
                </div>
            </li>
            <div class="clear"></div>
        </ul>
    </div>
    <div class="fypage">
        <span :class="{active:fst}" @click="specialJump('fst')">首页</span>
        <span :class="{active:pre}" @click="specialJump('pre')">上一页</span>
        <a v-for="page in pages" :class="{current:page.current}" @click="getPage(page.no)">{{page.no}}</a>
        <span :class="{active:nex}" @click="specialJump('nex')">下一页</span>
        <span :class="{active:Lst}" @click="specialJump('Lst')">尾页</span>
    </div>
</div>
