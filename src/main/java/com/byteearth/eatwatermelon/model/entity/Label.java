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
public class Label {

    private String path;
    private String text;
    private String label_theme;
    private String text_color;
    private int bg_style;
    private String bg_color;
    private String border_color;
    private boolean use_img_label;
    private String img_label_uri_hans;
    private String img_label_uri_hant;
    private String img_label_uri_hans_static;
    private String img_label_uri_hant_static;

}