<script setup>
    import { ref, computed, onMounted } from 'vue'
    import { useRouter } from  'vue-router'
    import { useStore } from 'vuex'
    import { ajaxGet, ajaxPost } from '@/utils/https'
    import { dialogShowAuto } from '@/utils/dialog'

    const router = useRouter()
    const store = useStore()
    const userInfo = computed(()=> store.state.userInfo)

    onMounted(()=>{
        ajaxPost('/user/read', null, false, function(resultData){
            store.commit('setUserInfo', resultData.data)
        })
    })

    function goToLogout(){
        ajaxPost('/login/out', null, false, function(){
            store.commit('removeUserInfo')
            router.push('/login')
        })
    }
</script>
<template>
    <p>个人中心</p>
    <p>
        <!-- <div v-if="userInfo != null">
            <p>当前用户{{ userInfo.userName }}</p>
            <p><button @click="goToLogout">退出帐号</button></p>
        </div> -->
        <div v-if="userInfo != null">
            <p><label>编号:</label>{{ userInfo.id }}</p>
            <p><label>昵称:</label>{{ userInfo.nickName }}</p>
            <p><label>用户名</label>{{ userInfo.userName }}</p>
            <p><button @click="goToLogout">退出帐号</button></p>
        </div>
    </p>
</template>