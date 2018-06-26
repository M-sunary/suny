package com.suny.blog;


import com.suny.blog.mapper.CombineMapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SunyApplication.class)
@Transactional
public class SunyApplicationTests {

	@Autowired
	private CombineMapper combineMapper;

//	@Test
//	public void contextLoads() {
//	}


}
