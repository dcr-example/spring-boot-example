<script>
    export default {
        methods: {
            goToLogin() {
                this.$router.push('/login')
            },
            goToIndex() {
                this.$router.router.push('/')
            }
        }
    }
</script>
<template>
    <p>注册页面</p>
    <p><button @click="goToLogin">已有帐号，去登录</button></p>
    <p><button @click="goToIndex">返回首页</button></p>
</template>