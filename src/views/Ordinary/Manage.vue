<template>
    <div class="detailContainer layui-row">
        <div v-if="!notFound">
        <div class="baseInfo layui-col-lg8"><p class="titleP">基本信息</p>
            <table class="layui-table">
                <tbody>
                <tr><td colspan="2" >可修改</td></tr>
                <tr>
                    <td>会议名</td>
                    <td>
                        <input  type="text" name="meetingName" required  lay-verify="required" v-model.lazy="meetingInfo.name" autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td>会议开始-结束时间</td>
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
                <tr><td colspan="2" class="align-center"><div>
                    <button @click="changeBaseInfo()" class="layui-btn layui-btn-checked" :disabled="flag.changeBaseDisabled">确认修改</button></div></td></tr>
                <tr> <td colspan="2" >不可修改</td></tr>
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
                <div slot="content" >
                    <div v-if="meetingUser.ifCreator">
                        <el-input placeholder="输入邮箱，id或名称进行查找" v-model.lazy="searchManagerInput">
                            <el-button slot="append" icon="el-icon-search" @click="searchManagerClick()"></el-button>
                        </el-input>
                        <table class="layui-table">
                            <thead><tr><td colspan="5" class="align-center">搜索结果</td></tr>
                            <tr><th>ID</th><th>名称</th><th>邮箱</th><th>详细</th><th>邀请成为管理员</th></tr></thead>
                            <tbody>
                            <tr v-show="searchManager.length===0"><td><p class="align-center">暂无数据</p></td></tr>
                            <tr v-for="memberItem in searchManager" :key="memberItem.id">
                                <td>{{memberItem.id}}</td>
                                <td>{{memberItem.username}}</td>
                                <td>{{memberItem.email}}</td>
                                <td>
                                    <el-popover
                                            placement="right"
                                            width="400"
                                            trigger="click">
                                        <SmallInfo :id="memberItem.id"></SmallInfo>
                                        <el-button slot="reference" size="small">查看信息</el-button>
                                    </el-popover>
                                </td>
                                <td><el-button size="small"  @click="inviteManager(memberItem.id,memberItem.IfManager)" :disabled="flag.inviteManager" plain>邀请</el-button></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <table class="layui-table">
                    <thead><thead><tr><td colspan="6" class="align-center">已添加</td>
                    <tr><th>用户名</th><th>联系方式</th><th>接受状态</th><td>详细信息</td><td>安排行程</td></tr></thead>
                    <tbody>
                    <tr v-for="item in managerInfo" :key="item.id">
                        <td>{{item.username}}</td><td>{{item.email}}</td>
                        <td>{{item.invitationStatus}}
                            <el-popconfirm v-if="meetingUser.ifCreator" title="确认解除该成员的管理员身份吗?" @confirm="removeManager(item.id)">
                                <el-button  size="small" slot="reference" type="danger">解除</el-button>
                            </el-popconfirm>
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
                            <el-button slot="reference" size="small">安排服务</el-button>
                        </el-popover>
                    </td>
                    </tr>
                    </tbody>
                </table></div>
            </Collapse>
            <Collapse                                                                                      >
                <span slot="title">普通成员名单</span>
                <div slot="content">
                    <div>
                        <el-input v-model="searchMemberInput" placeholder="输入id或名称进行查找">
                            <el-button slot="append" icon="el-icon-search" @click="searchMemberClick()"></el-button>
                        </el-input>
                        <table class="layui-table">
                            <thead><tr><td colspan="5" class="align-center">搜索结果</td></tr>
                            <tr><th>ID</th><th>名称</th><th>邮箱</th><th>详细</th><th>邀请参加会议</th></tr></thead>
                            <tbody>
                                <tr v-for="memberItem in searchMember" :key="memberItem.id">
                                    <td>{{memberItem.id}}</td>
                                    <td>{{memberItem.username}}</td>
                                    <td>{{memberItem.email}}</td>
                                    <td>
                                    <el-popover
                                            placement="right"
                                            width="400"
                                            trigger="click">
                                        <SmallInfo :id="memberItem.id"></SmallInfo>
                                        <el-button slot="reference" size="small">查看信息</el-button>
                                    </el-popover>
                                    </td>
                                    <td><el-button size="small" @click="inviteMember(memberItem.id,memberItem.haveJoin)" :disabled="flag.inviteMember" plain>邀请</el-button></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <table  class="layui-table">
                        <thead><tr><td colspan="6" class="align-center">已添加</td>
                        </tr><tr><th>姓名</th><th>联系方式</th><th>接受状态</th><th>详细信息</th><th>安排行程</th><th>删除或拒绝</th></tr></thead>
                        <tbody>
                        <tr v-for="item in memberInfo" :key="item.id"><td>{{item.username}}</td><td>{{item.email}}</td>
                            <td>{{item.invitationStatus}}
                                <el-button v-if="item.invitationStatus==='申请中'" @click="acceptMember(item.id)" size="small" type="primary" plain>同意</el-button>
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
                                    <el-button slot="reference" size="small">安排</el-button>
                                </el-popover>
                            </td>
                            <td><el-popconfirm title="真的要删除此成员吗？" @confirm="deleteMember(item.id)">
                                <el-button slot="reference" size="small el-icon-delete" type="danger"></el-button></el-popconfirm>
                            </td>
                        </tr>

                    </tbody>
                    </table>
                </div>
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
    import ArrangeOne from "./ArrangeOne";
    import {methods} from "../../assets/js/manager"
    export default {
        name: "Manage",
        components: {ArrangeOne, SmallInfo, RelateToMe,Collapse},
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
                },
                managerInfo:[{id:124,username:"嘿嘿", email:"123@qq.com",invitationStatus:"已接受"},
                    {id:123,username:"嘿嘿", email:"123@qq.com",invitationStatus:"已接受"}],
                memberInfo:[{id:127,username:"赵日天", email:"12323@qq.com",invitationStatus:"已接受"},
                    {id:1221,username:"赵日天", email:"12323@qq.com",invitationStatus:"已接受"},
                    {id:123211,username:"赵2313", email:"12323@qq.com",invitationStatus:"申请中"}],
                meetingUser:{
                    ifCreator:true,
                    ifJoin:true,
                    info:"",
                    journey:{
                        time:"2020年12月17日19:11",
                        origin:"床上",
                        target:"凳子上"
                    },
                    room:{
                    }
                },
                searchMemberInput:"",
                searchManagerInput:"",
                searchMember:[{id:11,username:"123",email:"wq321@qq.com",haveJoin:false},{id:21,username:"123",email:"wq321@qq.com",haveJoin:true}],
                searchManager:[{id:31,username:"123",email:"wq321@qq.com",IfManager:false},{id:21,username:"123",email:"wq321@qq.com",IfManager:true}],
                flag:{
                    changeBaseDisabled:false,
                    inviteMember:false,
                    inviteManager:false
                }
            }
        },
        computed:{

        },methods:methods,
        created() {
            this.meetingId=this.$route.query.meetingId;
            let sendUserId=this.$store.state.user.id;
            const loading = this.$loading({
                lock: true,
                text: 'Loading',
                spinner: 'el-icon-loading',
                background: 'rgba(32,32,32,0.7)'
            });
            this.$request(this.$url.detail,{
                params:{
                    meetingId:this.meetingId,
                    userId:sendUserId
                }
            }).then(res => {
                if(res.data==="error"){this.notFound=true;loading.close();this.$message("查询过程出现异常");return;}
                this.meetingInfo=res.data.meeting;
                this.managerInfo=res.data.meetingInfo;
                this.memberInfo=res.data.memberInfo;
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


    .notFound{
        text-align: center;
        font-size: 40px;
        color: orangered;
    }
    .area{
        height: 100px;
    }
    .align-center{text-align: center}
</style>