package org.example.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.web.utils.ApiWebUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ApiWebLoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 在Controller处理请求前执行。
     * 返回值控制请求是否继续处理（true继续，false终止）。
     * 典型应用：登录状态验证、权限校验。‌
     * */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("WebLoginHandlerInterceptor->preHandle()");
//        if(ApiWebUtils.get_session_user_info(request) == null){
//            response.sendRedirect("/login/index");
//            return false;
//        }
        return true;
    }

    /**
     * @Des 在Controller执行完成、视图渲染前执行。
     * 可修改ModelAndView对象。
     * 典型应用：统一添加响应参数。
     * */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("WebLoginHandlerInterceptor->postHandle()");


    }

    /**
     * 在视图渲染完成后执行。
     * 典型应用：线程本地变量清理、性能监控统计。
     * */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("WebLoginHandlerInterceptor->afterCompletion()");
    }
    
}
