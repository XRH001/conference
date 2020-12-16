<template>
    <div class="firstBack">
        <div class="backgroundImg">
            <img :style="marginTop" src="../assets/book1.png">

        </div>
        <div class="atCenter">
            <div class="managerButtonBox">
                <a href="javascript:void(0)">
                    <span class="iconfont icon-table  buttonBack back1"> </span>
                    <div class="sixBorder">界面简洁</div></a>
            </div>
            <div class="managerButtonBox">
                <a href="javascript:void(0)">
                    <span class="iconfont icon-ziyuan173  buttonBack back2"> </span>
                    <div class="sixBorder">功能齐全</div></a>
            </div>
            <div class="managerButtonBox">
                <a href="javascript:void(0)">
                    <span class="iconfont icon-car carIcon buttonBack back3"> </span>
                    <div class="sixBorder">平台司机</div></a>
            </div>
            <div class="managerButtonBox">
                <a href="javascript:void(0)">
                    <span class="iconfont icon-hotel  buttonBack back4"> </span>
                    <div class="sixBorder ">预约酒店</div></a>
            </div>
        </div>
        <div><img class="fullImg" src="../assets/book2.jpg"></div>
        <button class="centerButton" @click="toRegister">立即体验</button>
        <router-link to="/login" class="centerP">浑元形意 会务管理</router-link>
    </div>
</template>

<script>
    //初始界面，未登录时的宣传界面，要做的花里胡哨
    export default {
        name: "First",
        data(){
            return{
                topSet:-1000
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
                if(this.topSet<-1000)add=-0.1;
                if(this.topSet>0)add=0.1;
                this.topSet-=add;
                },20)
        }
    }
</script>

<style scoped>

    .backgroundImg{height: 300px;overflow: hidden;background-color:white}
    .backgroundImg>img{

        width: 100%;
        opacity: 80%;
    }
    .atCenter{
        width: 100%;
        margin: auto;
        height: 300px;

        padding: 20px 20px 20px 40px;
        background:linear-gradient(to bottom, white,#7B7B7B);
    }
    .firstBack{
        background-color: #2f4056;
    }
    .managerButtonBox{
        width: 21%;
        margin: 2%;
        color: #1e9fff;

    }
    .back1{color: #249312 !important;}
    .back2{color: #2E2D3C !important;}
    .back3{color: #01aaed !important;}
    .back4{color: #ff7f05 !important;}
    .buttonBack:hover{color: #e7daff !important;}
    .sixBorder{
        font-size: 25px;
        color: #4588b8;
        left: 40px;
        background-color: #f9fdff;
        width: 120px;
        border-radius: 5px;
        opacity: 60%;
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
        opacity: 60%;
    }
    .centerButton:hover{
        background:linear-gradient(to bottom, #56bbd3, #e4faff);
    }
    .centerP{
        position: fixed;
        top:38%;
        left: 27%;
        text-align: center;
        font-size: 80px;
        color: #1f0058;
        font-family: 华文行楷;
        background-color: white;
        opacity: 60%;
        border-radius: 20px;
    }
    .fullImg{
        width: 100%;
    }
</style>