
<script>
import request from "../utils/request.js";

export default {
  data() {
    return {
      username: sessionStorage.getItem("username"),
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
      request.post('/user/updatePassword', null,{params:form}).then(res => {

            if (res.code === '200') {
              this.$message({
                type: "success",
                message: "修改成功"

              })
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
    }
  }
}
</script>

<template>
  <div class="login-container">
    <h1 class="login-title">修改密码</h1>
    <form class="login-form">
      <div class="form-group" >
        <label for="password" class="form-label">账号</label>
        {{this.username}}
      </div>
      <div class="form-group">
        <label for="password" class="form-label">新密码</label>
        <input type="password" style="height: 30px;" id="passwords" v-model="password" required class="form-input">
      </div>
      <div style="display: flex; margin-top: 10px; justify-content: center;">
        <button @click="submitForm()" class="form-button" style="margin-right: 20px; width: 300px;">确认修改</button>
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









