package com.qfedu.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.common.JsonResult;
import com.qfedu.utils.StrUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //创建用户登陆变量
        Object loginUser = null;

        //获取浏览器访问的资源路径
        String requestURI = request.getRequestURI();

        if (requestURI.endsWith(".do")) {
            loginUser = request.getSession().getAttribute(StrUtils.LOGIN_USER);
        } else {
            loginUser = request.getSession().getAttribute("userAccount");
        }

//        Admin admin = (Admin) request.getSession().getAttribute(StrUtils.LOGIN_USER);
//        request.addResourceHandler("/**/index.html", "/")//设置哪些静态资源不缓存
//                .addResourceLocations("classpath:/static/")
//                .setCacheControl(CacheControl.noStore());//用 noStore 才起效


        if (loginUser == null) {

            //获取请求头，这里是ajax的请求头，ajax的请求头比较特殊
            String header = request.getHeader("X-Requested-With");
            //如果请求头的值不为空，且请求头的值是XMLHttpRequest，说明是ajax请求
            if (handler != null && handler.equals("XMLHttpRequest")) {
                //创建结果对象
                JsonResult jsonResult = new JsonResult(0, "未登录", 0, null);
                //手动转json格式
                ObjectMapper mapper = new ObjectMapper();
                String jsonInfo = mapper.writeValueAsString(jsonResult);
                response.getWriter().write(jsonInfo);
            } else {
                if (requestURI.endsWith(".do")) {
                    response.sendRedirect(request.getContextPath() + "/login.html");
                } else {
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                }
            }
            return false;
        } else {
            return true;
        }
    }
}
