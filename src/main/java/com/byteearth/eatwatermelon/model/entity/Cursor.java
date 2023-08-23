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
public class Cursor {

    private boolean is_begin;
    private int prev;
    private int next;
    private boolean is_end;
    private int mode;
    private String mode_text;
    private long all_count;
    private List<Integer> support_mode;
    private String name;
    private Pagination_reply pagination_reply;
    private String session_id;

}