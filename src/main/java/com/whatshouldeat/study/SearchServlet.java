package com.whatshouldeat.study;

import com.whatshouldeat.study.search.SearchDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/naver/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String searchStr = req.getParameter("searchText");
        List<SearchDTO> list = null;
        MySerachApiUtils mySerachApiUtils = new MySerachApiUtils();
        if(searchStr!=null){
            list =  mySerachApiUtils.searchPlace(searchStr);
        }
        req.setAttribute("data",list);
        req.getRequestDispatcher("/WEB-INF/view/naver/search.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
