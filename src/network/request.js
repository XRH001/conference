import axios from 'axios'

export function request(url,config) {
const instance=axios.create({
    baseURL:"/api",
    timeout:5000
});
return instance(url,config);
}

export function http(url,config) {
    const instance=axios.create({
        baseURL:"/test1",
        timeout:5000
    });
    return instance(url,config);
}
export function post(url,formData,config) {
    const instance=axios.create({
        baseURL:"upload",
        timeout:5000
    });
    return instance.post(url,formData,config);
}

//配置所有地址
const url={
    baseURL:"http://localhost:8080/",
    login:"/UserJudge",
    register:"/register",
    registerCode:"/registerYz",
    sendCode:"/createMeetingYz",
    create:"/createMeeting",
    searchMeetings:"/SearchMeeting",
    detail:"/Details",
    manage:"/manage",
    driverLogin:"/driverLogin",
    hotelLogin:"/hotelLogin",
    remarks:"/remarks",//用户修改备注
    applyJoin:"/applyJoin",//非参会人员申请加入请求
    personInfo:"/personInfo",//查询用户基本信息
    changeBaseInfo:"changeBaseInfo",//修改会议基本信息
    searchMember:"/searchMember",
    searchManager:"searchManager",
    inviteMember:"/inviteMember",
    inviteManager:"/inviteManager",
    deleteMember:"/deleteMember",
    removeManager:"/removeManager",
    acceptMember:"/acceptMember",
    changePassword:"/changePassword",//修改密码
    forgetPassword:"/",
    alterInfo:"/alterInfo",//用户修改个人信息
    searchMsg:"/msg",//查找用户新消息
};
export {url}