<template>
    <div class="container">
        <div id="joinDiv" class="layui-col-lg6 layui-col-xs11">
            <span  class="divTitle layui-icon layui-icon-form">参与会议</span>
            <hr class="layui-bg-green">
            <div class="layui-tab layui-tab-brief">
                <ul class="layui-tab-title">
                    <li  :class="{'layui-this':joinDiv.show===1}" @click="joinDiv.show=1">未结束</li>
                    <li  :class="{'layui-this':joinDiv.show===2}" @click="joinDiv.show=2">已结束</li>
                    <li  :class="{'layui-this':joinDiv.show===3}" @click="joinDiv.show=3">查找</li>
                    <li  :class="{'layui-this':joinDiv.show===4}" @click="joinDiv.show=4">申请中</li>
                </ul>
                <div class="layui-tab-content">
                    <div :class="{'layui-show':joinDiv.show===1}" class="layui-tab-item " >
                        <p class="emptyWarming" v-if="joinDiv.newMeetings.length===0">您的未结束会议为空，可立即
                            <i @click="joinDiv.show=3">查找新的会议</i>加入哦</p>
                        <meeting-list :meetings="joinDiv.newMeetings"></meeting-list>
                    </div>
                    <div :class="{'layui-show':joinDiv.show===2}" class="layui-tab-item">
                        <p class="emptyWarming" v-if="joinDiv.overMeetings.length===0">您的已结束会议为空，可立即
                            <i @click="joinDiv.show=3">查找新的会议</i>加入哦</p>
                        <meeting-list :meetings="joinDiv.overMeetings"></meeting-list>
                    </div>
                    <div :class="{'layui-show':joinDiv.show===3}" class="layui-tab-item layui-row">
                        <div class="searchInputDiv layui-col-lg10 layui-col-md10 layui-col-xs10">
                            <input class="layui-input" type="text" placeholder="输入会议id或名称进行查找" value="废物">
                        </div>
                        <div class="searchButtonDiv layui-col-lg2 layui-col-md2 layui-col-xs2">
                            <button class="searchButton layui-btn layui-btn"><span class="layui-icon layui-icon-search"></span></button>
                        </div><br><br><br>
                        <meeting-list :meetings="joinDiv.searchMeetings"></meeting-list>
                    </div>
                    <div :class="{'layui-show':joinDiv.show===4}" class="layui-tab-item">
                        <p class="emptyWarming" v-if="joinDiv.applyMeetings.length===0">您所申请的会议为空，可立即
                            <i @click="joinDiv.show=3">查找新的会议</i>加入哦</p>
                        <meeting-list :meetings="joinDiv.applyMeetings"></meeting-list>
                    </div>
                </div>
            </div>
        </div>
        <div id="managerDiv" class="layui-col-lg5 layui-col-xs11">
            <span  class="divTitle layui-icon layui-icon-chart-screen">管理会议</span>
            <hr class="layui-bg-orange">
            <div class="layui-tab layui-tab-brief">
                <ul class="layui-tab-title">
                    <li :class="{'layui-this':managerDiv.show===1}" @click="managerDiv.show=1">未结束</li>
                    <li :class="{'layui-this':managerDiv.show===2}" @click="managerDiv.show=2">已结束</li>
                    <li :class="{'layui-this':managerDiv.show===3}" @click="managerDiv.show=3">创建</li>
                </ul>
                <div class="layui-tab-content">
                    <div :class="{'layui-show':managerDiv.show===1}" class="layui-tab-item">
                        <p class="emptyWarming" v-if="managerDiv.newMeetings.length===0">您的所管理的未结束会议为空，可立即
                            <i @click="managerDiv.show=3">创建新的会议</i></p>
                        <meeting-list :meetings="joinDiv.overMeetings"></meeting-list>
                    </div>
                    <div :class="{'layui-show':managerDiv.show===2}" class="layui-tab-item">
                        <p class="emptyWarming" v-if="managerDiv.newMeetings.length===0">您的所管理的已结束会议为空，可立即
                            <i @click="managerDiv.show=3">创建新的会议</i></p>
                        <meeting-list :meetings="joinDiv.applyMeetings" router-to="/manage"></meeting-list>
                    </div>
                    <div :class="{'layui-show':managerDiv.show===3}" class="layui-tab-item ">
                        <div class="managerButtonBox">
                            <router-link to="/create" id="createMeetingButton" >
                                <span class="iconfont icon-hexagon  buttonBack"></span>
                                <div class="sixBorder layui-icon layui-icon-add-circle-fine">创建</div></router-link>
                        </div>
                        <div class="managerButtonBox">
                            <a @click="restart()" id="restartMeetingButton">
                                <span class="buttonBack layui-icon layui-icon-circle-dot"></span>
                                <div class="sixBorder layui-icon layui-icon-add-circle-fine">重启</div></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import MeetingList from "components/meetingList";
    const meetingList = ()=> import("components/meetingList");
    export default {
        name: "Ordinary",
        components: {MeetingList},
        comments:{
            meetingList
        },
        data(){
            return{
                joinDiv:{
                    newMeetings:[
                        {id:"233",name:'五分钟内，我要全部信息',state:"5小时后开始",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false},
                        {id:"234",name:'可是',state:"5小时后开始",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false},
                        {id:"235",name:'不行',state:"5小时后开始",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false}
                    ],
                    overMeetings:[
                        {id:"233",name:'五分钟内，我要一点信息',state:"5小时后开始",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false},
                        {id:"234",name:'可是',state:"5小时后开始",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false},
                        {id:"235",name:'不行',state:"5小时后开始",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false}
                    ],
                    searchMeetings:[
                        {id:"233",name:'五分钟内，我要一点信息',state:"5小时后开始",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false},
                        {id:"234",name:'可是',state:"5小时后开始",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false},
                        {id:"235",name:'不行',state:"5小时后开始",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false}
                    ],
                    applyMeetings:[
                        {id:"233",name:'五分钟内，我要一点信息',state:"申请中，未开始",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false},
                        {id:"234",name:'可是',state:"被拒绝",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false},
                        {id:"235",name:'不行',state:"已通过",startTime:"2020年12月6日12:36",position:"信工楼b区",show:false}
                    ],
                    show:1
                },
                managerDiv:{
                    newMeetings:[],
                    overMeetings:[],
                    show:1
                }
            }
        },
        methods:{
            restart(){
                alert("这个时候可以选择曾经创建的会议填充到下个页面");
                this.$router.push("/create");
            },
            setJoinMeetings(){
                let join=this.$store.state.meetings.join;
                //console.log(this.joinDiv);
                this.joinDiv.newMeetings=join.newMeetings;
                this.joinDiv.overMeetings=join.overMeetings;
                this.joinDiv.applyMeetings=join.applyMeetings;
                if(join.newMeetings.length===0)this.joinDiv.show=3;
            },
            setManageMeetings(){
                let manage=this.$store.state.meetings.manage;
                this.managerDiv.newMeetings=manage.newMeetings;
                this.managerDiv.overMeetings=manage.overMeetings;
                if(manage.newMeetings.length===0)this.managerDiv.show=3;
            }
        },
        created() {
            this.setJoinMeetings();
            this.setManageMeetings();

        }
    }

