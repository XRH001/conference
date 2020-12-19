<template>
    <div class="center layui-bg-blue ">
        <p class="iconfont icon-car loginTitle">司机登录</p>
        <a href="" class="layui-icon layui-icon-layer forget">忘记密码？</a>
        <br><br><br>
        <div class="layui-form ">
            <div class="layui-form-item">
                <label class="layui-form-label ">邮箱/账号</label>
                <div class="layui-input-block ">
                    <input type="text" name="email" required v-model.lazy="email"  lay-verify="required" placeholder="请输入邮箱或账号"  class="layui-input">
                </div>
            </div><br><br>
            <div class="layui-form-item">
                <label class="layui-form-label ">密码</label>
                <div class="layui-input-block ">
                    <input type="text" name="password" required v-model.lazy="password" lay-verify="required" placeholder="请输入密码"  class="layui-input">
                </div>
            </div><br>
            <p class="warming" :class="{'displayNone':right}">{{warming}}</p>
            <br><br>
            <div class="layui-form-item">
                <div class="layui-input-block layui-col-space30">
                    <input type="button" class="layui-btn layui-btn-checked"  @click="loginClick()" value="登录">
                    <button class="layui-btn layui-btn-primary" @click="clearClick()">重置</button>
                    <router-link to="" class="layui-btn layui-btn-checked">应聘</router-link>
                    <router-link to="/login" class="layui-btn layui-btn-primary">返回</router-link>

                </div>
            </div>
        </div>
        <Popup ref="popup1"></Popup>
    </div>

</template>

<script>
    import Popup from "components/Popup";
    export default {
        name: "DriverLogin",
            components:{
                Popup
            },data(){
                return {
                    email:"",
                    password:"",
                    right:true,
                    warming:"账号或密码错误，请重新输入",
                    tipsShow:false
                }
            },
            methods:{
                loginClick(){
                    if(!this.email){
                        this.$refs.popup1.showMsg("请输入账号");
                        return;
                    }
                    if(!this.password){
                        this.$refs.popup1.showMsg("请输入密码");
                        return;
                    }
                    if(this.email==="dsa"&&this.password==="123456"){//测试
                        this.$store.commit("setIdentity","driver");
                        console.log(this.$store.state.identity);
                        this.$store.commit("setDriver",{name:"可以啦",email:this.email});
                        this.$store.commit("setLogin");
                        this.$router.push("/index");
                        return;
                    }
                    this.$request(this.$url.login,{
                        params:{
                            email:this.email,
                            password:this.password
                        }
                    }).then(res => {
                        if(res.data.toString()==="password error")this.right=false;
                        else if(res.data.toString()==="error"){this.$refs.popup1.showMsg("发生错误");}
                        else{
                            //console.log(res.data);
                            let loginJSON =res.data;//JSON.parse(res.data);//eval('(' +res.data+')'); //
                            if(loginJSON.driver){
                                this.$store.commit("setDriver",loginJSON.driver);
                            }else {
                                this.$refs.popup1.showMsg("获取异常");return;
                            }
                            this.$store.commit("setIdentity","driver");
                            this.$store.commit("setLogin");

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
                        console.log(err);
                    });
                },
                clearClick(){
                    this.email="";
                    this.password="";
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
    .loginTitle{
        font-size:50px ;
        text-align: center;
    }
    .forget{
        color: #97d88b;
        font-size: 20px;
        float: right;
    }
    .center{
        width: 40%;
        margin:80px auto;
        padding: 25px 25px 25px 0;
        /*border: 2px solid #2f4056;*/
    }
</style>