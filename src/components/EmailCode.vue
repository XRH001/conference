<template>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱验证码</label>
        <div class="layui-input-inline">
            <slot name="codeInput">
                <input type="text" lay-filter="formDemo" placeholder="不区分大小写" v-model="codeInput"
                       @blur="$emit('getCodeInput',codeInput)" required  class="layui-input checkCodeInput">
            </slot>
        </div>
        <div class=" layui-input-inline"><div class="layui-icon layui-icon-refresh-1 rotateSpan" :class="{'displayNone':!disable}"></div>
            <button @click="getCode()" :disabled="disable" :class="{'bgGray':disable}" class="layui-btn layui-btn-normal getCodeButton">
                获取验证码{{secondShow}}</button>
        </div>

        <!--弹框-->
        <Popup ref="popup1" ></Popup>
    </div>
</template>

<script>
    /*import layer from 'layui-src/src/lay/modules/layer'*/
    import Popup from "./Popup";
    export default {
        name: "EmailCode",
        components: {Popup},
        data(){
            return {
                secondDec:60,
                disable:false,
                checkCode:"",
                codeInput: ""
            }
        },props:{
            email:String,
        },
        computed:{
            secondShow(){
                if(this.secondDec===60 || this.secondDec===0)return "";
                else
                    return '('+this.secondDec+')';
            }
        },
        methods:{
            getCode(){
                this.disable=true;
                this.sendEmail();
            },
            buttonSet(){
                this.secondDec=60;
                this.disable=true;
                const timeDec=setInterval(()=>{
                    // this.secondDec=parseInt(this.secondDec);
                    if(this.secondDec===0) {
                        clearInterval(timeDec);
                        this.disable=false;
                    }
                    else this.secondDec-=1;
                    // this.secondDec=this.secondDec.toString();
                },1000);
            },
            sendEmail(){
                let email = this.email;
                //console.log(email);
                let reg=/^([a-zA-Z]|[0-9])(\w)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;

                if(!reg.test(email)){
                    this.$refs.popup1.showMsg("邮箱格式错误");
                    this.disable=false;
                    //alert("邮箱格式错误");
                    return false;
                }
                this.$http.get("/EmailServlet?action=sendEmail",{
                    params:{
                        email:email
                    }
                }).then(res =>{
                    if(res.data===""){this.$refs.popup1.showMsg("-该邮箱账号不可用-");this.disable=false;}
                    else if(res.data==="already"){
                        this.$refs.popup1.showMsg("该邮箱已注册过本平台。");this.disable=false;}
                    else {
                        this.$refs.popup1.showMsg("验证码已发送");
                        let emailCode =res.data;
                        this.$emit("getEmailCode",emailCode);
                        this.buttonSet();
                    }
                }).catch(res =>{
                    alert("ERROR:"+res);
                    this.disable=false;
                });
            }
        }
    }
</script>

<style scoped>
    .displayNone{
        display: none;
    }
.bgGray{
    background-color: darkgray;
}
    .rotateSpan{
        color: #a2ff99;
        width: 16px;
        font-size: 16px;
        padding: 0;
        margin: 0;
        float: left;
        position: relative;
        left: 20px;
        top:8px;
        -webkit-transition-property: -webkit-transform;

        -webkit-transition-duration: 1s;

        -moz-transition-property: -moz-transform;

        -moz-transition-duration: 1s;

        -webkit-animation: rotate 3s linear infinite;

        -moz-animation: rotate 3s linear infinite;

        -o-animation: rotate 3s linear infinite;

        animation: rotate 3s linear infinite;

    }
@-webkit-keyframes rotate{from{-webkit-transform: rotate(0deg)}

    to{-webkit-transform: rotate(360deg)}

}

@-moz-keyframes rotate{from{-moz-transform: rotate(0deg)}

    to{-moz-transform: rotate(359deg)}

}

@-o-keyframes rotate{from{-o-transform: rotate(0deg)}

    to{-o-transform: rotate(359deg)}

}

@keyframes rotate{from{transform: rotate(0deg)}

    to{transform: rotate(359deg)}

}
</style>