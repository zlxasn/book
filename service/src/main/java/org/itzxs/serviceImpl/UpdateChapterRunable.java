package org.itzxs.serviceImpl;

import org.itzxs.dao.ChapterMapper;
import org.itzxs.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Itzxs on 2018/6/6.
 */
public class UpdateChapterRunable implements Runnable{

    @Autowired
    ChapterMapper chapterMapper;

    private List<Chapter> list;
    private CountDownLatch countDownLatch;

    public UpdateChapterRunable(List<Chapter> list,CountDownLatch countDownLatch){
        super();
        this.list = list;
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            System.out.println(simpleDateFormat.format(new Date()));
            chapterMapper.insertChapters(list);
            System.out.println(simpleDateFormat.format(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();//完成一次操作，计数减一
        }
    }

}
