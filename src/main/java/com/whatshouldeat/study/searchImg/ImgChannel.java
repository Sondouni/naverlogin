package com.whatshouldeat.study.searchImg;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ImgChannel {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<SearchImgVO> items;
}
