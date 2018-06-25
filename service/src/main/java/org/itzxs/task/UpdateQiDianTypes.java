package org.itzxs.task;

import org.itzxs.service.QiDianTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Itzxs on 2018/6/22.
 */
//@Component
public class UpdateQiDianTypes {

    @Autowired
    QiDianTypeService qiDianTypeService;

    /**
     * 定时任务，一月更新一次
     */
    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void fixedUpdateQiDianTypes() {
        qiDianTypeService.addQiDianType();
    }
}
