package com.cml.springboot.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cml.springboot.BootApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
@AutoConfigureMockMvc
public class CacheTest {
	// public void testEhCache() throws Exception, IOException {
	// ResourcePatternResolver patternResolver = new
	// PathMatchingResourcePatternResolver();
	//
	// CacheManager cacheManager = CacheManager
	// .newInstance(patternResolver.getResource("classpath:cache/ehcache.xml").getInputStream());
	//
	// // cacheManager.addCache("userCache");
	//
	// Cache cache = cacheManager.getCache("demo");
	//
	// cache.put(new Element("mine", "menglin.chen"));
	//
	// System.out.println(cacheManager.cacheExists("demo"));
	//
	// cacheManager.shutdown();
	//
	// System.out.println(1);
	// }

	@Autowired
	private MockMvc mvc;

	@Test
	public void testCache() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/cache/C78CE23552BC46328959C8C0AE391886"));
		System.out.println("=====================read data second==========================");
		mvc.perform(MockMvcRequestBuilders.get("/cache/C78CE23552BC46328959C8C0AE391886"));
	}

}
