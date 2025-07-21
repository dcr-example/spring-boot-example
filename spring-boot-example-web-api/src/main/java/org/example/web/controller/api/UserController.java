package org.example.web.controller.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.User;
import org.example.service.UserService;
import org.example.web.utils.ApiResultCode;
import org.example.web.utils.ApiWebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/read")
    @Description("读取用户信息!")
    public String read(HttpServletRequest request, HttpServletResponse response){
        log.info("{}->in()", this.getClass().getName());
        User user = ApiWebUtils.get_session_user_info(request);
        if(user == null){
            return  ApiWebUtils.write(ApiResultCode.ERR_NOT_LOGIN);
        }
        return  ApiWebUtils.write(ApiResultCode.SUCCESS, user);
    }
}
