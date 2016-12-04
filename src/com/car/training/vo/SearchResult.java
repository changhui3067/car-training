package com.car.training.vo;

/**
 * Created by bill on 11/29/16.
 */
public class SearchResult {
    private int pageCount;
    private int pageNo;
    private Object list;
    private Boolean login;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }
}
