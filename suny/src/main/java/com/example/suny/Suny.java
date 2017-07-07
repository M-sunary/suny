package com.example.suny;

import lombok.Data;

/**
 * Created by za-sunyu on 2017/7/5.
 */

@Data
public class Suny {

    private final long sid;
    private final String content;

    public Suny(Long sid,String content){
        this.sid = sid;
        this.content = content;
    }

    public long getSid() {
        return sid;
    }

    public String getContent() {
        return content;
    }
}
