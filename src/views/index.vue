<template>
    <div>
        <h1>正在根据您的身份跳转</h1><h1>{{point}}</h1>
    </div>
</template>

<script>
    export default {
        name: "index",
        data(){
            return {
                point:"."
            }
        },
        methods:{

        },
        created() {
            setInterval(() =>{
                if (this.point==="....")this.point=".";
                else this.point+=".";
            },800 );
            //跳转

            if(this.$store.state.haveLogin){
                let user = this.$store.state.user;
               if(user.identity.toLowerCase()==="common")this.$router.push({path:"/Ordinary",query:this.$route.query});
               else if(user.identity.toLowerCase()==="driver")this.$router.push({path:"/Driver",query:this.$route.query});
               else if(user.identity.toLowerCase()==="hotel")this.$router.push({path:"/Hotel",query:this.$route.query});

            }
            else this.$router.push("/First");
        }
    }

</script>

<style scoped>
h1{
    text-align: center;
    color: #726e73;
}

</style>