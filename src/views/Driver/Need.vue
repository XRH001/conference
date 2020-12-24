<template>
    <div>
        <EachJourney :meeting-journey="$store.state.driver.meetings.need"
                     :action="2"
                     @leftClick="acceptPickUp"
                     @rightClick="rejectPickUp"
        ></EachJourney>
    </div>
</template>

<script>
    import EachJourney from "./EachJourney";
    export default {
        name: "Need",
        components: {EachJourney},
        methods:{
            acceptPickUp(order){
                /*this.$http("mainServlet?ac=need&apiName=MsgSuccess"*/
                console.log(order.id);
                this.$request(this.$url.driverAccept,{
                    params:{
                    meetingId:order.id,
                    driverId:this.$store.state.driver.driver.id
                    }
                }).then(res =>{
                    let data = res.data;
                    if(data.msg==="success"){
                        this.$store.commit("driverAccept",order);
                        this.$message("已接受预约");
                    }
                    else this.$message("接受失败，对方可能已取消");
                }).catch(err =>{
                    console.log(err);
                    this.$message("网络请求失败")
                });
            },
            rejectPickUp(meetingId){
                /*this.$http("mainServlet?ac=need&apiName=MsgSuccess"*/
                this.$request(this.$url.driverReject,{
                    params: {
                        meetingId: meetingId,
                        driverId: this.$store.state.driver.driver.id
                    }
                }).then(res =>{
                    let data = res.data;
                    if(data.msg==="success"){
                        this.$store.commit("driverReject",meetingId);
                        this.$message("已拒绝");
                    }
                    else this.$message("拒绝失败，请稍后重试");
                }).catch(err =>{
                    console.log(err);
                    this.$message("网络请求失败")
                })
            }
        }
    }
</script>

<style scoped>

</style>