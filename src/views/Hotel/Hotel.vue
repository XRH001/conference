<template>
    <div class="hotelContainer">
        <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title layui-row">
                <li class=" layui-col-lg4"  :class="{'layui-this':layShow===0}" @click="layShow=0">预约消息</li>
                <li class="layui-col-lg4" :class="{'layui-this':layShow===1}" @click="layShow=1">已接受</li>
                <li class="layui-col-lg4" :class="{'layui-this':layShow===2}" @click="layShow=2">店家信息</li>
            </ul>
            <div class="layui-tab-content" >
                <div :class="{'layui-show':layShow===0}" class="layui-tab-item ">
                    <Reserve></Reserve>
                </div>
                <div :class="{'layui-show':layShow===1}" class="layui-tab-item ">
                    <Accept></Accept>
                </div>
                <div :class="{'layui-show':layShow===2}" class="layui-tab-item ">
                    <div class=" hotelMessage ">
                        <div class="hotelForm">
                            <div class="signUpper">在此修改您的店家信息</div><br>
                            <!--                    <hr class="layui-bg-cyan">-->
                            <form action="" method="get" class="layui-form ">
                                <div class="layui-form-item">
                                    <label class="layui-form-label ">店名</label>
                                    <div class="layui-input-block ">
                                        <input type="text" name="hotelName" required  lay-verify="required" placeholder="请输入贵店名称" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label ">地址</label>
                                    <div class="layui-input-block ">
                                        <input type="text" name="password" required  lay-verify="required" placeholder="请输入贵店地址" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label ">联系方式</label>
                                    <div class="layui-input-block ">
                                        <input type="text" name="password" required  lay-verify="required" placeholder="请输入邮箱或电话号码" autocomplete="off" class="layui-input">
                                    </div>
                                </div><br><br>
                                <div class="layui-form-item">
                                    <div class="layui-input-block layui-col-space30">
                                        <button class="layui-btn" lay-submit lay-filter="formDemo">确认修改</button>
                                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import Reserve from "./Reserve";
    import Accept from "./Accept";
    export default {
        name: "Hotel",
        components: {Accept, Reserve},
        data(){
            return{
                layShow:0
            }
        },
    }
</script>

<style scoped>
    .layui-tab{
        width: 95%;
        margin: auto;
    }

    .hotelMessage{
        border: 2px solid #4E5465;
        width: 80%;
        margin: auto;
    }
    .signUpper{
        text-align: center;
        font-size: 25px;
        color: #4E5465;
    }
    .hotelForm{
        width: 80%;
        margin:30px auto;
    }

</style>