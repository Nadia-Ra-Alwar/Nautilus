package com.rainmin.nautilus.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginApi
 */
@WebServlet("/login")
public class LoginApi extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginApi() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        System.out.println("execute doPost --->");
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        String result = "";
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        if (username != null && password != null) {
            System.out.println("username: " + username + ", password: " + password);
            if (username.equals("rainmin") && password.equals("123456")) {
                result = "{\"resultCode\":1,\"resultMes\":\"verify through\",\"data\":{\"token\":\"daf32da456hfdh\"}}";
            } else {
                result = "{\"resultCode\":2,\"resultMes\":\"username or password is wrong\",\"data\":{\"token\":\"\"}}";
            }
        } else {
            result = "{\"resultCode\":2,\"resultMes\":\"error\",\"token\":\"world\"}";
            System.out.println("username or password is null");
        }

        out.write(result);
        out.flush();
        out.close();
        System.out.println("doPost completed --->");
    }

}
