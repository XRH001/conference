<template>
    <div class="detailContainer layui-row">
        <div class="baseInfo layui-col-lg8"><p class="titleP">基本信息</p>
            <table class="layui-table">
                <colgroup>
                    <col width="20%">
                    <col width="80%">
                </colgroup>
                <tbody>
                <tr>
                    <td>会议名</td>
                    <td>
                        <input type="text" name="meetingName" required  lay-verify="required" value="废物心理学" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议开始时间</td>
                    <td>
                        <input type="text" name="startTime" required  lay-verify="required" value="2020年11月21日09:55" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议结束时间</td>
                    <td>
                        <input type="text" name="overTime" required  lay-verify="required" value="2020年11月21日09:55" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议地点</td>
                    <td>
                        <input type="text" name="meetingPosition" required  lay-verify="required" value="信工楼b202" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议状态</td>
                    <td>
                        <input type="text" name="meetingStatus" required  lay-verify="required" value="未开始" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                </tbody>
            </table>
            <div><button class="layui-btn layui-btn-checked">确认修改</button></div>
            <hr class="layui-bg-orange">
            <p class="titleP">人员管理</p>
            <br>
            <div class="layui-collapse">
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">管理员名单</h2>
                    <div class="layui-colla-content ">
                        <div class=" layui-row">
                            <div class="searchInputDiv layui-col-lg10 layui-col-md10 layui-col-xs10">
                                <input class="layui-input" type="text" placeholder="输入成员邮箱进行查找" value="2313@qq.com">
                            </div>
                            <div class="searchButtonDiv layui-col-lg2 layui-col-md2 layui-col-xs2">
                                <button class="searchButton layui-btn layui-btn"><span class="layui-icon layui-icon-search"></span></button>
                            </div>

                            <div class="layui-col-lg11 layui-col-md11 layui-col-xs11">
                                <br>
                                <table  class="layui-table">
                                    <colgroup>
                                        <col width="30%">
                                        <col width="50%">
                                        <col width="20%">
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th>姓名</th>
                                        <th>联系方式</th>
                                        <th>动作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>洪秀全</td>
                                        <td>4384381@qq.com</td>
                                        <td><button class="layui-btn layui-btn-normal  layui-btn-sm">添加</button></td>
                                    </tr>
                                    </tbody>
                                </table></div>
                        </div>
                        <table class="layui-table">
                            <colgroup><col width="30%"><col width="50%"/><col width="20%"> </colgroup>
                            <thead><tr><th>姓名</th><th>联系方式</th><th>删除</th></tr></thead>
                            <tbody>
                            <tr><td>金城山</td><td>2312@qq.com</td><td><button class="layui-btn layui-btn-danger"><span class="layui-icon layui-icon-delete"></span></button></td></tr>
                            <tr><td>程世峰</td><td>321312@qq.com</td><td><button class="layui-btn layui-btn-danger"><span class="layui-icon layui-icon-delete"></span></button></td></tr>
                            <tr><td>关婷楼</td><td>4124112@qq.com</td><td><button class="layui-btn layui-btn-danger"><span class="layui-icon layui-icon-delete"></span></button></td></tr>
                            </tbody>
                        </table></div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">普通成员名单</h2>
                    <div class="layui-colla-content ">

                        <div class=" layui-row">
                            <div class="searchInputDiv layui-col-lg10 layui-col-md10 layui-col-xs10">
                                <input class="layui-input" type="text" placeholder="输入成员邮箱进行查找" value="2313@qq.com">
                            </div>
                            <div class="searchButtonDiv layui-col-lg2 layui-col-md2 layui-col-xs2">
                                <button class="searchButton layui-btn "><span class="layui-icon layui-icon-search"></span></button>
                            </div>

                            <div class="layui-col-lg11 layui-col-md11 layui-col-xs11">
                                <br>
                                <table  class="layui-table">
                                    <colgroup>
                                        <col width="30%">
                                        <col width="30%">
                                        <col width="20%">
                                        <col width="20%">
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th>姓名</th>
                                        <th>联系方式</th>
                                        <th>邀请</th>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>洪秀全</td>
                                        <td>4384381@qq.com</td>
                                        <td><button class="layui-btn layui-btn-normal  layui-btn-sm">添加</button></td>
                                    </tr>
                                    </tbody>
                                </table></div>
                        </div>
                        <table class="layui-table">
                            <colgroup><col width="25%"><col width="35%"/><col width="20%"><col width="30%"> </colgroup>
                            <thead><tr><th>姓名</th><th>联系方式</th><th>踢出</th><th>安排</th></tr></thead>
                            <tbody>
                            <!--<tr><td>金城山</td><td>2312@qq.com</td><td><button class="layui-btn layui-btn-danger"><span class="layui-icon layui-icon-delete"></span></button></td>
                                <td><button onclick="arrangeThis(this)" onmouseover="showOne(this)" onmouseleave="clearAll()" class="layui-btn layui-btn-normal positionSet"><span class="layui-icon layui-icon-home"></span></button></td></tr>
                            <tr><td>程世峰</td><td>321312@qq.com</td><td><button class="layui-btn layui-btn-danger"><span class="layui-icon layui-icon-delete "></span></button></td>
                                <td><button onclick="arrangeThis(this)" onmouseover="showOne(this)" onmouseleave="clearAll()" class="layui-btn layui-btn-normal positionSet"><span class="layui-icon layui-icon-home"></span></button></td></tr>
                            <tr><td>关婷楼</td><td>4124112@qq.com</td><td><button class="layui-btn layui-btn-danger"><span class="layui-icon layui-icon-delete "></span></button></td>
                                <td><button onclick="arrangeThis(this)" onmouseover="showOne(this)" onmouseleave="clearAll()" class="layui-btn layui-btn-normal positionSet"><span class="layui-icon layui-icon-home"></span></button></td></tr>
                            <tr><td>金城山</td><td>2312@qq.com</td><td><button class="layui-btn layui-btn-danger"><span class="layui-icon layui-icon-delete "></span></button></td>
                                <td><button onclick="arrangeThis(this)" onmouseover="showOne(this)" onmouseleave="clearAll()" class="layui-btn layui-btn-normal positionSet"><span class="layui-icon layui-icon-home"></span></button></td></tr>
                            <tr><td>程世峰</td><td>321312@qq.com</td><td><button class="layui-btn layui-btn-danger"><span class="layui-icon layui-icon-delete"></span></button>
                                <td><button onclick="arrangeThis(this)" onmouseover="showOne(this)" onmouseleave="clearAll()" class="layui-btn layui-btn-normal positionSet"><span class="layui-icon layui-icon-home"></span></button></td></td></tr>
                            <tr><td>关婷楼</td><td>4124112@qq.com</td><td><button class="layui-btn layui-btn-danger"><span class="layui-icon layui-icon-delete"></span></button></td>
                                <td><button onclick="arrangeThis(this)" onmouseover="showOne(this)" onmouseleave="clearAll()" class="layui-btn layui-btn-normal positionSet"><span class="layui-icon layui-icon-home"></span></button></td></tr>
                            --></tbody>
                        </table></div>
                </div>
            </div>

            <hr class="layui-bg-orange">
            <p class="titleP">后勤服务管理</p>
            <br>
            <div class="hotelManage layui-row">
                <p class="smallTitleP">预约酒店房间</p>
                <div class="layui-col-lg10"><input type="text" placeholder="根据邮箱或id查询酒店：" class="layui-input"></div>
                <div class="layui-col-lg2"><button class="layui-btn layui-btn-normal"><span class="layui-icon layui-icon-search"></span></button></div>
                <br><br>
                <table  class="layui-table">
                    <colgroup>
                        <col width="30%">
                        <col width="50%">
                        <col width="20%">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>店名</th>
                        <th>联系方式</th>
                        <th>动作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>居家旅馆</td>
                        <td>4384381@qq.com</td>
                        <td><button class="layui-btn layui-btn-normal  layui-btn-sm">预约</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="hotelManage layui-row">
                <p class="smallTitleP">预约司机接送</p>
                <div class="layui-col-lg10"><input type="text" placeholder="根据邮箱或id查询司机：" class="layui-input"></div>
                <div class="layui-col-lg2"><button class="layui-btn layui-btn-normal"><span class="layui-icon layui-icon-search"></span></button></div>
                <br><br>
                <table  class="layui-table">
                    <colgroup>
                        <col width="30%">
                        <col width="50%">
                        <col width="20%">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>司机</th>
                        <th>联系方式</th>
                        <th>动作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>马大师</td>
                        <td>4384381@qq.com</td>
                        <td><button class="layui-btn layui-btn-normal  layui-btn-sm">预约</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>

        </div>
        <RelateToMe :meeting-user="meetingUser"></RelateToMe>
        <div id="arrangeDiv">
            <div onclick="clearClick()" class="arrangeShow relateMe layui-col-lg4"><p class="titleP">对该成员的安排</p><table class="layui-table">
                <!--                    3．填写参会的往返时间、住宿要求及其它情况-->
                <colgroup>
                    <col width="30%">
                    <col width="70%">
                </colgroup>
                <tbody>
                <tr>
                    <td>接车安排</td>
                    <td><input  type="text"  required  lay-verify="required" value="" autocomplete="off" class="layui-input"></td>
                </tr>
                <tr>
                    <td>住宿安排</td>
                    <td><input  type="text" name="stayRequire" required  lay-verify="required" value="单人间" autocomplete="off" class="layui-input"></td>
                </tr>
                <tr><td>其他安排</td><td><input  type="text" name="memberCount" required  lay-verify="required" value="" autocomplete="off" class="layui-input"></td></tr>
                </tbody>
            </table>
                <button class="layui-btn layui-btn-normal">确认提交</button></div>
        </div>
    </div>
