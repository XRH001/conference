import axios from 'axios'
export function request() {
    const instance=axios.create({
        baseURL:"http://localhost:8080/mine/",
        timeout:7000
    })
}