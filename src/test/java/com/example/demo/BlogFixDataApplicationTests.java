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
import java.util.List;

@SpringBootTest
class BlogFixDataApplicationTests {

    @Autowired
    private ContentsMapper contentsMapper;




    @Test
    void contextLoads() throws IOException {
        List<Contents> result = contentsMapper.findAll();
//        result.stream().map(contents -> {
//            String article="#"+contents.getTitle() + "/n" + contents.getContent();
//
//        });
        String article = "#" + result.get(1).getTitle() + "/n" + result.get(1).getContent();
        File file = new File(result.get(1).getTitle()+".md");
        String head = getHead(result.get(1));
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(head+article);
        fileWriter.close();
        System.out.println("#"+result.get(1).getTitle()+"/n"+result.get(1).getContent());
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

}
