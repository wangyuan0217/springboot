package com.trump.domain;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */
public class PageBean<T> {

    private int code;
    private String msg;
    private int totals;
    private List<T> data;

    public PageBean() {

    }

    //for success
    public PageBean(int code, int count, List<T> data) {
        this(code, "success", count, data);
    }

    public PageBean(int code, String msg, int totals, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.totals = totals;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotals() {
        return totals;
    }

    public void setTotals(int totals) {
        this.totals = totals;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
