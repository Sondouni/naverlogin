package com.whatshouldeat.study;

import com.whatshouldeat.study.search.SearchDTO;
import com.whatshouldeat.study.searchImg.SearchImgVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/naver/searchimg")
public class SearchImgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String searchStr = req.getParameter("searchText");
        List<SearchImgVO> list = null;
        MySerachImgApiUtils mySerachImgApiUtils = new MySerachImgApiUtils();
        if(searchStr!=null){
            list =  mySerachImgApiUtils.searchPlace(searchStr);
        }
        req.setAttribute("data",list);
        req.getRequestDispatcher("/WEB-INF/view/naver/searchimg.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
