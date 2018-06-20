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
     * 定时任务，每一天更新一次
     */
    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void fixedUpdateHotBooks() {
        bookService.addHotBook();
        bookService.addEveryModelHotBook();
        bookService.addEveryModelBook();
        bookService.addHotABookByModel("http://www.biquge.com.tw/xuanhuan/",1);
        bookService.addHotABookByModel("http://www.biquge.com.tw/xiuzhen/",2);
        bookService.addHotABookByModel("http://www.biquge.com.tw/dushi/",3);
        bookService.addHotABookByModel("http://www.biquge.com.tw/lishi/",4);
        bookService.addHotABookByModel("http://www.biquge.com.tw/wangyou/",5);
        bookService.addHotABookByModel("http://www.biquge.com.tw/kehuan/",6);
        bookService.addHotABookByModel("http://www.biquge.com.tw/kongbu/",7);
        bookService.addHotABookByModel("http://www.biquge.com.tw/quanben/",8);
        bookService.addBookByModel("http://www.biquge.com.tw/xuanhuan/",1);
        bookService.addBookByModel("http://www.biquge.com.tw/xiuzhen/",2);
        bookService.addBookByModel("http://www.biquge.com.tw/dushi/",3);
        bookService.addBookByModel("http://www.biquge.com.tw/lishi/",4);
        bookService.addBookByModel("http://www.biquge.com.tw/wangyou/",5);
        bookService.addBookByModel("http://www.biquge.com.tw/kehuan/",6);
        bookService.addBookByModel("http://www.biquge.com.tw/kongbu/",7);
        bookService.addBookByModel("http://www.biquge.com.tw/quanben/",8);

    }
}
