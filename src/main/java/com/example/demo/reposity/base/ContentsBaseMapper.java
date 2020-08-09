package com.example.demo.reposity.base;

import java.util.List;

import com.example.demo.model.Contents;
/**
*  @author dadaguo
*/

public interface ContentsBaseMapper {

    int insertContents(Contents object);

    int updateContents(Contents object);

    int update(Contents.UpdateBuilder object);

    List<Contents> queryContents(Contents object);

    Contents queryContentsLimit1(Contents object);

    List<Contents> findAll();

}