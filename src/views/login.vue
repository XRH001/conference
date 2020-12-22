<template>
    <div class="container layui-row " >
        <Swiper></Swiper>
        <div class="layui-col-lg-offset1 layui-col-lg4 layui-col-md4 ">
            <button class="layui-btn menuButton" @click="tipsShow=!tipsShow"><span class="layui-icon layui-icon-spread-left"></span></button>
            <div class="layui-card leftCard " :class="{'displayBlock':tipsShow}">
                <div class="cardTitle">tips</div>
                <div class="layui-card-body">
                    *账号身份在登录后自动检测，并跳转到对应首页<br>
                    *系统管理员登录入口不在此<br>
                    *暂时只支持使用邮箱登录<br>
                    *密码必须超过6位<br>
                    *界面使用了layui样式但layui组件的功能是由vue辅助完成的(主要是因为Vue里面最好不要引入jquery)<br>
                    <div class="layui-col-lg2 layui-col-md2 setFixed">
                        <p>扫码使用小程序</p>
                        <img  src="../assets/miniapp.png">
                    </div>
                </div>
            </div>
        </div>
        <div class="center layui-bg-cyan layui-col-lg-offset1 layui-col-md-offset1 layui-col-xs-offset1 layui-col-lg5 layui-col-md6 layui-col-xs10 ">
            <p class="layui-icon layui-icon-read loginTitle">用户登录</p>
            <a href="javascript:void(0)" class="layui-icon layui-icon-layer forget" @click="forget.dialog=true">忘记密码？</a>
            <br><br><br>
            <div class="layui-form ">
                <div class="layui-form-item">
                    <label class="layui-form-label ">邮箱/账号</label>
                    <div class="layui-input-block ">
                        <input type="text" name="email" required v-model.lazy="email"  lay-verify="required" placeholder="请输入邮箱或账号" autocomplete="off" class="layui-input">
                    </div>
                </div><br><br>
                <div class="layui-form-item">
                    <label class="layui-form-label ">密码</label>
                    <div class="layui-input-block ">
                        <input type="text" name="password" required v-model.lazy="password" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div><br>
                <p class="warming" :class="{'displayNone':right}">{{warming}}</p>
                <br><br>
                <div class="layui-form-item">
                    <div class="layui-input-block layui-col-space30">
                        <input type="button" class="layui-btn layui-btn-checked"  @click="loginClick()" value="登录">
                        <button class="layui-btn layui-btn-primary" @click="clearClick()">重置</button>
                        <router-link to="/Register" class="layui-btn layui-btn-normal">注册</router-link>
                        <router-link to="/DriverLogin" class="layui-btn layui-btn-normal">司机登录</router-link>
                        <router-link to="/HotelLogin" class="layui-btn layui-btn-normal">酒店登录</router-link>
                    </div>
                </div>
            </div>
        </div>
        <el-dialog title="忘记密码" :visible.sync="forget.dialog" class="forgetDialog" :modal-append-to-body='false'>
            <label>邮箱</label><input type="text" class="layui-input" v-model.lazy="email" autocomplete="off">
            <label>新密码</label><input type="text" class="layui-input" v-model.lazy="forget.newPassword" autocomplete="off">
            <label>确认密码</label><input type="text" class="layui-input" v-model="forget.newConfirm" autocomplete="off">
            <EmailCode :email="email" :sendURL="this.$url.sendCode" @getEmailCode="passwordCode" @getCodeInput="getChildCode"></EmailCode>
            <div slot="footer" class="dialog-footer">
                <el-button @click="forget.dialog = false">取 消</el-button>
                <el-button type="primary" @click="forgetClick">确认修改</el-button>
            </div>
        </el-dialog>
        <Popup ref="popup1" set-color="#FF832A"></Popup>
    </div>
</template>

