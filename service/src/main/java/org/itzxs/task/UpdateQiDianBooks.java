package org.itzxs.task;

import org.itzxs.service.QiDianBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Itzxs on 2018/6/25.
 */
//@Component
public class UpdateQiDianBooks {

    @Autowired
    QiDianBookService qiDianBookService;

    /**
     * 定时任务，一天更新一次
     */
    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void fixedUpdateQiDianBooks() {
        qiDianBookService.loadQiDianBook();
    }
}
