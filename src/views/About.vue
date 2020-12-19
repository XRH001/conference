<template>
  <div class="about">
    <h1>自己敲的组件测试</h1>
    <h2>1、折叠</h2>
    <Collapse :rightMsg="showMsg">
      <span slot="title">这里是标题</span>
      <div slot="content"><h1>这里写内容</h1></div>
    </Collapse>
    <h2>2、弹框</h2>
    <input type="text" class="layui-input" v-model.lazy="showMsg">
    <button class="layui-btn layui-btn-normal" @click="popupTest">点击测试</button>
    <Popup ref="popup1"></Popup>

    <h1>别人的组件-测试</h1>
    <h2><el-button @click="showMessage()">这是个好按键</el-button></h2>
    <!--<img :src="this.$url.baseURL+imgPath" class="imgSwipe">-->
  </div>
</template>
<script>
  import Collapse from "components/Collapse";
  import Popup from "components/Popup";
  export default {
    name:'About',
    components: {Popup, Collapse},
    data(){
      return {
        showMsg:"这里写弹出信息",
        imgPath:'img/head1.jpg'
      }
    },
    methods:{
      popupTest(){
        this.$refs.popup1.showMsg(this.showMsg);
      },
      showMessage(){
        this.$message("能弹出来吗？");
      }
    }

  }
</script>

<style scoped>
  .about{
    width: 60%;
    margin: auto;
    padding: 20px;
  }
  .imgSwipe{
    width: 40%;
    margin: auto;
  }
</style>
