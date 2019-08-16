package com.qfedu.common;


public class JsonResult {

    private int code; // 0 正常 1 异常
    private String msg;
    private long count;
    private Object data;


    public JsonResult() {
    }

    public JsonResult(long count, Object data) {
       new JsonResult(0,"",count,data);
    }

    public JsonResult(int code, String msg, long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
