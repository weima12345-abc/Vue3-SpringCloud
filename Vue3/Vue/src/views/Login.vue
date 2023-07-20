<script>
import request from "../utils/request.js";
import {activeRouter} from "../utils/permission.js";
import router from "../router/index.js";
export default {
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    submitForm() {
      let form = {
        accountUsername: this.username,
        accountPassword: this.password
      }
      // 处理表单提交逻辑
      request.post('/user/login', null,{params:form}).then(res => {
            if (res.code === '200') {
              this.$message({
                type: "success",
                message: "登录成功"
              })
              sessionStorage.setItem("username", this.username)
              sessionStorage.setItem("uid", res.data)
              // 登录成功的时候更新当前路由
              activeRouter(router)
              this.$router.push("/")  //登录成功之后进行页面的跳转，跳转到主页
            } else {
              this.$message({
                type: "error",
                message: res.message
              })
            }
          }
      ).catch(err => {
        console.log(err)
      })
    },
    register(){
      this.$router.push("/register")
    }
  }
}
</script>
<template>
  <div class="login-container">
    <h1 class="login-title">登录</h1>
    <form @submit.prevent="submitForm" class="login-form">
      <div class="form-group" >
        <label for="username" class="form-label">账号</label>
        <input type="text" style="height: 30px;" id="username" v-model="username" required class="form-input">
      </div>
      <div class="form-group">
        <label for="password" class="form-label">密码</label>
        <input type="password" style="height: 30px;" id="password" v-model="password" required class="form-input">
      </div>
      <div style="display: flex; margin-top: 10px; justify-content: center;">
        <button type="submit" class="form-button" style="margin-right: 20px; width: 300px;">登录</button>
        <button @click="register()" class="form-button" style="margin-right: 20px; width: 300px;">注册</button>
      </div>

    </form>
  </div>
</template>

<style>
.login-container {
  max-width: 400px;
  margin: 10% auto;
  padding: 10px;
  border: 1px solid #1da1f2;
  border-radius: 10px;
}
.login-title {
  text-align: center;
  margin-bottom: 20px;
}
.login-form {
  display: flex;
  flex-direction: column;

}
.form-group {
  margin-bottom: -10px;
  padding: 20px;
}
.form-label {
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 5px;
}
.form-input {
  display: block;
  font-size: 16px;
  width: 100%;
  height: 20px;
  border: 1px solid #1da1f2;
  border-radius: 5px;
}
.form-button {
  display: block;
  width: 100%;
  padding: 10px;
  font-size: 16px;
  background-color: #1da1f2;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-bottom: 10px;
}
.form-button:hover {
  background-color: #0c8de4;
}
</style>
