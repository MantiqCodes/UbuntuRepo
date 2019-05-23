package com.retail.store.discount.test.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.store.discount.model.RdsUsers;
import com.retail.store.discount.test.helper.RdsUsersFieldsTestHelper;
import com.retail.store.discount.test.util.RestTemplatePage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class UsersDynamicControllerRestTemplateTest
{
	@Autowired
	TestRestTemplate testRestTemplate;

	RdsUsersFieldsTestHelper rdsUsersFieldTestHelper = new RdsUsersFieldsTestHelper();

	@Test
	public void getAllRdsUsers()
	{
		ResponseEntity<RdsUsers[]> rdsUserArray = testRestTemplate.getForEntity("/rdsUsers", RdsUsers[].class);
		List<RdsUsers> rdsUsersList = Arrays.asList(rdsUserArray.getBody());
		assertNotNull(rdsUsersList);
		rdsUsersFieldTestHelper.testRdsUsersFields(rdsUsersList);

	}

	@Test
	public void getAllRdsUsersPaginated()
	{
		ResponseEntity<RestTemplatePage<RdsUsers>> response = testRestTemplate.exchange("/getRdsUsers", HttpMethod.GET,
				null, new ParameterizedTypeReference<RestTemplatePage<RdsUsers>>()
				{
				});
		assertNotNull(response);
		Page<RdsUsers> rdsUsersPage = response.getBody();
		assertNotNull(rdsUsersPage);
		List<RdsUsers> rdsUsersList = rdsUsersPage.getContent();
		assertNotNull(rdsUsersList);
		assertThat(rdsUsersList.size(), greaterThan(0));
		rdsUsersFieldTestHelper.testRdsUsersFields(rdsUsersList);

	}

}
