package org.itzxs.dao;

import org.itzxs.entity.QidianType;

import java.util.List;

public interface QidianTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QidianType record);

    int insertSelective(QidianType record);

    QidianType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QidianType record);

    int updateByPrimaryKey(QidianType record);

    int insertQiDianTypes(List<QidianType> list);

    List<QidianType> selectByLevel(int level);
}