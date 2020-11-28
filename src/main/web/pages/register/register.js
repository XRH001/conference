layui.use('carousel', function(){
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#rotation'
        ,width: '100%' //设置容器宽度
        ,height:'100px'
        ,arrow: 'always' //始终显示箭头
        ,anim: 'default' //切换动画方式
        ,autoplay:true
    });
});



//生日选择
layui.use('laydate', function(){
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#birthday' //指定元素
    });
});

//头像上传
layui.use('upload', function(){
    var upload = layui.upload;

    //执行实例
    var uploadInst = upload.render({
        elem: '#headImg' //绑定元素
        ,url: '/upload/' //上传接口
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#preview').attr('src', result); //图片链接（base64）
            });}
        ,done: function(res){
            //上传完毕回调
        }
        ,error: function(){
            //请求异常回调
        }
    });
});

/**
 *邮箱验证码
 */
function emailCode() {
    let reg=/^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    let email=$("#email").val();
    if(!reg.test(email)){
        layui.use("layer",function (){var layer = layui.layer;layer.tips('邮箱格式错误','#email',{tips:[2,'#ff6700'],time: 3000});});
        return;
    }
    $.get(
        "/meeting/EmailServlet?action=sendEmail",
        {email:$("#email").val()},
        function () {
            layui.use("layer",function (){var layer = layui.layer;layer.msg("验证码已发送");})
            let checkButton = $("#getEmailCode");
            checkButton.attr('disabled',true);
            checkButton.css('background-color','#999999');
            $("#getCode").text('60');
            //计数器
            interval = setInterval("var getCode = $('#getCode');getCode.text(parseInt(getCode.text())-1)",1000);

            setTimeout("clearInterval(interval);$('#getCode').text('');var $getEmailCode = $('#getEmailCode');" +
                "$getEmailCode.attr('disabled',false);$getEmailCode.css('background-color','');",60000);
        }
    );
}

layui.use("layer",function (){
    var layer = layui.layer;
    //用户名检验

    function nameCheck() {
        var nameFlag;
        var name=$("#name").val();
        if(name.length>=25){
            layer.tips('字符长度不符合', '#name',{tips:[1,'#ff6700'],time: 6000});
            nameFlag=false;
        }
        else nameFlag=true;
    return nameFlag;
    }
    $("#name").blur(nameCheck);
    //密码1检验

    function passwordCheck() {
        var passwordFlag;
        var password=$("#password").val();
        var reg_password=/^\w{6,18}$/;
        var flagP=reg_password.test(password);
        if(!flagP){
            layer.tips('格式不正确', '#password',{tips:[2,'#ff6700'],time: 3000});
            passwordFlag=false;
        }
        else passwordFlag=true;
        return passwordFlag;
    };
    $("#password").blur(passwordCheck);
    //密码2检验

    function password2Check() {
        var password2Flag;
        var password2=$("#password2").val();
        var password=$("#password").val();
        var flagT=password!==password2&&(password2.length>0);

        if(flagT){
            layer.tips('两密码不相同', '#password2',{tips:[2,'#ff6700'],time: 3000});
            password2Flag=false;
        }
        else {layer.tips('√', '#password2',{tips:[2,'#118b7a'],time: 1500});
            password2Flag=true;
        }
        return password2Flag;
    };
    $("#password2").blur(password2Check);


    //
    layui.use('form', function(){
        var form = layui.form;
        form.on('submit(formDemo)', function(data){
            //alert(data);
            let flag=false;
            $.ajaxSettings.async = false;
            $.get(
                "/meeting/emailServlet?action=checkCode",
                {checkCode:$("#checkCode").val()},function (res) {
                    if(res==='0')
                        layui.use('layer',function () {var layer=layui.layer;layer.msg("验证码错误");});
                    else flag=true;
                }
            );
            $.ajaxSettings.async = true;
            //layer.msg(JSON.stringify(data.field));
            flag=flag&&nameCheck()&&passwordCheck()&&password2Check();
            if(!flag) return false;
            else return true;
        });
        //监听提交
    });
});


