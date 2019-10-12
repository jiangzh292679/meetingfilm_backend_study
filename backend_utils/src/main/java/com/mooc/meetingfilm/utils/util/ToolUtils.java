package com.mooc.meetingfilm.utils.util;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.utils.util
 * @description : 基础工具类
 **/
public class ToolUtils {

    private ToolUtils(){}

    /**
    * @Description: 字符串为空
    * @Param: [str]
    * @return: boolean
    * @Author: jiangzh
    */
    public static boolean strIsNull(String str){
        if(str == null || str.trim().length() == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @Description: 字符串不为空
     * @Param: [str]
     * @return: boolean
     * @Author: jiangzh
     */
    public static boolean strIsNotNul(String str){
        if(strIsNull(str)){
            return false;
        }else{
            return true;
        }
    }

}
