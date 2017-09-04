package com.suny.blog.service.impl;

import com.suny.blog.model.Combine;
import com.suny.blog.service.CombineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CombineServiceImpl implements CombineService {

    private static final Logger logger = LoggerFactory.getLogger(CombineServiceImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Combine> getCombineList() {
        String sql = "select * from a_sir_combine";
        List<Combine> cmbList = new ArrayList<Combine>();
        try {
            List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
            for (int i = 0; i < rows.size(); i++) {
                Map<String,Object> cmbMap = rows.get(i);
                Combine cmb = new Combine();
                cmb.setId(Integer.valueOf(cmbMap.get("id")+""));
                cmb.setContent(cmbMap.get("content").toString());
                cmb.setName(cmbMap.get("name").toString());
                cmb.setThumbUrl(cmbMap.get("thumb_url").toString());
                cmb.setParams(cmbMap.get("params").toString());
                cmb.setPrice(Float.valueOf(cmbMap.get("price").toString()));
                cmb.setMemo(cmbMap.get("memo").toString());
                cmbList.add(cmb);
            }
        }catch (DataAccessException e){
            logger.error("查询异常",e);
        }
        return cmbList;
    }

    @Override
    public Combine getCombineById(int combineId) {
        return null;
    }

    @Override
    public int updateCombine(Combine cmb) {
        return 0;
    }

    @Override
    public int delCombine(Combine cmb) {
        return 0;
    }
}
