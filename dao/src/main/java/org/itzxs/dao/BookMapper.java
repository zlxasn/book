package org.itzxs.dao;

import org.apache.ibatis.annotations.Param;
import org.itzxs.entity.Book;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    int insertBooks(List<Book> books);

    int updateBooks(List<Book> books);

    List<Integer> selectIdByLevel(Integer level);

    List<Integer> selectIdByLevelAndType(@Param("level") Integer level, @Param("type") Integer type);
}