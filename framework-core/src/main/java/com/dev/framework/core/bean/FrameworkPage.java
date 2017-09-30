package com.dev.framework.core.bean;

import java.util.List;

/**
 * @Author fanr
 * @Date 2017/9/30 9:10
 * @desc
 */
public interface FrameworkPage<T> {

    void setPageNo(Integer pageNo);

    Integer getPageNo();

    void setPageSize(Integer pageSize);

    Integer getPageSize();

    void setTotalPageNo(Integer totalPageNo);

    Integer getTotalPageNo();

    void setTotalRecords(Long totalRecords);

    Long getTotalRecords();

    void setContents(List<T> contents);

    List<T> getContents();

    public static <T> FrameworkPage<T> getFrameworkPage(FrameworkPageable frameworkPageable, List<T> contents){

        FrameworkPage<T> frameworkPage = new FrameworkPageImpl();
        if(frameworkPageable != null){
            frameworkPage.setPageNo(frameworkPageable.getPageNo());
            frameworkPage.setPageSize(frameworkPageable.getPageSize());
            frameworkPage.setTotalPageNo(frameworkPageable.getTotalPageNo());
            frameworkPage.setTotalRecords(frameworkPageable.getTotalRecords());
        }
        frameworkPage.setContents(contents);

        return frameworkPage;
    }

}
