import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import 'element-plus/dist/index.css'
import './assets/css/global.css'



import App from './App.vue'
import router from './router'
import store from './store'
import axios from './axios'
import dialog from './utils/dialog'

const app = createApp(App)


app.use(ElementPlus, {
    locale: zhCn
})

app.use(router)
app.use(store)
app.use(dialog)


app.config.globalProperties.$axios = axios;

app.mount('#app')
//  npm run dev -- --host 10.1.1.112 --port 8082
//  访问 app.dcr.com
