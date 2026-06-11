package com.demowechat;

import freemarker.template.*;

import java.io.*;
import java.util.*;

public class Test {


    public static void main(String[] args) throws Exception {

        // 1. 配置 FreeMarker
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setDirectoryForTemplateLoading(new File("templates")); // 模板目录
        cfg.setDefaultEncoding("UTF-8");

        // 2. 获取模板
        Template template = cfg.getTemplate("user.ftl");

        // 3. 构造数据模型（后端数据）
        Map<String, Object> user = new HashMap<>();
        user.put("name", "张三");
        user.put("age", 50);
        user.put("email", "zhangsan@gmail.com");
        user.put("showEmail", true);
        user.put("role", "admin");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("user", user);

        // 4. 输出文件
        Writer out = new FileWriter("output.html");

        // 5. 生成 HTML
        template.process(dataModel, out);

        out.close();

        System.out.println("HTML生成完成！");
    }
}
