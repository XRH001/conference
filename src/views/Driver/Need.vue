<template>
    <div class="meetingContainer layui-row">
        <div class="layui-card  ">
            <div class="layui-card-header">怎么写bug不被发现</div>
            <div class="layui-card-body">
                <div class="meetingDetailCard">
                    会议开始时间：2020年11月22日21:14<br>
                    会议地点：安徽小岗村。<br>
                    会议人数：300
                </div>
                <div class="">
                    <button class="layui-btn layui-btn-normal">接收请求</button>
                    <button class="layui-btn layui-btn-normal">详细信息</button>
                </div>
            </div>
        </div>

        <div class="layui-card ">
            <div class="layui-card-header">怎么发现喜欢写bug的人</div>
            <div class="layui-card-body">
                <div class="meetingDetailCard">
                    会议开始时间：2020年11月22日21:14<br>
                    会议地点：安徽小岗村。<br>
                    会议人数：200
                </div>
                <div class="">
                    <button class="layui-btn layui-btn-normal">接收请求</button>
                    <button class="layui-btn layui-btn-normal">详细信息</button>
                </div>
            </div>
        </div>
        <div class="layui-card ">
            <div class="layui-card-header">怎么消除写bug的人</div>
            <div class="layui-card-body">
                <div class="meetingDetailCard">
                    会议开始时间：2020年11月22日21:14<br>
                    会议地点：安徽小岗村。<br>
                    会议人数：300
                </div>
                <div class="">
                    <button class="layui-btn layui-btn-normal">接收请求</button>
                    <button class="layui-btn layui-btn-normal">详细信息</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Need"
    }
</script>

<style scoped>


    .meetingContainer{
        margin: 20px auto;
        width: 94%;
    }

    .layui-card-header{
        font-size: 25px;
    }
    .layui-card{
        border: 2px solid #4E5465;
        width: 46%;
        margin: 20px;
        float: left;
    }
    @media screen and (max-width: 1200px) {
        .layui-card{
            width: 40% !important;
        }
    }
    @media screen and (max-width: 900px) {
        .layui-card{
            width: 92% !important;
        }
    }


</style>