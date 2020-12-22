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
        //console.log(sendValue);
        if(new Date(sendValue.beginTime).getTime()-new Date(sendValue.endTime).getTime()>0 ||
            new Date(sendValue.beginTime).getTime()-new Date().getTime()<0
        ){
            this.$message("开始时间需大于现在，且小于结束时间");return;
        }
        if(sendValue.name===""){this.$message("会议名称不可为空");return;}
        this.flag.changeBaseDisabled=true;
        this.$request(this.$url.changeBaseInfo,{
            params:sendValue
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
        console.log(this.meetingInfo.id);
        console.log(searchMemberInput);
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
        /*this.$http("mainServlet?ac=need&apiName=returnSuccess"*/
        this.$request(this.$url.inviteMember,{
            params:{
                memberId,
                meetingId:this.meetingInfo.id
            }
        }).then( res =>{
            if(res.data==="fail"){this.$message("邀请失败");}
            else if(res.data==="success"){
                this.$message("邀请新消息已发出");
                //添加到成员信息里
                let invite = this.getByKey(this.searchMember,'id',memberId);
                invite['invitationStatus']="邀请中";
                this.memberInfo.push(invite);
                this.removeByKey(this.searchMember,'id',memberId)
            }
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
        /*this.$http("mainServlet?ac=need&apiName=returnSuccess"*/
        this.$request(this.$url.inviteManager,{
            params:{
                memberId,
                meetingId:this.meetingInfo.id
            }
        }).then( res =>{
            console.log(res.data);
            if(res.data==="fail"){this.$message("邀请失败，该用户可能已是管理员");}
            else if(res.data==="success"){
                this.$message("邀请新消息已发出");
                let invite = this.getByKey(this.searchManager,'id',memberId);
                invite['invitationStatus']="邀请中";
                this.managerInfo.push(invite);
                this.removeByKey(this.searchManager,'id',memberId)
            }
            else this.$message("服务器异常");
            this.flag.inviteManager=false;
        }).catch(err =>{
            console.log(err);
            this.$message("网络请求异常");
            this.flag.inviteManager=false;
        });
    },
    deleteMember(memberId) {
        /*this.$http("mainServlet?ac=need&apiName=returnSuccess"*/
        this.$request(this.$url.deleteMember, {
            params: {
                meetingId: this.meetingInfo.id,
                memberId: memberId
            }
        }).then(res => {
            if (res.data === "fail") {
                this.$message("删除失败,该成员可能未加入");
                return;
            }
            if (res.data === "success"){
                this.$message("已删除");
                this.removeByKey(this.memberInfo,'id',memberId);
            }
            else this.$message("服务处理异常");
        }).catch(err => {
            console.log(err);
            this.$message("网络请求异常");
        })
    },
    removeManager(memberId){
        /*this.$http("mainServlet?ac=need&apiName=returnSuccess"*/
        this.$request(this.$url.removeManager, {
            params: {
                meetingId: this.meetingInfo.id,
                memberId: memberId
            }
        }).then(res => {
            if (res.data === "fail") {
                this.$message("解除失败,该成员可能已退出会议");
                return;
            }
            if (res.data === "success") {
                this.$message("已解除");
                let toMember = this.getByKey(this.managerInfo,'id',memberId);
                this.removeByKey(this.managerInfo,'id',memberId);
                this.memberInfo.push(toMember);
            }
            else this.$message("服务处理异常");
        }).catch(err => {
            console.log(err);
            this.$message("网络请求异常");
        })
    },
    acceptMember(memberId){
        /*this.$http("mainServlet?ac=need&apiName=returnSuccess"*/
        this.$request(this.$url.acceptMember, {
            params: {
                meetingId: this.meetingInfo.id,
                memberId: memberId
            }
        }).then(res => {
            if (res.data === "fail") {
                this.$message("添加失败");
                return;
            }
            if (res.data === "success") {
                this.$message("已同意");
                this.getByKey(this.memberInfo,'id',memberId).invitationStatus="已接受";
            }
            else this.$message("服务处理异常");
        }).catch(err => {
            console.log(err);
            this.$message("网络请求异常");
        });
    },haveReservedDriver(haveDriverList){
        this.haveDriverList=haveDriverList;
    },
    haveReservedHotel(haveHotelList){
        this.haveHotelList=haveHotelList;
    },
    getByKey(list,key,value){
        for(let obj of list){
            if(obj[key]===value)return obj;
        }
        return null;
    },
    removeByKey(list,key,value){
        for(let inx in list){
            if(list[inx][key]===value)list.splice(inx,1);
        }
    },
    printTime(){
        console.log(this.meetingInfo.beginTime)
    }
};