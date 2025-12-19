
<script setup>
    import { ref, onMounted } from 'vue'
    import { useStore } from 'vuex'
    import { ajaxGet, ajaxPost } from '@/utils/https'
    import { dialogShowAuto } from '@/utils/dialog'


    const store = useStore()
    const demoList = ref(null)


    onMounted(()=>{
        queryList()
    })

    function queryList(){
        ajaxGet('/demo/list', {}, false, 
        function(resultData){
            if(resultData.status == 'success'){
                demoList.value = resultData.data
            }else{
                demoList.value = null
            }
        }, 
        function(resultData){
            demoList.value = null
        })
    }

</script>

<template>
    <table border="1" width="90%">
        <thead>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>详情</th>
            </tr>
        </thead>
        <tbody v-if="demoList != null && demoList.length > 0">
            <tr v-for="demo in demoList">
                <th>{{ demo.id }}</th>
                <th>{{ demo.name }}</th>
                <th>{{ demo.age }}</th>
                <th><RouterLink :to="{name: 'demoDetail', params: {id: demo.id}}">详情</RouterLink></th>
            </tr>
        </tbody>
        <tbody v-else>
            <tr>
                <th colspan="3" style=" text-align: center; color: red;">暂无数据!</th>
            </tr>
        </tbody>
    </table>
</template>