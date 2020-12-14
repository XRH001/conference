<template>
    <div class="">
        <Swiper>
                <div slot="t1" class="swipe layui-icon layui-icon-templeate-1 ">欢迎注册易渠会议</div>
                <div slot="t2" class="swipe layui-icon layui-icon-tabs">注册后即可创建会议</div>
                <div slot="t3" class="swipe layui-icon layui-icon-app">会议后勤功能完善</div>
                <div slot="t4" class="swipe layui-icon layui-icon-slider">操作简单快捷</div>
        </Swiper>
        <div class="layui-container layui-row">
            <div class="layui-col-lg-offset2  layui-col-lg8">
                <div >
                    <div class="layui-form-item">
                        <label class="layui-form-label" for="name">用户名</label>
                        <div class="layui-input-block">
                            <input type="text" v-model.lazy="sendData.username" id="name" @blur="nameCheck" required  lay-verify="required" placeholder="请输入少于20位的任意字符(必填)" autocomplete="off" class="layui-input">
                            <span :class="{'displayNone':nameWarming}" class="warming">超出长度限制</span>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" for="password">密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="password" v-model.lazy="sendData.password" @blur="passwordCheck" required lay-verify="required" placeholder="请输入6~18位密码(必填)" autocomplete="off" class="layui-input">
                            <span :class="{'displayNone':passwordWarming}" class="warming">密码不符合规范</span>
                        </div>
                        <!--                <div class="layui-form-mid layui-word-aux">辅助文字</div>-->
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" for="password2">确认密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="password2" v-model.lazy="password2" @blur="password2Check" required lay-verify="required" placeholder="请再次确认密码(必填)" autocomplete="off" class="layui-input">
                            <span :class="{'displayNone':password2Warming}" class="warming">两次输入不同</span>
                        </div>
                        <!--                <div class="layui-form-mid layui-word-aux">辅助文字</div>-->
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" for="birthday">生日</label>
                        <div class="layui-input-block">
                            <input type="date" class="layui-input" v-model="birthday" id="birthday">
                        </div>

                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block sexSelect">
                            <input  class="radioSex" type="radio" v-model="sendData.sex" value="male"  checked><span class="layui-icon layui-icon-male">男</span>
                            <input class="radioSex" type="radio" v-model="sendData.sex" value="female"  ><span class="layui-icon layui-icon-female">女</span>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">账户类别</label>
                        <div class="layui-input-block sexSelect">
                            <input  class="radioSex" type="radio" v-model="sendData.identity" value="common"  checked>
                            <span class="layui-icon layui-icon-user">一般账户</span>
                            <input class="radioSex" type="radio" v-model="sendData.identity" value="driver"  >
                            <span class="iconfont icon-car">司机</span>
                            <input class="radioSex" type="radio" v-model="sendData.identity" value="hotel"  >
                            <span class="iconfont icon-Hotel">酒店</span>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">邮箱</label>
                        <div class="layui-input-block">
                            <input type="text" id="email" v-model.lazy="sendData.email" class="layui-input" required placeholder="请输入正确邮箱账号(必填)">
                        </div>
                    </div>
                    <EmailCode :email="sendData.email"  @getEmailCode="passwordCode" @getCodeInput="getChildCode"></EmailCode>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">头像</label>
                        <div class="layui-input-block layui-upload">
                            <button class="layui-btn" @click="fileClick" id="headImg">
                                <input type="file" id="headFileInput" @change="headFileChange(this)" class="displayNone">
                                <i class="layui-icon">&#xe67c;</i>上传图片
                            </button>
                            <div class="layui-upload-list">
                                <img class="layui-upload-img" id="preview" :src="headSrc">
<!--                                <img class="layui-upload-img"  src="../assets/defaultHead.png" :src="headSrc">-->
<!--                                <p id="demoText">{{headSrc}}</p>-->
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item layui-row layui-col-space10">
                        <div class="layui-input-block ">
                            <button class="layui-btn" @click="registerSend()"><i class="layui-icon layui-icon-friends"></i>立即注册</button>
                            <button @click="resetAll()" class="layui-btn layui-btn-primary"><i class="layui-icon layui-icon-close-fill"></i>重置</button>
                            <router-link class="layui-btn" to="/login"><i class="layui-icon layui-icon-user"></i>立即登录</router-link>
                        </div>
                    </div>
                    <div><p class="bottomMsg">请填写完整信息，头像可不上传。</p></div>
                </div>
            </div>
            <div class="layui-col-lg2 layui-col-md2 setFloat">
                <p>扫码使用小程序</p>
                <img  src="../assets/miniapp.png">
            </div>

            <br><br>
        </div>
        <br><Popup ref="popup1" set-color="#FFBF1E"></Popup>
    </div>
