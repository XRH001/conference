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
        proxy: "http://localhost:8088/UserServlet",
        port:8088
            }
        };