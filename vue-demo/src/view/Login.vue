<script setup>
    import { ref, computed } from 'vue'
    import { useRouter } from  'vue-router'
    import { useStore } from 'vuex'
    import { ajaxGet, ajaxPost } from '@/utils/https'
    import { dialogShowAuto } from '@/utils/dialog'


    const router = useRouter()
    const userPwd = ref(null)
    const userName = ref(null)

    const store = useStore()

    const userInfo = computed(()=> store.state.userInfo)

    function goToIndex() {
        router.push('/')
    }
    function goToRegister() {
        router.push('/register')
    }
    function login(){
        if(userPwd.value != null && userPwd.value != undefined && userName.value != null && userName.value != undefined){
            const params = {
                user_name: userName.value,
                user_pwd: userPwd.value,
            }
            ajaxPost('/login/in', params, true, function(resultData){
                store.commit('setUserInfo', resultData.data)
                userPwd.value = ''
            })

        }else{
            if(userName.value == null || userName.value == undefined){
                dialogShowAuto('请输入用户名!')
            }else{
                dialogShowAuto('请输入密码!')
            }
        }
    }
    function goToLogout(){
        ajaxPost('/login/out', null, true, function(){
            store.commit('removeUserInfo')
        })
    }
</script>

<template>
    <p>登录页面</p>
    <div v-if="userInfo != null">
        <p>当前用户{{ userInfo.userName }}</p>
        <p><button @click="goToLogout">退出帐号</button></p>
    </div>
    <div v-else>
        <p><label>姓名:</label><input v-model="userName"/></p>
        <p><label>密码:</label><input v-model="userPwd"/></p>
        <p><button @click="login">登录</button></p>
        <p><button @click="goToRegister">没有帐号？去注册</button></p>
    </div>
    <p><button @click="goToIndex">返回首页</button></p>


</template>