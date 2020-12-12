layui.use('carousel', function(){
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#test1'
        ,width:'100%'
        ,height:'100px'
        ,arrow: 'none' //始终显示箭头
        ,anim: 'default' //切换动画方式
        ,autoplay:true

    });
});

function menuClick()
 {  let leftCard = $(".leftCard");
     if(leftCard.css('display')==='none')
    {
        leftCard.css('display','block');
    }
     else leftCard.css('display','none');
};