<script>
    import Swiper from "components/Swiper";
    import Popup from "components/Popup";
    import EmailCode from "../components/EmailCode";
    /*
        import SETUSER from "../store/mutations-types"
        import SETMEETINGS from "../store/mutations-types"*/
    export default {
        name: "login",
        components:{
            EmailCode,
            Popup,
            Swiper
        },data(){
            return {
                email:"",
                password:"",
                right:true,
                warming:"账号或密码错误，请重新输入",
                tipsShow:false,
                forget:{
                    dialog:false,
                    newPassword:"",
                    newConfirm:"",
                    emailCode:"",
                    codeInput:""
                }
            }
        },
        methods:{
            forgetClick(){
                let reg=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z\\W]{6,18}$/;
                if(!reg.test(this.forget.newPassword)){this.$message("新密码格式不正确(6-18位字母数字或特殊符号)");return;}
                if(this.forget.newPassword!==this.forget.newConfirm){this.$message("两次输入不同");return;}
                let codeRight;
                if(this.forget.codeInput!==""){
                    codeRight=this.forget.codeInput.toLowerCase()===this.$decrypt(this.forget.emailCode).toLowerCase();}
                else {this.$message("请输入验证码");return;}
                if(!codeRight){this.$message("验证码错误");return;}
                /*this.$http("mainServlet?ac=need&apiName=returnSuccess"*/
                this.$request(this.$url.forgetPassword,{
                    params:{
                        email:this.email,
                        newPassword: this.forget.newPassword
                    }
                }).then(res => {
                    if(res.data==="success"){
                        this.$message("修改成功");
                        this.forget.dialog=false;
                    }
                    else if(res.data==="fail"){this.$message("修改失败，请检查是否填入不支持的信息");}
                    else this.$message("发生错误");
                }).catch(err => {
                    console.log(err);
                    this.$message("网络请求失败");
                });
            },
            loginClick(){
                if(!this.email){
                    this.$refs.popup1.showMsg("请输入账号");
                    return;
                }
                if(!this.password){
                    this.$refs.popup1.showMsg("请输入密码");
                    return;
                }
                if(this.password==="123456"&&this.email==="dsa"){//测试
                    this.$store.commit("setUser",{name:"测试",
                        username:"cece",
                        sex:"male",
                        birth:"2000/03/04",
                        email:"1795490987@qq.com",
                        imgPath:"img/head.jpg",
                        phone:"123",
                        id:2});
                    this.$store.commit("setIdentity","common");
                    this.$router.push("/index");
                    return;
                }
                this.$request(this.$url.login,{
                    params:{
                        email:this.email,
                        password:this.password
                    }
                }).then(res => {
                    console.log(res.data);
                    if(res.data.toString()==="password error")this.right=false;
                    else if(res.data.toString()==="error"){this.$refs.popup1.showMsg("发生错误");}
                    else{
                        //console.log(res.data);
                        let loginJSON =res.data;//JSON.parse(res.data);//eval('(' +res.data+')'); //
                        //console.log(loginJSON.user);
                        //console.log(loginJSON.meetings);
                        this.$store.commit("setUser",loginJSON.user);
                        this.$store.commit("setIdentity","common");
                        if(loginJSON.meetings)
                            this.$store.commit("setMeetings",loginJSON.meetings);
                        //this.$store.state.user=loginJSON.user; 不建议使用
                        //  vuex中的数据发生改变时触发localStorage的存储操作
                        localStorage.setItem('state', JSON.stringify(this.$store.state));
                        //登录状态改为true

                        this.$router.push({
                            path:"/index",
                            query:{
                                /*meetings:loginJSON.meetings*/
                            }
                        });
                    }
                }).catch( err =>{
                    this.right=false;
                    this.warming="网络请求异常";
                    this.$message("网络请求出现错误");
                    console.log(err);
                });
            },
            clearClick(){
                this.email="";
                this.password="";
            }
            ,//获取邮箱验证码时调用
            passwordCode(emailCode){
                this.forget.emailCode=emailCode;
                //console.log(this.emailCode);
            },
            //子组件的input值获取
            getChildCode(codeInput){
                this.forget.codeInput=codeInput;
            }
        },
        created() {
            this.email=this.$route.query.email;
        }
    }
</script>

<style scoped>
    .warming{
        font-size: 20px;
        color:orangered;
        margin:auto ;
        text-align: center;
    }
    .displayNone{
        display: none;
    }
    .displayBlock{
        display: block !important;
    }
    .container{
        margin: 0;
        width: 100%;
        opacity: 80%;
    }
    .center{
        margin-top: 20px;
        padding: 25px 25px 25px 0;
    }
    .loginTitle{
        font-size:50px ;
        text-align: center;
    }
    .forget{
        color:darkgray;
        font-size: 20px;
        float: right;
    }
    .setFixed{
        margin-top: 20px;
        width: 150px;
        padding: 10px;
    }
    .setFixed>img{
         height: 100px;

     }
    .leftCard{
        padding: 20px;
        font-size: 17px;
        font-family: '楷体';
        color: #7ac6b8;

        border-radius: 6px;
        margin: 20px;
    }
    .forgetDialog{
        padding: 20px;
    }
    .forgetDialog>label{
        float: left;
        width: 100px;
        margin-top: 10px;
        margin-bottom: 10px;
        display: block;
    }
    .menuButton{
        display: none;
        margin-left: 9%;
    }
    @media screen and (max-width: 1200px) {
        .leftCard{
            display: none;
        }
        .swipe{
            font-size: 30px;
        }
        .menuButton{
            display: block;
        }
    }
</style>