<template>
  <div id="app">
    <div>
      <ul class="layui-nav layui-row ">
        <span>
        <li class="layui-nav-item "><router-link to="/index" :active-class="thisActive" >首页</router-link></li>
        <li class="layui-nav-item  "><router-link to="/search" :active-class="thisActive">查询{{$store.state.onTime}}</router-link></li><!--{{$store.state.user.userId}}-->
        <li class="layui-nav-item  layui-col-lg-offset7"><router-link to="/About" :active-class="thisActive">关于</router-link></li>
          </span>

        <span v-if="$store.state.haveLogin">
        <li class="layui-nav-item "><router-link to="/my-message" :active-class="thisActive">我的消息</router-link></li>
        <li class="layui-nav-item ">
          <router-link to="/personalInfo" :active-class="thisActive">
            <img :src="$store.getters.headPath" class="smallHead" ><!--$store.getters.headPath-->
            <span>{{$store.state.user.username}}</span>
          </router-link></li>
        <li class="layui-nav-item "><a @click="exitCount()">退出登录</a></li>
          </span>

        <span v-else>
          <li class="layui-nav-item "><router-link to="/login" :active-class="thisActive">登录</router-link></li>
          <li class="layui-nav-item "><router-link to="/Register" :active-class="thisActive">注册</router-link></li>
        </span>
      </ul>
    </div>

    <keep-alive exclude="detail,create,login"><router-view></router-view></keep-alive>

  </div>
</template>

<script>

export default {
  name:"App",
  data(){
    return {
      show:true,
      thisActive:'underLine'
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
    //刷新存保存数据
    saveLocal(){
      //   在页面加载时读取sessionStorage里的状态信息
      if ( sessionStorage.getItem('state') ) {
        this.$store.replaceState( Object.assign( {}, this.$store.state,
                JSON.parse(sessionStorage.getItem('state') ) ) )
      }
      /*localStorage.getItem('state') && this.$store.replaceState(JSON.parse(localStorage.getItem('state')));*/
      //   页面刷新时将state数据存储到sessionStorage中
      window.addEventListener('beforeunload',()=>{
        sessionStorage.setItem('state',JSON.stringify(this.$store.state) )
      })
    }
  },
  created() {
    //刷新页面保持登录状态
    this.saveLocal();
    this.$store.dispatch("computeTime");

  }
}
</script>
<style>
  @import "./assets/css/normalize.css";
.underLine{
  border-bottom: 5px solid orange;
}
.container{
  margin: 15px ;
  border: #999999;
  border-radius: 5px;

}
  .smallHead{
    width: 50px;
    height: 50px;
    border-radius: 50%;
  }
</style>
