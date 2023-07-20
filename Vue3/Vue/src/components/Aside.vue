<template>




<div style="height: 100%">
<el-col>
      <div  v-for="(item,index) in userPermission" :key="index">
            <el-button type="primary" @click="go(index)">{{ item.name }}</el-button>
      </div>
</el-col>
</div>







</template>

<script>
import {ref} from "vue";
import {userPermission} from "../utils/permission.js";
export default {
  name: "Aside",
  data() {
    return {
      user: {},
      isCollapse : ref(true),
      userPermission:[{
        name:"1111",
        path:"/home"
      }],
    }
  },
  created() {
    let userStr = sessionStorage.getItem("user") || "{}"
    // if (userStr == "user"){
    this.userPermission = userPermission;
    // }
    // 请求服务端，确认当前登录用户的 合法信息
    // request.get("/user/" + this.user.id).then(res => {
    //   if (res.code === '0') {
    //     this.user = res.data
    //   }
    // })
  },
  methods:{
    go(index){
      this.$router.push("/home"+userPermission[index].path)
    },
  }
}
</script>

<style scoped>

</style>
