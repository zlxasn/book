package org.itzxs.util;

import org.itzxs.entity.Chapter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Itzxs on 2018/6/6.
 */
public class GetChapter {

    public List<Chapter> getChapter(int bookId,String url) {
        try {
            //解析返回结果为document
            Document doc = Jsoup.parse(new URL(url).openStream(),"GBK",url);
            Elements chaptersNameAndUrl = doc.select(".box_con dd a");
            List<Chapter> chapters = new ArrayList<>();
            //遍历
            for (Element e : chaptersNameAndUrl) {
                Chapter chapter = new Chapter();
                chapter.setBookId(bookId);
                chapter.setBookChapterName(e.text());
                Document document = Jsoup.parse(new URL("http://www.biquge.com.tw"+e.attr("href")).openStream(),"GBK","http://www.biquge.com.tw"+e.attr("href"));
                Elements content = document.select("#content");
                chapter.setBookChapterContent(content.text());
                chapter.setModifyDate(new Date());
                chapters.add(chapter);
            }
            return chapters;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
