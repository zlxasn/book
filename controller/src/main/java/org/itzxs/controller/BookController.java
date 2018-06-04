package org.itzxs.controller;

import org.itzxs.entity.Book;
import org.itzxs.entity.UserInformation;
import org.itzxs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Itzxs on 2018/4/23.
 */
@Controller
@RequestMapping("/book")
@SessionAttributes(types = {UserInformation.class, String.class}, value = {"userInformation"})
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/addBook")
    @ResponseBody
    public ModelAndView addBook(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ModelAndView mv = new ModelAndView();
        bookService.addHotBook();
        mv.setViewName("/demo");
        return mv;
    }

    @RequestMapping("/bookList")
    @ResponseBody
    public ModelAndView bookList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/bookList");
        return mv;
    }
}
