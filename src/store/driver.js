export const driver={
    state:{
        driver:{},
        wait:[],
        already:[],
        need:[]
    },
    mutations:{
        setDriver(state,driver){
            state.driver=driver;
            console.log(state.driver);
        }
    },
    actions:{},
    getters:{}
};