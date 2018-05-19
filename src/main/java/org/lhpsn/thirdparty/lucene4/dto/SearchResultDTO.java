package org.lhpsn.thirdparty.lucene4.dto;

import java.util.List;

/**
 * 查询结果DTO
 *
 * @param <T> 装载的页面数据
 * @author lh
 * @since 1.0.0
 */
public class SearchResultDTO<T> {

    /**
     * 当前页
     */
    private int pageNo;

    /**
     * 每页显示记录数
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private int recordCount;

    /**
     * 耗时
     */
    private double time;

    /**
     * 当前页的数据
     */
    private List<T> datas;

    /**
     * 开始记录数
     */
    private int startNo;

    /**
     * 结束记录数
     */
    private int endNo;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 总页面数
     */
    private int totalPage = 0;


    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getStartNo() {
        return startNo;
    }

    public void setStartNo(int startNo) {
        this.startNo = startNo;
    }

    public int getEndNo() {
        return endNo;
    }

    public void setEndNo(int endNo) {
        this.endNo = endNo;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
