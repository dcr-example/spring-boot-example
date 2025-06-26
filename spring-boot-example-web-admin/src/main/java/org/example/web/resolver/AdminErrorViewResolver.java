//package org.example.web.resolver.admin;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Map;
//
///**
// * 配置错误页面
// * */
//
//public class AdminErrorViewResolver implements ErrorViewResolver {
//    @Override
//    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
//        if (status == HttpStatus.NOT_FOUND) {
//            new ModelAndView("error/404");
//        } else if (status == HttpStatus.INTERNAL_SERVER_ERROR) {
//            new ModelAndView("error/400");
//        } else if (status == HttpStatus.BAD_REQUEST) {
//            new ModelAndView("error/500");
//        } else {
//            new ModelAndView("error/error"); // 默认错误页面
//        }
//        return null;
//    }
//}
