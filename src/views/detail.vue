<template>
    <div class="detailContainer layui-row">
        <div class="baseInfo layui-col-lg8"><p class="titleP">基本信息</p>
            <table class="layui-table">
                <tbody>
                <tr>
                    <td>会议名</td>
                    <td>
                        <input disabled type="text" name="meetingName" required  lay-verify="required" :value="meetingInfo.name" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议编号</td>
                    <td>
                        <input disabled type="text" name="meetingID" required  lay-verify="required" :value="meetingId" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议开始时间</td>
                    <td>
                        <input disabled type="text" name="startTime" required  lay-verify="required" :value="meetingInfo.beginTime" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议预计结束时间</td>
                    <td>
                        <input disabled type="text" name="overTime" required  lay-verify="required" :value="meetingInfo.endTime" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议地点</td>
                    <td>
                        <input disabled type="text" name="meetingPosition" required  lay-verify="required" :value="meetingInfo.address" autocomplete="off" class="layui-input">
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
            <hr class="layui-bg-cyan">
            <div class="layui-collapse">
                <p class="titleP">人员信息</p><br><br>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title" @click="managerShow=!managerShow">
                        <span v-if="managerShow" class="layui-icon layui-icon-down"></span>
                        <span v-else class="layui-icon layui-icon-right"></span>
                        管理员名单</h2>
                    <div class="layui-colla-content" :class="{'layui-show':managerShow}">
                        <table class="layui-table">
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
                        </table></div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title" @click="memberShow=!memberShow">
                        <span v-if="memberShow" class="layui-icon layui-icon-down"></span>
                        <span v-else class="layui-icon layui-icon-right"></span>
                        普通成员名单</h2>
                    <div class="layui-colla-content" :class="{'layui-show':memberShow}">
                        <table class="layui-table">
                            <thead><tr><th>姓名</th><th>联系方式</th></tr></thead>
                            <tbody>
                            <tr v-for="item in meetingInfo.memberInfo" :key="item.id"><td>{{item.name}}</td><td>{{item.email}}</td></tr>
                            </tbody>
                        </table></div>
                </div>
            </div>
        </div>
        <RelateToMe :meeting-user="meetingUser"></RelateToMe>

    </div>
</template>

<script>
    import RelateToMe from "./Ordinary/RelateToMe";
    import SmallInfo from "../components/SmallInfo";
    export default {
        name: "detail",
        components: {SmallInfo, RelateToMe},
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
</style>