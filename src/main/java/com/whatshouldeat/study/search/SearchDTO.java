package com.whatshouldeat.study.search;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchDTO {
    private String title;
    private String link;
    private String description;
    private String telephone;
    private String address;
    private String roadAddress;
    private String category;
    private int mapx;
    private int mapy;
}
