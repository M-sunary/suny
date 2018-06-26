package com.suny.blog.service;

import com.suny.blog.model.Combine;

import java.util.List;

/**
 * 【套餐业务处理接口】模块
 *
 * @author yu.sun
 * @content 套餐业务处理接口
 * @date 2018/4/8 16:27
 */
public interface CombineService {
    public List<Combine> getCombineList();
    public Combine getCombineById(int combineId);
    public int updateCombine(Combine cmb);
    public int delCombine(Combine cmb);
}
