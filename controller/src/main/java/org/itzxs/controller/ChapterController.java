package org.itzxs.controller;

import org.itzxs.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Itzxs on 2018/6/6.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    ChapterService chapterService;

    @RequestMapping("/updateChapter")
    public ModelAndView updateChapter(){
        chapterService.updateChapter();
        return new ModelAndView("/demo");
    }
}
