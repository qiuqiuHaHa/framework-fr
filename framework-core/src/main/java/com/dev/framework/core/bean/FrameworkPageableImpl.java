package com.dev.framework.core.bean;

import java.io.Serializable;

/**
 * @Author fanr
 * @Date 2017/9/30 9:40
 * @desc
 */
public class FrameworkPageableImpl implements FrameworkPageable,Serializable {

    Integer pageNo;
    Integer pageSize;
    Integer totalPageNo;
    Long totalRecords;

    @Override
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public Integer getPageNo() {
        return pageNo;
    }

    @Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public void setTotalPageNo(Integer totalPageNo) {
        this.totalPageNo = totalPageNo;
    }

    @Override
    public Integer getTotalPageNo() {
        return totalPageNo;
    }

    @Override
    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
        Integer pageNo = (int)( totalRecords%pageSize==0l?totalRecords/pageSize:totalRecords/pageSize+1);
        setPageNo(pageNo);
    }

    @Override
    public Long getTotalRecords() {
        return totalRecords;
    }
}
