<template>
    <div>
        <table class="layui-table">
            <colgroup><col width="20%"><col width="80%"></colgroup>
            <tbody>
                <tr><td>出行</td>
                    <td><el-select v-model="selectDriver">
                        <el-option v-for="driverItem in haveDriverList" :key="driverItem.id"  :label="driverItem.name+'-'+driverItem.carNum" :value="driverItem.id"></el-option>
                    </el-select></td>
                </tr>
                <tr>
                    <td>入住</td>
                    <td>房间</td>
                </tr>
                <tr><td colspan="2" class="align-center">
                    <el-button size="small">确认修改</el-button>
                </td></tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "ArrangeOne",
        data(){
            return{
                selectDriver:""
            }
        },methods:{

        },
        props:{
            haveDriverList:Array
        }
    }
</script>

<style scoped>

</style>