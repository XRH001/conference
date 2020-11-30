layui.use('form', function(){
    var form = layui.form;
    form.on('submit(formDemo)', function(data){
        return false;
    });
});
const app=new Vue({
    el:'#navBar',
    data:{
        notLogin:'<a href="../../pages/login/login.html">登录</a>'
        ,haveLogin:'<a href=""><img src="../../img/defaultHead.png" class="layui-nav-img">我</a>\n' +
            '        <dl class="layui-nav-child">\n' +
            '            <dd><a href="javascript:;">个人信息</a></dd>\n' +
            '            <dd><a href="javascript:;">我的消息</a></dd>\n' +
            '            <dd><a href="javascript:;">退出登陆</a></dd>\n' +
            '        </dl>'

    }
});