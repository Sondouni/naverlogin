package com.whatshouldeat.study.search;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Channel {
    private String lastBuildDate;
    private String category;
    private int total;
    private int start;
    private int display;
    private List<SearchDTO> items;
}