</template>

<script>
    import RelateToMe from "./RelateToMe";
    export default {
        name: "Manage",
        components: {RelateToMe},
        data(){
            return {
                memberShow:false,
                managerShow:false,
                meetingId:"",
                notFound:false,
                meetingInfo:{//这里是会议的全部信息
                    name:"123",
                    id:123,
                    beginTime:"2020年12月6日20:47",
                    endTime:"2020年12月6日20:47",
                    address:"信工楼b区303",
                    orderStatus:"未开始",
                    createTime:"2020年12月6日20:48:33",
                    num:321,
                    managerInfo:[{id:123,name:"嘿嘿", email:"123@qq.com"},{id:123,name:"嘿嘿", email:"123@qq.com"}],
                    memberInfo:[{id:123,name:"赵日天", email:"12323@qq.com"}]
                },
                meetingUser:{
                    ifJoin:false,
                    info:"",
                    journey:{
                        time:"2020年12月17日19:11",
                        origin:"床上",
                        target:"凳子上"
                    },
                    room:{

                    }
                }
            }
        },
        computed:{
            identity(){
                return this.$store.state.identity.toLowerCase()==="common";
            }
        },
        created() {
            this.meetingId=this.$route.query.meetingId;
            let sendUserId;
            if(!this.identity){//若不是普通用户则不进行关联此id的查找
                sendUserId=0;
            }else sendUserId=this.$store.state.user.id;
            this.$request(this.$url.detail,{
                params:{
                    meetingId:this.meetingId,
                    userId:sendUserId
                }
            }).then(res => {
                if(res.data==="error"){this.notFound=false;this.$message("查询过程出现异常");return;}
                this.meetingInfo=res.data.meeting;
                if(this.identity)
                    this.meetingUser=res.data.meetingUser;
            }).catch( err => {
                console.log(err);
                this.$message("网络请求出错！已为您显示样例信息")
            });
        }
    }
</script>

<style scoped>
    .detailContainer{
        margin: 20px;
        border:2px solid #4E5465;
        border-radius: 5px;
    }
    .titleP{
        font-size: 35px;
        color: #4E5465;
        text-align: center;
    }
    .baseInfo{
        border-right: #999999 solid 2px;
        padding: 15px;
    }
    .relateMe{
        padding: 15px;
    }
    .hotelManage{
        margin: auto;
    }
    .smallTitleP{
        text-align: center;
        margin: 10px;
        font-size: 20px;
    }
    .createMeeting{
        width: 60%;
        margin: auto;
        padding: 20px;
    }
    .beforeCheckBox{
        height: 30px;
    }
    .positionSet{
        position: relative;
        max-width: 55px;
    }
    #arrangeDiv{
        display: none;
    }
    .arrangeShow{
        position: absolute;
        top:-30px;
        left: 100px;
        background-color: #e8e8e8;
        opacity: 90%;
        width: 400px!important;


    }
</style>