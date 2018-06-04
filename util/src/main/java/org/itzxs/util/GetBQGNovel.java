package org.itzxs.util;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.itzxs.dto.ChapterDTO;
import org.itzxs.entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Itzxs on 2018/6/4.
 */
public class GetBQGNovel {

    public List<ChapterDTO> getNovleNameAndHref(String url) {
        try {
            //解析返回结果为document
            Document doc = Jsoup.parse(new URL(url).openStream(),"GBK",url);
            Elements as = doc.select(".novelslist li a");
            List<ChapterDTO> chapters = new ArrayList<>();
            //遍历
            for (Element a : as) {
                ChapterDTO chapterDTO = new ChapterDTO();
                //章节标题
                chapterDTO.setTitle(a.text());
                //章节链接
                chapterDTO.setUrl(a.attr("href"));
                chapters.add(chapterDTO);
            }
            return chapters;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取热点小说
     * @param url
     * @return
     */
    public List<Book> getHotNovle(String url) {
        try {
            //解析返回结果为document
            Document doc = Jsoup.parse(new URL(url).openStream(),"GBK",url);
            Elements bookImg = doc.select(".l img");
            Elements bookNameAndUrl = doc.select(".l dt a");
            Elements bookUser = doc.select(".l dt span");
            List<Book> books = new ArrayList<>();
            //遍历
            for (int i = 0;i<bookImg.size();i++) {
                Book book = new Book();
                book.setBookName(bookNameAndUrl.get(i).text());
                book.setBookImgUrl(bookImg.get(i).attr("src"));
                book.setBookLevel(1);
                book.setBookUrl(bookNameAndUrl.get(i).attr("href"));
                book.setBookUser(bookUser.get(i).text());
                book.setModifyDate(new Date());
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    }

}