</script>

<style scoped>

    #joinDiv,#managerDiv{
        border-radius: 10px;
        padding: 15px;
        margin: 15px;
        border: 2px #4E5465 solid;
    }
    /*#joinDiv{
        background-color: #f7f3ff;
    }
    #managerDiv{
        background-color: #ebfffa;
    }*/
    .divTitle{
        font-size: 30px !important;
        color: #393D49;
    }
    .layui-elem-field{
        border-radius: 5px;
    }

    .searchButtonDiv{
        width: 19%;
    }
    .searchInputDiv{
        width: 79%;
    }
    #searchResultTable{
        text-align: center;
    }
    .layui-table th{
        text-align: center !important;
    }
    li{
        font-size: 15px !important;
        font-family: 微软雅黑;
    }

    .buttonBack{
        font-size: 200px !important;
        color: darkgray;
        border-radius: 50%;
    }

    .managerButtonBox{
        float: left;
        width: 50%;
        border-radius: 50%;
    }
    .sixBorder {
        font-size: 30px !important;
        position: relative;
        top:-130px;
        left:55px;
    }
    .buttonBack:hover{
        color: #c1c1c1 !important;
    }
    .emptyWarming{
        width: 100%;
        font-size: 20px;
        color: #464955;
    }
    .emptyWarming > i{
        color: #007ddb;
    }

    /*阿里矢量图标*/
    @font-face {font-family: "iconfont";
        src: url('//at.alicdn.com/t/font_2241269_knz5buwy1ug.eot?t=1606830150517'); /* IE9 */
        src: url('//at.alicdn.com/t/font_2241269_knz5buwy1ug.eot?t=1606830150517#iefix') format('embedded-opentype'), /* IE6-IE8 */
        url('data:application/x-font-woff2;charset=utf-8;base64,d09GMgABAAAAAAKgAAsAAAAABlAAAAJTAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHEIGVgCCcApYbAE2AiQDCAsGAAQgBYRtBzEbkwXIrrApw69Q0d26TKB4MLCfBwADRBCs/W/2/JtKc6CJJpJLI5MhNUKEqiFZxSP5bT/ds4Yx8bAlak01bWfe604vDRy4GsFQX7oPT+36V5s0E/4khRAL7278ywFFnPHmBM9QPxjxtkuGTnafuHf6RwEFMh9QjnvRWJMmdQF12QIpwL2wTVYkkTeMXeASzhOoN2xRHK+Pl0JDxpoWiPu+tgqNnEcmY/FKKGrWZsRrclVy2H8Fr8Lvxx/jaCCRp1hFZ2+u3ML0x5+dJLl2V3wCLwFtzpFiERlxsTZyWlkwVqo+UjHOvvKDH6n6ZrFXg2B/nZXbCAah8J5ErvhW4wncVl+9GBn1KKL3Rf5E831m+/uZ8viL87uS9XnZ9c6arbv+vPa5Qp77ncK+Amq73KUjENx9P92g/422A77sG7pqu0I/G9WerMEfEfWsy3SJZUoyVVTbnOg9U0m9etTAjnbfx2q7Tp8Ila4RttJQilRlksyYi8g12EShsod6C05tbtDhqbLIPMx7CRBavUGi2VukWn0mM+Y35Lr9Q6E1yqh3OezZYDr81oyWoAv2C3yHEuVYpBXln1DfI4uzkpB9Q858P4z6w2J8gwnyHAuyhx6LKFBMMazBZRhFBClTgI70PZF0Mhioujf1HYoLLUcYsgjkAle9gDscJKH81qJV+vwJ0u4iFm6pqQneIJbxBwdrlq32IDfKpFfNvVzzzIM29pxQwE2MxMBJMApFIgQ8rh8VQA7Rd3tEKDWxYje62VfZX18df90eqGfpkrCHCuVtfFqakkIBAAAA') format('woff2'),
        url('//at.alicdn.com/t/font_2241269_knz5buwy1ug.woff?t=1606830150517') format('woff'),
        url('//at.alicdn.com/t/font_2241269_knz5buwy1ug.ttf?t=1606830150517') format('truetype'), /* chrome, firefox, opera, Safari, Android, iOS 4.2+ */
        url('//at.alicdn.com/t/font_2241269_knz5buwy1ug.svg?t=1606830150517#iconfont') format('svg'); /* iOS 4.1- */
    }

    .iconfont {
        font-family: "iconfont" !important;
        font-size: 16px;
        font-style: normal;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }

    .icon-hexagon:before {
        content: "\e79d";
    }



</style>