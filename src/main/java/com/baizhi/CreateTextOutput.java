package com.baizhi;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CreateTextOutput {
    /**
     * 组装 模板+数据
     * @param args
     */
    public static void main(String[] args) throws IOException, TemplateException {
        //数据使用map集合进行封装
        Map<String,Object> dataModel = new HashMap<>();
        //1.普通类型
        dataModel.put("username","小白菜");
        //2.封装对象类型
        dataModel.put("user",new User(1,"李四"));
        //3.封装集合
        List<String> list = Arrays.asList("苹果", "香蕉", "桔子");
        dataModel.put("fruit",list);
        //4.map集合
        HashMap<String, Object> citys = new HashMap<>();
        citys.put("bj","北京");
        citys.put("sx","山西");
        dataModel.put("citys",citys);
        //5.日期类型
        dataModel.put("date",new Date());
        //6.空值的处理
        dataModel.put("sex",null);
        //组装
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        //指定默认编码格式
        configuration.setDefaultEncoding("utf-8");
        //指定模板加载目录
        configuration.setDirectoryForTemplateLoading(
                new File("E:\\IdeaWorkSpace\\SpringBootDemo\\freemarkerdemo\\src\\main\\resources\\templates"));
        //获取模板
        Template template = configuration.getTemplate("index.html");
        //处理 加工  参数二：文本输出
        template.process(dataModel,new FileWriter("E:\\index.html"));
    }
}
