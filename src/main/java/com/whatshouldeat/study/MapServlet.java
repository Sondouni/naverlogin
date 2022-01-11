package com.whatshouldeat.study;

import com.whatshouldeat.study.search.SearchDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/naver/map")
public class MapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        SearchDTO dto = new SearchDTO();
        dto.setTitle(req.getParameter("title"));
        dto.setMapx(Integer.parseInt(req.getParameter("mapx")));
        dto.setMapy(Integer.parseInt(req.getParameter("mapy")));
        req.setAttribute("search",dto);
        req.getRequestDispatcher("/WEB-INF/view/naver/map.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
