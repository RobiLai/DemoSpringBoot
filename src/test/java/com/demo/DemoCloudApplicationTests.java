package com.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DemoCloudApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void ciaoClienteTest() throws Exception{
		this.mockMvc.perform(get("/cliente/ciaoCliente"))
					.andDo(print())
					.andExpect(content().string("Ciao Cliente"));
	}
	
	@Test
	void contextLoads() {
	}

}
