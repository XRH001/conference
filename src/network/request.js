import axios from 'axios'

export function request(url,config) {
const instance=axios.create({
    baseURL:"/api",
    timeout:15000
});
return instance(url,config);
}

export function http(url,config) {
    const instance=axios.create({
        baseURL:"/test1",
        timeout:15000
    });
    return instance(url,config);
}

//配置所有地址
const url={
    baseURL:"http://localhost:8080",
    login:"/UserJudge",
    register:"/register",
    registerCode:"/registerYz",
    sendCode:"/sas",
    create:"/create",
    searchMeetings:"/SearchMeeting",
    detail:"/detail",
    manage:"/manage",
    driverLogin:"/driverLogin",
    hotelLogin:"/hotelLogin"
};
export {url}