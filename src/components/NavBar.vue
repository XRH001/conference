<template>
    <div>
        <ul class="layui-nav layui-row ">
        <span>
        <li class="layui-nav-item "><router-link to="/index" :active-class="thisActive" >首页</router-link></li>
        <li class="layui-nav-item  "><router-link to="/search" :active-class="thisActive">查询{{$store.state.onTime}}</router-link></li><!--{{$store.state.user.userId}}-->
        <li class="layui-nav-item layui-col-sm-offset4 layui-col-md-offset6 layui-col-lg-offset7"><router-link to="/About" :active-class="thisActive">关于</router-link></li>
          </span>

            <span v-if="$store.state.haveLogin">
        <li class="layui-nav-item "><router-link to="/my-message" :active-class="thisActive">我的消息</router-link></li>
        <li class="layui-nav-item ">
          <router-link to="/personalInfo" :active-class="thisActive">
            <img :src="$store.getters.headPath" class="smallHead" ><!--$store.getters.headPath-->
            <span>{{$store.state.user.username}}</span>
          </router-link></li>
          </span>

            <span v-else>
          <li class="layui-nav-item "><router-link to="/login" :active-class="thisActive">登录</router-link></li>
          <li class="layui-nav-item "><router-link to="/Register" :active-class="thisActive">注册</router-link></li>
        </span>
        </ul>

        <keep-alive exclude="index,detail,create,login,Register"><router-view></router-view></keep-alive>
    </div>
</template>

<script>
    export default {
        name: "NavBar",
        data(){
            return {
                show:true,
                thisActive:'underLine'
            }
        },
        methods:{

        }
    }
</script>

<style scoped>
    .underLine{
        border-bottom: 5px solid orange;
    }

    .smallHead{
        width: 50px;
        height: 50px;
        border-radius: 50%;
    }
</style>