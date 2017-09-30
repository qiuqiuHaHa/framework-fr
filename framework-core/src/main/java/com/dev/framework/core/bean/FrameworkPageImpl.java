package com.dev.framework.core.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author fanr
 * @Date 2017/9/30 9:11
 * @desc
 */
public class FrameworkPageImpl<T> implements FrameworkPage<T>, Serializable {


    private static final long serialVersionUID = -4432345389970520816L;
    private Integer pageNo = 1;  //第几页
    private Integer pageSize = 10; //每页10条
    private Integer totalPageNo;
    private Long totalRecords = -1l; //总条数
    private List<T> contents;

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
    }

    @Override
    public Long getTotalRecords() {
        return totalRecords;
    }

    @Override
    public void setContents(List<T> contents) {
        this.contents = contents;
    }

    @Override
    public List<T> getContents() {
        return contents;
    }
}
