package com.example.userimpl.entity;

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
 * LoggEntity: 数据映射实体定义
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
    table = "logg",
    schema = "shopping"
)
public class LoggEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId("id")
  private Integer id;

  @TableField("loginName")
  private String loginName;

  @TableField("loginTime")
  private String loginTime;

  @Override
  public final Class entityClass() {
    return LoggEntity.class;
  }
}
