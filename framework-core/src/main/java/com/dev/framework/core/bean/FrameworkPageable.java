package com.dev.framework.core.bean;

/**
 * @Author fanr
 * @Date 2017/9/30 9:12
 * @desc
 */
public interface FrameworkPageable {

    void setPageNo(Integer pageNo);

    Integer getPageNo();

    void setPageSize(Integer pageSize);

    Integer getPageSize();

    void setTotalPageNo(Integer totalPageNo);

    Integer getTotalPageNo();

    void setTotalRecords(Long totalRecords);

    Long getTotalRecords();

}
