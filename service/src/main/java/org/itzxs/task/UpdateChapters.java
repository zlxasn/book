package org.itzxs.task;

import org.itzxs.service.BookService;
import org.itzxs.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Itzxs on 2018/6/4.
 */
//@Component
public class UpdateChapters {

    @Autowired
    ChapterService chapterService;

    /**
     * 定时任务，每一周更新一次
     */
    @Scheduled(fixedRate = 7 * 24 * 60 * 60 * 1000)
    public void fixedUpdateHotBooks() {
        chapterService.updateChapter();
    }
}
