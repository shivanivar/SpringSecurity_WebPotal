package com.cisco.portal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import config.AppConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
// @ContextConfiguration(locations = {"classpath:testContext.xml",
// "classpath:exampleApplicationContext-web.xml"})
@WebAppConfiguration
public class HelloControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		// We have to reset our mock between tests because the mock objects
		// are managed by the Spring container. If we would not reset them,
		// stubbing and verified behavior would "leak" from one test to another.

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void sayHello_ShouldRenderIndexView() throws Exception {
		mockMvc.perform(get("/hello", 1L)).andExpect(status().is(200)).andExpect(view().name("index"))
				.andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));
	}
}