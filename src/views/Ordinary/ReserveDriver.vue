<template>
    <div class="hotelManage layui-row">
        <p class="smallTitleP">预约司机接送</p>
        <el-input v-model="driverInput" placeholder="输入id、邮箱或名称进行查找">
            <el-button slot="append" @click="searchDriverClick" icon="el-icon-search" ></el-button>
        </el-input>
        <table  class="layui-table">
            <thead><tr><td colspan="6" class="align-center">搜索结果</td></tr>
            <tr>
                <th>司机</th>
                <th>联系方式</th>
                <th>车型</th>
                <th>核载人数</th>
                <th>车牌号</th>
                <th>预约</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="driverItem in searchDriverList" :key="driverItem.id"><td>{{driverItem.name}}</td><td>{{driverItem.phone}}</td>
                <td>{{driverItem.type}}</td><td>{{driverItem.maxNum}}</td>
                <td>{{driverItem.carNum}}</td>
                <td>
                    <el-popover
                            placement="right"
                            width="400"
                            trigger="click">
                        <reserve-driver-form :meeting-id="meetingId" :driver-id="driverItem.id" :action="1"></reserve-driver-form>
                        <el-button slot="reference" size="small">预约</el-button>
                    </el-popover>
                </td>
            </tr>
            <tr v-show="searching===1"><td colspan="6"><p class="warnMessage">正在查询...</p></td></tr>
            <tr v-show="searching===2"><td colspan="6"><p class="warnMessage">未查询到。</p></td></tr>
            </tbody>
        </table>
        <br><br>
        <table  class="layui-table">
            <thead><tr><td colspan="6" class="align-center">全部司机</td></tr>
            <tr>
                <th>司机</th>
                <th>联系方式</th>
                <th>车型</th>
                <th>核载人数</th>
                <th>车牌号</th>
                <th>预约</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="driverItem in driverList" :key="driverItem.id"><td>{{driverItem.name}}</td><td>{{driverItem.phone}}</td>
                <td>{{driverItem.type}}</td><td>{{driverItem.maxNum}}</td>
                <td>{{driverItem.carNum}}</td>
                <td>
                    <el-popover
                            placement="right"
                            width="400"
                            trigger="click">
                        <reserve-driver-form :meeting-id="meetingId" :driver-id="driverItem.id" :action="1"></reserve-driver-form>
                        <el-button slot="reference" size="small">预约</el-button>
                    </el-popover>
                </td>
            </tr>
            <tr v-show="finding===1"><td colspan="6"><p class="warnMessage">正在查询...</p></td></tr>
            <tr v-show="finding===2"><td colspan="6"><p class="warnMessage">已无更多。</p></td></tr>
            </tbody>
        </table>
        <div class="align-center">
            <el-pagination
                layout="prev, pager, next"
                :total="pageTotal" @current-change="getOnePage">
            </el-pagination>
        </div>
        <br>
        <table  class="layui-table">
            <thead><tr><td colspan="7" class="align-center">已预约</td></tr>
            <tr>
                <th>司机</th>
                <th>联系方式</th>
                <th>车型</th>
                <th>核载人数</th>
                <th>车牌号</th>
                <th>接受状态</th>
                <th>查看</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="driverItem in haveDriverList" :key="driverItem.id"><td>{{driverItem.name}}</td><td>{{driverItem.phone}}</td>
                <td>{{driverItem.type}}</td><td>{{driverItem.maxNum}}</td>
                <td>{{driverItem.carNum}}</td><td>{{driverItem.state}}</td>
                <td>
                    <el-popover
                            placement="right"
                            width="400"
                            trigger="click">
                        <reserve-driver-form :meeting-id="meetingId" :driver-id="driverItem.id" :action="3"></reserve-driver-form>
                        <el-button slot="reference" size="small">查看</el-button>
                    </el-popover>
                </td>
            </tr>
            <tr v-show="getting===1"><td colspan="6"><p class="warnMessage">正在查询...</p></td></tr>
            <tr v-show="getting===2"><td colspan="6"><p class="warnMessage">已无更多。</p></td></tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import ReserveDriverForm from "../../components/reserveDriverForm";
    export default {
        name: "ReserveDriver",
        components: {ReserveDriverForm},
        data(){
            return{
                driverInput:"",
                driverAll:[
                    /*[
                    {id:11322,name:"马师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"},
                    {id:11323,name:"马师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"},
                    {id:11324,name:"马师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"}],
                    [{id:1232,name:"洪师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"},
                        {id:1132,name:"洪师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"},
                        {id:11322,name:"洪师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"}],
                    [{id:1232,name:"马师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"},
                        {id:1132,name:"马师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"},
                        {id:11322,name:"马师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"}],
                    [{id:1232,name:"黎师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"},
                        {id:1132,name:"黎师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"},
                        {id:11322,name:"黎师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231"}]*/
                    ],
                driverList:[],
                searchDriverList:[],
                haveDriverList:[{id:11322,name:"马师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231",state:"已接受"},
                    {id:11323,name:"马师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231",state:"未接受"},
                    {id:11324,name:"马师傅",phone:"4384381@qq.com",type:"小型客车",maxNum:28,carNum:"231231",state:"被拒绝"}],
                pageTotal:70,
                finding:0,
                searching:0,
                getting:0
            }
        },
        props:{
            meetingId:Number
        },methods:{
            getOnePage(pageNum,lineNum){
                let lineNumber=3;
                if(lineNum)lineNumber=lineNum;
                if(pageNum>this.driverAll.length){
                    this.sendDriverPage(pageNum,lineNumber);
                    return;
                }
                let driverAllElement = this.driverAll[pageNum-1];
                this.driverList= driverAllElement;
                if(!driverAllElement)this.finding=2;
                else {
                if(driverAllElement.length<lineNumber){
                    this.finding=2;
                }else this.finding=0;}
            },
            sendDriverPage(pageNum,lineNum){
                this.finding=1;
                this.driverList=[];
                this.$request(this.$url.sendDriverPage,{
                    params:{
                        pageNum,lineNum
                    }
                }).then(res =>{
                    let data=res.data;
                    if(data.msg==="success"){
                        this.driverAll.push(data.newDriverList);
                        this.pageTotal=data.pageTotal*10;
                        this.finding=0;
                        this.driverList=this.driverAll[pageNum-1];
                    }
                    else {this.$message("加载失败，可能已无更多数据。");this.finding=2;}
                }).catch(err =>{
                    console.log(err);
                    this.$message("网络请求错误");
                    this.finding=2;
                });
            },
            searchDriverClick(){
                if(this.driverInput.length===0)return;
                this.searching=1;
                this.$request(this.$url.searchDriver,{
                    params:{input:this.driverInput}
                }).then(res =>{
                    let data=res.data;
                    if(data.msg==="success"){
                        this.searchDriverList=data.driverList;
                        this.searching=0;
                    }
                    else this.searching=2;
                }).catch(err =>{
                    console.log(err);
                    this.$message("网络请求错误");
                    this.searching=2;
                });
            },
            searchDriverByMeetingId(){
                this.$request(this.$url.searchDriverByMeetingId,{
                    params:{meetingId:this.meetingId}
                }).then(res =>{
                    let data=res.data;
                    if(data.msg==="success"){
                        this.haveDriverList=data.driverList;
                        this.$emit("haveReservedDriver",data.driverList);
                    }
                    else {
                        console.log("搜索失败");
                    }
                }).catch(err =>{
                    console.log(err);
                    this.$message("查找司机出现错误");
                });
            }
        },
        created() {
            this.getOnePage(1);
            this.searchDriverByMeetingId();
        }
    }
</script>

<style scoped>
    .hotelManage{
        margin: auto;
        border:1px solid #4e5465;
        border-radius: 2px;
        padding: 10px;
        background-color: #f0f4ff;
    }
    .smallTitleP{
        text-align: center;
        margin: 10px;
        font-size: 20px;
    }

    .warnMessage{
        text-align: center;
        font-size: 20px;
        color: orange;
    }
</style>