package org.itzxs.serviceImpl;

import org.itzxs.dao.QidianTypeMapper;
import org.itzxs.entity.QidianType;
import org.itzxs.service.QiDianTypeService;
import org.itzxs.util.qidian.LoadQiDianType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Itzxs on 2018/6/22.
 */
@Service
public class QiDianTypeServiceImpl implements QiDianTypeService{

    @Autowired
    QidianTypeMapper qidianTypeMapper;

    private static final String QIDAIN_MAN_URL = "https://www.qidian.com";
    private static final String QIDAIN_WOMEN_URL = "https://www.qdmm.com";

    @Override
    public int addQiDianType(){
        LoadQiDianType loadQiDianType = new LoadQiDianType();
        List<QidianType> qidianTypes = new ArrayList<>();
        QidianType qidianType_man = new QidianType(1, null, "男生", QIDAIN_MAN_URL, 1);
        QidianType qidianType_women = new QidianType(2, null, "女生", QIDAIN_WOMEN_URL, 1);
        List<QidianType> qidianTypes_Man = loadQiDianType._Get_QiDian_Novle_Type(QIDAIN_MAN_URL);
        List<QidianType> qidianTypes_WoMan = loadQiDianType._Get_QiDian_Novle_Type(QIDAIN_WOMEN_URL);
        qidianTypes.add(qidianType_man);
        qidianTypes.add(qidianType_women);
        qidianTypes.addAll(qidianTypes_Man);
        qidianTypes.addAll(qidianTypes_WoMan);
        return qidianTypeMapper.insertQiDianTypes(qidianTypes);
    }
}
