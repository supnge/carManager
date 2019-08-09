package com.carManager.servlet;

import com.carManager.domain.TAdmin;
import com.carManager.service.TAdminService;
import com.carManager.service.impl.TAdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String userPw = request.getParameter("userPw");
        String userType = request.getParameter("userType");
        System.out.println("username:" + username + " userPw:" + userPw + " userType:" + userType);

        TAdminService tAdminService = new TAdminServiceImpl();

        TAdmin tAdmin = new TAdmin(username, userPw, userType);
        TAdmin admin;

        try {
            admin = tAdminService.adminLogin(tAdmin);
            System.out.println(admin == null);
            if (admin != null) {
                if (null == admin.getUsername()) {
                    response.getWriter().write("登录失败，3秒后返回登录页面");
                    response.setHeader("refresh", "3;url=" + request.getContextPath() + "/admin/login/login.jsp");
                } else {
                    request.getSession().setAttribute("loginUsername", admin.getUsername());
                    response.getWriter().write("登录成功，3秒后返回登录页面");
                    response.setHeader("refresh", "3;url=" + request.getContextPath() + "/admin/login/home.jsp");
                }
            }
            else {
                response.getWriter().write("登录失败，3秒后返回登录页面");
                response.setHeader("refresh", "3;url=" + request.getContextPath() + "/admin/login/login.jsp");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            request.setAttribute("exception", e);
            request.getRequestDispatcher("/admin/login/login.jsp").forward(request, response);
        }

    }
}
