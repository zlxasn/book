package org.itzxs.service;

import org.itzxs.entity.Book;

import java.util.List;

/**
 * Created by Itzxs on 2018/4/23.
 */
public interface BookService {
//    void addBook(String url);

    boolean addHotBook();

    public boolean addEveryModelHotBook();

    public boolean addEveryModelBook();
}
