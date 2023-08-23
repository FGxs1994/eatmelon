package com.byteearth.eatwatermelon.model.entity;

/**
 * Copyright 2023 bejson.com
 */
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
public class BilibiliData {

    private Cursor cursor;
    private List<Replies> replies;
    private Top top;
    private List<Top_replies> top_replies;
    private Up_selection up_selection;
    private Effects effects;
    private int assist;
    private int blacklist;
    private int vote;
    private Config config;
    private Upper upper;
    private Control control;
    private int note;
    private String callbacks;

}
