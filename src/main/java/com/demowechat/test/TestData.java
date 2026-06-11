package com.demowechat.test;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class TestData {

    //压缩
    public static void compressed() throws Exception{
        //拿到文件输入流
        FileInputStream fileInputStream=new FileInputStream("C:/Users/Administrator/Desktop/壁报.ppt");

        //创建zip输出流
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("C:/Users/Administrator/Desktop/test.zip"));

        //创建zip条目
        zipOutputStream.putNextEntry(new ZipEntry("test/壁报.ppt"));

        //写入数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            zipOutputStream.write(buffer, 0, len);
        }
        //完成当前 ZIP 条目的写入,准备下一个文件,每个 putNextEntry() 之后都应该有对应的 closeEntry()
        zipOutputStream.closeEntry();



        //关闭zip输出流
        zipOutputStream.close();
        //关闭文件输入流
        fileInputStream.close();
    }

    //解压
    public static void uncompressed() throws Exception {

        String zipPath = "C:/Users/Administrator/Desktop/test.zip";
        String outDir = "C:/Users/Administrator/Desktop/";

        ZipFile zipFile = new ZipFile(zipPath, Charset.forName("GBK"));

        zipFile.stream().forEach(entry -> {

            try {
                String outPath = outDir + entry.getName();
                File file = new File(outPath);
                System.out.println(entry.getName());

                //如果是目录就创建目录
                if (entry.isDirectory()) {
                    file.mkdirs();
                    return;
                }

                //防止偷懒的 ZIP 文件(直接存的带有路径的文件.但是又没有文件夹)
                File parent = file.getParentFile();
                if (parent != null && !parent.exists()) {
                    parent.mkdirs();
                }

                // 获取文件条目并写入 文件
                try (InputStream is = zipFile.getInputStream(entry); FileOutputStream fos = new FileOutputStream(file)) {

                    byte[] buffer = new byte[1024];
                    int len;

                    while ((len = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        zipFile.close();
    }


    //模版生成
    public static void freeMarker() throws Exception{

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
        Writer out = new FileWriter("out/output.html");

        // 5. 生成 HTML
        template.process(dataModel, out);

        out.close();

        System.out.println("HTML生成完成！");
    }

    public static void main(String[] args) throws  Exception{
        freeMarker();
    }


}
