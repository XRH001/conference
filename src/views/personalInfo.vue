<template>
    <div class="personalContainer">
        <div v-if="show===0" >
            <table class="layui-table">
            <colgroup>
                <col width="20%">
                <col width="80%">
            </colgroup>
            <tbody>
                <tr>
                    <td colspan="2"><div class="headDiv"><img class="headImg" :src="$store.getters.headPath" @error="notFindImg()"></div>
                        <button class="floatRight layui-btn layui-btn-normal" @click="alterNone=!alterNone">修改/完善信息</button>
                        <button class="floatRight layui-btn layui-btn-checked" @click="passwordChangeNone=!passwordChangeNone">修改密码</button>
                    </td>
                </tr>
                <tr>
                    <td>用户名</td><td>{{$store.state.user.username}}</td>
                </tr>
                <tr>
                    <td>邮箱</td><td>{{$store.state.user.email}}</td>
                </tr>
                <tr>
                    <td>性别</td><td>{{sex}}</td>
                </tr>
                <tr>
                    <td>生日</td><td>{{$store.state.user.birth}}</td>
                </tr>
                <tr>
                    <td>平台ID</td><td>{{$store.state.user.id}}</td>
                </tr>
                <tr>
                    <td>手机</td><td>{{$store.state.user.phone}}</td>
                </tr>
                <tr>
                    <td>真实姓名</td><td>{{$store.state.user.name}}</td>
                </tr>

            </tbody>
        </table>
            <table class="alterTable layui-table" v-show="alterNone">
            <colgroup>
                <col width="30%">
                <col width="70%">
            </colgroup>
            <tbody>
                <tr><td colspan="2"><div class="headDiv"><img class="headImg" :src="$store.getters.headPath" @error="notFindImg()">
                    点击修改头像</div>
                    </td></tr>
                <tr><td>用户名</td><td><input v-model.lazy="alterSend.username" class="layui-input" placeholder="请输入25位字符以下任意字符，不可为空"></td></tr>
                <tr><td>手机号</td><td><input v-model.lazy="alterSend.phone" class="layui-input" placeholder="手机号将影响您的会议通信，请认真填写"></td></tr>
                <tr><td>真实姓名</td><td><input v-model.lazy="alterSend.name" class="layui-input" placeholder=""></td></tr>
                <tr><td>性别</td><td><input v-model.lazy="alterSend.sex" class="radioSex" type="radio"  value="male"  checked><span class="layui-icon layui-icon-male">男</span>
                    <input class="radioSex" v-model.lazy="alterSend.sex" type="radio"  value="female"  ><span class="layui-icon layui-icon-female">女</span>
                </td></tr>
                <tr><td>生日</td><td><el-date-picker v-model.lazy="alterSend.birthday" value-format="yyyy/MM/dd"></el-date-picker></td></tr>
                <tr><td colspan="2"><div class="buttonDiv">
                    <button  class="layui-btn layui-btn-checked" @click="alterInfoClick">确认修改</button>
                    <button @click="alterNone=!alterNone" class="layui-btn layui-btn-primary ">取消修改</button>
                    </div></td>
                </tr>
            </tbody>
        </table>
            <table class="alterTable layui-table" v-show="passwordChangeNone">
            <colgroup>
                <col width="30%">
                <col width="70%">
            </colgroup>
            <tbody>
            <tr><td>原密码</td><td><input v-model.lazy="password.formerInput" type="password" class="layui-input" placeholder="找回密码的位置在登录界面"></td></tr>
            <tr><td>新密码</td><td><input v-model.lazy="password.newPassword" type="password" class="layui-input" placeholder="请输入8-16位字母数字或特殊符号"></td></tr>
            <tr><td>确认新密码</td><td><input v-model.lazy="password.newConfirm" type="password" class="layui-input" placeholder=""></td></tr>
            <tr><td colspan="2"><div class="buttonDiv">
                <button  class="layui-btn layui-btn-checked" @click="changePasswordClick()">确认修改</button>
                <button class="layui-btn layui-btn-primary" @click="passwordChangeNone=!passwordChangeNone">取消</button>
            </div>
            </td></tr>
            </tbody>
        </table>
        </div>
        <div v-if="show===1"><DriverInfo></DriverInfo></div>
        <div v-if="show===2"><HotelInfo></HotelInfo></div>
        <div v-if="show===3"><h1>未找到您的信息请<a href="javascript:void(0)" @click="errorInfo()">重新登录</a></h1></div>
        <div class="headDiv" v-if="show!==3"><button @click="exitCount" class="layui-btn layui-btn-danger">退出登录</button></div>
        <div class="cover" v-show="alterNone^passwordChangeNone"></div>
    </div>
</template>

