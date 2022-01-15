package com.whatshouldeat.study.foodapi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodVO {
    private int no;
    private String fd_Code;
    private String upper_Fd_Grupp_Nm;
    private String fd_Grupp_Nm;
    private String fd_Nm;
    private String fd_Wgh;
    private String food_Cnt;
    private String image_Address;
}
