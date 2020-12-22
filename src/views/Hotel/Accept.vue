<template>
    <div>
        <fieldset v-for="meetingItem in $store.state.hotel.meetings.accepted" :key="meetingItem.id" class="layui-elem-field eachReserve">
            <legend>会议名：{{meetingItem.name}}</legend>
            <div class="layui-field-box">
                <!--会议时间：2020年11月23日11:26-2020年11月23日11:26<br>
                会议地点：你家酒店附近<br>
                会议人数：200<br>-->
                <div class="customer">预约人：{{meetingItem.customer}}<br>
                    联系方式：{{meetingItem.contact}}<br>
                    <RouterLink :to="{path:'detail',query:{meetingId:meetingItem.id}}" class="routerLink el-icon-view">会议详情</RouterLink>
                </div>
                <hr class="layui-bg-orange">
                <Collapse>
                    <span slot="title">预定房间</span>
                    <table slot="content" class="layui-table">
                        <thead>
                        <tr><th>房间类型</th><th>预定数量</th><th>入住时间</th><th>退房时间</th></tr>
                        </thead>
                        <tbody>
                        <tr v-for="(roomItem,index) in meetingItem.rooms" :key="index">
                            <td>{{roomItem.type}}</td><td>{{roomItem.num}}</td>
                            <td>{{roomItem.beginTime}}</td>
                            <td>{{roomItem.endTime}}</td>
                        </tr>
                        </tbody>
                    </table>
                </Collapse>

                <hr class="layui-bg-orange">
                <div class="btnDiv layui-row">
                    <div class="layui-col-lg2 layui-col-lg-offset4">
                        <button class="layui-btn layui-bg-orange">完成订单</button>
                    </div>
                    <div class="layui-col-lg3 ">
                        <button class="layui-btn layui-btn-danger">取消订单</button>
                </div>
            </div>
            </div>
        </fieldset>
        <div style="clear: both"></div>
    </div>
</template>

<script>
    import Collapse from "components/Collapse";
    export default {
        name: "Accept",
        components:{
            Collapse
        },
        created() {
            //console.log(this.$store.state.hotel.meetings.accepted);
        }
    }
</script>

<style scoped>

    .customer{
        font-size: 16px;
        margin-left: 15px;
        margin-top: 10px;
    }
    .eachReserve{
        border: 2px solid #4E5465;
        width: 46%;
        margin: 20px;
        float: left;
    }
    .routerLink{
        color: #01aaed;
        font-size: 19px;
    }
    .routerLink:hover{
        color: #46d7ed;

    }
    @media screen and (max-width: 1200px) {
        .eachReserve{
            width: 40% !important;
        }
    }
    @media screen and (max-width: 900px) {
        .eachReserve{
            width: 92% !important;
        }
    }
</style>