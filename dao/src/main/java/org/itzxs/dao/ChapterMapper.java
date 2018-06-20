package org.itzxs.dao;

import org.itzxs.entity.Chapter;

import java.util.List;

public interface ChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);

    Chapter selectLast();

    int insertChapters(List<Chapter> chapters);

    int deleteAll();
}