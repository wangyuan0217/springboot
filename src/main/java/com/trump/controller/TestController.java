package com.trump.controller;

import com.trump.domain.LearnResouce;
import com.trump.domain.Resume;
import com.trump.domain.User;
import com.trump.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping(value = "/test")
public class TestController extends BaseController {

    @Autowired
    TestService mTestService;

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot";
    }

    /**
     * 登录操作
     **/
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (!userName.equals("") && password != "") {
            User user = new User(userName, password);
            request.getSession().setAttribute("user", user);
            map.put("result", "1");
        } else {
            map.put("result", "0");
        }
        return map;
    }

    @RequestMapping("/learn")
    public ModelAndView learn() {
        List<LearnResouce> learnList = new ArrayList<>();
        LearnResouce bean = new LearnResouce("官方参考文档", "Spring Boot Reference Guide", "http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application");
        learnList.add(bean);
        bean = new LearnResouce("官方SpriongBoot例子", "官方SpriongBoot例子", "https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples");
        learnList.add(bean);
        bean = new LearnResouce("龙国学院", "Spring Boot 教程系列学习", "http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean = new LearnResouce("嘟嘟MD独立博客", "Spring Boot干货系列 ", "http://tengj.top/");
        learnList.add(bean);
        bean = new LearnResouce("后端编程嘟", "Spring Boot教程和视频 ", "http://www.toutiao.com/m1559096720023553/");
        learnList.add(bean);
        bean = new LearnResouce("程序猿DD", "Spring Boot系列", "http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean = new LearnResouce("纯洁的微笑", "Sping Boot系列文章", "http://www.ityouknow.com/spring-boot");
        learnList.add(bean);
        bean = new LearnResouce("CSDN——小当博客专栏", "Sping Boot学习", "http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean = new LearnResouce("梁桂钊的博客", "Spring Boot 揭秘与实战", "http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean = new LearnResouce("林祥纤博客系列", "从零开始学Spring Boot ", "http://412887952-qq-com.iteye.com/category/356333");
        learnList.add(bean);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }


    @RequestMapping("/getResumeByUid")
    @ResponseBody
    public String getResumeByUid(HttpServletRequest request, HttpServletResponse response) {
        String uid = getParameter(request, "uid");
        Resume resume = mTestService.getResumeByUid(uid);
        return getCommonReturn(200, "success", resume);
    }


    @Autowired
    private JdbcTemplate mJdbcTemplate;

    @RequestMapping("/getResumeByUid2")
    @ResponseBody
    public String getResumeByUid2(HttpServletRequest request, HttpServletResponse response) {
        String uid = getParameter(request, "uid");

        String sql = "select * from rc_resume where uid = ?";
        RowMapper<Resume> rowMapper = new BeanPropertyRowMapper<>(Resume.class);
        Resume resume = mJdbcTemplate.queryForObject(sql, rowMapper, uid);

        return getCommonReturn(200, "success", resume);
    }


}
