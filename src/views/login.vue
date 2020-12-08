<template>
    <div class="container layui-row " >
        <swiper></swiper>
        <div class="layui-col-lg-offset1 layui-col-lg4 layui-col-md4 ">
            <button class="layui-btn menuButton" onclick="menuClick()"><span class="layui-icon layui-icon-spread-left"></span></button>
            <div class="layui-card leftCard layui-bg-cyan">
                <div class="cardTitle">tips</div>
                <div class="layui-card-body">
                    卡片式面板面板通常用于非白色背景色的主体内<br>
                    从而映衬出边框投影<br>
                    扫描二维码体验小程序版<br>
                    <img class="secondImg" src="../assets/miniapp.png" >
                </div>
            </div>
        </div>
        <div class="center layui-bg-cyan layui-col-lg-offset1 layui-col-md-offset1 layui-col-xs-offset1 layui-col-lg5 layui-col-md6 layui-col-xs10 ">
            <p class="layui-icon layui-icon-read loginTitle">登录</p>
            <a href="" class="layui-icon layui-icon-layer forget">忘记密码？</a>
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
                <p class="warming" :class="{'displayNone':right}">账号或密码错误，请重新输入</p>
                <br><br>
                <div class="layui-form-item">
                    <div class="layui-input-block layui-col-space30">
                        <input type="button" class="layui-btn"  @click="loginClick()" value="登录">
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        <a class="layui-btn" href="pages/register/register.html">注册</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import swiper from "../components/swiper";
    export default {
        name: "login",
        components:{
            swiper
        },data(){
            return {
                email:"",
                password:"",
                right:true
            }
        },
        methods:{
            loginClick(){
                this.$http.get("/UserServlet?action=loginFront",{
                    params:{
                        email:this.email,
                        password:this.password
                    }
                }).then(res => {
                    if(res.data.toString()==="")this.right=false;
                    else{
                        //获取的数据是字符串，得自己转JSON
                        let loginJSON = eval('(' +res.data+')');

                        this.$store.commit("setUser",loginJSON.user);
                        this.$store.commit("setMeetings",loginJSON.meetings);
                        //this.$store.state.user=loginJSON.user; 不建议使用
                        //  vuex中的数据发生改变时触发localStorage的存储操作
                        localStorage.setItem('state', JSON.stringify(this.$store.state));
                        this.$store.state.haveLogin=true;
                        this.$router.push({
                            path:"/index",
                            query:{
                                /*meetings:loginJSON.meetings*/
                            }
                        });
                    }
                });
            }
        }
    }
</script>

<style scoped>
    .warming{
        font-size: 20px;
        color:orangered;
    }
    .displayNone{
        display: none;
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

    .leftCard{
        font-size: 25px;
        font-family: '楷体';
        color:#007DDB;
        opacity: 70%;
        border-radius: 6px;
        margin: 20px;
    }
    .secondImg{
        height: 220px;
        margin-left: 90px ;
    }
    .menuButton{
        display: none;
        margin-left: 9%;
    }
    @media screen and (max-width: 700px) {
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