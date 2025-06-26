package org.example.web.controller.admin;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.User;
import org.example.service.UserService;
import org.example.web.utils.AdminWebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @Description("User->list页面!")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "用户-列表页";
        resultMap.put("page_title", page_title);

        resultMap.put("dataList", userService.queryList(resultMap));

        System.out.println("UserController->list()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "user/list");
    }
    @RequestMapping("/detail/{id}")
    @Description("User->detail页面!")
    public ModelAndView detail(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "用户-详情页";
        resultMap.put("page_title", page_title);
        resultMap.put("dataObject", userService.queryById(id));
        System.out.println("UserController->detail()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "user/detail");
    }

    @RequestMapping("/add")
    @Description("User->add页面!")
    public ModelAndView add_index(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "用户-新增页面";
        resultMap.put("page_title", page_title);
        System.out.println("UserController->add()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "user/add");
    }
    @RequestMapping("/save")
    @Description("User->save页面!")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "用户-操作结果页面";
        Boolean page_result = true;

        String nickName = request.getParameter("nick_name");
        String userName = request.getParameter("user_name");
        String userPwd = request.getParameter("user_pwd");
        User user = new User(nickName, userName, userPwd);
        try {
            userService.add(user);
        }catch (Exception e){
            page_result = false;
            e.printStackTrace();
        }
        resultMap.put("page_title", page_title);
        resultMap.put("page_result", page_result);
        resultMap.put("page_result_title", page_result ? "操作成功" : "操作失败");
        System.out.println("UserController->save()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "user/result");
    }
    @RequestMapping("/remove/{id}")
    @Description("User->remove页面!")
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "用户-操作结果页面";
        Boolean page_result = true;
        try {
            userService.remove(id);
        }catch (Exception e){
            page_result = false;
            e.printStackTrace();
        }
        resultMap.put("page_title", page_title);
        resultMap.put("page_result", page_result);
        resultMap.put("page_result_title", page_result ? "操作成功" : "操作失败");
        System.out.println("UserController->remove()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "user/result");
    }



}
