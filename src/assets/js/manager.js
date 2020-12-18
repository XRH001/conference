export const methods={
    changeBaseInfo(){
        let sendValue={
            name:this.meetingInfo.name,
            beginTime:this.meetingInfo.beginTime,
            endTime:this.meetingInfo.endTime,
            address:this.meetingInfo.address,
            remark:this.meetingInfo.remark
        };
        if(sendValue.beginTime){
            this.$message("时间不必对");
        }
        console.log(sendValue);
    },
    showOne(){
        this.$message(this.meetingInfo.name);
    }
};