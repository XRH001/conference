<template>
    <div class="firstBack">
        <div class="backgroundImg">
            <img :style="marginTop" src="../assets/book.jpg">

        </div>
        <div class="atCenter">
            <div class="managerButtonBox">
                <a href="javascript:void(0)">
                    <span class="iconfont icon-table  buttonBack"> </span>
                    <div class="sixBorder">界面简洁</div></a>
            </div>
            <div class="managerButtonBox">
                <a href="javascript:void(0)">
                    <span class="iconfont icon-ziyuan173  buttonBack"> </span>
                    <div class="sixBorder">功能齐全</div></a>
            </div>
            <div class="managerButtonBox">
                <a href="javascript:void(0)">
                    <span class="iconfont icon-car carIcon buttonBack"> </span>
                    <div class="sixBorder">平台司机</div></a>
            </div>
            <div class="managerButtonBox">
                <a href="javascript:void(0)">
                    <span class="iconfont icon-hotel  buttonBack"> </span>
                    <div class="sixBorder ">预约酒店</div></a>
            </div>
        </div>
<!--        <div><img src="../assets/book.jpg"></div>-->
        <button class="centerButton" @click="toRegister">立即体验</button>
    </div>
</template>

<script>
    //初始界面，未登录时的宣传界面，要做的花里胡哨
    export default {
        name: "First",
        data(){
            return{
                topSet:0
            }
        },computed:{
          marginTop(){
              return "margin-top:"+this.topSet+"px;";
          }
        },methods:{
            toRegister(){
                this.$router.push("/Register");
            }
        },
        created() {
            let baseURL = this.$url.baseURL;
            this.$store.commit("setURL",baseURL);
            var add=0.1;
            setInterval(() =>{
                if(this.topSet<-350)add=-0.1;
                if(this.topSet>0)add=0.1;
                this.topSet-=add;
                },20)
        }
    }
</script>

<style scoped>

    .backgroundImg{height: 300px;overflow: hidden}
    .backgroundImg>img{

        width: 100%;
        opacity: 90%;
    }
    .atCenter{
        width: 100%;
        margin: auto;
        height: 300px;

        padding: 20px 20px 20px 40px;
        background:linear-gradient(to bottom,darkslategray,white);
    }
    .firstBack{
        background-color: #2f4056;
    }
    .managerButtonBox{
        width: 21%;
        margin: 2%;
        color: #1e9fff;

    }
    .buttonBack{color: #ffe2be !important;}
    .buttonBack:hover{color: #deffa9 !important;}
    .sixBorder{
        font-size: 25px;
        color: #4588b8;
        left: 40px;
        background-color: #f9fdff;
        width: 120px;
        border-radius: 5px;
        opacity: 80%;
    }
    .centerButton{
        width: 200px;
        height: 120px;
        border: 2px solid #2E2D3C;
        position: fixed;
        top:52%;
        left: 42%;
        border-radius: 10px;
        background-color: transparent;
        font-size: 30px;
        opacity: 80%;
    }
    .centerButton:hover{
        background:linear-gradient(to bottom, #56bbd3, #e4faff);
    }
</style>