<script>
import {userPermission} from "../utils/permission.js";
import request from "../utils/request.js";
export default {
  data() {
    return {
      uid:sessionStorage.getItem("uid"),
      tableData:[]
    };
  },
  created() {
    request.post("/user/getList",null, {params:{userid:this.uid}}).then(res=>{
      if(res.code === '200'){
        this.tableData = res.data
      }else{
        this.$message({
          type: "error",
          message: res.msg
        })
      }
    })

  },
  methods:{
  }
};
</script>
<template>
  <el-container class="layout-container-demo" style="height: 500px">
    <el-aside width="200px">
    </el-aside>
    <el-container>
      <el-header style="text-align: right; font-size: 20px">
        <div class="toolbar">
          <span>用户id{{this.uid}}</span>
        </div>
      </el-header>
      <el-header style="text-align: left; font-size: 20px">
        <div class="toolbar">
          <span>购买记录</span>
        </div>
      </el-header>
      <el-main>
        <el-scrollbar>
            <el-table :data="tableData" height="250" style="width: 100%">
              <el-table-column prop="commodityName" label="商品名称" width="250" />
              <el-table-column prop="commodityId" label="商品ID" width="250" />
              <el-table-column prop="buyTime" label="购买时间" />
            </el-table>
        </el-scrollbar>
      </el-main>
    </el-container>
  </el-container>
</template>
<style scoped>
.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}
</style>