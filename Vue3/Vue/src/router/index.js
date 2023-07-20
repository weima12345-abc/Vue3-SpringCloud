//从VueRouter中导入需要的函数模块
import {createRouter, createWebHashHistory } from 'vue-router'
import Login from "../views/Login.vue"
import ChangePassword from "../views/ChangePassword.vue"
import Home from "../views/Home.vue"
import ShoppingCart from "../views/ShoppingCart.vue"
import {activeRouter} from "../utils/permission.js"
import Menu from "../views/Menu.vue";
import changePassword from "../views/ChangePassword.vue";

const routes = [
    // {
    //     path: '/',
    //     name:'Layout',
    //     component:Menu,
    //     redirect: "/home",
    //     meta:{
    //         title:'首页',
    //         icon:'HomeFilled'
    //     },
    //     children: [
    //     ]
    // },
    {
        path: '/login',
        name:'Login',
        component: Login,
    },
    {
        path: '/changePassword',
        name:'ChangePassword',
        component: ChangePassword,
    },
    {
        path: '/home',
        name:'Home',
        component: Home,
    },
    {
        path: '/ShoppingCart',
        name:'Shopping',
        component: ShoppingCart,
    },
    {
        path: '/register',
        name: 'Register',
        component: () => import("../views/Register.vue")
    },
]
const router = createRouter({
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
})
// 在刷新页面的时候重置当前路由
activeRouter(router)
router.beforeEach((to, from, next) => {
    next()
})
export default router