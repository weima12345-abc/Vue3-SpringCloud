
<script>
import {userPermission} from "../utils/permission.js";
import request from "../utils/request.js";
export default {
  data() {
    return {
      user: {},
      userPermission:[{
        name:"1111",
        path:"/home"
      }],
    };
  },
  created() {
    let userStr = sessionStorage.getItem("user") || "{}"
    this.userPermission = userPermission;

  },
  methods:{
    go(index){
      this.$router.push(userPermission[index].path)
    },
    lo(){
      this.$router.push("/login")
    }
  }
};
</script>

<template>
  <div class="container">
    <div class="box">
      <div class="buttons">
        <button v-for="(item,index) in this.userPermission" :key="index" @click="go(index)" class="button">{{ item.name }}</button>
        <button @click="lo()" class="button">退出登录</button>
      </div>
    </div>
  </div>
</template>
<style>
.container {
  display: flex;
  height: 100vh;
  justify-content:center;
  align-items: center;
}
.box {
  width: 33%;
  height: 33%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.buttons {
  display: flex;
  justify-content: space-between;
  flex-direction: column;
  width: 30%;
}
.button {
  padding: 10px;
  background-color: #1da1f2;
  color: #ffffff;
  border: 1px solid #ffffff;
  margin-top: 10px;
  border-radius: 20px;
  cursor: pointer;
}
.button:hover {
  background-color: #0c8de4;
  color: #1da1f2;
}
</style>