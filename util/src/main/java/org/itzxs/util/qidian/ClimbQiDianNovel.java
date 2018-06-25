package org.itzxs.util.qidian;

import org.itzxs.entity.QidianBook;
import org.itzxs.entity.QidianType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Itzxs on 2018/6/22.
 */
public class ClimbQiDianNovel {

    public List<QidianBook> loadQiDianNovelByType(String url,int typeCode){
        List<QidianBook> qidianBooks = new ArrayList<>();
        try{
            Document doc = Jsoup.parse(new URL(url).openStream(),"UTF-8",url);
            Elements book_Img_Url = doc.select(".book-img-text li .book-img-box a");
            Elements book_Name_Url = doc.select(".book-img-text li .book-mid-info h4");
            Elements book_User = doc.select(".book-img-text li .book-mid-info .author");
            Elements book_Describe = doc.select(".book-img-text li .book-mid-info .intro");
            for (int i = 0; i < book_Img_Url.size(); i++) {
                QidianBook qidianBook = new QidianBook();
                qidianBook.setBookName(book_Name_Url.get(i).getElementsByTag("a").text());
                qidianBook.setBookUrl("https:"+book_Name_Url.get(i).getElementsByTag("a").attr("href"));
                qidianBook.setBookImgUrl("https:"+book_Img_Url.get(i).getElementsByTag("img").attr("src"));
                qidianBook.setBookAuthor(book_User.get(i).getElementsByTag("a").get(0).text());
                qidianBook.setModifyDate(new Date());
                qidianBook.setBookType(typeCode);
                qidianBook.setBookDescribe(book_Describe.get(i).text());
                qidianBooks.add(qidianBook);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return qidianBooks;
    }

    public static void main(String[] args) {
        /*List<QidianBook> qidianBooks = loadQiDianNovelByType("https://www.qidian.com/all?chanId=21&subCateId=8&pageSize=20&page=1",101);
        for (QidianBook qidianBook : qidianBooks){
            System.out.println(qidianBook.toString());
        }*/
        /*try{

            Document doc = Jsoup.parse(new URL("https://www.qidian.com/all?chanId=21&subCateId=8&pageSize=20&page=1").openStream(),"UTF-8","https://www.qidian.com/all?chanId=21&subCateId=8&pageSize=20&page=1");
            Elements pageCountEle = doc.select(".lbf-pagination-item-list li a");
            int pageCount = Integer.parseInt(pageCountEle.get(pageCountEle.size()-2).text());
            System.out.println(pageCount);
        }catch (Exception e){
            throw new RuntimeException();
        }*/
    }
}
