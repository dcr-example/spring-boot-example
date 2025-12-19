
<script setup>
    import { ref, onMounted} from 'vue'
    import { useRoute } from  'vue-router'
    import { useStore } from 'vuex'
    import { ajaxGet, ajaxPost } from '@/utils/https'
    import { dialogShowAuto } from '@/utils/dialog'


    const store = useStore()
    const demo = ref(null)
    const route = useRoute()
   
    onMounted(()=>{
        queryDemoInfo()
    })
    function queryDemoInfo(){
        const demoId = route.params.id
        if(demoId != null && demoId != undefined){

            ajaxGet('/demo/detail/' + demoId , {}, false, 
                function (resultData) {
                    demo.value = resultData.data
                },
                function (resultData) {
                    demo.value = null
                }
            )
        }else{
            showDialog('参数异常!')
        }
    }
</script>
<template>
   
    <div v-if="demo != null">
        <p>
            <label>编号:</label>{{ demo.id }}<br/>
            <label>姓名:</label>{{ demo.name }}<br/>
            <label>年龄:</label>{{ demo.age }}<br/>
        </p>
    </div>
    <div v-else>
        <p><label>数据不存在!</label></p>
    </div>
    
    <ul>
        <li><RouterLink :to="{name: 'demoList'}">返回demo列表-1</RouterLink></li>
        <li><RouterLink to="/demoList">返回demo列表-2</RouterLink></li>
    </ul>
</template>