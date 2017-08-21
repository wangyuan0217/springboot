package com.trump.domain;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */
public class PageBean<T> {

    private int total;
    private List<T> rows;

    public PageBean(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