<script>
    import DriverInfo from "../components/DriverInfo";
    import HotelInfo from "../components/HotelInfo";
    export default {
        name: "personalInfo",
        components: {HotelInfo, DriverInfo},
        data(){
            return{
                alterNone:false,
                passwordChangeNone:false,
                show:0,
                password:{
                    formerInput:"",
                    newPassword:"",
                    newConfirm:""
                },
                alterSend:{
                    name:"",
                    phone:"",
                    sex:"male",
                    username:"",
                    birthday:""
                }
            }
        },
        computed:{
            sex(){
                return this.$store.state.user.sex==="male"?"男":"女";
            }
        },
        methods:{
            alterInfoClick(){
                if(!this.nameCheck()){this.$message("用户名不可为空，且长度需小于25");return;}
                /*this.$http("mainServlet?ac=need&apiName=returnSuccess"*/
                this.$post(this.$url.alterInfo,{
                        userId:this.$store.state.user.id,
                        alter:this.alterSend

                }).then(res => {
                    if(res.data==="success"){
                        this.$store.commit("updateUser",this.alterSend);this.$message("修改成功");
                        this.alterNone=!this.alterNone;
                    }
                    else if(res.data==="fail"){this.$message("修改失败，请检查是否填入不支持的信息");}
                    else this.$message("发生错误");
                }).catch(err => {
                    console.log(err);
                    this.$message("网络请求失败");
                });
            },
            changePasswordClick(){
                /*let reg=/^[0-9A-Za-z\\W]{6,18}$/;
                if(!reg.test(this.password.newPassword)){this.$message("新密码格式不正确(6-18位字母数字或特殊符号)");return;}*/
                if(this.password.newPassword!==this.password.newConfirm){this.$message("两次输入不同");return;}
                //console.log(this.$store.state.user.id);
                console.log(this.password.formerInput);
                console.log(this.password.newPassword);
                this.$request(this.$url.changePassword,{
                    params:{
                        userId:this.$store.state.user.id,
                        formerPassword:this.password.formerInput,
                        newPassword: this.password.newPassword
                    }
                }).then(res =>{
                    if(res.data==="error"){this.$message("原密码输入错误");}
                    else if(res.data==="success"){this.$message("修改成功");this.passwordChangeNone=!this.passwordChangeNone}
                    else {
                        this.$message("修改失败，请重新登录后重试");
                    }
                }).catch(err =>{
                    this.$message("网络请求异常");
                    console.log(err);
                });
            },
            //退出登录
            exitCount(){
                let flag=confirm("确定退出登录？");
                if(flag){
                    this.$store.commit("exitCount");
                    this.$router.push("/index");
                }
            },
            notFindImg(){
                this.$notFind(require("assets/defaultHead.png"));
            },
            errorInfo(){
                this.$store.commit("exitCount");
                this.$router.push("/login");
            },
            nameCheck(){
                let length = this.alterSend.username.length;
                this.nameWarming =  length <= 25&& length>0;
                return this.nameWarming;
            }
        },
        created() {
            if(this.$store.state.identity.toLowerCase() ==='common'){
                this.show=0;
                    this.alterSend.name=this.$store.state.user.name;
                    this.alterSend.phone=this.$store.state.user.phone;
                    this.alterSend.sex=this.$store.state.user.sex.toLowerCase();
                    this.alterSend.username=this.$store.state.user.username;
                    this.alterSend.birthday=this.$store.state.user.birth;
            }
            else if(this.$store.state.identity.toLowerCase() ==='driver')this.show=1;
            else if(this.$store.state.identity.toLowerCase() ==='hotel')this.show=2;
            else this.show=3;
            console.log(this.alterSend);
        }
    }
</script>

<style scoped>

    .personalContainer{
        width: 60%;
        padding: 20px;
        border: 2px solid #595B5D;
        border-radius: 6px;
        margin: 30px auto auto;
    }
    .headDiv{
        margin: auto;
        width: 120px;
        text-align: center;
    }
    .headImg{
        border-radius: 50%;
        border:2px solid #46d7ed;
        padding: 3px;
        width: 100px;
        height: 100px;
        margin: auto;
    }
    .alterTable{
        position: fixed;
        background-color: white;
        width: 50%;
        top:20%;
        left: 25%;
        z-index: 100;
    }
    .cover{
        position: fixed;
        left: 0;
        width: 100%;
        height: 100%;
        opacity: 30%;
        background-color: #3a404a;
        z-index: 10;
        top:0;
    }
    .floatRight{
        float: right;
    }
    .buttonDiv{text-align: center}
    .radioSex{
        display: inline !important;
        border:2px solid orangered;
        width: 20px;
        height: 20px;
        margin-left: 15px;
        margin-top:10px;
        /*//padding-top: 10px;*/
    }
</style>