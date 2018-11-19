package com.testeSRM.testeSRM;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testeSRM.TesteSrmApplication;
import com.testeSRM.controller.JurosController;
import com.testeSRM.model.JurosVO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { TesteSrmApplication.class })
@WebAppConfiguration
@AutoConfigureMockMvc
public class JurosControllerTest {

	@Autowired
	private JurosController classController;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders
         .standaloneSetup(classController)
         .build();
	}

	public JurosVO initJurosVO() {
		JurosVO jurosVO = new JurosVO();
		jurosVO.setJuros(new BigDecimal(40));
		jurosVO.setRisco("D");

		return jurosVO;
	}
	
	static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	@Test
	public void testGetJuros() throws Exception {	
		mockMvc.perform(get("/juros")).andExpect(status().isOk());
	}
	
	@Test
	public void testSalvarCliente() throws Exception {	
		mockMvc.perform(post("/juros/salvar")
        .contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(initJurosVO()))).andExpect(status().isCreated());
	}
}
