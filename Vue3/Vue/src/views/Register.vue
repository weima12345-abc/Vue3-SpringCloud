<template>
    <div class="register-container">
      <div style="width: 400px; margin: 100px auto">
        <div style="font-size: 30px; text-align: center; padding: 30px 0">注册</div>
        <el-form ref="form" :model="form" size="normal" :rules="rules">
          <el-form-item label="姓名">
            <el-input v-model="form.userName"></el-input>
          </el-form-item>
          <el-form-item label="账号">
            <el-input v-model="form.accountUsername"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="form.accountPassword" show-password></el-input>
          </el-form-item>
          <el-form-item label="手机号">
            <el-input v-model="form.userPhone"></el-input>
          </el-form-item>
          <div>
            <el-form-item>
              <el-button style="width: 100%" type="primary" @click="register">注册</el-button>
            </el-form-item>
            <el-form-item>
              <el-button style="width: 100%" type="primary" @click="$router.push('/login')">返回登录</el-button>
            </el-form-item>
          </div>
        </el-form>
      </div>
    </div>
</template>

<script>
import request from "../utils/request";
// interface User {
//   userName: string
//   accountUsername: string
//   accountPassword:string
//   userPhone:string
//
// }
export default {
  name: "Register",
  data() {
    return {
      form: {},
    }
  },
  methods: {
    register() {
          request.post("/user/register", null,{params:this.form}).then(res => {
            if (res.code === '200') {
              this.$message({
                type: "success",
                message: "注册成功"
              })
              this.$router.push("/login")  //登录成功之后进行页面的跳转，跳转到主页
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })

      }

  }
}
</script>

<style scoped>

.register-container{
  max-width: 400px;
  margin: 0% auto;
  padding: 10px;
  border-radius: 10px;
}
.video-container .poster img{
  z-index: 0;
  position: absolute;
}

.video-container .filter {
  z-index: 1;
  position: absolute;
  width: 100%;
}


</style>






















