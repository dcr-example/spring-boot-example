<script setup>
    import { computed } from 'vue';
    import { useRoute, useRouter,RouterView } from 'vue-router';

    import Top from '@/view/Top.vue'
    import PageMenu from '@/view/PageMenu.vue'
    import Foot from '@/view/Foot.vue'

    const router = useRouter();
    const route = useRoute();

</script>

<template>
  <div class="common-layout">
    <el-container class="el_container">
      <el-header class="el_header"><top></top></el-header>
      <el-container style=" padding: 0 20px;">
        <el-aside class="el_aside"><page-menu></page-menu></el-aside>
        <el-main class="el_main" >
          <RouterView/>
        </el-main>
      </el-container>
      <el-footer class="el_footer"><foot></foot></el-footer>
    </el-container>
  </div>
</template>


<style scoped>
  .el_container {
    padding: 0;
    margin: 0;
    height: 100vh;
    width:100vw;
  }
  .el_aside {
    background-color: red;
  }
  .el_main{
    background-color: chartreuse;
    width: 100%;
  }
  .el_header {
    height: 100px;
    text-align: left;
    font-size: 12px;
    /* background-color: #545c64; */
  }
  .el_footer {
    height: 50px;
  }
</style>