package com.mooc.meetingfilm.film.controller.vo;

import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.film.controller.vo
 * @description : 根据编号获取电影信息实体
 **/
@Data
public class DescribeFilmRespVO {

    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmCats;
    private String actors;
    private String imgAddress;

}
