package com.bmeit.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by sunqiang on 2016/10/8.
 */
public class PageData {

    int page;
    int count;
    int total_page;
    boolean isfirst;
    boolean islast;

    public PageData(Page pages){
        this.page=pages.getNumber();
        this.count=pages.getSize();
        this.total_page=pages.getTotalPages();
        this.isfirst=pages.isFirst();
        this.islast=pages.isLast();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public boolean isfirst() {
        return isfirst;
    }

    public void setIsfirst(boolean isfirst) {
        this.isfirst = isfirst;
    }

    public boolean islast() {
        return islast;
    }

    public void setIslast(boolean islast) {
        this.islast = islast;
    }
}
