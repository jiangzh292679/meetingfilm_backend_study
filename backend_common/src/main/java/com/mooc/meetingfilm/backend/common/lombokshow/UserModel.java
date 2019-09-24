package com.mooc.meetingfilm.backend.common.lombokshow;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {

    public UserModel(){}

    private String id;
    private String username;
    private String userpasswd;

}
