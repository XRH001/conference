<template>
    <div>
        <EachJourney :meeting-journey="$store.state.driver.meetings.already" :action="1"></EachJourney>
    </div>
</template>

<script>
    import EachJourney from "./EachJourney";
    export default {
        name: "Already",
        components:{
            EachJourney
        }
    }
</script>

<style scoped>

</style>