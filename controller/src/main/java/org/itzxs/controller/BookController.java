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
//        bookService.addHotABookByModel();
//        bookService.addEveryModelHotBook();
//        bookService.addHotBook();
//        List<Book> books = bookService.getBooks();
        /*bookService.addBookByModel("http://www.biquge.com.tw/xuanhuan/",1);
        bookService.addBookByModel("http://www.biquge.com.tw/xiuzhen/",2);
        bookService.addBookByModel("http://www.biquge.com.tw/dushi/",3);
        bookService.addBookByModel("http://www.biquge.com.tw/lishi/",4);
        bookService.addBookByModel("http://www.biquge.com.tw/wangyou/",5);
        bookService.addBookByModel("http://www.biquge.com.tw/kehuan/",6);
        bookService.addBookByModel("http://www.biquge.com.tw/kongbu/",7);
        bookService.addBookByModel("http://www.biquge.com.tw/quanben/",8);*/
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
