package com.whatshouldeat.study;

import com.google.gson.Gson;
import com.mysql.cj.Session;
import com.whatshouldeat.study.model.NaverUserEntity;
import com.whatshouldeat.study.model.UserEntity;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;

import static java.lang.System.out;

@WebServlet("/naver/nlogin")
public class NaverLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/naver/nlogin.jsp").forward(req,res);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //패치로 보낸값 가져오기
        res.setContentType("text/html;charset=UTF-8");
        String json = MyUtils.getJson(req);
        Gson gson = new Gson();

        NaverUserEntity entity = gson.fromJson(json, NaverUserEntity.class);
        out.println(entity);
        //받은 값 데이터 용으로 포멧
        UserEntity userEntity = new UserEntity();
        userEntity.setNm(entity.getName());
        String uid = "naver_"+entity.getEmail().replace("@naver.com","");
        userEntity.setUid(uid);
        userEntity.setUpw("0");
        userEntity.setEmail(entity.getEmail());
        out.println(userEntity);
        //id가 등록되어있는지 확인
        UserEntity resultEntity = UserDAO.selChkNaver(userEntity);
        //id가 없으면 등록
        if(resultEntity==null){
            UserDAO.join(userEntity);
            resultEntity = UserDAO.selChkNaver(userEntity);
        }
        
        out.println("resultEntity : "+resultEntity);
        HttpSession session = req.getSession();
        session.setAttribute("loginUser",resultEntity);
        session.setAttribute("msg","메세지");

    }
}
