package com.dev.framework.core.bean;

/**
 * @Author fanr
 * @Date 2017/9/30 13:31
 * @desc
 */
public class PagingResponseResult extends ResponseResult {

    private static final long serialVersionUID = -7409169310774389933L;

    /**
     * 数据所有的条数
     */
    private Long totalCount;

    /**
     * 所有的页数
     */
    private Integer pageCount;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public PagingResponseResult(Long totalCount, Integer pageCount) {
        this.totalCount = totalCount;
        this.pageCount = pageCount;
    }

    public PagingResponseResult(){}

}
