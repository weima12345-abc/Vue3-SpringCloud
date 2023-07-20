package com.example.commodityapi.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * code 状态码
 * result 结果对象
 * */
//@Schema(description = "后端传回数据格式")
@Data
@AllArgsConstructor
public class ResultFul<T>{
    //@Schema(description = "状态码")
    public String code;
    //@Schema(description = "数据")
    public T data;
    //@Schema(description = "描述信息")
    public String message;
}