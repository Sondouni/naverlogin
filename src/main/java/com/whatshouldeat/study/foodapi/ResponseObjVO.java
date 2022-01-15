package com.whatshouldeat.study.foodapi;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseObjVO {
    private String result_Code;
    private String result_Msg;
    private int rcdcnt;
    private int page_No;
    private int total_Count;
    private List<FoodVO> list;
}
