package com.mooc.meetingfilm.backend.common.dao.mapper;

import com.mooc.meetingfilm.backend.common.dao.entity.MoocBackendUserT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface MoocBackendUserTMapper extends BaseMapper<MoocBackendUserT> {

    MoocBackendUserT describeUserByUserName(@Param("username") String username);

}
