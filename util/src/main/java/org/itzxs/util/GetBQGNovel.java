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
import org.itzxs.constant.ParamterConstant;
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

    public List<Book> getEveryModelHotNovel(String url) {
        try {
            //解析返回结果为document
            Document doc = Jsoup.parse(new URL(url).openStream(),"GBK",url);
            Elements bookType = doc.select(".novelslist h2");
            Elements topBookImg = doc.select(".top img");
            Elements topBookNameAndUrl = doc.select(".top a");
            Elements topBookDescribe = doc.select(".top dd");
            List<Book> books = new ArrayList<>();
            //遍历
            for (int i = 0;i<bookType.size();i++) {
                Book book = new Book();
                book.setBookName(topBookNameAndUrl.get(i).text());
                book.setBookImgUrl(topBookImg.get(i).attr("src"));
                book.setBookLevel(2);
                book.setBookUrl(topBookNameAndUrl.get(i).attr("href"));
                book.setModifyDate(new Date());
                if(ParamterConstant.XUHUAN_NOVEL.equals(bookType.get(i).text())){
                    book.setBookType(ParamterConstant.XUHUAN_NOVEL_CODE);
                }else if(ParamterConstant.XIUZHEN_NOVEL.equals(bookType.get(i).text())){
                    book.setBookType(ParamterConstant.XIUZHEN_NOVEL_CODE);
                }else if(ParamterConstant.DUSHI_NOVEL.equals(bookType.get(i).text())){
                    book.setBookType(ParamterConstant.DUSHI_NOVEL_CODE);
                }else if(ParamterConstant.LISHI_NOVEL.equals(bookType.get(i).text())){
                    book.setBookType(ParamterConstant.LISHI_NOVEL_CODE);
                }else if(ParamterConstant.WANGYOU_NOVEL.equals(bookType.get(i).text())){
                    book.setBookType(ParamterConstant.WANGYOU_NOVEL_CODE);
                }else if(ParamterConstant.KEHUAN_NOVEL.equals(bookType.get(i).text())){
                    book.setBookType(ParamterConstant.KEHUAN_NOVEL_CODE);
                }else{
                    book.setBookType(ParamterConstant.ERROR_CODE);
                }
                book.setBookDescribe(topBookDescribe.get(i).text());
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getEveryModelNovel(String url) {
        try {
            //解析返回结果为document
            Document doc = Jsoup.parse(new URL(url).openStream(),"GBK",url);
            Elements bookNameAndUrl = doc.select(".content li a");
            Elements bookType = doc.select(".content h2");
            List<Book> books = new ArrayList<>();
            for (int i = 0; i < bookNameAndUrl.size(); i++) {
                Book book = new Book();
                book.setBookName(bookNameAndUrl.get(i).text());
                book.setBookLevel(3);
                book.setBookUrl(bookNameAndUrl.get(i).attr("href"));
                book.setModifyDate(new Date());
                if(i<12){
                    book.setBookType(ParamterConstant.XUHUAN_NOVEL_CODE);
                }else if(12 <= i && i < 24){
                    book.setBookType(ParamterConstant.XIUZHEN_NOVEL_CODE);
                }else if(24 <= i && i < 36){
                    book.setBookType(ParamterConstant.DUSHI_NOVEL_CODE);
                }else if(36 <= i && i < 48){
                    book.setBookType(ParamterConstant.LISHI_NOVEL_CODE);
                }else if(48 <= i && i < 60){
                    book.setBookType(ParamterConstant.WANGYOU_NOVEL_CODE);
                }else if(60 <= i && i < 72){
                    book.setBookType(ParamterConstant.KEHUAN_NOVEL_CODE);
                }
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getHotNovelByModel(String url) {
        try {
            //解析返回结果为document
            Document doc = Jsoup.parse(new URL(url).openStream(),"GBK",url);
            Elements bookImg = doc.select(".item img");
            Elements bookNameAndUrl = doc.select(".item dt a");
            Elements bookUser = doc.select(".item dt span");
            Elements bookDescribe = doc.select(".item dd");
            List<Book> books = new ArrayList<>();
            for (int i = 0; i < bookNameAndUrl.size(); i++) {
                Book book = new Book();
                book.setBookName(bookNameAndUrl.get(i).text());
                book.setBookLevel(4);
                book.setBookUrl(bookNameAndUrl.get(i).attr("href"));
                book.setModifyDate(new Date());
                book.setBookImgUrl(bookImg.get(i).attr("src"));
                book.setBookUser(bookUser.get(i).text());
                if(url.contains("xuanhuan")){
                    book.setBookType(ParamterConstant.XUHUAN_NOVEL_CODE);
                }else if(url.contains("xiuzhen")){
                    book.setBookType(ParamterConstant.XIUZHEN_NOVEL_CODE);
                }else if(url.contains("dushi")){
                    book.setBookType(ParamterConstant.DUSHI_NOVEL_CODE);
                }else if(url.contains("lishi")){
                    book.setBookType(ParamterConstant.LISHI_NOVEL_CODE);
                }else if(url.contains("wangyou")){
                    book.setBookType(ParamterConstant.WANGYOU_NOVEL_CODE);
                }else if(url.contains("kehuan")){
                    book.setBookType(ParamterConstant.KEHUAN_NOVEL_CODE);
                }else if(url.contains("kongbu")){
                    book.setBookType(ParamterConstant.KONGBU_NOVLE_CODE);
                }else if(url.contains("quanben")){
                    book.setBookType(ParamterConstant.QUANBEN_NOVLE_CODE);
                }
                book.setBookDescribe(bookDescribe.get(i).text());
                books.add(book);
                System.out.println(book.toString());
            }
            return books;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        GetBQGNovel getBQGNovel  = new GetBQGNovel();
        List<Book> books = getBQGNovel.getHotNovelByModel("http://www.biquge.com.tw/xuanhuan/");
        System.out.println(books.size());
    }

}
