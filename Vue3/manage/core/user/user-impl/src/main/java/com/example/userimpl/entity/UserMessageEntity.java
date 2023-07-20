package com.example.userimpl.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * UserMessageEntity: 数据映射实体定义
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
    table = "user_message",
    schema = "shopping"
)
public class UserMessageEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  @TableField("account_username")
  private String accountUsername;

  @TableField("user_id")
  private Integer userId;

  @TableField("user_name")
  private String userName;

  @TableField("user_phone")
  private String userPhone;

  @Override
  public final Class entityClass() {
    return UserMessageEntity.class;
  }
}
