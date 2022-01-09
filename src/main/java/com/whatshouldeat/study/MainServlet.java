package com.whatshouldeat.study;

import com.google.gson.Gson;
import com.whatshouldeat.study.restaurant.DMBodyVO;
import com.whatshouldeat.study.restaurant.RestaurantVO;
import com.whatshouldeat.study.restaurant.ServerCon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@WebServlet("/naver/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        /*
        ServerCon.getConnect("https://www.daegufood.go.kr/").getRestList().enqueue(new Callback<DMBodyVO>() {
            @Override
            public void onResponse(Call<DMBodyVO> call, Response<DMBodyVO> response) {
                if(response.isSuccessful()){
                    System.out.println("성공");
                    DMBodyVO dmVO = response.body();
                    List<RestaurantVO> list= dmVO.getData();
                    for(RestaurantVO vo : list){
                        System.out.println(vo);
                    }
                }
                System.out.println("실패2");
            }

            @Override
            public void onFailure(Call<DMBodyVO> call, Throwable throwable) {
                System.out.println("실패");
            }
        });
        System.out.println("?");
         */
        BufferedReader br = null;
        try {
            String urlStr = "https://www.daegufood.go.kr/kor/api/tasty.html?mode=json&addr=%EC%A4%91%EA%B5%AC";
            URL url = new URL(urlStr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            String result = "";
            String line;
            while ((line=br.readLine())!=null){
                result = result+line+"\n";
            }
            System.out.println(result);
            Gson gson = new Gson();
            DMBodyVO vo = gson.fromJson(result,DMBodyVO.class);
            for(RestaurantVO rvo : vo.getData() ){
                System.out.println(rvo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/WEB-INF/view/naver/main.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
