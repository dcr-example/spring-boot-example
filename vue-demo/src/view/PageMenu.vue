
<script lang="ts" setup>
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'
import {RouterLink } from 'vue-router';

const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>

<!-- <template>-->
<!--    <nav>-->
<!--        <ul>-->
<!--            <li><RouterLink to="/">首页</RouterLink></li>-->
<!--            <li><RouterLink to="/demoList">示例列表</RouterLink></li>-->
<!--            <li><RouterLink to="/user">个人中心</RouterLink></li>-->
<!--            <li><RouterLink to="/login">登录</RouterLink></li>-->
<!--            <li><RouterLink to="/register">注册</RouterLink></li>-->
<!--            <li><RouterLink to="/about">关于我们</RouterLink></li>-->
<!--        </ul>-->
<!--    </nav>-->
<!--  </template>-->

<template>
  <div>
    <el-row class="tac" style="/* width: 100%; height: 100%;*/">
      <el-col :span="12">
         <h5 class="mb-2">Custom colors</h5>
        <el-scrollbar style=" width: 300px; max-height: 480px;">
          <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose">
            <el-sub-menu index="1">
              <template #title>
                <el-icon>
                  <location />
                </el-icon>
                <span>首页</span>
              </template>
              <el-menu-item index="1-1"><RouterLink to="/">欢迎页</RouterLink></el-menu-item>
              <el-menu-item index="1-2">工作台</el-menu-item>
              <!-- <el-sub-menu index="1-4">
                  <template #title>item four</template>
                  <el-menu-item index="1-4-1">item one</el-menu-item>
              </el-sub-menu> -->
            </el-sub-menu>
            <el-sub-menu index="2">
              <template #title>
                <el-icon><icon-menu /></el-icon>
                <span>示例</span>
              </template>
              <el-menu-item index="2-1"><RouterLink to="/demo/demoList">示例列表</RouterLink></el-menu-item>
              <el-menu-item index="2-2"><RouterLink to="/user/userInfo">用户详情</RouterLink></el-menu-item>
            </el-sub-menu>
            <el-menu-item index="3" >
              <el-icon>
                <document />
              </el-icon>
              <span><RouterLink to="/about">关于我们</RouterLink></span>
            </el-menu-item>
            <el-menu-item index="4">
              <el-icon>
                <setting />
              </el-icon>
              <span><RouterLink to="/login">登录</RouterLink></span>
            </el-menu-item>
          </el-menu>
        </el-scrollbar>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>

</style>

