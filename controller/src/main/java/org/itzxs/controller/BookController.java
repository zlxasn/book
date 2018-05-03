package org.itzxs.controller;

import org.itzxs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by Itzxs on 2018/4/23.
 */
@Controller
@RequestMapping("/bookController")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/addBook")
    @ResponseBody
    public ModelAndView addBook(){
        ModelAndView mv = new ModelAndView();
//        bookService.addBook("http://www.biquge.tw/0_5/");
        mv.setViewName("/demo");
        return mv;
    }
}
