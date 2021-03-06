package com.hallth.mapper;

import com.hallth.domain.OaMenu;
import com.hallth.domain.OaMenuUserRel;

import java.util.List;

public interface OaMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_menu
     *
     * @mbggenerated
     */
    int insert(OaMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_menu
     *
     * @mbggenerated
     */
    int insertSelective(OaMenu record);

    List<OaMenu> getMenuById(List<OaMenuUserRel> menuIdList);
}