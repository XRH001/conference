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
                target:"http://10.101.20.62:8080",
                changeOrigin:true,
                ws:true,
                pathRewrite:{"^/api":""}
            },
            '/test1':{
                target:"http://119.3.235.179:8080/apiTest/",
                changeOrigin:true,
                ws:true,
                pathRewrite:{"^/test1":""}
            },
            '/upload':{
                target:"http://119.3.235.179:8080/",
                changeOrigin:true,
                ws:true,
                pathRewrite:{"^/upLoad":""}
            }
        },
        port: 8087
    }
};
/*
{'/test':{
    target:"http://localhost:8080/",
        changeOrigin:true,
        pathRewrite:{'/test':'/mine'}
}
}*/
