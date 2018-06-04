package org.itzxs.task;

import org.itzxs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Itzxs on 2018/6/4.
 */
@Component
public class UpdateBooks {

    @Autowired
    BookService bookService;

    /**
     * 定时任务，每一个小时更新一次热点小说
     */
    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void fixedUpdateHotBooks() {
        if(bookService.addHotBook()){
            System.out.println(new Date()+"--------->更新热点小说");
        }else {
            System.out.println(new Date()+"！！！！！>更新热点小说失败");
        }
    }
}
