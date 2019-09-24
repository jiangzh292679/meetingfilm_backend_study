package com.mooc.meetingfilm.backend.common.backend.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.backend.common.BackendCommonApplicationTests;
import com.mooc.meetingfilm.backend.common.dao.entity.MoocBackendUserT;
import com.mooc.meetingfilm.backend.common.dao.mapper.MoocBackendUserTMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class UserTest extends BackendCommonApplicationTests {

    @Resource
    private MoocBackendUserTMapper backendUser;

    @Test
    public void add() {
        for(int i=0;i<5;i++){
            MoocBackendUserT user = new MoocBackendUserT();
            user.setUserName("admin"+i);
            user.setUserPwd("admin"+i);
            user.setUserPhone("1310000000"+i);

            backendUser.insert(user);
        }
    }

    @Test
    public void select() {
        // 根据主键查询
//        MoocBackendUserT moocBackendUserT = backendUser.selectById(2);
//        System.out.println("moocBackendUserT="+moocBackendUserT);

        // 查询列表
//        List<MoocBackendUserT> user = backendUser.selectList(null);
//        user.stream().forEach(
//                System.out::println
//        );

        // 查询列表带条件
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("user_name","admin");

        List<MoocBackendUserT> user = backendUser.selectList(wrapper);
        user.stream().forEach(
                System.out::println
        );
    }

    @Test
    public void selectByPage(){
        // 分页对象
        Page<MoocBackendUserT> page = new Page<>(1,3);
        // 条件
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("user_name","admin");

        IPage<MoocBackendUserT> iPage = backendUser.selectPage(page, wrapper);
        iPage.getRecords().stream().forEach(
                System.out::println
        );
    }

    @Test
    public void desribeUser(){
        MoocBackendUserT user = backendUser.describeUserByUserName("admin");
        System.out.println("user="+user);
    }

    @Test
    public void update(){
//        MoocBackendUserT user = new MoocBackendUserT();
//        user.setUuid(2);
//        user.setUserName("admin");
//        user.setUserPwd("jiangzh");
//        user.setUserPhone("18500000000");
//
//        // 根据主键修改
//        backendUser.updateById(user);

        // 根据条件修改
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_name","admin4");

        MoocBackendUserT user2 = new MoocBackendUserT();
        user2.setUserName("admin");
        user2.setUserPwd("jiangzh");
        user2.setUserPhone("18500000000");
        backendUser.update(user2, wrapper);
       // where user_name = 'admin4'

    }

    @Test
    public void del(){
        backendUser.deleteById(2);
    }

}
