package service;

import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Integer state=-1;
        String msg="";
        if (session!=null&&session.getAttribute("userinfo")!=null){
            session.setAttribute("userinfo",null);
            state=1;
        }

        HashMap<String,Object>hashMap=new HashMap<>();
        hashMap.put("state",state);
        hashMap.put("msg",msg);
        ResultJSONUtils.writeMap(resp, hashMap);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
