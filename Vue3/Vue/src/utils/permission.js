
import UserMessage from "../views/UserMessage.vue";
import ChangePassword from "../views/ChangePassword.vue";
import Menu from "../views/Menu.vue";
import Home from "../views/Home.vue";
import ShoppingCart from "../views/ShoppingCart.vue";
export function activeRouter(router) {
        let root = {
            path: '/',
            name: 'Menu',
            component: Menu,
        }
            userPermission.forEach(p => {
                let obj = {
                    path: p.path,
                    name: p.name,
                    component: p.com
                };
                router.addRoute(obj)
                //root.children.push(obj)
            })

        if (router) {
            router.addRoute(root)
        }
        return router;

}
export let userPermission= [
    {path: '/home', name: '回到首页',com:Home},
    {path: '/userMessage', name: '购买信息',com:UserMessage},
    {path: '/chanePassword', name: '修改密码',com:ChangePassword},
    {path: '/ShoppingCart', name: '购物车',com:ShoppingCart},
]


