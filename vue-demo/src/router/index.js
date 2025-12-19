import { createRouter, createWebHistory, createWebHashHistory } from 'vue-router'
import Layout from '@/view/Layout/Layout.vue'

import DemoList from '@/view/DemoList.vue'
import NotFound from '@/view/NotFound.vue'
import Register from '@/view/Register.vue'
import Home from '@/view/Home.vue'
import About from '@/view/About.vue'
import UserInfo from '@/view/UserInfo.vue'
import Login from '@/view/Login.vue'
import DemoDetail from '@/view/DemoDetail.vue'



const routes = [
    {
        path: '/',
        name: 'index',
        component: Layout,
        meta: { requiresAuth: false },
        children: [
            {
                path: '',
                name: 'home',
                component: Home,
                meta: { requiresAuth: false }
            }
        ],
    },
    {
        path: '/user',
        name: 'user',
        component: Layout,
        meta: { requiresAuth: false },
        children: [
            {
                path: '/user/userInfo',
                name: 'userInfo',
                component: UserInfo,
                meta: { requiresAuth: false }
            }
        ],
    },
    {
        path: '/demo',
        name: 'demo',
        component: Layout,
        meta: { requiresAuth: false },
        children: [
            {
                path: '/demo/demoList',
                name: 'demoList',
                component: DemoList,
                meta: { requiresAuth: false }
            },
            {
                path: '/demo/demoDetail/:id',
                name: 'demoDetail',
                component: DemoDetail,
                meta: { requiresAuth: false }
            }
        ],
    },
    { path: '/about', name: 'about', component: About, meta: { requiresAuth: false },},
    { path: '/login', name: 'login', component: Login, meta: { requiresAuth: false },},
    // { path: '/register', name: 'register', component: Register, meta: { requiresAuth: false },},

]




const router = createRouter({
    history: createWebHistory(),
    routes: routes
})


// router.beforeEach((to, from, next) => {
//     const store = useStore()
//     if(to.meta.requiresAuth && !store.state.isAuthenticated){
//         dialogShowAuto('您还没有登录,请先登录!')
//         next({
//             path: '/login',
//             query: { redirect: to.fullPath } // 将目标路由地址作为参数传递给登录页面，以便登录后重定向回该页面
//           })
//     } else {
//       next(); // 确保一定要调用next()
//     }
//   });


export default router







  