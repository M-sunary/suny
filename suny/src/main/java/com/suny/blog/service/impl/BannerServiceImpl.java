package com.suny.blog.service.impl;

import com.suny.blog.model.Banner;
import com.suny.blog.service.BannerService;
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
public class BannerServiceImpl implements BannerService {

    private static final Logger logger = LoggerFactory.getLogger(BannerServiceImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Banner> getBannerList() {
        String sql = "select * from a_sir_banner";
        List<Banner> bannerList = new ArrayList<>();
        try {
            List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
            for (int i = 0; i < rows.size(); i++) {
                Map<String,Object> bannerMap = rows.get(i);
                Banner banner = new Banner();
                banner.setId(Integer.parseInt(bannerMap.get("id").toString()));
                banner.setThumbUrl(bannerMap.get("thumb_url").toString());
                bannerList.add(banner);
            }
        }catch (DataAccessException e){
            logger.error("查询异常",e);
        }
        return bannerList;

    }

    @Override
    public void updateBanner(Banner banner) {

    }
}
