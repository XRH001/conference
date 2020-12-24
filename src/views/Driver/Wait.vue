<template>
    <div class="allContainer">
        <EachJourney :meeting-journey="$store.state.driver.meetings.accepted"
                     @leftClick="finishPickUp"
                     @rightClick="cancelPickUp"
                     :action="0"></EachJourney>
    </div>
</template>

<script>
    import EachJourney from "./EachJourney";
    export default {
        name: "Wait",
        components:{
            EachJourney
        },
        methods:{
            finishPickUp(order){
                /*this.$http("mainServlet?ac=need&apiName=MsgSuccess"*/
                this.$request(this.$url.driverFinish,{
                    meetingId:order.id,
                    driverId:this.$store.state.driver.driver.id
                }).then(res =>{
                    let data = res.data;
                    if(data.msg==="success"){
                        this.$store.commit("driverFinish",order);
                        this.$message("已完成接送");
                    }
                    else this.$message("完成失败，请与会议管理员核实");
                }).catch(err =>{
                    console.log(err);
                    this.$message("网络请求失败")
                });
            },
            cancelPickUp(){
                this.$message("不支持取消功能，请自行与会议管理员联系")
            }
        }
    }
</script>

<style scoped>

</style>