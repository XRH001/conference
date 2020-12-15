<template>
  <div id="app">
    <NavBar></NavBar>
  </div>
</template>

<script>

import NavBar from "./components/NavBar";
export default {
  name:"App",
  components: {NavBar},
  data(){
    return {
      show:true
    }
  },
  methods:{
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
  .displayNone{
    display: none;
  }
  .container{
    margin: 15px ;
    border: #999999;
    border-radius: 5px;

  }
  .area{
    font-size: 16px;
    padding: 10px;
    height: 120px!important;
  }
</style>
