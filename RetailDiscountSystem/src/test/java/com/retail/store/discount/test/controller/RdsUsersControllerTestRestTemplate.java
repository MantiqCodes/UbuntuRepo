package com.retail.store.discount.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.retail.store.discount.dto.DTOConverter;
import com.retail.store.discount.dto.RdsUsersDTO;
import com.retail.store.discount.test.helper.RdsUsersFieldsTestHelper;
import com.retail.store.discount.util.RandomRdsUsersBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RdsUsersControllerTestRestTemplate
{
	@Autowired
	TestRestTemplate testRestTemplate;

	RdsUsersFieldsTestHelper rdsUsersFieldsTestHelper=new RdsUsersFieldsTestHelper();
	@Test
	public void getAllRdsUsers()
	{
		ResponseEntity<RdsUsersDTO[]> rdsUserArray = testRestTemplate.getForEntity("/findAllRdsUsers1",
				RdsUsersDTO[].class);
		List<RdsUsersDTO> rdsUsersList = Arrays.asList(rdsUserArray.getBody());
		assertNotNull(rdsUsersList);
rdsUsersFieldsTestHelper.testRdsUsersFields(new DTOConverter().getRdsUsersList(rdsUsersList));
	}

	@Test
	public void getRdsUsersById()
	{
		ResponseEntity<RdsUsersDTO> rdsUsers = testRestTemplate.getForEntity("/rdsUsers/1", RdsUsersDTO.class);
		// List<RdsUsersDTO> rdsUsersList = Arrays.asList(rdsUserArray.getBody());
		assertNotNull(rdsUsers);
		rdsUsersFieldsTestHelper.rdsUsersCumulativeTest(new DTOConverter().getRdsUsers(rdsUsers.getBody()));

	}

	@Test
	public void createRdsUsersTest()
	{
		RdsUsersDTO rdsUsersDTO = new DTOConverter().getRdsUsersDTO(RandomRdsUsersBuilder.build());

		ResponseEntity<RdsUsersDTO> rdsUsersResponse = testRestTemplate.postForEntity("/rdsUsers/", rdsUsersDTO,
				RdsUsersDTO.class);
		assertNotNull(rdsUsersResponse);
		assertNotNull(rdsUsersResponse.getBody());
		rdsUsersFieldsTestHelper.rdsUsersCumulativeTest(new DTOConverter().getRdsUsers(rdsUsersResponse.getBody()));

	}

	@Test
	public void updateRdsUsersTest()
	{
		ResponseEntity<RdsUsersDTO> rdsUsersDTOResponse = testRestTemplate.getForEntity("/rdsUsers/1",
				RdsUsersDTO.class);
		assertNotNull(rdsUsersDTOResponse);
		RdsUsersDTO rdsUsersDTO = rdsUsersDTOResponse.getBody();
		assertNotNull(rdsUsersDTO);
		rdsUsersDTO.setPhone("0099112233");
		testRestTemplate.put("/rdsUsers", rdsUsersDTO);
		ResponseEntity<RdsUsersDTO> updatedRdsUsersDTOResponse=testRestTemplate.getForEntity("/rdsUsers/1", RdsUsersDTO.class);
	assertNotNull(updatedRdsUsersDTOResponse);
	assertNotNull(updatedRdsUsersDTOResponse.getBody());
	rdsUsersFieldsTestHelper.rdsUsersCumulativeTest(new DTOConverter().getRdsUsers(updatedRdsUsersDTOResponse.getBody()));

	}

	@Test
	public void deleteRdsUsersTest()
	{
		ResponseEntity<RdsUsersDTO> rdsUsersDTOResponse = testRestTemplate.getForEntity("/rdsUsers/1",RdsUsersDTO.class);
		assertNotNull(rdsUsersDTOResponse);
		RdsUsersDTO rdsUsersDTO = rdsUsersDTOResponse.getBody();
		assertNotNull(rdsUsersDTO);
		testRestTemplate.delete("/rdsUsers/1");
		try
		{
			rdsUsersDTOResponse=testRestTemplate.getForEntity("/rdsUsers/1",RdsUsersDTO.class);
		}
		catch(final HttpClientErrorException e)
		{
			assertEquals(e.getStatusCode(),HttpStatus.NOT_FOUND);
		}
				
	}
}
