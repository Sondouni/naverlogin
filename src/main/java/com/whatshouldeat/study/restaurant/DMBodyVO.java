package com.whatshouldeat.study.restaurant;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DMBodyVO {
    private String status;
    private String total;
    private List<RestaurantVO> data;
}
