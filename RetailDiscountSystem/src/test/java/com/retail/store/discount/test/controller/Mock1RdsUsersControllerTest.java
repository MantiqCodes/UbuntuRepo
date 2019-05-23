//package com.retail.store.discount.test.controller;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.retail.store.discount.model.RdsUsers;
//import com.retail.store.discount.service.RdsUsersRepoService;
//import com.retail.store.discount.util.RandomRdsUsersBuilder;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ActiveProfiles("test")
//@AutoConfigureMockMvc
//public class Mock1RdsUsersControllerTest
//{

//	@Autowired
//	ObjectMapper objectMapper;
//
//	@Autowired
//	private MockMvc					mockMvc;
//	@Autowired
//	private WebApplicationContext	webApplicationContext;
//	@MockBean
//	private RdsUsersRepoService		rdsUsersRepoService;
//
//	@Before
//	public void init() throws Exception
//	{
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//
//	}
//
//	@Test
//	public void shouldPassUserCreationTest() throws Exception
//	{
//		RdsUsers u1 = RandomRdsUsersBuilder.build();
//
//		this.mockMvc
//				.perform(post("/rdsUsers").contentType(MediaType.APPLICATION_JSON).content(getJson(u1))
//						.accept(MediaType.APPLICATION_JSON))
//				.andDo(print()).andExpect(status().isCreated())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
//
//	}
	// RdsUsers u1 = RandomRdsUsersBuilder.build();

	// @Before
	// public void inita()
	// {
	// u1.setId(1L);
	// when(rdsUsersRepoService.findRdsUsersById(1).get()).thenReturn(u1);
	////
	// }
	// @Test
	// public void shouldPassUserUpdateTest() throws Exception
	// {
	// u1.setId(1L);
	//
	// when(rdsUsersRepoService.findRdsUsersById(1).get()).thenReturn(u1);
	// this.mockMvc.perform(
	//
	// put("/updateRdsUsers/{id}", 1L)
	//
	// .contentType(MediaType.APPLICATION_JSON)
	// .content(getJson(u1)))
	// .andExpect(status().isOk())
	// ;
	// }

//	public String getJson(Object object)
//	{
//		String json = "";
//		try
//		{
//			json = new ObjectMapper().writeValueAsString(object);
//		} catch (JsonProcessingException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return json;
//	}
}
