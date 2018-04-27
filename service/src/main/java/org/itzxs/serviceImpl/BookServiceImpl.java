package org.itzxs.serviceImpl;

import org.itzxs.dao.BookMapper;
import org.itzxs.dao.ChapterMapper;
import org.itzxs.dto.ChapterDTO;
import org.itzxs.entity.Book;
import org.itzxs.entity.Chapter;
import org.itzxs.service.BookService;
import org.itzxs.util.Spider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Itzxs on 2018/4/23.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    ChapterMapper chapterMapper;

    @Override
    public void addBook(String url){
        try{
            /*Spider spider = new Spider();
            List<ChapterDTO> list = spider.getChapter("http://www.biquge.tw/0_5/");
            List<Chapter> chapters = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Chapter chapter = spider.getChapterText(list.get(i).getUrl());
                File file = new File("F:/novel/"+chapter.getBookChapterName()+".txt");
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file);
                String countText = chapter.getBookChapterContent();
                countText = countText.replace("<br>","\n");
                countText = countText.replace("&nbsp;"," ");
                fileWriter.write(countText);
                fileWriter.flush();
                fileWriter.close();
                chapter.setBookChapterContent(file.getPath());
                chapters.add(chapter);
            }*/
            Spider spider = new Spider();
            List<Chapter> chapters = new ArrayList<>();
            List<Map<String,String>> list = spider.getFiles("F:/novel/");
            for (int i = 0; i < list.size(); i++) {
                Chapter chapter = new Chapter(1,list.get(i).get("name"),list.get(i).get("path"));
                chapters.add(chapter);
                chapterMapper.insert(chapter);
            }
            chapterMapper.insertChapters(chapters);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
