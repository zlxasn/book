package org.itzxs.dao;

import org.itzxs.entity.QidianBook;

import java.util.List;

public interface QidianBookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QidianBook record);

    int insertSelective(QidianBook record);

    QidianBook selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QidianBook record);

    int updateByPrimaryKeyWithBLOBs(QidianBook record);

    int updateByPrimaryKey(QidianBook record);

    int insertBooks(List<QidianBook> qidianBooks);
}