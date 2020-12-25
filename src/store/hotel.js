//模块
export const hotel={
    state:{
        hotel:{
            id:23,
            name:"我是酒店名",
            phone:"158354345345",
            address:"前湖迎宾馆旁边的小黑屋",
            username:"赱卅靈",
            email:"464561456@qq.com",
            imgPath:"hotel.jpg"
        },
        meetings:{
            accepted:[
                {   id:42,
                    name:"会议名称",
                    customer:"顾客名字/创建者",
                    contact:"联系电话",
                    rooms:[
                        {type:"单人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                        {type:"双人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                        {type:"仨人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                    ]
                },
                {   id:33,
                    name:"Hunyuan",
                    customer:"liYeXuan",
                    contact:"153124132131",
                    rooms:[
                        {type:"单人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                        {type:"双人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                        {type:"仨人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                    ]
                }
            ],
            reserve:[
                {   id:51,
                    name:"Hun",
                    customer:"liYan",
                    contact:"1531232131",
                    rooms:[
                        {type:"单人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                        {type:"双人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                        {type:"仨人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                    ]
                }
            ],
            completed:[
                {   id:24,
                    name:"Hun",
                    customer:"liYan",
                    contact:"1531232131",
                    rooms:[
                        {type:"单人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                        {type:"双人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                        {type:"仨人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                    ]
                }
            ]
        }
    },
    mutations:{
        setHotel(state,hotel){
            state.hotel=hotel;
        },
        setHotelMeetings(state,meetings){
            state.meetings=meetings;
        },
        hotelAccepted(state,order){
            let key="id";
            let value=order.id;
            for(let inx in state.meetings.reserve){
                if(state.meetings.reserve[inx][key]===value){
                    state.meetings.reserve.splice(inx,1);
                    break;
                }
            }
            state.meetings.accepted.push(order);
        },
        hotelReject(state,orderId){
            for(let orderInx in state.meetings.reserve){
                if(state.meetings.reserve[orderInx].id===orderId){
                    state.meetings.reserve.splice(orderInx,1);
                    return;
                }
            }

        },
        hotelFinished(state,order){
            let value=order.id;
            console.log(value);
            console.log(state.meetings.accepted[0]);
            for(let inx in state.meetings.accepted){
                if(state.meetings.accepted[inx].id===value){
                    state.meetings.accepted.splice(inx,1);
                    break;
                }
            }
            state.meetings.completed.push(order);
        }
    },
    actions:{},
    getters:{}
};