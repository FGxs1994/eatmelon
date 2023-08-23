/**
  * Copyright 2023 bejson.com 
  */
package com.byteearth.eatwatermelon.model.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class Top_replies {

    private long rpid;
    private long oid;
    private int type;
    private long mid;
    private int root;
    private int parent;
    private int dialog;
    private int count;
    private int rcount;
    private int state;
    private int fansgrade;
    private long attr;
    private long ctime;
    private String rpid_str;
    private String root_str;
    private String parent_str;
    private long like;
    private int action;
    private Member member;
    private Content content;
    private List<Replies> replies;
    private int assist;
    private UpAction up_action;
    private boolean invisible;
    private Reply_control reply_control;
    private Folder folder;
    private String dynamic_id_str;

}