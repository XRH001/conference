<template>
    <div><div class="personalContainer">
        <table class="layui-table">
            <colgroup>
                <col width="20%">
                <col width="80%">
            </colgroup>
            <tbody>
                <tr>
                    <td colspan="2"><div class="headDiv"><img class="headImg" :src="$store.getters.headPath" @error="notFindImg()"></div>
                        <button class="floatRight layui-btn layui-btn-normal" @click="alterNone=!alterNone">修改/完善信息</button>
                        <button class="floatRight layui-btn layui-btn-checked" @click="passwordChangeNone=false">修改密码</button>
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
                    <td>用户类别</td><td>{{identity}}</td>
                </tr>
                <tr>
                    <td>真实姓名</td><td>{{$store.state.user.name}}</td>
                </tr>
                <tr>
                    <td colspan="2"><div class="headDiv"><button @click="exitCount" class="layui-btn layui-btn-danger">退出登录</button></div></td>
                </tr>
            </tbody>
        </table>
        <table class="alterTable layui-table" :class="{'displayNone':alterNone}">
            <colgroup>
                <col width="30%">
                <col width="70%">
            </colgroup>
            <tbody>
                <tr><td colspan="2"><div class="headDiv"><img class="headImg" :src="$store.getters.headPath" @error="notFindImg()">
                    点击修改头像</div>
                    </td></tr>
                <tr><td>用户名</td><td><input class="layui-input" placeholder="请输入20位字符以下任意字符，不可为空"></td></tr>
                <tr><td>手机号</td><td><input class="layui-input" placeholder="手机号将影响您的会议通信，请认真填写"></td></tr>
                <tr><td>真实姓名</td><td><input class="layui-input" placeholder=""></td></tr>
                <tr><td colspan="2"><div class="buttonDiv">
                    <button  class="layui-btn layui-btn-checked">确认修改</button>
                    <button @click="alterNone=true" class="layui-btn layui-btn-primary ">取消修改</button>
                    </div></td>
                </tr>
            </tbody>
        </table>
        <table class="alterTable layui-table" :class="{'displayNone':passwordChangeNone}">
            <colgroup>
                <col width="30%">
                <col width="70%">
            </colgroup>
            <tbody>
            <tr><td>原密码</td><td><input class="layui-input" placeholder="找回密码的位置在登录界面"></td></tr>
            <tr><td>新密码</td><td><input class="layui-input" placeholder="找回密码的位置在登录界面"></td></tr>
            <tr><td>确认新密码</td><td><input class="layui-input" placeholder="找回密码的位置在登录界面"></td></tr>
            <tr><td colspan="2"><div class="buttonDiv">
                <button  class="layui-btn layui-btn-checked">确认修改</button>
                <button class="layui-btn layui-btn-primary" @click="passwordChangeNone=true">取消</button>
            </div>
            </td></tr>
            </tbody>
        </table>
    </div>
        <div class="cover" :class="{'displayNone':alterNone&&passwordChangeNone}"></div></div>
</template>

<script>
    export default {
        name: "personalInfo",
        data(){
            return{
                alterNone:true,
                passwordChangeNone:true
            }
        },
        computed:{
            sex(){
                return this.$store.state.user.sex==="male"?"男":"女";
            },
            identity(){
                let identity=this.$store.state.user.identity.toLowerCase();
                if(identity==="driver")return "司机/车队";
                else if(identity==="hotel")return "酒店/旅馆"
                else return "一般用户";
            }
        },
        methods:{
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
            }
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
</style>