package com.whatshouldeat.study;

import com.whatshouldeat.study.restaurant.ICRestaurantVO;
import com.whatshouldeat.study.restaurant.IMBodyVO;
import com.whatshouldeat.study.restaurant.ServerCon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/naver/main2")
public class Main2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServerCon.getConnect("https://tour.chungbuk.go.kr/").getICMJList().enqueue(new Callback<IMBodyVO>() {
            @Override
            public void onResponse(Call<IMBodyVO> call, Response<IMBodyVO> response) {
                if (response.isSuccessful()){
                    System.out.println("성공");
                    IMBodyVO vo = response.body();
                    List<ICRestaurantVO> list = vo.getResult();
                    for(ICRestaurantVO rvo : list){
                        System.out.println(rvo);
                    }
                }
                System.out.println("실패1");
            }

            @Override
            public void onFailure(Call<IMBodyVO> call, Throwable throwable) {
                System.out.println("실패2");
            }
        });
        System.out.println("?");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
