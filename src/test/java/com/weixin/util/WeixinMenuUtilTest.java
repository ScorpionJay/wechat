package com.weixin.util;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weixin.app.Application;

/**
* @author	jay
* @since	2016年6月12日
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class WeixinMenuUtilTest {

	@Test
	public void testCreateMenu() throws Exception {
		WeixinMenuUtil.getMenu("pgFBZYBvfrffZll168qxESsvrvwuRRLrBRFFzF_EnJ9uyzokqDoghO9kMffaCyuv-Q3cwSyBlKEYhN7jQUMdMW73a7ooaXw2VXkZj3mnrZ0XUYfAJAOLP");
	}

	@Test
	public void testGetMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitMenu() {
		fail("Not yet implemented");
	}

}
