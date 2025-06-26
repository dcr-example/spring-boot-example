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

public class AdminWebUtils {
    static final String SYSTEM_CURRENT_TIME_MILLIS = "systemCurrentTimeMillis";
    static final String SYSTEM_CURRENT_DATE_TIME = "systemCurrentDateTime";
    public static ModelAndView getModelAndView(HttpServletRequest request, HttpServletResponse response, Map<String, Object> resultMap, String viewName){

        Date nowTime = new Date();
        resultMap.put(SYSTEM_CURRENT_DATE_TIME, nowTime);
        resultMap.put(SYSTEM_CURRENT_TIME_MILLIS, nowTime.getTime());
        ModelAndView modelAndView = new ModelAndView(viewName, resultMap);
        return modelAndView;
    }


    public static void write(HttpServletResponse response, JSONObject bean){
        String result = JSON.toJSONString(bean);
        try {
            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().print(SecureUtil.encode_moble(result, key, iv));
            response.getWriter().print(result);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static HttpSession get_session_info(HttpServletRequest request){
        return request.getSession();
    }
    public static User get_session_user_info(HttpServletRequest request){
        Object userObj = request.getSession().getAttribute(SESSION_USER_INFO);
        if(userObj != null){
            return (User) userObj;
        }
        return null;
    }
}
