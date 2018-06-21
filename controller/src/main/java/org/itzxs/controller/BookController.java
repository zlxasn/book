package org.itzxs.controller;

import org.itzxs.constant.ParamterConstant;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping("/getCategory")
    public ModelAndView getCategory(){
        ModelAndView mv = new ModelAndView();
        Map map = new HashMap();
        map.put(ParamterConstant.XUHUAN_NOVEL_CODE,ParamterConstant.XUHUAN_NOVEL);
        map.put(ParamterConstant.XIUZHEN_NOVEL_CODE,ParamterConstant.XIUZHEN_NOVEL);
        map.put(ParamterConstant.DUSHI_NOVEL_CODE,ParamterConstant.DUSHI_NOVEL);
        map.put(ParamterConstant.LISHI_NOVEL_CODE,ParamterConstant.LISHI_NOVEL);
        map.put(ParamterConstant.WANGYOU_NOVEL_CODE,ParamterConstant.WANGYOU_NOVEL);
        map.put(ParamterConstant.KEHUAN_NOVEL_CODE,ParamterConstant.KEHUAN_NOVEL);
        map.put(ParamterConstant.KONGBU_NOVEL_CODE,ParamterConstant.KONGBU_NOVEL);
        map.put(ParamterConstant.QUANBEN_NOVEL_CODE,ParamterConstant.QUANBEN_NOVEL);
        mv.addObject(map);
        mv.setViewName("/book/categroy.html");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/getBookByCategory")
    public ModelAndView getBookByCategory(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        List<Book> books = bookService.getBookByCategroy(Integer.parseInt(request.getParameter("categroy")));
        mv.addObject(books);
        mv.setViewName("/book/categroy.html");
        return mv;
    }
}
