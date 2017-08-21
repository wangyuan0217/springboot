package com.trump.controller;

import com.trump.config.Constant;
import com.trump.domain.PageBean;
import com.trump.domain.User;
import com.trump.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
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
        String userName = request.getParameter("name");
        String password = request.getParameter("pass");

        if (!userName.equals("") && password != "") {
            User user = new User(userName);
            request.getSession().setAttribute("user", user);
            map.put("result", "1");
        } else {
            map.put("result", "0");
        }
        return map;
    }

    @RequestMapping("/getUsers")
    public String getUsers(HttpServletRequest request,
                           @RequestParam(value = "pageNumber", defaultValue = "0") int page,
                           @RequestParam(value = "pageSize", required = false, defaultValue = Constant.PAGE_SIZE + "") int pageSize) {

        PageBean<User> pageBean = mTestService.getUsers(page, pageSize);
        return toJsonStr(pageBean);
    }


}
