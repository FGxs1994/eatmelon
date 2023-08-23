/**
  * Copyright 2023 bejson.com 
  */
package com.byteearth.eatwatermelon.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Auto-generated: 2023-08-23 12:17:59
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vip {

    private int vipType;
    private long vipDueDate;
    private String dueRemark;
    private int accessStatus;
    private int vipStatus;
    private String vipStatusWarn;
    private int themeType;
    private Label label;
    private int avatar_subscript;
    private String nickname_color;

}