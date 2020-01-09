package com.hallth.utils;

public class MathUtils {

    public static int getStartRow(int currentPage, int pageSize){
        return (currentPage-1)*pageSize;
    }
}
