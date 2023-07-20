package com.example.userimpl.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * OrderRecordEntity: 数据映射实体定义
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
    table = "order_record",
    schema = "shopping"
)
public class OrderRecordEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId("record_id")
  private Integer recordId;

  @TableField("buy_time")
  private Date buyTime;

  @TableField("commodity_id")
  private Integer commodityId;

  @TableField("commodity_name")
  private String commodityName;

  @TableField("user_id")
  private Integer userId;

  @Override
  public final Class entityClass() {
    return OrderRecordEntity.class;
  }
}
