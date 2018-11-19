package com.testeSRM.testeSRM;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testeSRM.TesteSrmApplication;
import com.testeSRM.controller.ClienteController;
import com.testeSRM.model.ClienteVO;
import com.testeSRM.repository.ClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { TesteSrmApplication.class })
@WebAppConfiguration
@AutoConfigureMockMvc
public class ClienteControllerTest {

	@Autowired
	private ClienteRepository classRepo;

	@Autowired
	private ClienteController classController;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders
         .standaloneSetup(classController)
         .build();
	}

	public ClienteVO initClienteVO() {
		ClienteVO clienteVO = new ClienteVO();
		clienteVO.setNome("Yohanes Lopes");
		clienteVO.setLimiteCredito(new BigDecimal(200000));
		clienteVO.setRisco("A");
		clienteVO.setJuros(new BigDecimal(0));

		return clienteVO;
	}
	
	static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	@Test
	public void testGetClientes() throws Exception {	
		mockMvc.perform(get("/cliente")).andExpect(status().isOk());
	}
	
	@Test
	public void testSalvarCliente() throws Exception {	
		mockMvc.perform(post("/cliente/salvar")
        .contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(initClienteVO()))).andExpect(status().isCreated());
	}
}
