package org.itzxs.serviceImpl;

import org.itzxs.dao.BookMapper;
import org.itzxs.dao.ChapterMapper;
import org.itzxs.dto.ChapterDTO;
import org.itzxs.entity.Book;
import org.itzxs.entity.Chapter;
import org.itzxs.service.BookService;
import org.itzxs.util.GetBQGNovel;
import org.itzxs.util.Spider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Itzxs on 2018/4/23.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    BookMapper bookMapper;
    /*@Override
    public void addBook(String url){
        try{
            *//*Spider spider = new Spider();
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
            }*//*
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
    }*/

    /**
     * 首页热点小说
     * @return
     */
    @Override
    public boolean addHotBook(){
        GetBQGNovel getBQGNovel = new GetBQGNovel();
        List<Book> books = getBQGNovel.getHotNovle("http://www.biquge.com.tw/");
        List<Integer> ids = bookMapper.selectIdByLevel(1);
        if(books.size() == ids.size()){
            for (int i = 0; i < ids.size(); i++) {
                books.get(i).setId(ids.get(i));
                books.get(i).setModifyDate(new Date());
            }
            int num = bookMapper.updateBooks(books);
            if(num <= 0){
                return false;
            }
        }else{
            System.out.println("爬取的网站格式修改，需要重新编写代码");
            return false;
        }
        return true;
    }

    /**
     * 首页每个模块的热点小说
     * @return
     */
    @Override
    public boolean addEveryModelHotBook(){
        GetBQGNovel getBQGNovel = new GetBQGNovel();
        List<Book> books = getBQGNovel.getEveryModelHotNovel("http://www.biquge.com.tw/");
        List<Integer> ids = bookMapper.selectIdByLevel(2);
        if(books.size() == ids.size()){
            for (int i = 0; i < ids.size(); i++) {
                books.get(i).setId(ids.get(i));
                books.get(i).setModifyDate(new Date());
            }
            int num = bookMapper.updateBooks(books);
            if(num <= 0){
                return false;
            }
        }else{
            System.out.println("爬取的网站格式修改，需要重新编写代码");
            return false;
        }
        return true;
    }

    /**
     * 首页每个模块的小说
     * @return
     */
    @Override
    public boolean addEveryModelBook(){
        GetBQGNovel getBQGNovel = new GetBQGNovel();
        List<Book> books = getBQGNovel.getEveryModelNovel("http://www.biquge.com.tw/");
        List<Integer> ids = bookMapper.selectIdByLevel(3);
        if(books.size() == ids.size()){
            for (int i = 0; i < ids.size(); i++) {
                books.get(i).setId(ids.get(i));
                books.get(i).setModifyDate(new Date());
            }
            int num = bookMapper.updateBooks(books);
            if(num <= 0){
                return false;
            }
        }else{
            System.out.println("爬取的网站格式修改，需要重新编写代码");
            return false;
        }
        return true;
    }

    /**
     * 每个模块的热点小说
     * @param url
     * @param type
     * @return
     */
    @Override
    public boolean addHotABookByModel(String url,int type){
        GetBQGNovel getBQGNovel = new GetBQGNovel();
        List<Book> books = getBQGNovel.getHotNovelByModel(url);
        List<Integer> ids = bookMapper.selectIdByLevelAndType(4,type);
        if(books.size() == ids.size()){
            for (int i = 0; i < ids.size(); i++) {
                books.get(i).setId(ids.get(i));
                books.get(i).setModifyDate(new Date());
            }
            int num = bookMapper.updateBooks(books);
            if(num <= 0){
                return false;
            }
        }else{
            System.out.println("爬取的网站格式修改，需要重新编写代码");
            return false;
        }
        return true;
    }

    @Override
    public boolean addBookByModel(String url,int type){
        GetBQGNovel getBQGNovel = new GetBQGNovel();
        List<Book> books = getBQGNovel.getNovelByModel(url,type);
        List<Integer> ids = bookMapper.selectIdByLevelAndType(5,type);
        if(books.size() == ids.size()){
            for (int i = 0; i < ids.size(); i++) {
                books.get(i).setId(ids.get(i));
                books.get(i).setModifyDate(new Date());
            }
            int num = bookMapper.updateBooks(books);
            if(num <= 0){
                return false;
            }
        }else{
            System.out.println("爬取的网站格式修改，需要重新编写代码");
            return false;
        }
        return true;
    }

    public List<Book> getBooks(){
        return bookMapper.selectAllBook();
    }

    @Override
    public List<Book> getBookByCategroy(int categroy){
        return bookMapper.selectByType(categroy);
    }
}
