module.exports = {
    configureWebpack:{
        resolve:{
            alias:{
                'assets':'@/assets',
                'components':'@/components'
            }
        }
    },

    devServer: {
        proxy:{
            '/api':{
                target:"http://192.168.137.245:8080",
                changeOrigin:true,
                ws:true,
                pathRewrite:{"^/api":""}
        }},
        port: 8088
    }
};
/*
{'/test':{
    target:"http://localhost:8080/",
        changeOrigin:true,
        pathRewrite:{'/test':'/mine'}
}
}*/
