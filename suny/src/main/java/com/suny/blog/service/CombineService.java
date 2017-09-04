package com.suny.blog.service;

import com.suny.blog.model.Combine;

import java.util.List;

public interface CombineService {
    public List<Combine> getCombineList();
    public Combine getCombineById(int combineId);
    public int updateCombine(Combine cmb);
    public int delCombine(Combine cmb);
}
