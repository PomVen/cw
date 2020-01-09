package com.hallth.mapper;

import com.hallth.domain.OaDataTypeDic;

import java.util.List;

public interface OaDataTypeDicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_data_type_dic
     *
     * @mbggenerated
     */
    int insert(OaDataTypeDic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oa_data_type_dic
     *
     * @mbggenerated
     */
    int insertSelective(OaDataTypeDic record);

    List<OaDataTypeDic> getOaLeaveTypeList();

    List<OaDataTypeDic> getSchoolTypeList();
}