import axios from 'axios'

export function request(url,config) {
const instance=axios.create({
    baseURL:"/api",
    timeout:10000
});
return instance(url,config);
}
export function post(url,obj,config) {
const instance=axios.create({
    baseURL:"/api",
    timeout:5000
    });
return instance.post(url,obj,config);
}

export function http(url,config) {
    const instance=axios.create({
        baseURL:"/test1",
        timeout:5000
    });
    return instance(url,config);
}
/*export function postImg(url,formData,config) {
    const instance=axios.create({
        baseURL:"/upload",
        timeout:5000
    });
    return instance.post(url,formData,config);
}*/

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
    personInfo:"/SearchUser",//查询用户基本信息
    changeBaseInfo:"changeBaseInfo",//修改会议基本信息
    searchMember:"/SearchJoiner",
    searchManager:"SearchManager",
    inviteMember:"/inviteNewMember",
    inviteManager:"/inviteAdmin",
    deleteMember:"/deleteMember",
    removeManager:"/removeManager",
    acceptMember:"/acceptMember",
    changePassword:"/AlterPassword",//修改密码
    forgetPassword:"/ForgetPassword",
    alterInfo:"/updatePersonInfo",//用户修改个人信息
    searchMsg:"/findUserMessage",//查找用户新消息
    acceptInvite:"/agreeConferenceInvite",//用户同意邀请
    sendDriverPage:"/loadDrivers",//加载司机页
    searchDriver:"/queryDrivers",
    searchDriverByMeetingId:"/queryDriversByConference",
    reserveDriver:"/orderDriver",//预约司机
    findDriverJourney:"/queryJourney",//查找司机行程
    sendHotelPage:"/sendHotelPage",//加载酒店页
    searchHotel:"/searchHotel",
    searchHotelByMeetingId:"/searchHotelByMeetingId",//通过会议查找已定酒店
    reserveHotel:"/reserveHotel",//预约酒店
    findHotelRoom:"/findHotelRoom",//查找已预定酒店房间
    confirmArrange:"/confirmArrange",//给成员安排行程和住宿

    hotelAcceptOrder:"/hotelAcceptOrder",//酒店接受订单

};
export {url}