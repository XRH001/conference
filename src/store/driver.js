export const driver={
    state:{
        driver:{

        },
        meetings:{
            accepted:[
                {
                    id:12,
                    name:"待接送1",
                    address:"会议地点",
                    beginTime:"会议开始时间",
                    journey:{
                        origin:"始发地",
                        target:"终点",
                        time:"出发时间"
                    },
                    passenger:[//乘客：参会人员的接送需求
                        {username:"参会人员信息",userId:321,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:331,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:3321,contact:"参会人员联系方式"},
                    ],

                },
                {
                    id:122,
                    name:"待接送2",
                    address:"会议地点",
                    beginTime:"会议开始时间",
                    journey:{
                        origin:"始发地",
                        target:"终点",
                        time:"出发时间"
                    },
                    passenger:[//乘客：参会人员的接送需求
                        {username:"参会人员信息",userId:321,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:331,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:3321,contact:"参会人员联系方式"},
                    ],

                },
                {
                    id:132,
                    name:"待接送3",
                    address:"会议地点",
                    beginTime:"会议开始时间",
                    journey:{
                        origin:"始发地",
                        target:"终点",
                        time:"出发时间"
                    },
                    passenger:[//乘客：参会人员的接送需求
                        {username:"参会人员信息",userId:321,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:331,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:3321,contact:"参会人员联系方式"},
                    ],

                },
                ],
            already:[
                {
                    id:1223,
                    name:"会议测试",
                    address:"会议地点",
                    beginTime:"会议开始时间",
                    journey:{
                        origin:"始发地",
                        target:"终点",
                        time:"出发时间"
                    },
                    passenger:[//乘客：参会人员的接送需求
                        {username:"参会人员信息",userId:321,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:331,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:3321,contact:"参会人员联系方式"},
                    ],

                },
                {
                    id:15122,
                    name:"已接送1",
                    address:"会议地点",
                    beginTime:"会议开始时间",
                    journey:{
                        origin:"始发地",
                        target:"终点",
                        time:"出发时间"
                    },
                    passenger:[//乘客：参会人员的接送需求
                        {username:"参会人员信息",userId:321,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:331,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:3321,contact:"参会人员联系方式"},
                    ],

                },
                {
                    id:13622,
                    name:"会议测试",
                    address:"会议地点",
                    beginTime:"会议开始时间",
                    journey:{
                        origin:"始发地",
                        target:"终点",
                        time:"出发时间"
                    },
                    passenger:[//乘客：参会人员的接送需求
                        {username:"参会人员信息",userId:321,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:331,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:3321,contact:"参会人员联系方式"},
                    ],

                },
            ],
            need:[{
                id:1862,
                name:"预约2",
                address:"会议地点",
                beginTime:"会议开始时间",
                journey:{
                    origin:"始发地",
                    target:"终点",
                    time:"出发时间"
                },
                passenger:[//乘客：参会人员的接送需求
                    {username:"参会人员信息",userId:321,contact:"参会人员联系方式"},
                    {username:"参会人员信息",userId:331,contact:"参会人员联系方式"},
                    {username:"参会人员信息",userId:3321,contact:"参会人员联系方式"},
                ],

            },
                {
                    id:19622,
                    name:"预约2",
                    address:"会议地点",
                    beginTime:"会议开始时间",
                    journey:{
                        origin:"始发地",
                        target:"终点",
                        time:"出发时间"
                    },
                    passenger:[//乘客：参会人员的接送需求
                        {username:"参会人员信息",userId:321,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:331,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:3321,contact:"参会人员联系方式"},
                    ],

                },
                {
                    id:126732,
                    name:"会议测试",
                    address:"会议地点",
                    beginTime:"会议开始时间",
                    journey:{
                        origin:"始发地",
                        target:"终点",
                        time:"出发时间"
                    },
                    passenger:[//乘客：参会人员的接送需求
                        {username:"参会人员信息",userId:321,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:331,contact:"参会人员联系方式"},
                        {username:"参会人员信息",userId:3321,contact:"参会人员联系方式"},
                    ],

                },]
        }

    },
    mutations:{
        setDriver(state,driver){
            state.driver=driver;
        },
        setMeetings(state,meetings){
            state.meetings=meetings
        },
        driverAccept(state,order){
            for(let pick in state.meetings.need){
                if(state.meetings.need[pick].id===order.id) {
                    state.meetings.need.splice(pick, 1);
                    break;
                }
            }
            state.meetings.accepted.push(order);
        },
        driverFinish(state,order){
            for(let pick in state.meetings.accepted){
                if(state.meetings.accepted[pick].id===order.id) {
                    state.meetings.accepted.splice(pick, 1);
                    break;
                }
            }
            state.meetings.already.push(order);
        },
        driverReject(state,meetingId){
            for(let pick in state.meetings.need){
                if(state.meetings.need[pick].id===meetingId) {
                    state.meetings.need.splice(pick, 1);
                    break;
                }
            }
        }
    },
    actions:{},
    getters:{}
};