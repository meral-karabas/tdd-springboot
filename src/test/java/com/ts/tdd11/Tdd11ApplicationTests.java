package com.ts.tdd11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tdd11ApplicationTests {

	@Autowired
	WebApplicationContext	context;

	@Test
	public void contextLoads() {
    	System.out.println(
			context.getServletContext().toString());
    	System.out.println(
    		context.toString());
    	System.out.println(
    		context.getEnvironment().toString());

    	System.out.println(
    			context.getBeanDefinitionCount());
    	System.out.println(context.getApplicationName());
    	for (String s : context.getBeanDefinitionNames()) {
      		System.out.println(s);
		}
	}

}
