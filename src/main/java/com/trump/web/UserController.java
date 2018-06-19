package com.trump.web;

import com.trump.config.Constant;
import com.trump.domain.PageBean;
import com.trump.domain.User;
import com.trump.domain.validate.LoginParam;
import com.trump.service.TestService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController()  // == @ResponseBody + @Controller
@Validated
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    TestService mTestService;

    //test session
    @GetMapping("/session")
    public String session(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return uid.toString();
    }

    @RequestMapping(value = "/validate1", method = RequestMethod.GET)
    public String testValidate1(@RequestParam String name) {
        return getCommonReturn_Success(name);
    }

    @RequestMapping("/validate2")
    public String testValidate2(@NotEmpty(message = "姓名不能为空") String name) {
        return getCommonReturn_Success(name);
    }

    @RequestMapping(value = "/testValidate3", method = RequestMethod.GET)
    public String testValidate3(@Validated LoginParam loginParam) {
        return getCommonReturn_Success(loginParam.toString());
    }

    /**
     * 登录操作
     **/
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        String userName = request.getParameter("name");
        String password = request.getParameter("pass");

        if (userName.equals("123") && password.equals("123")) {
            User user = new User(userName);
            request.getSession().setAttribute("user", user);
            map.put("result", "1");
        } else {
            map.put("errortip", "错误");
            map.put("result", "0");
        }
        return map;
    }

    @RequestMapping("/getUsers")
    public String getUsers(HttpServletRequest request,
                           @RequestParam(value = "page", defaultValue = Constant.PAGE_FROM_str) int page,
                           @RequestParam(value = "limit", defaultValue = Constant.PAGE_SIZE_str) int pageSize) {
        PageBean<User> pageBean = mTestService.getUsers(page, pageSize);
        return toJsonStr(pageBean);
    }

    @GetMapping("/getUsers2")
    public String getUsers2(HttpServletRequest request) {
        PageBean<User> pageBean = mTestService.getUsers2();
        return toJsonStr(pageBean);
    }


}
