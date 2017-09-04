package com.suny.blog.service.impl;

import com.suny.blog.model.Navigation;
import com.suny.blog.service.NavigationService;
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
public class NavigationServiceImpl implements NavigationService {
    private static final Logger logger = LoggerFactory.getLogger(NavigationServiceImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Navigation> getNavList() {
        String sql = "select * from a_sir_navigation";
        List<Navigation> navList = new ArrayList<Navigation>();
        try {
            List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
            for (int i = 0; i < rows.size(); i++) {
                Map<String,Object> navMap = rows.get(i);
                Navigation navigation = new Navigation();
                navigation.setNavId(Integer.parseInt(navMap.get("nav_id").toString()));
                navigation.setNavName(navMap.get("nav_name").toString());
                navigation.setNavShortName(navMap.get("nav_shortname").toString());
                navList.add(navigation);
            }
        }catch (DataAccessException e){
            logger.error("查询异常",e);
        }
        return navList;
    }

    @Override
    public void updateNavigation(Navigation navigation) {

    }
}
