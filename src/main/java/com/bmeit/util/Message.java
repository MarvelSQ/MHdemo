package com.bmeit.util;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sunqiang on 2016/9/27.
 */
public class Message {

    public final static int OK=200;
    public final static int CREATED=201;
    public final static int ACCEPTED=202;
    public final static int ERROR=400;
    public final static int UNAUTHORIZED=401;
    public final static int FORBIDDEN=403;
    public final static int NOT_FOUND=404;

    private int code;

    private Object data;

    private HashMap<String,Object> pdata=new HashMap<>();

    public Message(){
        this(OK,null);
    }

    public Message(int code, Object data) {
        this(OK,data,null);
    }

    public Message(int code,Object data,Object paging){
        this.code=code;
        if(paging!=null){
            this.pdata.put("page",paging);
            this.pdata.put("list",data);
            this.data=this.pdata;
        }else {
            this.data=data;
        }
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }
}
