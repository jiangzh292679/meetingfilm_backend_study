package com.mooc.meetingfilm.hall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.meetingfilm.hall.controller.vo.HallSavedReqVO;
import com.mooc.meetingfilm.hall.controller.vo.HallsReqVO;
import com.mooc.meetingfilm.hall.controller.vo.HallsRespVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import org.springframework.stereotype.Service;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.hall.service
 * @description :
 **/
@Service
public class HallServiceImpl implements HallServiceAPI{
    @Override
    public IPage<HallsRespVO> describeHalls(HallsReqVO hallsReqVO) throws CommonServiceException {
        return null;
    }

    @Override
    public void saveHall(HallSavedReqVO hallSavedReqVO) throws CommonServiceException {

    }
}
