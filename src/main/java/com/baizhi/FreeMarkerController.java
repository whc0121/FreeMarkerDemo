package com.baizhi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class FreeMarkerController {
      @RequestMapping("/")
      public ModelAndView index(ModelAndView modelAndView){
          //map集合
          HashMap<String, Object> citys = new HashMap<>();
          citys.put("bj","北京");
          citys.put("sx","山西");

          modelAndView.addObject("citys",citys);
          //提供模板  底层完成模板+数据的组装  并且会将生成的文本输出响应会客户端
          modelAndView.setViewName("springfreemarker");
          return modelAndView;
      }
}
