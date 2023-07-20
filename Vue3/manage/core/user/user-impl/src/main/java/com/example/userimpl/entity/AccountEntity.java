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
 * AccountEntity: 数据映射实体定义
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
    table = "account",
    schema = "shopping"
)
public class AccountEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableId("user_id")
  private Integer userId;

  @TableField("account_password")
  private String accountPassword;

  @TableField("account_username")
  private String accountUsername;

  @Override
  public final Class entityClass() {
    return AccountEntity.class;
  }
}
