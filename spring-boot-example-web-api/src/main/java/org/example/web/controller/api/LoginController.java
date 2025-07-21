package org.example.web.controller.api;

import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.example.model.User;
import org.example.service.UserService;
import org.example.web.utils.ApiResultCode;
import org.example.web.utils.ApiWebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final static Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    @Description("请登录!")
    public String index(HttpServletRequest request, HttpServletResponse response){
        log.info("{}->in()", this.getClass().getName());
        return  ApiWebUtils.write(ApiResultCode.ERR_NOT_LOGIN);
    }
    @PostMapping("/in")
    @Description("系统->登录!")
    public String in(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject dataJSONObject){
        log.info("{}->in()", this.getClass().getName());
        String user_name = null;
        String user_pwd = null;
        if(dataJSONObject != null){
            user_name = dataJSONObject.getString("user_name");
            user_pwd = dataJSONObject.getString("user_pwd");
        }
        if(StringUtils.isBlank(user_name) || StringUtils.isBlank(user_pwd) ){
            return  ApiWebUtils.write(ApiResultCode.ERR_LOGIN_ACC_PWD_NOT_NULL);
        }
        User user = userService.queryByNameAndPwd(user_name, user_pwd);
        if(user == null){
            return  ApiWebUtils.write(ApiResultCode.ERR_LOGIN_ACC_PWD_WRONG);
        }else{
            ApiWebUtils.set_session_user_info(request, user);
            return ApiWebUtils.write(ApiResultCode.SUC_LOGIN, user);
        }
    }
    @PostMapping("/out")
    @Description("系统->退出!")
    public String out(HttpServletRequest request, HttpServletResponse response) {
        log.info("{}->out()", this.getClass().getName());
        ApiWebUtils.remove_session_user_info(request);
        return  ApiWebUtils.write(ApiResultCode.SUC_LOGOUT);
    }
}
