package com.web3n.community.controller;

import com.web3n.community.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @create 2020-03-17 9:27
 */
@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private DemoService demoService;
    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return demoService.find();
    }
    @RequestMapping("/http")
    public void http(HttpServletRequest req, HttpServletResponse res){
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            String header = req.getHeader(s);
            System.out.println(s + ": " + header);
        }
        res.setContentType("text/html;charset=utf-8");
        try ( PrintWriter writer = res.getWriter()){
           writer.write("<h1> 100 <h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
    @GetMapping("/students")
    @ResponseBody
    public String getStudents(){
        return "some students";
    }
    // 获取 html 模板
    @GetMapping("/teacher")
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "张三");
        mav.addObject("age", 30);
        mav.setViewName("/demo/view");
        return mav;
    }
    // 同上面的方法一样的功能和结果 获取 html 模板
    @GetMapping("/teachers")
    public String getTeachers(Model model) {
        model.addAttribute("name", "张三");
        model.addAttribute("age", 300);
        return "/demo/view";
    }
    // 响应 JSON 数据
    @GetMapping("/json")
    @ResponseBody
    public Map<Object, Object> getJson() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 300);
        return map;
    }
    // 响应 JSON 数据
    @GetMapping("/jsonLs")
    @ResponseBody
    public List<Map<Object, Object>> getJsonLs() {
        List<Map<Object, Object>> list = new ArrayList<>();
        HashMap<Object, Object> map1 = new HashMap<>();
        map1.put("name", "张三");
        map1.put("age", 300);
        HashMap<Object, Object> map2 = new HashMap<>();
        map2.put("name", "李四");
        map2.put("age", 0);
        list.add(map1);
        list.add(map2);
        return list;
    }
}
