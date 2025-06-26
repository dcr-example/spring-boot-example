package org.example.web.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.web.utils.AdminWebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final static Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {

        log.trace("demo日志级别：trace！");
        log.debug("demo日志级别：debug！");
        log.info("demo日志级别：info！");
        log.warn("demo日志级别：warn！");
        log.error("demo日志级别：error！");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        System.out.println("HomeController->list()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "home/index");
    }
}
