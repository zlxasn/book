package org.itzxs.util.qidian;

import org.itzxs.entity.QidianType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Itzxs on 2018/6/22.
 */
public class LoadQiDianType {
    /**
     * 获取起点小说类型
     * @return
     */
    public static List<QidianType> _Get_QiDian_Novle_Type(String url){
        try {
            //解析返回结果为document
            Document doc = Jsoup.parse(new URL(url).openStream(),"UTF-8",url);
            Elements _OneLevelTypeUrl = doc.select("#classify-list dd a");
            Elements _OneLevelTypeName = doc.select("#classify-list dd a span i");
            List<QidianType> qidianTypes = new ArrayList<>();
            for (int i = 0 ; i < _OneLevelTypeUrl.size() ; i++) {
                QidianType qidianType = new QidianType();
                qidianType.setTypeCode((i+1)*10);
                String _One_Level_Type = url+_OneLevelTypeUrl.get(i).attr("href");
                qidianType.setTypeName(_OneLevelTypeName.get(i).text());
                qidianType.setTypeLevel(2);
                if(url.contains("qidian")){
                    qidianType.setParentId(1);
                }else if(url.contains("qdmm")){
                    qidianType.setParentId(2);
                }
                if(!_OneLevelTypeUrl.get(i).attr("href").contains("www")){
                    qidianType.setTypeUrl(_One_Level_Type);
                    if("/2cy".equals(_One_Level_Type)){
                        Document document = Jsoup.parse(new URL(_One_Level_Type).openStream(),"UTF-8",_One_Level_Type);
                        Elements _TwoLevelType = document.select(".main-nav-wrap li a");
                        for (int j = 0; j < _TwoLevelType.size(); j++) {
                            QidianType qidianType_TwoLevel = new QidianType();
                            qidianType_TwoLevel.setTypeCode((i+1)*100+j+1);
                            qidianType_TwoLevel.setTypeName(_TwoLevelType.get(j).text());
                            qidianType_TwoLevel.setParentId((i+1)*10);
                            qidianType_TwoLevel.setTypeLevel(3);
                            qidianType_TwoLevel.setTypeUrl("https:"+_TwoLevelType.get(j).attr("href"));
                            qidianTypes.add(qidianType_TwoLevel);
                        }
                    }else{
                        Document document = Jsoup.parse(new URL(_One_Level_Type).openStream(),"UTF-8",_One_Level_Type);
                        Elements _TwoLevelType = document.select(".sub-type-wrap a");
                        for (int j = 0; j < _TwoLevelType.size(); j++) {
                            QidianType qidianType_TwoLevel = new QidianType();
                            qidianType_TwoLevel.setTypeCode((i+1)*100+j+1);
                            qidianType_TwoLevel.setTypeName(_TwoLevelType.get(j).text());
                            qidianType_TwoLevel.setParentId((i+1)*10);
                            qidianType_TwoLevel.setTypeLevel(3);
                            qidianType_TwoLevel.setTypeUrl("https:"+_TwoLevelType.get(j).attr("href"));
                            qidianTypes.add(qidianType_TwoLevel);
                        }
                    }
                }else{
                    qidianType.setTypeUrl("https:"+_OneLevelTypeUrl.get(i).attr("href"));
                }
                qidianTypes.add(qidianType);
            }
            return qidianTypes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<QidianType> qidianTypes = _Get_QiDian_Novle_Type("https://www.qdmm.com");
        for (QidianType qidianType : qidianTypes) {
            System.out.println(qidianType.getTypeCode()+"---"+qidianType.getTypeName()+"---"+qidianType.getParentId());
        }
    }
}
