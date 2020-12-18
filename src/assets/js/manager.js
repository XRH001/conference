export const methods={
    changeBaseInfo(){

        let sendValue={
            id:this.meetingInfo.id,
            name:this.meetingInfo.name,
            beginTime:this.meetingInfo.beginTime,
            endTime:this.meetingInfo.endTime,
            address:this.meetingInfo.address,
            remark:this.meetingInfo.remark
        };
        console.log(sendValue);
        if(new Date(sendValue.beginTime).getTime()-new Date(sendValue.endTime).getTime()>0 ||
            new Date(sendValue.beginTime).getTime()-new Date().getTime()<0
        ){
            this.$message("开始时间需大于现在，且小于结束时间");return;
        }
        if(sendValue.name===""){this.$message("会议名称不可为空");return;}
        this.flag.changeBaseDisabled=true;
        this.$request(this.$url.changeBaseInfo,{
            params:{
                meetingBase:sendValue
            }
        }).then(res => {
            let state=res.data;
            if(state==="success")this.$message("修改成功");
            else if(state==="fail")this.$message("修改失败，请检查是否存在空值");
            else this.$message("服务器错误");
            this.flag.changeBaseDisabled=false;
        }).catch(err => {
            this.$message("网络请求错误");
            console.log(err);
            this.flag.changeBaseDisabled=false;
        });

    },searchMemberClick(){
        let searchMemberInput = this.searchMemberInput;
        if(searchMemberInput===""){this.$message("搜索值不能为空");return;}
        this.$request(this.$url.searchMember,{
            params:{
                search:searchMemberInput,
                meetingId:this.meetingInfo.id
            }
        }).then( res => {
            if (res.data === "fail") {
                this.$message("搜索失败，请不要输入奇怪字符");return;
            }
            this.searchMember = res.data;
        }).catch(err =>{
            console.log(err);
            this.$message("网络请求异常");
        });
    },
    searchManagerClick(){
        let searchManagerInput = this.searchMemberInput;
        if(searchManagerInput===""){this.$message("搜索值不能为空");return;}
        this.$request(this.$url.searchManager,{
            params:{
                search:searchManagerInput,
                meetingId:this.meetingInfo.id
            }
        }).then( res =>{
            if(res.data==="fail"){this.$message("搜索失败，请不要输入奇怪字符");return;}
            this.searchManager=res.data;
        }).catch(err =>{
            console.log(err);
            this.$message("网络请求异常");
        });
    },
    inviteMember(memberId,haveJoin){
        if(haveJoin){this.$message("该用户已参加本会议，或已在邀请中，或在申请中");return;}
        this.flag.inviteMember=true;
        this.$request(this.$url.inviteMember,{
            params:{
                memberId,
                meetingId:this.meetingInfo.id
            }
        }).then( res =>{
            if(res.data==="fail"){this.$message("邀请失败");}
            else if(res.data==="success"){this.$message("邀请新消息已发出");}
            else this.$message("服务器异常");
            this.flag.inviteMember=false;
        }).catch(err =>{
            console.log(err);
            this.$message("网络请求异常");
            this.flag.inviteMember=false;
        });
    },
    inviteManager(memberId,ifManager){
        if(ifManager){this.$message("该用户已是管理员，或邀请消息已发出");return;}
        this.flag.inviteManager=true;
        this.$request(this.$url.inviteManager,{
            params:{
                memberId,
                meetingId:this.meetingInfo.id
            }
        }).then( res =>{
            if(res.data==="fail"){this.$message("邀请失败，该用户可能已是管理员");}
            else if(res.data==="success"){this.$message("邀请新消息已发出");}
            else this.$message("服务器异常");
            this.flag.inviteManager=false;
        }).catch(err =>{
            console.log(err);
            this.$message("网络请求异常");
            this.flag.inviteManager=false;
        });
    },
    deleteMember(memberId,ifManager){
        if(ifManager)this.$message(memberId.toString());
    }
};