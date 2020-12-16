<template>
    <div class=" hotelMessage ">
        <div class="hotelForm">
            <div class="signUpper">在此修改您的车队信息</div><br>
            <!--                    <hr class="layui-bg-cyan">-->
            <form action="" method="get" class="layui-form ">
                <div class="layui-form-item">
                    <label class="layui-form-label ">司机</label>
                    <div class="layui-input-block ">
                        <input type="text" name="driverName" required  lay-verify="required" placeholder="请输入司机姓名" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label ">联系方式</label>
                    <div class="layui-input-block ">
                        <input type="text" name="contact" required  lay-verify="required" placeholder="请输入邮箱或电话号码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label ">车型</label>
                    <div class="layui-input-block ">
                        <input type="text" name="carType" required  lay-verify="required" placeholder="请输入驾车类型" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label ">限载人数</label>
                    <div class="layui-input-block ">
                        <input type="text" name="maxCount" required  lay-verify="required" placeholder="请输入最大载客数量" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label ">车牌号码</label>
                    <div class="layui-input-block ">
                        <input type="text" name="licenseNumber" required  lay-verify="required" placeholder="请输入车牌号" autocomplete="off" class="layui-input">
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
</template>

<script>
    export default {
        name: "DriverInfo"
    }
</script>

<style scoped>

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