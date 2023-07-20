package com.example.userapi.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderRecord {
    private Date buyTime;
    private Integer commodityId;
    private String commodityName;
    private Integer userId;
    private Integer recordId;
}
