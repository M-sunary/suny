package com.suny.blog.service.impl;

import com.suny.blog.model.AsirImages;
import com.suny.blog.model.Banner;
import com.suny.blog.model.UserBaseInfo;
import com.suny.blog.service.AsirImagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AsirImagesServiceImpl  implements AsirImagesService {

    private static final Logger logger = LoggerFactory.getLogger(AsirImagesServiceImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public AsirImages getImageListsByKey(int imageKey) {
        String sql = "SELECT * FROM a_sir_images WHERE image_key = "+imageKey ;
        AsirImages asirImages = null;
        try{
            asirImages=jdbcTemplate.queryForObject(sql, new RowMapper<AsirImages>() {
                @Override
                public AsirImages mapRow(ResultSet resultSet, int i) throws SQLException {
                    AsirImages images = new AsirImages();
                    images.setImagesKey(resultSet.getInt("image_key"));
                    images.setImage1(resultSet.getString("image1"));
                    images.setImage2(resultSet.getString("image2"));
                    images.setImage3(resultSet.getString("image3"));
                    images.setImage4(resultSet.getString("image4"));
                    images.setImage5(resultSet.getString("image5"));
                    images.setImage6(resultSet.getString("image6"));
                    return images;
                }
            });
        }catch (Exception e){
            logger.error("查询异常:"+e);
        }
        return asirImages;
    }

}
