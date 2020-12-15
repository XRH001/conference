<template>
    <div class="createMeeting layui-row"><p class="titleP">创建会议</p>
        <div class="">

            <div class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">会议名</label>
                    <div class="layui-input-block">
                        <input type="text" v-model="meetingName" @blur="checkName" name="meetingName" id="meetingName" required   placeholder="请输入少于20位的任意字符(不可为空)" autocomplete="off" class="layui-input">
                        <span class="warming " :class="{'displayNone':show.name}">不符合要求</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">开始时间</label>
                    <div class="layui-input-block">
                        <input type="datetime-local" v-model="beginTime" @blur="checkTime" name="startTime" required   value="" autocomplete="off" class="layui-input">
                        <span class="warming " :class="{'displayNone':show.startTime}">请填写此栏，可点击右侧小按键快速选择</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">会议地点</label>
                    <div class="layui-input-block">
                        <textarea name="overTime" v-model="position" @blur="checkPosition" required  placeholder="长度限制100字以内"  class="layui-input area"></textarea>
                        <span class="warming " :class="{'displayNone':show.position}">不符合要求:长度限制100</span>
                    </div>
                </div>
                <EmailCode :email="$store.state.user.email" :sendURL="this.$url.sendCode" @getEmailCode="passwordCode" @getCodeInput="getChildCode"></EmailCode>
                <div class="layui-form-item layui-row layui-col-space10">
                    <div class="layui-input-block ">
                        <button class="layui-btn" @click="createClick"><i class="layui-icon layui-icon-friends"></i>立即创建</button>
                        <button  @click="resetAll()" class="layui-btn layui-btn-primary displayNone"><i class="layui-icon layui-icon-close-fill"></i>重置</button>
                        <a class="layui-btn" @click="cancelCreate"><i class="layui-icon layui-icon-user"></i>取消</a>
                    </div>
                </div>
            </div>
        </div>
        <Popup ref="popup1" ></Popup>
        <Popup ref="popup2" set-color="#red"></Popup>
    </div>
</template>

<script>
    import EmailCode from "components/EmailCode";
    import Popup from "../../components/Popup";
    export default {
        name: "create",
        data(){
            return {
                emailCode:"",
                codeInput:"",
                meetingName:"",
                beginTime:"",
                position:"",
                show:{
                    name:true,
                    startTime:true,
                    position:true
                }
            }
        },
        components: {Popup, EmailCode},
        methods:{
            //获取邮箱验证码时调用
            passwordCode(emailCode){
                this.emailCode=emailCode;
                //console.log(this.emailCode);
            },
            //子组件的input值获取
            getChildCode(codeInput){
                this.codeInput=codeInput;
            },createClick(){
                //验证码
                let codeRight;
                if(this.codeInput!==""){
                 codeRight=this.codeInput.toLowerCase()===this.$decrypt(this.emailCode).toLowerCase();}
                else this.$refs.popup1.showMsg("请输入验证码");
                if(codeRight){
                    if(this.checkName()&&this.checkTime()&&this.checkPosition()){
                        this.$http("mainServlet?ac=need&apiName=createMeetingSuccess"
                        /*this.$request(this.$url.create*/,{
                            params:{
                                email:this.$store.state.user.email,
                                name:this.meetingName,
                                beginTime: this.beginTime,
                                position:this.position,
                                userID:this.$store.state.user.ID
                            }
                        }).then(res =>{
                            console.log(res.data);
                            let resp=res.data;
                            if(resp.msg==="success"){
                                this.$refs.popup1.showMsg("创建成功，即将跳转到详情页");
                                let newMeeting={
                                    name:this.meetingName,
                                    beginTime: this.beginTime,
                                    address:this.position,
                                    id:resp.meetingID,
                                    orderStatus:"已通过审核！"
                                };
                                //在这里把创建的会议存到creator里
                                this.$store.commit("addCreateMeetings",newMeeting);
                                setTimeout(() =>{
                                    this.$router.push({path:"/Manage",query:{meetingId:resp.meetingID}})
                                },1500);
                            }else if(resp.msg==="fail"){
                                this.$refs.popup1.showMsg("创建失败，请重试")
                            }else this.$refs.popup1.showMsg("服务器出错")
                        }).catch(err => {
                            console.log(err);
                            this.$refs.popup1.showMsg("发生错误");
                        });
                    }
                }
                else this.$refs.popup1.showMsg("验证码错误");
            },
            checkName(){
                if(this.meetingName==="" || this.meetingName.length>40){
                    this.show.name=false;
                    return false;
                }
                else {
                    this.show.name=true;
                    return true;
                }
            },
            checkTime(){
                if(this.beginTime===""){
                    this.show.startTime=false;
                    return false;
                }
                else {
                    this.show.startTime=true;
                    return true;
                }
            },
            checkPosition(){
                if(this.position==="" ||this.position.length>200){
                    this.show.position=false;
                    return false;
                }
                else {
                    this.show.position=true;
                    return true;
                }
            },resetAll(){
                this.codeInput="";
                this.meetingName="";
                this.beginTime="";
                this.position="";
            },
            cancelCreate(){
                this.$router.push("/index");
            }
        }
    }
</script>

<style scoped>
    .createMeeting{
        width: 60%;
        padding: 20px;
        border: 2px solid #595B5D;
        border-radius: 6px;
        margin: 30px auto auto;
    }
    .titleP{
        font-size: 35px;
        color: #4E5465;
        text-align: center;
        margin-bottom: 25px;
    }


    @media screen and (max-width: 800px){

        .createMeeting{
            width: 94%;
            padding-left: 0;

        }
        .displayNone{
            display: none;
        }
    }
    .warming{
        color: red;
        float: left;
        font-size: 12px;
    }
</style>