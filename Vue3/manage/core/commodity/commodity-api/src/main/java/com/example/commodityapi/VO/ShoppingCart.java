package com.example.commodityapi.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    private Integer commodityId;

    private String commodityName;

    private Float commodityPrice;

    private Integer userId;
}
