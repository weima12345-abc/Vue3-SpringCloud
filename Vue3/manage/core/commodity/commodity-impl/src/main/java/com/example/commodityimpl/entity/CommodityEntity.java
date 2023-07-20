package com.example.commodityimpl.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * CommodityEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@AllArgsConstructor
@NoArgsConstructor
@FluentMybatis(
    table = "commodity",
    schema = "shopping"
)
public class CommodityEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId("commodity_id")
  private Integer commodityId;

  @TableField("commodity_name")
  private String commodityName;

  @TableField("commodity_price")
  private Float commodityPrice;

  @Override
  public final Class entityClass() {
    return CommodityEntity.class;
  }
}
