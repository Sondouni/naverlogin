package com.whatshouldeat.study.restaurant;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class IMBodyVO {
    private String pageIndex;
    private String pageUnit;
    private String totalCount;
    private String searchCnd;
    private String searchKrwd;
    private String status;
    private List<ICRestaurantVO> result;
}
