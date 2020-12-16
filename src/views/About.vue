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
        showMsg:"这里写弹出信息"
      }
    },
    methods:{
      popupTest(){
        this.$refs.popup1.showMsg(this.showMsg);
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
