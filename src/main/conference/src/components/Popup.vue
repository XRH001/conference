<template>
    <span class="popupStyle" :class="{'displayNone':ifHidden}" :style="bgColor">
        {{setText}}
    </span>
</template>

<script>
    export default {
        name: "Popup",
        data(){
            return {
                ifHidden:true,
                setText:"提示！"
            }
        },
        props:{
            setColor:{
                type:String,
                default:"#e6a300"
            },

            setTime:{
                type:Number,
                default:2500
            }
        },
        computed:{
            bgColor(){
                return "background-color:"+this.setColor;
            }
        },
        methods:{
            showMsg(msg){
                this.setText=msg;
                this.ifHidden=false;
                setTimeout(()=>{
                    this.ifHidden=true;
                },this.setTime);
            }
        }
    }
</script>

<style scoped>
    .popupStyle{
        color: #f7fcff;
        font-size: 25px;
        position: fixed;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        margin: auto;
        /*border: #8ed6d6 solid 2px;*/
        border-radius: 3px;
        opacity: 88%;

        max-width: 400px;
        height: 30px;
        max-height: 100px;
        text-align: center;
        padding: 10px;
    }
    .displayNone{
        display: none;
    }
</style>