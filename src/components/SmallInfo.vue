<template>
    <div class="small" >
        <div v-if="find===0"><p class="finding">查找中，请稍等...</p></div>
        <table v-if="find===1" class="loadingTable layui-table" >
            <colgroup>
                <col width="20%">
                <col width="80%">
            </colgroup>
            <tbody>
            <tr>
                <td colspan="2"><div class="align-center"><img class="headImg" :src="headPath" @error="notFindImg()"></div>
                </td>
            </tr>
            <tr>
                <td>用户名</td><td>{{person.username}}</td>
            </tr>
            <tr>
                <td>邮箱</td><td>{{person.email}}</td>
            </tr>
            <tr>
                <td>性别</td><td>{{person.sex}}</td>
            </tr>
            <tr>
                <td>生日</td><td>{{person.birth}}</td>
            </tr>
            <tr>
                <td>平台ID</td><td>{{person.id}}</td>
            </tr>
            <tr>
                <td>手机</td><td>{{person.phone}}</td>
            </tr>
            <tr>
                <td>姓名</td><td>{{person.name}}</td>
            </tr>

            </tbody>
        </table>
        <div v-if="find===2"><p class="warning">查找失败，请检查网络</p></div>
        <div v-if="find===3"><el-button @click="findInfo">查找</el-button></div>
    </div>
</template>

<script>
    export default {
        name: "SmallInfo",
        data(){
            return {
                person:{
                    headPath:"",
                    username:"",
                    email:"",
                    sex:"",
                    id:"",
                    phone:"",
                    name:"",
                    birth:""
                },
                find:3
            }
        },props:{
            id:Number,
            personInfo:Object
        },methods:{
            notFindImg(){
                this.$notFind(require("assets/defaultHead.png"));
            },
            findInfo(){
                this.find=0;
                if(this.id) {
                    /*this.$http("mainServlet?ac=need&apiName=personalInfoSucess3",*/
                    this.$request(this.$url.personInfo,{
                        params:{id:this.id}
                    }).then(res => {
                        console.log(res.data);
                        if(res.data==="fail"){this.find=2;}
                        this.person=res.data.person;
                        this.find=1;
                    }).catch(err =>{
                        this.$message("网络请求异常");
                        this.find=1;
                        console.log(err);
                    });
                }
                else this.find=2;
            }
        },
        computed:{
            headPath(){
                return this.$url.baseURL+this.person.headPath
            }
        },
        created() {
            if(this.personInfo){
                this.person=this.personInfo;
                this.find=1;
            }
        }
    }
</script>

<style scoped>
    .small{
    width: 400px;
    }
    .warning{
        font-size: 16px;
        text-align: center;
        color: darkgrey;
    }
    .align-center{
        text-align: center;
    }
    .finding{
        font-size: 16px;
        text-align: center;
        color: #90d3b2;
    }
    .headImg{
        border-radius: 50%;
        border:2px solid #46d7ed;
        padding: 3px;
        width: 100px;
        height: 100px;
        margin: auto;
    }
</style>