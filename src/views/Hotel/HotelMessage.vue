<template>
    <div class="messageContent">
        <div class="oneMessage">
            <p class="title">平台消息</p>
            <hr class="borderLine">
            <div class="content">
                欢迎加盟浑元形意网约酒店

            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "HotelMessage"
    }
</script>

<style scoped>
    .oneMessage{
        background-color: #daf5ff;
        margin: 20px;
        padding: 10px;
        border-radius: 5px;
    }
    .title{
        color: #35a2a4;
        font-size: 19px;
    }
    .content{
        color: #aa8773;
        font-size: 17px;
    }
    .messageContent{
        max-height: calc(90vh);
        overflow-y: scroll;
    }
</style>