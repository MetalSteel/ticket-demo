package com.ujeat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by MetalSteel on 2017/11/5.
 */
@Controller
public class IndexController {
    @GetMapping("/index")
    public String index() {
        return "/index";
    }
    @PostMapping("/post")
    public void  getVerifyImage(HttpServletResponse response, String title, String num,String nickname,String cinema,String movie,String date) throws IOException {
        // 生成图片
        TicketProcess tp = new TicketProcess();
        tp.generate(response.getOutputStream(),title,num,nickname,cinema,movie,date);
    }
}
