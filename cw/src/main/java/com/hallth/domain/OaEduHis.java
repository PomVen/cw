package com.hallth.domain;

import java.util.Date;

public class OaEduHis {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_edu_his.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_edu_his.user_id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_edu_his.school_name
     *
     * @mbggenerated
     */
    private String schoolName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_edu_his.school_type
     *
     * @mbggenerated
     */
    private Integer schoolType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_edu_his.major
     *
     * @mbggenerated
     */
    private String major;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_edu_his.start_time
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_edu_his.end_time
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_edu_his.degree
     *
     * @mbggenerated
     */
    private String degree;

    private String userName;
    private String typeValue;

    private int startRow;
    private int pageSize;

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_edu_his.id
     *
     * @return the value of oa_edu_his.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_edu_his.id
     *
     * @param id the value for oa_edu_his.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_edu_his.user_id
     *
     * @return the value of oa_edu_his.user_id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_edu_his.user_id
     *
     * @param userId the value for oa_edu_his.user_id
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_edu_his.school_name
     *
     * @return the value of oa_edu_his.school_name
     *
     * @mbggenerated
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_edu_his.school_name
     *
     * @param schoolName the value for oa_edu_his.school_name
     *
     * @mbggenerated
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_edu_his.school_type
     *
     * @return the value of oa_edu_his.school_type
     *
     * @mbggenerated
     */
    public Integer getSchoolType() {
        return schoolType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_edu_his.school_type
     *
     * @param schoolType the value for oa_edu_his.school_type
     *
     * @mbggenerated
     */
    public void setSchoolType(Integer schoolType) {
        this.schoolType = schoolType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_edu_his.major
     *
     * @return the value of oa_edu_his.major
     *
     * @mbggenerated
     */
    public String getMajor() {
        return major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_edu_his.major
     *
     * @param major the value for oa_edu_his.major
     *
     * @mbggenerated
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_edu_his.start_time
     *
     * @return the value of oa_edu_his.start_time
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_edu_his.start_time
     *
     * @param startTime the value for oa_edu_his.start_time
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_edu_his.end_time
     *
     * @return the value of oa_edu_his.end_time
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_edu_his.end_time
     *
     * @param endTime the value for oa_edu_his.end_time
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_edu_his.degree
     *
     * @return the value of oa_edu_his.degree
     *
     * @mbggenerated
     */
    public String getDegree() {
        return degree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_edu_his.degree
     *
     * @param degree the value for oa_edu_his.degree
     *
     * @mbggenerated
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }
}