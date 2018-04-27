package org.itzxs.dao;

import org.apache.ibatis.annotations.Param;
import org.itzxs.entity.Chapter;

import java.util.List;

public interface ChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);

    int insertChapters(@Param("chapters") List<Chapter> chapters);
}