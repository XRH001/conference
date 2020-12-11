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
        proxy: "http://localhost:8080/mine",
        port: 8088
    } };
/*

{'/test':{
    target:"http://localhost:8080/",
        changeOrigin:true,
        pathRewrite:{'/test':'/mine'}
}
}*/
