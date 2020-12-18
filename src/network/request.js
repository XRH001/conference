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

//配置所有地址
const url={
    baseURL:"http://localhost:8080",
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
    remarks:"/remarks",
    applyJoin:"/applyJoin",
    personInfo:"/personInfo"
};
export {url}