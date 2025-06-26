package org.example.web.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.User;
import org.example.service.UserService;
import org.example.web.utils.AdminWebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    @Description("系统->登录页面!")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "系统-登录页";
        resultMap.put("page_title", page_title);
        System.out.println("LoginController->index()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "login/index");
    }
    @RequestMapping("/in")
    @Description("系统->登录!")
    public ModelAndView in(HttpServletRequest request, HttpServletResponse response, @RequestParam("user_name") String user_name, @RequestParam("user_pwd") String user_pwd) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "系统-登录";
        Boolean page_result = true;
        User user = userService.queryByNameAndPwd(user_name, user_pwd);
        if(user == null){
            page_result = false;
        }else{
            AdminWebUtils.set_session_user_info(request, user);
        }
        resultMap.put("page_title", page_title);
        resultMap.put("page_result", page_result);
        resultMap.put("page_result_title", page_result ? "登录成功" : "登录失败, 用户名或密码错误！");
        System.out.println("LoginController->in()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "login/result");
    }
    @RequestMapping("/out")
    @Description("系统->退出!")
    public ModelAndView out(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "系统-退出";
        Boolean page_result = true;
        resultMap.put("page_title", page_title);
        resultMap.put("page_result", page_result);
        AdminWebUtils.remove_session_user_info(request);
        resultMap.put("page_result_title", "退出成功");
        System.out.println("LoginController->out()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "login/result");
    }
}
