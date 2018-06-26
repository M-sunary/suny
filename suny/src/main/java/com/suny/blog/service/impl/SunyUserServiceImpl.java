package com.suny.blog.service.impl;

import com.suny.blog.model.UserBaseInfo;
import com.suny.blog.service.SunyUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by za-sunyu on 2017/7/18.
 */
@Service
public class SunyUserServiceImpl implements SunyUserService {

    private static final Logger logger = LoggerFactory.getLogger(SunyUserServiceImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserBaseInfo getUserById(int userId) {
        String sql = "select * from base_info limit 1";
        UserBaseInfo u = null;
        try{
             u=jdbcTemplate.queryForObject(sql, new RowMapper<UserBaseInfo>() {
                @Override
                public UserBaseInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                    UserBaseInfo userBaseInfo = new UserBaseInfo();
                    userBaseInfo.setEmail(resultSet.getString("e_mail"));
                    userBaseInfo.setUserId(resultSet.getInt("user_id"));
                    userBaseInfo.setUserName(resultSet.getString("user_name"));
                    userBaseInfo.setUserIntroduce(resultSet.getString("user_introduce"));
                    userBaseInfo.setUserMotto(resultSet.getString("user_motto"));
                    userBaseInfo.setUsesrAdreess(resultSet.getString("user_address"));
                    userBaseInfo.setNavImg(resultSet.getString("nav_img"));
                    userBaseInfo.setAvatarImg(resultSet.getString("avatar_img"));
                    userBaseInfo.setYearOfWorks(resultSet.getFloat("years_of_work"));
                    return userBaseInfo;
                }
            });
        }catch (Exception e){
            logger.error("查询异常:"+e);
        }
        return u;
    }
}
