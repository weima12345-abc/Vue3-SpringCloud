
<template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column label="商品名" prop="commodityName" />
    <el-table-column label="商品价格" prop="commodityPrice" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="检索商品" />
      </template>
      <template #default="scope">
        <el-button  type="primary" size="small" @click="inCar(scope.$index)"
        >加入购物车</el-button
        >
        <el-button
            size="small"
            type="danger"
            @click="buy(scope.$index, scope.row)"
        >购买</el-button
        >
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import request from "../utils/request.js";
export default {
  data() {
    return {
      tableData: [],
      search: ""
    }
  },
  created() {
    request.post("/commodity/getList").then(res => {
      if (res.code === '200') {
        this.tableData = res.data
      } else {
        this.$message({
          type: "error",
          message: res.msg
        })
      }
    })


  },
  methods: {
    buy(index){
      request.post("/user/insertRecord",null, {params:{commodityName:this.tableData[index].commodityName,commodityId:this.tableData[index].commodityId,userId:sessionStorage.getItem("uid")}}).then(res=>{
        if(res.code === '200'){
          this.$message({
            type: "success",
            message: "购买成功"
          })
        }else{
          this.$message({
            type: "error",
            message: res.msg
          })
        }
      })
    },
    inCar(index){
      request.post("/commodity/insertShoppingCart",null, {params:{commodityPrice:this.tableData[index].commodityPrice,commodityName:this.tableData[index].commodityName,commodityId:this.tableData[index].commodityId,userId:sessionStorage.getItem("uid")}}).then(res=>{
        if(res.code === '200'){
          this.$message({
            type: "success",
            message: "加入成功"
          })
        }else{
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

