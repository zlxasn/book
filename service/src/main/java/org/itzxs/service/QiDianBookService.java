package org.itzxs.service;

import org.itzxs.entity.PageRespository;
import org.itzxs.entity.QidianBook;

import java.util.List;

/**
 * Created by Itzxs on 2018/6/25.
 */
public interface QiDianBookService {

    void loadQiDianBook();

    List<QidianBook> getQiDianBooks(int type, PageRespository pageRespository);
}
