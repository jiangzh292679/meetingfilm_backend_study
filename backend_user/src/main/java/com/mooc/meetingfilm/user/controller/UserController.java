package com.mooc.meetingfilm.user.controller;

import com.mooc.meetingfilm.user.controller.vo.LoginReqVO;
import com.mooc.meetingfilm.user.service.UserServiceAPI;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.user.controller
 * @description : 用户模块表现层
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceAPI serviceAPI;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResponseVO login(@RequestBody LoginReqVO reqVO) throws CommonServiceException {

        // 数据验证
        reqVO.checkParam();

        // 验证用户名和密码是否正确
        String userId = serviceAPI.checkUserLogin(reqVO.getUsername(),reqVO.getPassword());

        // randomKey  token
        Map<String,String> result = new HashMap<>();
        result.put("randomKey","");
        result.put("token","");

        return BaseResponseVO.success(result);
    }

}
