package com.suny.blog.constant;

public interface Constant {
    Integer LOG_MODE = 0;// 0为测试环境，1为生产环境
    String LOG_ROOT_DAILY="info,error,CONSOLE,DEBUG";
    String LOG_PATH_DAILY="/data/log/";
}
