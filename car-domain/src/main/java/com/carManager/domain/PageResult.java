package com.carManager.domain;

import java.util.List;

public class PageResult<T> {
    private List<T> list;
    private long totalCount;
    private int totalPage;
    private int currentPage;
    private int pageCount = 5;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     *  放入除currentPage 和 pageCount 外， 三个属性的值
     * @param pageResult
     * @param list
     * @return
     */
    public PageResult<T> putMessage(PageResult<T> pageResult,  List<T> list){
        int totalSize = list.size();
        pageResult.setTotalCount(totalSize);
        pageResult.setList(list);
        int totalPageCount = ((totalSize)%pageResult.getPageCount()==0? (totalSize)/pageResult.getPageCount():(totalSize)/pageResult.getPageCount()+1);
        pageResult.setTotalPage(totalPageCount);
        return pageResult;
    }
}
