package org.example.web.controller.admin;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Demo;
import org.example.service.DemoService;
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
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;
    @RequestMapping("/list")
    @Description("Demo->list页面!")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "示例-列表页";
        resultMap.put("page_title", page_title);

        resultMap.put("dataList", demoService.queryList(resultMap));

        System.out.println("DemoController->list()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "demo/list");
    }
    @RequestMapping("/detail/{id}")
    @Description("Demo->detail页面!")
    public ModelAndView detail(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "示例-详情页";
        resultMap.put("page_title", page_title);
        resultMap.put("dataObject", demoService.queryById(id));
        System.out.println("DemoController->detail()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "demo/detail");
    }

    @RequestMapping("/add")
    @Description("Demo->add页面!")
    public ModelAndView add_index(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "示例-新增页面";
        resultMap.put("page_title", page_title);
        System.out.println("DemoController->add()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "demo/add");
    }
    @RequestMapping("/save")
    @Description("Demo->save页面!")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "示例-操作结果页面";
        Boolean page_result = true;

        String name = request.getParameter("name");
        String age_str = request.getParameter("age");
        Integer age = Integer.valueOf(age_str);
        Demo demo = new Demo(name, age);
        try {
            demoService.add(demo);
        }catch (Exception e){
            page_result = false;
            e.printStackTrace();
        }
        resultMap.put("page_title", page_title);
        resultMap.put("page_result", page_result);
        resultMap.put("page_result_title", page_result ? "操作成功" : "操作失败");
        System.out.println("DemoController->save()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "demo/result");
    }
    @RequestMapping("/remove/{id}")
    @Description("Demo->remove页面!")
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String page_title = "示例-操作结果页面";
        Boolean page_result = true;

        try {
            demoService.remove(id);
        }catch (Exception e){
            page_result = false;
            e.printStackTrace();
        }
        resultMap.put("page_title", page_title);
        resultMap.put("page_result", page_result);
        resultMap.put("page_result_title", page_result ? "操作成功" : "操作失败");
        System.out.println("DemoController->remove()");
        return AdminWebUtils.getModelAndView(request, response, resultMap, "demo/result");
    }



}
