<template>
  <div class="about">
    <h1>This is an about page</h1>
    <img class="imgSwipe" :src="path">
  </div>
</template>
<script>
  export default {
    name:'About',
    data(){
      return {imgPaths:[],path:""}
    },
    created() {
      this.$http.get("/swipeServlet?action=getImgPathJson"
      ).then(res =>{
        this.imgPaths=res.data;
      });
      let num=0;
      setInterval(()=>{
        this.path=this.$store.state.url+this.imgPaths[num%3].imgPath;
        num++;
      },3000);
    },
  }
</script>

<style scoped>
  .imgSwipe{
    width: 40%;
    margin: auto;
  }
</style>
