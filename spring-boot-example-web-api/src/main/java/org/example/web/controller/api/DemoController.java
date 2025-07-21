package org.example.web.controller.api;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Demo;
import org.example.service.DemoService;
import org.example.web.utils.ApiResultCode;
import org.example.web.utils.ApiWebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final static Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;
    @GetMapping("/list")
    @Description("Demo->list页面!")
    public String list(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        return ApiWebUtils.writeSuccess(demoService.queryList(searchMap));
    }
    @GetMapping("/detail/{id}")
    @Description("Demo->detail页面!")
    public String detail(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        log.debug("{}->detail()", this.getClass().getName());
        return ApiWebUtils.writeSuccess(demoService.queryById(id));
    }

    @PostMapping("/save")
    @Description("Demo->save页面!")
    public String save(HttpServletRequest request, HttpServletResponse response) {
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
        log.debug("{}->save()", this.getClass().getName());

        if(page_result){
            return ApiWebUtils.write(ApiResultCode.SUC_SAVE);
        }else{
            return ApiWebUtils.write(ApiResultCode.ERR_SAVE);
        }
    }
    @PostMapping("/remove/{id}")
    @Description("Demo->remove页面!")
    public String remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {
        Boolean page_result = true;

        try {
            demoService.remove(id);
        }catch (Exception e){
            page_result = false;
            e.printStackTrace();
        }
        log.debug("{}->remove()", this.getClass().getName());
        if(page_result){
            return ApiWebUtils.write(ApiResultCode.ERR_DELETE);
        }else{
            return ApiWebUtils.write(ApiResultCode.ERR_DELETE);
        }
    }

}
