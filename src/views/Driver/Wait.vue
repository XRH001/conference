<template>
    <div class="allContainer">
        <EachJourney :meeting-journey="$store.state.driver.meetings.wait"></EachJourney>
    </div>
</template>

<script>
    import EachJourney from "./EachJourney";
    export default {
        name: "Wait",
        components:{
            EachJourney
        }
    }
</script>

<style scoped>

</style>