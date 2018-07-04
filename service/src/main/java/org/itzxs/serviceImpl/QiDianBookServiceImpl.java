package org.itzxs.serviceImpl;

import org.itzxs.dao.QidianBookMapper;
import org.itzxs.dao.QidianTypeMapper;
import org.itzxs.entity.PageRespository;
import org.itzxs.entity.QidianBook;
import org.itzxs.entity.QidianType;
import org.itzxs.service.QiDianBookService;
import org.itzxs.util.qidian.ClimbQiDianNovel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Itzxs on 2018/6/25.
 */
@Service
public class QiDianBookServiceImpl implements QiDianBookService{

    @Autowired
    QidianBookMapper qidianBookMapper;

    @Autowired
    QidianTypeMapper qidianTypeMapper;

    @Override
    public void loadQiDianBook() {
        List<QidianType> list = qidianTypeMapper.selectByLevel(3);
        ClimbQiDianNovel climbQiDianNovel = new ClimbQiDianNovel();
        int num = 0;
        try{
            for (QidianType qidianType : list){
                Document doc = Jsoup.parse(new URL(qidianType.getTypeUrl()+"&pageSize=20&page=1").openStream(),"UTF-8",qidianType.getTypeUrl()+"&pageSize=20&page=1");
                Elements pageCountEle = doc.select(".lbf-pagination-item-list li a");
                int pageCount = Integer.parseInt(pageCountEle.get(pageCountEle.size()-2).text());
//                List<QidianBook> qidianBookList = new ArrayList<>();
                for (int i = 0; i <= pageCount; i++) {
                    List<QidianBook> qidianBooks = climbQiDianNovel.loadQiDianNovelByType(qidianType.getTypeUrl()+"&pageSize=20&page="+i,qidianType.getTypeCode());
//                    qidianBookList.addAll(qidianBooks);
                    if(qidianBooks != null && qidianBooks.size() > 0){
                        num = num +  qidianBooks.size();
                        qidianBookMapper.insertBooks(qidianBooks);
                    }
                    System.out.println(num);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Cacheable("getQiDianBooks")
    @Override
    public List<QidianBook> getQiDianBooks(int type, PageRespository pageRespository){
        return qidianBookMapper.selectByType(type,pageRespository);
    }

}
