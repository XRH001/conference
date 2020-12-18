<template>
    <div class="detailContainer layui-row">
        <div v-if="!notFound">
        <div class="baseInfo layui-col-lg8"><p class="titleP">基本信息</p>
            <table class="layui-table">
                <tbody>
                <tr><td colspan="2">可修改</td></tr>
                <tr>
                    <td>会议名</td>
                    <td>
                        <input  type="text" name="meetingName" required  lay-verify="required" v-model.lazy="meetingInfo.name" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议开始时间</td>
                    <td>
                        <el-date-picker type="datetime"  required v-model.lazy="meetingInfo.beginTime"  ></el-date-picker>
                    </td>
                </tr>
                <tr>
                    <td>会议结束时间</td>
                    <td>
                        <el-date-picker type="datetime"  required v-model.lazy="meetingInfo.endTime"  ></el-date-picker>
                    </td>
                </tr>
                <tr>
                    <td>会议地点</td>
                    <td>
                        <textarea v-model.lazy="meetingInfo.address" autocomplete="off" class="area"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>备注</td>
                    <td>
                        <textarea v-model.lazy="meetingInfo.address" autocomplete="off" class="area"></textarea>
                    </td>
                </tr>
                <tr><td colspan="2"><div><button class="layui-btn layui-btn-checked">确认修改</button></div></td></tr>
                <tr> <td colspan="2">不可修改</td></tr>
                <tr>
                    <td>会议编号</td>
                    <td>
                        <input disabled type="text" name="meetingID" required  lay-verify="required" :value="meetingInfo.id" autocomplete="off" class="layui-input">
                    </td>
                </tr>

                <tr>
                    <td>会议状态</td>
                    <td>
                        <input disabled type="text" name="meetingStatus" required  lay-verify="required" :value="meetingInfo.orderStatus" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>创建时间</td>
                    <td>
                        <input disabled type="text" name="createTime" required  lay-verify="required" :value="meetingInfo.createTime" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议人数</td>
                    <td>
                        <input disabled type="text" name="memberCount" required  lay-verify="required" :value="meetingInfo.num" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                </tbody>
            </table>

            <hr class="layui-bg-orange">
            <p class="titleP">人员管理</p>
            <br>
            <Collapse>
                <span slot="title">管理员名单</span>
                <table slot="content" class="layui-table">
                    <thead><tr><th>姓名</th><th>联系方式</th><td>详细信息</td></tr></thead>
                    <tbody>
                    <tr v-for="item in meetingInfo.managerInfo" :key="item.id">
                        <td>{{item.name}}</td><td>{{item.email}}</td><td>
                        <el-popover
                                placement="right"
                                width="400"
                                trigger="click">
                            <SmallInfo></SmallInfo>
                            <el-button slot="reference">click 激活</el-button>
                        </el-popover>
                    </td></tr>
                    </tbody>
                </table>
            </Collapse>
            <Collapse>
                <span slot="title">普通成员名单</span>
                <table slot="content" class="layui-table">
                    <thead><tr><th>姓名</th><th>联系方式</th></tr></thead>
                    <tbody>
                    <tr v-for="item in meetingInfo.memberInfo" :key="item.id"><td>{{item.name}}</td><td>{{item.email}}</td></tr>
                    </tbody>
                </table>
            </Collapse>

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
        <div v-if="notFound" class="baseInfo">
            <p class="notFound layui-icon layui-icon-404" >未找到此会议信息，会议可能已被取消<router-link to="/index">-回到首页-</router-link></p>
        </div>
    </div>
</template>

<script>
    import RelateToMe from "./RelateToMe";
    import Collapse from "../../components/Collapse";
    import SmallInfo from "../../components/SmallInfo";
    export default {
        name: "Manage",
        components: {SmallInfo, RelateToMe,Collapse},
        data(){
            return {
                memberShow:false,
                managerShow:false,
                meetingId:"",
                notFound:false,
                meetingInfo:{//这里是会议的全部信息
                    name:"123",
                    id:123,
                    beginTime:"2020-12-6 20:47",
                    endTime:"2020-12-6 20:47",
                    address:"信工楼b区303",
                    orderStatus:"未开始",
                    createTime:"2020-12-6 20:48:00",
                    num:321,
                    managerInfo:[{id:124,name:"嘿嘿", email:"123@qq.com"},{id:123,name:"嘿嘿", email:"123@qq.com"}],
                    memberInfo:[{id:127,name:"赵日天", email:"12323@qq.com"}]
                },
                meetingUser:{
                    ifJoin:true,
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

        },
        created() {
            this.meetingId=this.$route.query.meetingId;
            let sendUserId=this.$store.state.user.id;
            const loading = this.$loading({
                lock: true,
                text: 'Loading',
                spinner: 'el-icon-loading',
                background: 'rgba(0, 0, 0, 0.7)'
            });

            this.$request(this.$url.detail,{
                params:{
                    meetingId:this.meetingId,
                    userId:sendUserId
                }
            }).then(res => {
                if(res.data==="error"){this.notFound=true;loading.close();this.$message("查询过程出现异常");return;}
                this.meetingInfo=res.data.meeting;
                if(this.identity)
                    this.meetingUser=res.data.meetingUser;
                loading.close();
            }).catch( err => {
                console.log(err);
                this.$message("网络请求出错！已为您显示样例信息");
                loading.close();
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
    .notFound{
        text-align: center;
        font-size: 40px;
        color: orangered;
    }
    .area{
        height: 100px;
    }
</style>