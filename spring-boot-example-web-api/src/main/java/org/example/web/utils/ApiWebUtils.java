package org.example.web.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.User;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class ApiWebUtils {

    public static String writeSuccess(){
        return write(ApiResultCode.SUCCESS);
    }
    public static String writeSuccess(Object data){
        return write(ApiResultCode.SUCCESS, data, null);
    }
    public static String writeError(){
        return write(ApiResultCode.ERROR);
    }
    public static String writeError(String msg){
        return write(ApiResultCode.ERROR, msg);
    }
    public static String write(ApiResultCode resultCode){
        return JSON.toJSONString(new ApiResultData(resultCode, null, null));
    }
    public static String write(ApiResultCode resultCode, Object data){
        return JSON.toJSONString(new ApiResultData(resultCode, data, null));
    }
    public static String write(ApiResultCode resultCode, String msg){
        return JSON.toJSONString(new ApiResultData(resultCode, null, msg));
    }
    public static String write(ApiResultCode resultCode, Object data, String msg){
        return JSON.toJSONString(new ApiResultData(resultCode, data, msg));
    }

    public static final String SESSION_INFO = "session_info";
    public static final String SESSION_USER_INFO = "session_user_info";
    public static void set_session_user_info(HttpServletRequest request, User user){
        user.setUserPwd("");
        request.getSession().setAttribute(SESSION_USER_INFO, user);
    }
    public static void remove_session_user_info(HttpServletRequest request){
        request.getSession().removeAttribute(SESSION_USER_INFO);
    }
    public static User get_session_user_info(HttpServletRequest request){
        Object userObj = request.getSession().getAttribute(SESSION_USER_INFO);
        if(userObj != null){
            return (User) userObj;
        }
        return null;
    }
}
