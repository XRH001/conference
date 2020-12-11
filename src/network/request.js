import axios from 'axios'
export function request(path,config) {
        const instance=axios.create({
            baseURL:"",
            timeout:7000
        });
            //这是个promise
        return instance(path,config);
}