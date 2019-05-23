package com.retail.store.discount.test.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.retail.store.discount.model.RdsUsers;
import com.retail.store.discount.service.RdsUsersRepoService;
import com.retail.store.discount.util.RandomRdsUsersBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MockMvcUserControllerTest
{

	@Autowired
	private MockMvc				mockMvc;
	@MockBean
	private RdsUsersRepoService	rdsUsersRepoService;

	public String formatDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
		sdf.setTimeZone(TimeZone.getTimeZone("GST"));
		return sdf.format(date);
	}

	@Test
	public void shouldSucceedFindAllUsers() throws Exception
	{
		List<RdsUsers> userList = Arrays.asList(RandomRdsUsersBuilder.build(), RandomRdsUsersBuilder.build(),
				RandomRdsUsersBuilder.build());
		when(rdsUsersRepoService.findAll()).thenReturn(userList);
		ResultActions resultActions = mockMvc.perform(

				MockMvcRequestBuilders.get("/rdsUsers").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").isNotEmpty());
	}

	@Test
	public void findAllUsers_OK() throws Exception
	{
		List<RdsUsers> userList = Arrays.asList(RandomRdsUsersBuilder.build(), RandomRdsUsersBuilder.build(),
				RandomRdsUsersBuilder.build());
		when(rdsUsersRepoService.findAll()).thenReturn(userList);
		ResultActions resultActions = mockMvc.perform(get("/rdsUsers").contentType(MediaType.APPLICATION_JSON))
				// .andDo(print())
				.andExpect(status().isOk());
		// resultActions.andExpect(jsonPath("$.[0].activeDate").value(formatDate(userList.get(0).getActiveDate())))
		resultActions.andExpect(jsonPath("$.[0].address").value(userList.get(0).getAddress()))
				.andExpect(jsonPath("$.[0].city").value(userList.get(0).getCity()))
				.andExpect(jsonPath("$.[0].country").value(userList.get(0).getCountry()))
				.andExpect(jsonPath("$.[0].email").value(userList.get(0).getEmail()))
				// .andExpect(jsonPath("$.[0].entDate").value(formatDate(userList.get(0).getEntDate())))
				.andExpect(jsonPath("$.[0].firstName").value(userList.get(0).getFirstName()))
				.andExpect(jsonPath("$.[0].id").value(userList.get(0).getId()))
				.andExpect(jsonPath("$.[0].isActive").value(userList.get(0).getIsActive()))
				.andExpect(jsonPath("$.[0].lastName").value(userList.get(0).getLastName()))
				.andExpect(jsonPath("$.[0].password").value(userList.get(0).getPassword()))
				.andExpect(jsonPath("$.[0].phone").value(userList.get(0).getPhone()))
				.andExpect(jsonPath("$.[0].username").value(userList.get(0).getUsername()))
				.andExpect(jsonPath("$.[0].userType").value(userList.get(0).getUserType()));
		verify(rdsUsersRepoService, times(1)).findAll();

	}

	RdsUsers rdsUsers = RandomRdsUsersBuilder.build();

	@Before
	public void init()
	{
		when(rdsUsersRepoService.findRdsUsersById(rdsUsers.getId())).thenReturn(Optional.of(rdsUsers));
	}

	@Test
	public void findUsersById_Ok() throws Exception
	{
		ResultActions resultActions = mockMvc.perform(get("/rdsUsers/" + rdsUsers.getId()))
				// .andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk());

		resultActions.andExpect(jsonPath("$.firstName").value(rdsUsers.getFirstName()));
		resultActions.andExpect(jsonPath("$.id").value(rdsUsers.getId()));
		// resultActions.andExpect(jsonPath("$.activeDate").value(formatDate(rdsUsers.getActiveDate())))
		resultActions.andExpect(jsonPath("$.address").value(rdsUsers.getAddress()))
				.andExpect(jsonPath("$.city").value(rdsUsers.getCity()))
				.andExpect(jsonPath("$.country").value(rdsUsers.getCountry()))
				.andExpect(jsonPath("$.email").value(rdsUsers.getEmail()))
				// .andExpect(jsonPath("$.entDate").value(formatDate(rdsUsers.getEntDate())))
				.andExpect(jsonPath("$.firstName").value(rdsUsers.getFirstName()))
				.andExpect(jsonPath("$.id").value(rdsUsers.getId()))
				.andExpect(jsonPath("$.isActive").value(rdsUsers.getIsActive()))
				.andExpect(jsonPath("$.lastName").value(rdsUsers.getLastName()))
				.andExpect(jsonPath("$.password").value(rdsUsers.getPassword()))
				.andExpect(jsonPath("$.phone").value(rdsUsers.getPhone()))
				.andExpect(jsonPath("$.username").value(rdsUsers.getUsername()))
				.andExpect(jsonPath("$.userType").value(rdsUsers.getUserType()));

		verify(rdsUsersRepoService, times(1)).findRdsUsersById(rdsUsers.getId());
	}
}
