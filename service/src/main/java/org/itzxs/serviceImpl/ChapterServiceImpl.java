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
        List<Book> books = bookMapper.selectAllBook();
        List<Chapter> chapters = new ArrayList<>();
        for (Book book:books) {
            GetChapter getChapter = new GetChapter();
            List<Chapter> chaptersByNovel = getChapter.getChapter(book.getId(),book.getBookUrl());
            chapters.addAll(chaptersByNovel);
        }
        System.out.println("爬取完毕");
//        chapterMapper.insertChapters(chapters);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("=============================开始插入=================="+simpleDateFormat.format(new Date()));
        //10个线程
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //一组500
        int MAX_DEAL = 500;
        int times = (chapters.size() + 1 + MAX_DEAL) / MAX_DEAL;
        //一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
        CountDownLatch countDownLatch = new CountDownLatch(times);
        try {
            for (int i = 0; i < times; i++) {
                System.out.println("开始批量插入"+i);
                if (i == times - 1) {
                    executor.execute(new UpdateChapterRunable(chapters.subList(i * MAX_DEAL, chapters.size()), countDownLatch));//调用业务逻辑
                } else {
                    executor.execute(new UpdateChapterRunable(chapters.subList(i * MAX_DEAL, (i + 1) * MAX_DEAL), countDownLatch));
                }
            }
            System.out.println("=============================结束插入=================="+simpleDateFormat.format(new Date()));
            countDownLatch.await();//一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
