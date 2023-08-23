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
public class Fallback_layers {

    private List<Layers> layers;
    private boolean is_critical_group;

}