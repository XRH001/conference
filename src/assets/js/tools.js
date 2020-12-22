export function decrypt(code) {
    if(code){
    let str = "";
    for(let i=0;i<code.length/2;i++){
        str += String.fromCharCode(parseInt(code[i*2]+code[i*2+1], 16));
    }
    console.log(str);
    return str;
    }
    else return null;
}

//时间格式
export function format(fmt) {
    var o = {
        "M+" : this.getMonth()+1, //月份
        "d+" : this.getDate(), //日
        "h+" : this.getHours()%12 === 0 ? 12 : this.getHours()%12, //小时
        "H+" : this.getHours(), //小时
        "m+" : this.getMinutes(), //分
        "s+" : this.getSeconds(), //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S" : this.getMilliseconds() //毫秒
    };
    var week = {
        "0" : "/u65e5",
        "1" : "/u4e00",
        "2" : "/u4e8c",
        "3" : "/u4e09",
        "4" : "/u56db",
        "5" : "/u4e94",
        "6" : "/u516d"
    };
    if(/(y+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    if(/(E+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);
    }
    for(var k in o){
        if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length===1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
    return fmt;
}

export function replaceAll(s1, s2) {
    return this.replace(new RegExp(s1, "gm"), s2);
}

export function notFind(url){
    let img=event.srcElement;
    //alert("根本没触发");
    //let url="http://119.3.235.179:8080/driver/picture/head1011608000531344.jpg";
    img.src=url; //替换的图片
    img.onerror=null; //控制不要一直触发错误
}

export function getByKey(list,key,value){
    for(let obj of list){
        if(obj[key]===value)return obj;
    }
    return null;
}
export function removeByKey(list,key,value){
    for(let inx in list){
        if(list[inx][key]===value)list.splice(inx,1);
    }
}
/*
export function test(add) {
console.log("导入了"+add);
}*/
