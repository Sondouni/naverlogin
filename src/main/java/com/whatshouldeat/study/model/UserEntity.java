package com.whatshouldeat.study.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserEntity {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private String email;
    private String rdt;

}
