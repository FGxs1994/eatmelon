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
public class Control {

    private boolean input_disable;
    private String root_input_text;
    private String child_input_text;
    private String giveup_input_text;
    private int screenshot_icon_state;
    private int upload_picture_icon_state;
    private String answer_guide_text;
    private String answer_guide_icon_url;
    private String answer_guide_ios_url;
    private String answer_guide_android_url;
    private String bg_text;
    private String empty_page;
    private int show_type;
    private String show_text;
    private boolean web_selection;
    private boolean disable_jump_emote;
    private boolean enable_charged;
    private boolean enable_cm_biz_helper;

}