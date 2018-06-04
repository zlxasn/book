package org.itzxs.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.itzxs.dto.ChapterDTO;
import org.itzxs.entity.Chapter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Itzxs on 2018/4/18.
 */
public class Spider {
    protected String crawl(String url) throws Exception {
        //采用HttpClient技术
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
             CloseableHttpResponse httpResponse = httpClient.execute(new HttpGet(url))) {
            String result = EntityUtils.toString(httpResponse.getEntity());
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ChapterDTO> getChapter(String url) {
        try {
            //获取连接结果
//            String result = crawl(url);
            //解析返回结果为document
            Document doc = Jsoup.parse(new URL(url).openStream(),"GBK",url);
//            Elements as = doc.select("#list dd a");
            Elements as = doc.select(".novelslist li a");
            List<ChapterDTO> chapters = new ArrayList<>();
            //遍历
            for (Element a : as) {
                ChapterDTO chapterDTO = new ChapterDTO();
                //章节标题
                chapterDTO.setTitle(a.text());
                System.out.println(a.text());
                //章节链接
                System.out.println(a.attr("href"));
                chapterDTO.setUrl(a.attr("href"));
                /*if((a.attr("href")).contains("0_5")){
                    chapterDTO.setUrl("http://www.biquge.tw" + a.attr("href"));
                }else{
                    chapterDTO.setUrl("http://www.biquge.tw/0_5/" + a.attr("href"));
                }*/
                chapters.add(chapterDTO);
            }
            return chapters;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Chapter getChapterText(String url){
        try{
            String result = crawl(url);
            Document doc = Jsoup.parse(result);
            //章节名
            Elements bookChapterName = doc.select(".bookname h1");
            //章节内容
            Elements bookChapterContent = doc.select("#content");
            Chapter chapter = new Chapter();
            chapter.setBookId(1);
            chapter.setBookChapterName(bookChapterName.text());
            chapter.setBookChapterContent(bookChapterContent.html());
            return chapter;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<Map<String,String>> getFiles(String path) {
        List<Map<String,String>> list = new ArrayList<>();
        File file = new File(path);
        // 如果这个路径是文件夹
        if (file.isDirectory()) {
            // 获取路径下的所有文件
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                Map<String,String> map = new HashMap<>();
                // 如果还是文件夹 递归获取里面的文件 文件夹
                if (files[i].isDirectory()) {
//                    getFiles(files[i].getPath());
                    map.put("name",files[i].getName());
                    map.put("path",files[i].getPath());
                    list.add(map);
                } else {
                    map.put("name",files[i].getName());
                    map.put("path",files[i].getPath());
                    list.add(map);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Spider spider = new Spider();
        List<ChapterDTO> list = spider.getChapter("http://www.biquge.com.tw/");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTitle());
            System.out.println(list.get(i).getUrl());
            System.out.println("----------------------------");
        }
        System.out.println(list.size());
        /*List<Map<String,String>> list = spider.getFiles("F:/novel/");
        System.out.println(list.size());*/
        /*try{
            Spider spider = new Spider();
            List<ChapterDTO> list = spider.getChapter("http://www.biquge.tw/0_5/");
            for (int i = 0; i < list.size(); i++) {
                ContentText contentText = spider.getContentText(list.get(i).getUrl());

                File file = new File("F:/novel/"+contentText.getTitel()+".txt");
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file);
                String countText = contentText.getContent();
                countText = countText.replace("<br>","\n");
                countText = countText.replace("&nbsp;"," ");
                fileWriter.write(countText);
                fileWriter.flush();
                fileWriter.close();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }*/
    }
}
