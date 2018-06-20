package org.itzxs.serviceImpl;

import org.itzxs.dao.BookMapper;
import org.itzxs.dao.ChapterMapper;
import org.itzxs.entity.Book;
import org.itzxs.entity.Chapter;
import org.itzxs.service.ChapterService;
import org.itzxs.util.GetChapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Itzxs on 2018/6/6.
 */
@Service
public class ChapterServiceImpl implements ChapterService{

    @Autowired
    BookMapper bookMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Override
    public boolean updateChapter(){
        chapterMapper.deleteAll();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
        List<Book> books = bookMapper.selectAllBook();
        List<Chapter> chapters = new ArrayList<>();
        for (int i= 0;i< books.size();i++) {
            GetChapter getChapter = new GetChapter();
            List<Chapter> chaptersByNovel = getChapter.getChapter(books.get(i).getId(),books.get(i).getBookUrl());
            chapters.addAll(chaptersByNovel);
            chapterMapper.insertChapters(chaptersByNovel);
        }
        System.out.println("爬取完毕");
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println(chapters.size());
        /*int chapterSize = chapters.size();
        int range = 500;
        int loopTimes = chapterSize / range;
        int lastIndex = chapterSize-1;
        for (int i = 0;i< loopTimes;i++){
            int startIndex = range * i;
            int endIndex = startIndex +range;
            List<Chapter> insertChapters =
            (i == loopTimes-1 && endIndex!= lastIndex)? chapters.subList(startIndex, lastIndex):chapters.subList(startIndex, endIndex);
            chapterMapper.insertChapters(insertChapters);
        }*/
        return true;
    }
}
