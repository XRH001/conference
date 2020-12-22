//模块
export const hotel={
    state:{
        hotel:{
            id:0,
            name:"我是酒店名",
            phone:"",
            address:"",
            username:"",
            email:"",
            imgPath:""
        },
        meetings:{
            accepted:[
                {   id:2,
                    name:"会议名称",
                    customer:"顾客名字/创建者",
                    contact:"联系电话",
                    rooms:[
                        {type:"单人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                        {type:"双人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                        {type:"仨人间",num:12,beginTime:"2020/12/22",endTime:"2020/13/12"},
                    ]
                },
                {   id:3,
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
                {   id:5,
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
        }
    },
    actions:{},
    getters:{}
};