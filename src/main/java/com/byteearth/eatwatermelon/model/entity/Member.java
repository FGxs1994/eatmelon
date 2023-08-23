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
public class Member {

    private String mid;
    private String uname;
    private String sex;
    private String sign;
    private String avatar;
    private String rank;
    private int face_nft_new;
    private int is_senior_member;
    private Senior senior;
    private Level_info level_info;
    private Pendant pendant;
    private Nameplate nameplate;
    private Official_verify official_verify;
    private Vip vip;
    private String fans_detail;
    private String user_sailing;
    private boolean is_contractor;
    private String contract_desc;
    private String nft_interaction;
    private Avatar_item avatar_item;
}