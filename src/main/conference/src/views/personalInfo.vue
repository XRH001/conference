<template>
    <div class="personalContainer">
        <table class="layui-table">
            <colgroup>
                <col width="20%">
                <col width="80%">
            </colgroup>
            <tbody>
                <tr>
                    <td colspan="2"><div class="headDiv"><img class="headImg" :src="$store.getters.headPath"></div></td>
                </tr>
                <tr>
                    <td>用户名</td><td>{{$store.state.user.username}}</td>
                </tr>
                <tr>
                    <td>邮箱</td><td>{{$store.state.user.userEmail}}</td>
                </tr>
                <tr>
                    <td>平台ID</td><td>{{$store.state.user.userId}}</td>
                </tr>
            </tbody>
        </table>

    </div>
</template>

<script>
    export default {
        name: "personalInfo",
        computed:{

        }
    }
</script>

<style scoped>

    .personalContainer{
        width: 60%;
        padding: 20px;
        border: 2px solid #595B5D;
        border-radius: 6px;
        margin: 30px auto auto;
    }
    .headDiv{
        margin: auto;
        width: 120px;
    }
    .headImg{
        border-radius: 50%;
        border:2px solid #46d7ed;
        padding: 3px;
        width: 100px;
        height: 100px;
        margin: auto;
    }

</style>