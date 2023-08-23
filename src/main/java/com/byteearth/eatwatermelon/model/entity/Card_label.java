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
public class Card_label {

    private long rpid;
    private String text_content;
    private String text_color_day;
    private String text_color_night;
    private String label_color_day;
    private String label_color_night;
    private String image;
    private int type;
    private String background;
    private int background_width;
    private int background_height;
    private String jump_url;
    private int effect;
    private int effect_start_time;
}