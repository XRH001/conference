<template>
    <div class="detailContainer layui-row">
        <div v-if="!notFound">
        <div  class="baseInfo layui-col-lg8"><p class="titleP">基本信息</p>
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
                        <input disabled type="text" name="meetingID" required  lay-verify="required" :value="meetingInfo.id" autocomplete="off" class="layui-input">
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
                    <td>备注</td>
                    <td>
                        <textarea :value="meetingInfo.remark" disabled autocomplete="off" class="area"></textarea>
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
                <Collapse>
                    <span slot="title">管理员名单</span>
                    <div slot="content" >

                        <table class="layui-table">
                            <thead><thead><tr><th>用户名</th><th>联系方式</th><th>接受状态</th><td>详细信息</td><td>查看行程</td></tr></thead>
                            <tbody>
                            <tr v-for="item in managerInfo" :key="item.id">
                                <td>{{item.name}}</td><td>{{item.email}}</td>
                                <td>{{item.invitationStatus}}
                                </td>
                                <td>
                                    <el-popover
                                            placement="right"
                                            width="400"
                                            trigger="click">
                                        <SmallInfo :id="item.id" ref="personInfo"></SmallInfo>
                                        <el-button slot="reference" size="small">查看信息</el-button>
                                    </el-popover>
                                </td>
                                <td>
                                    <el-popover
                                            placement="right"
                                            width="400"
                                            trigger="click">
                                        <ArrangeOne></ArrangeOne>
                                        <el-button slot="reference" size="small">查看行程</el-button>
                                    </el-popover>
                                </td>
                            </tr>
                            </tbody>
                        </table></div>
                </Collapse>
                <Collapse>                                                                                      >
                    <span slot="title">普通成员名单</span>
                    <div slot="content">
                        <table  class="layui-table">
                            <thead><tr><th>姓名</th><th>联系方式</th><th>接受状态</th><th>详细信息</th><th>查看行程</th></tr></thead>
                            <tbody>
                            <tr v-for="item in memberInfo" :key="item.id"><td>{{item.name}}</td><td>{{item.email}}</td>
                                <td>{{item.invitationStatus}}
                                    </td>
                                <td>
                                    <el-popover
                                            placement="right"
                                            width="400"
                                            trigger="click">
                                        <SmallInfo :id="item.id" ref="personInfo"></SmallInfo>
                                        <el-button slot="reference" size="small">查看信息</el-button>
                                    </el-popover>
                                </td>
                                <td>
                                    <el-popover
                                            placement="right"
                                            width="400"
                                            trigger="click">
                                        <ArrangeOne ></ArrangeOne>
                                        <el-button slot="reference" size="small">查看行程</el-button>
                                    </el-popover>
                                </td>

                            </tr>

                            </tbody>
                        </table>
                    </div>
                </Collapse>
            </div>
        </div>
        <RelateToMe :meeting-user="meetingUser" :meetingId="meetingInfo.id" @infoChange="infoChange"
        v-if="identity" class="layui-col-lg4"></RelateToMe>
        </div>
        <div v-if="notFound" class="baseInfo">
            <p class="notFound layui-icon layui-icon-404" >未找到此会议信息，会议可能已被取消<router-link to="/index">-回到首页-</router-link></p>
        </div>
    </div>
</template>

<script>
    import RelateToMe from "./Ordinary/RelateToMe";
    import SmallInfo from "../components/SmallInfo";
    import ArrangeOne from "./Ordinary/ArrangeOne";
    import Collapse from "../components/Collapse";
    export default {
        name: "detail",
        components: {ArrangeOne, SmallInfo, RelateToMe,Collapse},
        data(){
            return {
                memberShow:false,
                managerShow:false,
                notFound:false,
                meetingInfo:{//这里是会议的全部信息
                    name:"123",
                    id:123,
                    beginTime:"2020-12-6 20:47",
                    endTime:"2020-12-6 20:47",
                    address:"信工楼b区303",
                    remark:"本次会议，请务必参加",
                    orderStatus:"未开始",
                    createTime:"2020-12-6 20:48:00",
                    num:321,
                },
                managerInfo:[{id:124,name:"嘿嘿", email:"123@qq.com",invitationStatus:"已接受"},
                    {id:123,name:"嘿嘿", email:"123@qq.com",invitationStatus:"已接受"}],
                memberInfo:[{id:127,name:"赵日天", email:"12323@qq.com",invitationStatus:"已接受"},
                    {id:1221,name:"赵日天", email:"12323@qq.com",invitationStatus:"已接受"},
                    {id:123211,name:"赵2313", email:"12323@qq.com",invitationStatus:"申请中"}],
                meetingUser:{
                    ifJoin:true,
                    ifApplied:false,
                    info:"",

                    driver:{//司机信息
                        name:"黎烨玄",
                        id:12,
                        carNum:"皖·H 141223",
                        phone:"56451313",
                        journey:{
                            time:"2020年12月17日19:11",
                            origin:"床上",
                            target:"凳子上"
                        }
                        },
                    hotel:{//酒店信息

                        room:{
                        }
                    },

                }
            }
        },
        computed:{
            identity(){
                return this.$store.state.identity.toLowerCase()==="common";
            }
        },methods:{
            infoChange(info){
                this.meetingUser.info=info;
            }
        },
        created() {
            let meetingId=this.$route.query.meetingId;
            let sendUserId;
            if(!this.identity){//若不是普通用户则不进行关联此id的查找
                sendUserId=0;
            }else sendUserId=this.$store.state.user.id;
            const loading = this.$loading({
                lock: true,
                text: 'Loading',
                spinner: 'el-icon-loading',
                background: 'rgba(0, 0, 0, 0.7)'
            });

            this.$request(this.$url.detail,{
                params:{
                    meetingId:meetingId,
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
                loading.close();
                this.$message("网络请求出错！已为您显示样例信息");
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
    .notFound{
        text-align: center;
        font-size: 40px;
        color: orangered;
    }
</style>