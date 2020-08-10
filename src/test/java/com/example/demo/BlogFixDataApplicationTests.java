package com.example.demo;

import com.example.demo.model.Contents;
import com.example.demo.reposity.ContentsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BlogFixDataApplicationTests {

    @Autowired
    private ContentsMapper contentsMapper;

    @Test
    void contextLoads() throws IOException {
        List<Contents> result = contentsMapper.findAll();
        result.forEach(contents -> {
        File file = getFile(contents);
        try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(getContent(contents));
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private File getFile(Contents contents) {
        Long time = contents.getCreated().longValue();
        String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date(time * 1000));
        date = date.substring(0, 4);
        File packageFile = new File("/Users/dadaguo/Documents/GitHub_Blog/_posts/"+date);
        if (!packageFile.exists()) {
            packageFile.mkdir();
        }
        String fileName = getFileName(contents);
        return new File(packageFile,fileName);
    }

    private String getFileName(Contents contents) {

        Long time = contents.getCreated().longValue();
        String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date(time * 1000));
        String title = date + "-" + contents.getTitle() + ".md";
        return title;
    }


    public static String getHead(Contents contents) {
        String head="---\n" +
                "layout: post\n" +
                "title: 自定义spring.factories，实现自己的自动化装配\n" +
                "category:"+ contents.getCategories()+"\n" +
                "tags: ["+contents.getTags()+"]\n" +
                "keywords: "+contents.getTags()+"\n" +
                "---"+"\n";
        return head;
    }

    private String getContent(Contents contents) {
        return getHead(contents) +"#"+contents.getTitle()+"/n"+ contents.getContent();
    }

}
