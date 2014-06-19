package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class StartController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 处理Request请求
        System.out.println("[INFO]Controller is working!");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("start");
        return mv;
    }

}
