<template>
    <div class="hotelManage layui-row">
        <p class="smallTitleP">预约酒店房间</p>
        <el-input v-model="hotelInput" placeholder="输入id、邮箱或名称进行查找">
            <el-button slot="append" icon="el-icon-search" @click="searchHotelClick"></el-button>
        </el-input>
        <br>
        <table  class="layui-table">
            <thead><tr><td colspan="6" class="align-center">搜索结果</td></tr>
            <tr>
                <th>酒店名</th>
                <th>联系方式</th>
                <th>详细地址</th>
                <th>预约</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="hotelItem in searchHotelList" :key="hotelItem.id"><td>{{hotelItem.name}}</td><td>{{hotelItem.phone}}</td>
                <td>{{hotelItem.address}}</td>
                <td>
                    <el-popover
                            placement="right"
                            width="800"
                            trigger="click">
                        <reserve-hotel-form :meeting-id="meetingId" :driver-id="hotelItem.id"></reserve-hotel-form>
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
            <thead><tr><td colspan="6" class="align-center">全部酒店</td></tr>
            <tr>
                <th>酒店名</th>
                <th>联系方式</th>
                <th>详细地址</th>
                <th>预约</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="hotelItem in hotelList" :key="hotelItem.id"><td>{{hotelItem.name}}</td><td>{{hotelItem.phone}}</td>
                <td>{{hotelItem.address}}</td>
                <td>
                    <el-popover
                            placement="right"
                            width="400"
                            trigger="click">
                        <reserve-hotel-form :meeting-id="meetingId" :driver-id="hotelItem.id"></reserve-hotel-form>
                        <el-button slot="reference" size="small">预约</el-button>
                    </el-popover>
                </td>
            </tr>
            <tr v-show="finding===1"><td colspan="6"><p class="warnMessage">正在查询...</p></td></tr>
            <tr v-show="finding===2"><td colspan="6"><p class="warnMessage">未查询到。</p></td></tr>
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
            <thead><tr><td colspan="6" class="align-center">已预约</td></tr>
            <tr>
                <th>酒店名</th>
                <th>联系方式</th>
                <th>详细地址</th>
                <th>接受状态</th>
                <th>预约</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="hotelItem in haveHotelList" :key="hotelItem.id"><td>{{hotelItem.name}}</td><td>{{hotelItem.phone}}</td>
                <td>{{hotelItem.address}}</td><td>{{hotelItem.state}}</td>
                <td>
                    <el-popover
                            placement="right"
                            width="800"
                            trigger="click">
                        <reserve-hotel-form :meeting-id="meetingId" :driver-id="hotelItem.id"></reserve-hotel-form>
                        <el-button slot="reference" size="small">查看</el-button>
                    </el-popover>
                </td>
            </tr>
            <tr v-show="getting===1"><td colspan="6"><p class="warnMessage">正在查询...</p></td></tr>
            <tr v-show="getting===2"><td colspan="6"><p class="warnMessage">未查询到。</p></td></tr>
            </tbody>
        </table>
    </div>
</template>

<script>

    import ReserveHotelForm from "../../components/reserveHotelForm";
    export default {
        name: "ReserveHotel",
        components: {ReserveHotelForm},
        /*components: {ReserveDriverForm},*/
        data(){
            return{
                hotelInput:"",
                hotelAll:[
                    [{id:11322,name:"前湖迎宾馆",phone:"12438438132",address:"南昌大学对面"},
                        {id:113122,name:"前湖迎滨馆",phone:"12438438132",address:"南昌大学对面"},
                        {id:1412322,name:"前湖迎殡馆",phone:"12438438132",address:"南昌大学对面"}],
                    [{id:11322,name:"前湖迎宾馆",phone:"12438438132",address:"南昌大学对面"},
                        {id:113122,name:"前湖迎滨馆",phone:"12438438132",address:"南昌大学对面"},
                        {id:1412322,name:"前湖迎殡馆",phone:"12438438132",address:"南昌大学对面"}],
                ],
                hotelList:[],
                searchHotelList:[],
                haveHotelList:[{id:11322,name:"前湖迎宾馆",phone:"12438438132",address:"南昌大学对面",state:"已接受"},
                    {id:113122,name:"前湖迎滨馆",phone:"12438438132",address:"南昌大学对面",state:"未接受"},
                    {id:1412322,name:"前湖迎殡馆",phone:"12438438132",address:"南昌大学对面",state: "被拒绝"}],
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
                if(pageNum>this.hotelAll.length){
                    this.sendHotelPage(pageNum,lineNumber);
                    return;
                }
                let hotelAllElement = this.hotelAll[pageNum-1];
                this.hotelList= hotelAllElement;
                if(!hotelAllElement)this.finding=2;
                else {
                    if(hotelAllElement.length<lineNumber){
                        this.finding=2;
                    }else this.finding=0;}
            },
            sendHotelPage(pageNum,lineNum){
                this.finding=1;
                this.hotelList=[];
                this.$request(this.$url.sendHotelPage,{
                    params:{
                        pageNum,lineNum
                    }
                }).then(res =>{
                    let data=res.data;
                    if(data.msg==="success"){
                        this.hotelAll.push(data.newHotelList);
                        this.pageTotal=data.pageTotal*10;
                        this.finding=0;
                        this.hotelList=this.hotelAll[pageNum-1];
                    }
                    else {this.$message("加载失败，可能已无更多数据。");this.finding=2;}
                }).catch(err =>{
                    console.log(err);
                    this.$message("网络请求错误");
                    this.finding=2;
                });
            },
            searchHotelClick(){
                if(this.hotelInput.length===0)return;
                this.searching=1;
                this.$request(this.$url.searchHotel,{
                    params:{input:this.hotelInput}
                }).then(res =>{
                    let data=res.data;
                    if(data.msg==="success"){
                        this.searchHotelList=data.hotelList;
                        this.searching=0;
                    }
                    else this.searching=2;
                }).catch(err =>{
                    console.log(err);
                    this.$message("网络请求错误");
                    this.searching=2;
                });
            },
            searchHotelByMeetingId(){
                this.$request(this.$url.searchHotelByMeetingId,{
                    params:{meetingId:this.meetingId}
                }).then(res =>{
                    let data=res.data;
                    if(data.msg==="success"){
                        this.haveHotelList=data.hotelList;
                        this.$emit("haveReservedHotel",data.hotelList);
                    }
                    else {
                        console.log("搜索失败");
                    }
                }).catch(err =>{
                    console.log(err);
                    this.$message("查找酒店出现错误");
                });
            }
        },
        created() {
            this.getOnePage(1);
            this.searchHotelByMeetingId();
        }

    }
</script>

<style scoped>
    .hotelManage{
        margin: auto;
        border:1px solid #4e5465;
        border-radius: 2px;
        padding: 10px;
        background-color: #ffe1e6;

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