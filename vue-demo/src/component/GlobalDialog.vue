<script setup>
    import { ref, computed } from 'vue'
    import { useStore } from 'vuex'

    const store = useStore()
    
    const isShow = computed(() => store.state.globalDialog.isShow)
    const message = computed(() => store.state.globalDialog.message)

</script>

<template>
    <div v-if="isShow" class="modal">
      <div class="modal-content">{{ message }}</div>
    </div>
  </template>
   
 <style scoped>
  .modal {
    position: fixed;
    z-index: 1000;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(255, 255, 255, 0);
  }
  .modal-content {
    background-color: #00000015;
    padding: 15px;
    position: absolute; /* 使用绝对定位 */
    top: 50%; /* 向上偏移50% */
    left: 50%; /* 向左偏移50% */
    transform: translate(-50%, -50%); /* 向相反方向移动自身宽高的50% */
  }
  </style>