</template>

<script>
    import Swiper from "components/Swiper";
    import EmailCode from "components/EmailCode";
    import Popup from "../components/Popup";
    import ('assets/css/fonts.css');
    export default {
        name: "Register",
        data(){
            return {
                emailCode:"",
                codeInput:"",
                headSrc:require("../assets/defaultHead.png"),
                password2:'',
                birthday:"",
                sendData:{
                    username:'',
                    password:'',
                    email:'',
                    sex:'male',
                    identity:'common',
                    birth:""
                },
                nameWarming:true,
                passwordWarming:true,
                password2Warming:true,
                codeWarming:true
            }
        },
        methods:{
            //获取邮箱验证码时调用
            passwordCode(emailCode){
                this.emailCode=emailCode;
                console.log(this.emailCode);
            },
            //子组件的input值获取
            getChildCode(codeInput){
                this.codeInput=codeInput;
            },
            nameCheck(){
                this.nameWarming = this.sendData.username.length <= 25;
                return this.nameWarming;
            },
            passwordCheck(){
                let reg_password=/^\w{6,18}$/;
                this.passwordWarming = reg_password.test(this.sendData.password);
                return this.passwordWarming
            },
            password2Check(){
              this.password2Warming=this.sendData.password===this.password2;
              return this.password2Warming
            },
            registerSend(){
                console.log(this.codeInput);


                this.codeWarming=this.codeInput.toLowerCase()===this.$decrypt(this.emailCode).toLowerCase();
                console.log(this.$decrypt(this.emailCode));
                //解决日期format问题
                this.sendData.birth=this.birthday.replaceAll('-','/');
                console.log(this.sendData.birth);
                if(this.codeWarming)
                    if(this.nameCheck() && this.passwordCheck() && this.password2Check() && this.sendData.birth!==''){
                        //提交表单
                        this.$request("/register",{
                            params:
                                this.sendData

                        }).then( res => {
                            if(res.data==="success"){
                            alert("注册成功，请登录");
                            this.$router.push({
                                path:"/login",
                                query:{
                                    email:this.sendData.email
                                }});}
                            else this.$refs.popup1.showMsg("注册失败,请重试.");
                        }).catch(() => {
                            this.$refs.popup1.showMsg("发生错误");
                            }
                        );
                    }
                else this.$refs.popup1.showMsg("请检查是否填写生日项或者有错误的输入");
                else this.$refs.popup1.showMsg("验证码错误");
            },
            resetAll(){
                this.sendData={
                    username:'',
                        password:'',
                        password2:'',
                        email:'',
                        sex:'male',
                        birth:""
                };
                this.codeInput='';
                this.headSrc=require("../assets/defaultHead.png");
            },
            fileClick(){
                document.getElementById("headFileInput").click();
            },
            headFileChange(){
                let file=document.getElementById("headFileInput").files[0];
                if(!/image\/\w+/.test(file.type)){
                    alert("请确保文件为图像类型");
                    return;
                }

                this.headSrc=URL.createObjectURL(file);//获取图片URL
            }
        },
        components: {Popup, EmailCode, Swiper}
    }
</script>

<style scoped>
    .bottomMsg{
        text-align: center;
        font-size: 20px;
        color: gray;
    }
    .displayNone{
        display: none;
    }
    .warming{
        color: red;
        float: left;
        font-size: 12px;
    }
    .swipe{
        font-size: 50px;
        color: #2E2D3C;
        margin: auto;
        text-align: center;
        font-family: '楷体';
    }
    .layui-container{
        margin-top: 20px;
        border:2px solid #4E5465;
        padding-top: 30px;
        margin-bottom: 30px;
        border-radius: 5px;
    }
    .layui-upload-list{
        width: 100px;
        height: 100px;
        border: 1px solid #2E2D3C;
    }
    .layui-upload-list>img{
        width: 100px;
        height: 100px;
    }
    .setFloat{
        position: relative;
        top:400px;
        margin-bottom: 20px;
    }
    .setFloat>img{
        width: 100px;

    }
    .radioSex{
        display: inline !important;
        border:2px solid orangered;
        width: 20px;
        height: 20px;
        margin-left: 15px;
        margin-top:10px;
        /*//padding-top: 10px;*/
    }
    .sexSelect{
        color: #1e9fff;
    }
    @media screen and (max-width: 700px) {
        .swipe{
            font-size: 25px;
        }
    }
</style>