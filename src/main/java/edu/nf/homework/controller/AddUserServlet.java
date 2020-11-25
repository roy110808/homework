package edu.nf.homework.controller;

import com.google.gson.Gson;
import edu.nf.homework.entity.Users;
import edu.nf.homework.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author roy
 */
@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        Integer age=Integer.valueOf(req.getParameter("age"));
        String tel=req.getParameter("tel");
        UserService service=new UserService();
        Users users=new Users();
        users.setUname(name);
        users.setAge(age);
        users.setTel(tel);
        try{
            service.addUsers(users);
            String json=new Gson().toJson(200);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().println(json);
        }catch (RuntimeException e){
            e.fillInStackTrace();
            String json=new Gson().toJson(500);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().println(json);
        }

    }
}
