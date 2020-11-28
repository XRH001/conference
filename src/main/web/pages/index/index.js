layui.use('element', function(){
    var element = layui.element;

    //…
});

/**
 *
 */
layui.use('laydate', function(){
    var laydate = layui.laydate;

    //执行一个laydate实例
    $('.startTime').each(function(){

        laydate.render({
            elem: this //指定元素
            ,type: 'datetime'
            ,format:'y年M月d日 HH:mm'
    });});

    $('.endTime').each(function(){

            laydate.render({
                elem: this //指定元素
                ,type: 'datetime'
                ,format:'y年M月d日 HH:mm'
            });});
});