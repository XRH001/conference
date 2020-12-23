<template>
    <div>
        <EachJourney :meeting-journey="$store.state.driver.meetings.wait"></EachJourney>
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