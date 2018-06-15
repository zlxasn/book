package org.itzxs.service;

import org.itzxs.entity.Book;

import java.util.List;

/**
 * Created by Itzxs on 2018/4/23.
 */
public interface BookService {
//    void addBook(String url);

    boolean addHotBook();

    boolean addEveryModelHotBook();

    boolean addEveryModelBook();

    boolean addHotABookByModel(String url,int type);

    List<Book> getBooks();
}
