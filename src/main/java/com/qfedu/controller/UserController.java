package com.qfedu.controller;


import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login.do")// query  login
    @ResponseBody
    public JsonResult findOne(Integer idCard, Integer password, HttpSession session) {

        User user = userService.findOne(idCard);

        JsonResult jsonResult = null;

        if (user == null) {

            jsonResult = new JsonResult(1, "账号不存在,请先注册", 0, null);

        } else if (!user.getPassword().equals(password.toString())) {

            if (user.getWrongNum() <= 3) {

                Integer wrongNum = user.getWrongNum() + 1;
                userService.updateWrongNum(idCard, wrongNum);
                jsonResult = new JsonResult(2, "账号或密码不正确", 0, null);
            } else {
                jsonResult = new JsonResult(2, "账号已冻结", 0, null);
            }

        } else {
            jsonResult = new JsonResult(0, "登陆成功", 0, user);

            session.setAttribute("login_user", user);
        }
        return jsonResult;
    }

    @RequestMapping("/query.do")
    @ResponseBody
    public JsonResult getLoginInfo(HttpSession session) {

        User user = (User) session.getAttribute("login_user");

        JsonResult jsonResult = new JsonResult(0, null, 0, user);

        return jsonResult;
    }

    @RequestMapping("/logout.do")
    public String outLogin(HttpSession session) {
        session.removeAttribute(StrUtils.LOGIN_USER);
        return "redirect:/login.html";
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public JsonResult addUser(User user) {
        userService.addUser(user);
        return new JsonResult(0, "注册成功", 0, user);
    }
}
